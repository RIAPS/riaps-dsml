package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import java.util.HashMap
import java.util.Set
import java.util.HashSet
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.generator.IFileSystemAccess2
import edu.vanderbilt.riaps.datatypes.FStructType
import edu.vanderbilt.riaps.datatypes.FType
import edu.vanderbilt.riaps.Console
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.MessageConsoleStream
import java.util.logging.Logger
import java.util.logging.Level
import edu.vanderbilt.riaps.datatypes.FField
import edu.vanderbilt.riaps.datatypes.FEnumerationType
import java.util.Random

class CapnProtoGenerator extends AbstractGenerator {
	@Inject extension IQualifiedNameProvider
	private final Logger LOGGER = Logger.getLogger(typeof(CapnProtoGenerator).name);

	def static String createRandomString(int length) {
		var Random random = new Random();
		var StringBuilder sb = new StringBuilder();
		while (sb.length() < length) {
			sb.append(Integer.toHexString(random.nextInt()));
		}
		return sb.toString();
	}

	static class SequenceDefinition {
		String typename
		String suffix

		new(FType y, String type) {
			suffix = y.name
			typename = type
		}

		def String uniqueIdentifier() {
			typename + '_' + suffix
		}

		def String sequenceName() '''		 
			typedef sequence<«typename»> «uniqueIdentifier»;		
		'''
	}

	static var typedefs = new HashMap<String, SequenceDefinition>

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : input.allContents.toIterable.filter(FStructType)) {

			var messageString = e.compileToString
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".capnp",
				messageString.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, e.fullyQualifiedName.toString("/") + ".idl generated");
		}

		for (e : input.allContents.toIterable.filter(FEnumerationType)) {

			var messageString = e.compileToString
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".idl",
				messageString.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, e.fullyQualifiedName.toString("/") + ".idl generated");
		}
	}

	def beautify(String code) {
		var indent = 0;
		var temp = new StringBuilder
		var contents = code.split("\n")
		var SEPARATOR = "    "
		for (line : contents) {

			if (line.contains("{")) {
				for (var i = 0; i < indent; i++) {
					temp.append(SEPARATOR)
				}
				temp.append(line.trim)
				temp.append("\n")
				indent++
			} else if (line.contains("}")) {
				indent--
				for (var i = 0; i < indent; i++) {
					temp.append(SEPARATOR)
				}
				temp.append(line.trim)
				temp.append("\n")
			} else {
				for (var i = 0; i < indent; i++) {
					temp.append(SEPARATOR)
				}
				temp.append(line.trim)
				temp.append("\n")
			}
		}
		return temp.toString

	}

	def String compileToString(FEnumerationType message) ''' 
		«var x= message.fullyQualifiedName»
		«var s = x.getSegmentCount»		
		@0x«createRandomString(8)»;	
		enum «message.name» {
			«FOR j : message.enumerators»
				«j.name»	@0;
			«ENDFOR»
			};
	'''

	def String compileToString(FStructType message) ''' 
		«var z= new HashSet<String>»
		«var listz= new HashSet<String>»
		«var x= message.fullyQualifiedName»
		«var s = x.getSegmentCount»	
		@0x«createRandomString(8)»;	
		«FOR j : message.elements»
			«IF j.type.derived != null»
				«var result=z.add(j.type.derived.name)»
				«IF (result)»
					«var n = j.type.derived.fullyQualifiedName.toString("/")»
					using import  "«n».capnp".«j.type.derived.name»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
			struct «message.name»
			{
			«FOR j : message.elements»	
				«IF j.isList»
					«j.name» @0: List(«j.idlType»);
				«ELSE»					
					«j.name» @0: «j.idlType»;									
				«ENDIF»	
			«ENDFOR»
			};
	'''

	def String getIdlType(FField field) {
		if (field.type.derived != null)
			return field.type.derived.name;
		Console.instance.log(java.util.logging.Level.INFO, field.type.predefined.literal)
		if (field.type.predefined.literal == "Boolean")
			return "Bool"
		if (field.type.predefined.literal == "Float")
			return "Float32"
		if (field.type.predefined.literal == "Double")
			return "Float64"
		if (field.type.predefined.literal == "ByteBuffer")
			return "Data"
		if (field.type.predefined.literal == "char")
			return "UInt8"
			if (field.type.predefined.literal == "String")
			return "Text"

		return field.type.predefined.literal

	}

}

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
import edu.vanderbilt.riaps.app.FStructType
import edu.vanderbilt.riaps.app.FType
import edu.vanderbilt.riaps.Console
import java.util.logging.Logger
import java.util.logging.Level
import edu.vanderbilt.riaps.app.FField
import edu.vanderbilt.riaps.app.FEnumerationType

class IDLGenerator extends AbstractGenerator {
	@Inject extension IQualifiedNameProvider
	private final Logger LOGGER = Logger.getLogger(typeof(IDLGenerator).name);

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
				e.fullyQualifiedName.toString("/") + ".idl",
				messageString.beautify
			)
			//Console.instance.log(java.util.logging.Level.INFO,e.fullyQualifiedName.toString("/") + ".idl generated");
		}
		
		for (e : input.allContents.toIterable.filter(FEnumerationType)) {

			var messageString = e.compileToString
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".idl",
				messageString.beautify
			)
			//Console.instance.log(java.util.logging.Level.INFO,e.fullyQualifiedName.toString("/") + ".idl generated");
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
	«FOR i : 0..<s-1»
				module «x.getSegment(i)»
				{
	«ENDFOR»
	enum «message.name» {
		«FOR j : message.enumerators SEPARATOR ','»
		«j.name»	
		«ENDFOR»
		};
	«FOR i : s-1..1»
				};
	«ENDFOR»
	'''

	def String compileToString(FStructType message) ''' 
		«var z= new HashSet<String>»
		«var listz= new HashSet<String>»
		«var x= message.fullyQualifiedName»
		«var s = x.getSegmentCount»		
		«FOR j : message.elements»
			«IF j.type.derived != null»
				«var result=z.add(j.type.derived.name)»
				«IF (result)»
					«var n = j.type.derived.fullyQualifiedName.toString("/")»
					#include <«n».idl>
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		«FOR i : 0..<s-1»
			module «x.getSegment(i)»
			{
		«ENDFOR»
		«FOR j : message.elements»
					«IF j.isList»
						«var result=listz.add(j.idlType)»
						«IF (result)»
							«var temp= new SequenceDefinition(message,j.idlType)»
								«temp.sequenceName»
						«ENDIF»
					«ENDIF»
		«ENDFOR»
			struct «message.name»
			{
			«FOR j : message.elements»	
				«IF j.isList»
					«var temp= new SequenceDefinition(message,j.idlType)»
						«temp.uniqueIdentifier» «j.name»;
				«ELSE»					
						«j.idlType»  «j.name»;									
				«ENDIF»	
			«ENDFOR»
			};
		«FOR i : s-1..1»
			};
		«ENDFOR»
		
	'''

	def String getIdlType(FField field) {
		if (field.type.derived != null)
			return field.type.derived.name;

		//Console.instance.log(java.util.logging.Level.INFO, field.type.predefined.literal)
		if(field.type.predefined.literal == "Int8")
			return "octet"
		if(field.type.predefined.literal == "UInt8")
			return "octet"
		if(field.type.predefined.literal == "Int16")
			return "short"		
		if(field.type.predefined.literal == "UInt16")
			return "unsigned short "	
		if(field.type.predefined.literal == "Int32")
			return "long"	
		if(field.type.predefined.literal == "UInt32")
			return "unsigned long"		
		if(field.type.predefined.literal == "Int64")
			return "long long"		
		if(field.type.predefined.literal == "UInt64")
			return "unsigned long long"		
	    if(field.type.predefined.literal == "Boolean")
			return "boolean"		
	    if(field.type.predefined.literal == "Float")
			return "float"	
		if(field.type.predefined.literal == "Double")
			return "double"
		if(field.type.predefined.literal == "ByteBuffer")
			return "Octet"
		if(field.type.predefined.literal == "char")
			return "char"
	
		return field.type.predefined.literal	
		

	}

}

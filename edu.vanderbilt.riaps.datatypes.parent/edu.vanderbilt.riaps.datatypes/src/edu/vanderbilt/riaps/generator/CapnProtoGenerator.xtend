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
import java.util.ArrayList
import edu.vanderbilt.riaps.datatypes.Model
import java.util.regex.Pattern
import java.io.BufferedReader
import java.io.InputStreamReader

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
	
	def static String createCapnpID() {
		var rt = Runtime.getRuntime();
		var pr = rt.exec("capnp id");

		var stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()))
	    var s = ""
		s = stdInput.readLine()
		
		return s
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
	static var packageNameMap = new HashMap<String, String>

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e: input.allContents.toIterable.filter(Model)) {
			var packageNameArray = e.name.split(Pattern.quote("."))
			
			for (type : e.types) {
				if (type instanceof FStructType) {
					packageNameMap.put(type.name, packageNameArray.get(0))
					var aStruct = type as FStructType
					var messageString = aStruct.compileToString
					fsa.generateFile(
						aStruct.fullyQualifiedName.toString("/") + ".capnp",
						messageString.beautify
					)
					Console.instance.log(java.util.logging.Level.INFO, aStruct.fullyQualifiedName.toString("/") + ".idl generated");
				}
				
				if (type instanceof FEnumerationType) {
					packageNameMap.put(type.name, packageNameArray.get(0))
					var anEnum = type as FEnumerationType 
					var messageString = anEnum.compileToString
					fsa.generateFile(
						anEnum.fullyQualifiedName.toString("/") + ".idl",
						messageString.beautify
					)
					Console.instance.log(java.util.logging.Level.INFO, anEnum.fullyQualifiedName.toString("/") + ".idl generated");
				}
			}
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
		«createCapnpID()»;
		
		enum «message.name» {
			«var fields = createEnumFields(message)»
			«FOR j : fields»
				«j»
			«ENDFOR»
			};
	'''

	def String compileToString(FStructType message) ''' 
		«var z= new HashSet<String>»
		«var listz= new HashSet<String>»
		«var x= message.fullyQualifiedName»
		«var s = x.getSegmentCount»
		«createCapnpID()»;
		
		«FOR j : message.elements»
			«IF j.type.derived != null»
				«var result=z.add(j.type.derived.name)»
				«IF (result)»
					«var n = j.type.derived.fullyQualifiedName.toString("/")»
					using import  "«n».capnp".«j.type.derived.name»
				«ENDIF»
			«ENDIF»
		«ENDFOR»
		
		using Cxx = import "/capnp/c++.capnp";
		$Cxx.namespace("«packageNameMap.get(message.name)»::messages");		
		
			struct «message.name»
			{
				«var fieldList = createStructFields(message)»
				«FOR field : fieldList»
					«field»
				«ENDFOR»
			}
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

	def ArrayList<String> createStructFields(FStructType struct) {
		val fieldList = new ArrayList<String>()
		for (var i = 0; i < struct.elements.length; i++) {
				if (struct.elements.get(i).isList)	{
					val field = '''
					«struct.elements.get(i).name» @«i»: List(«struct.elements.get(i).idlType»);
					'''
					fieldList.add(field)
				}
				else {
					val field = '''
					«struct.elements.get(i).name» @«i»: «struct.elements.get(i).idlType»;
					'''
					fieldList.add(field)
				}
		}
		return fieldList
	}
	
	def ArrayList<String> createEnumFields(FEnumerationType enumeration) {
		val fieldList = new ArrayList<String>()
		for (var i = 0; i < enumeration.enumerators.length; i++) {
			val field = '''
			«enumeration.enumerators.get(i).name»	@«i»;
			'''
		}
		return fieldList
	}
}

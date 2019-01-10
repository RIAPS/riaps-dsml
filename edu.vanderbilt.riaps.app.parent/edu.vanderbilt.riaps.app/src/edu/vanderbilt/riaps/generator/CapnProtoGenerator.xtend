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
import java.util.Random
import java.util.ArrayList
import edu.vanderbilt.riaps.app.Model
import java.util.regex.Pattern
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.IOException

import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.AnswerPort

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
		try {
			var rt = Runtime.getRuntime();
			var pr = rt.exec("/opt/riaps/amd64/bin/capnp id");
			var stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()))
			var s = ""
			s = stdInput.readLine()
			return s

		} catch (IOException e) {
			var result = randomNumber.Number()			
			var uid=String.format("%016x",result)
			return "@0x" + uid
		}

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
			typedef sequence<�typename�> �uniqueIdentifier�;		
		'''
	}

	

	override doGenerate(Resource input, IFileSystemAccess2 fsa, IGeneratorContext context)
	 {
		/*
		var HashSet<FStructType> allstructs = new HashSet<FStructType>
		var HashSet<FEnumerationType> allenums = new HashSet<FEnumerationType>
		
		for (e : input.allContents.toIterable.filter(Port)) {
			if(e instanceof PubPort)
			{
				var astruct=e.type.type
				if(astruct!==null)
					allstructs.add(astruct)	
			}
			if(e instanceof SubPort)
			{
				var astruct=e.type.type
				if(astruct!==null)
				allstructs.add(astruct)	
			}	
			if(e instanceof SrvPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
				if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)		
			}	
			if(e instanceof ClntPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
			if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)		
			}	
			if(e instanceof RepPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
				if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)		
			}
			if(e instanceof ReqPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
			if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)			
			}	
			if(e instanceof QueryPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
			if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)			
			}	
			if(e instanceof AnswerPort)
			{
				var astruct=e.req_type.type
				var astruct2=e.rep_type.type
			if(astruct!==null)
					allstructs.add(astruct)
				if(astruct2!==null)
					allstructs.add(astruct2)		
			}		
		}
		
		for (e : input.allContents.toIterable.filter(Model)) {
			//var packageNameArray = e.name.split(Pattern.quote("."))

			for (type : e.collections) {
				if (type instanceof FStructType) {
				//	packageNameMap.put(type.name, packageNameArray.get(0))

					var aStruct = type as FStructType
					allstructs.add(aStruct)
					
					//Console.instance.log(java.util.logging.Level.INFO, aStruct.name + " generating")
				}
				if (type instanceof FEnumerationType) {
					//packageNameMap.put(type.name, packageNameArray.get(0))
					var anEnum = type as FEnumerationType
					allenums.add(anEnum)
				}
			}
		}
		
		var moreToCheck = true

		while (moreToCheck) {
			moreToCheck = false
			var HashSet<FStructType> allstructsrefs = new HashSet<FStructType>
			for (aStruct : allstructs) {
				for (element : aStruct.elements) {
					if (element.type.derived !== null) {
						var entry = element.type.derived
						if (entry instanceof FStructType) {
							if (!allstructs.contains(entry)) {
								allstructsrefs.add(entry)
								moreToCheck = true
							}

						} else if (entry instanceof FEnumerationType) {
							allenums.add(entry)
						}
					}
				}
			}
			allstructs.addAll(allstructsrefs)
		}
		
		for(aStruct:allstructs){
			try{
			var messageString = aStruct.compileToString
			fsa.generateFile(
						aStruct.fullyQualifiedName.toString("/") + ".capnp",
						RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_MESSAGE,
						messageString.beautify
					)
					
			}
			catch(java.lang.NullPointerException e )
			{
				Console.instance.log(java.util.logging.Level.INFO, aStruct.toString + " problem")
			}
			
		}
		for(anEnum:allenums)
		{
			try{
			var messageString = anEnum.compileToString
		
					fsa.generateFile(
						anEnum.fullyQualifiedName.toString("/") + ".capnp",
						RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_MESSAGE,
						messageString.beautify
					)
					
				}
					catch(java.lang.NullPointerException e )
			{
				Console.instance.log(java.util.logging.Level.INFO, anEnum.toString + " problem")
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
 */
	}

	def String compileToString(FEnumerationType message) ''' 
		�var x= message.fullyQualifiedName�
		�var s = x.getSegmentCount�
		�createCapnpID()�;		
		using Cxx = import "/capnp/c++.capnp";
		enum �message.name� {
			�var fields = createEnumFields(message)�
			�FOR j : fields�
				�j�
			�ENDFOR�
			}
	'''

	def String compileToString(FStructType message) ''' 
		«var z= new HashSet<String>»
		�createCapnpID()�;		
		�FOR j : message.elements�
			�IF j.type.derived !== null�
				�var result=z.add(j.type.derived.name)�
				�IF (result)�
					�var n = j.type.derived.fullyQualifiedName.toString("/")�
���					using import  "/�n�.capnp".�j.type.derived.name�;
					using import  "�n�.capnp".�j.type.derived.name�;
				�ENDIF�
			�ENDIF�
		�ENDFOR�
		using Cxx = import "/capnp/c++.capnp";
���		$Cxx.namespace("�message.fullyQualifiedName.skipLast(1).toString("::")�");		
		
		struct �message.name�
		{
			�var fieldList = createStructFields(message)�
			�FOR field : fieldList�
			�field�
		    �ENDFOR�
		}
	'''
	

		

	def String getIdlType(FField field) {
		if (field.type.derived !== null)
			return field.type.derived.name;
		//Console.instance.log(java.util.logging.Level.INFO, field.type.predefined.literal)
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
			if (struct.elements.get(i).isList) {
				val field = '''
					�struct.elements.get(i).name� @�i�: List(�struct.elements.get(i).idlType�);
				'''
				fieldList.add(field)
			} else {
				val field = '''
					�struct.elements.get(i).name� @�i�: �struct.elements.get(i).idlType�;
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
				�enumeration.enumerators.get(i).name�	@�i�;
			'''
			fieldList.add(field)
		}
		return fieldList
	}
}

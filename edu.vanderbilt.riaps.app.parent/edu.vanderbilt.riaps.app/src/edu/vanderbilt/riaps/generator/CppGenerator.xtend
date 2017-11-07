package edu.vanderbilt.riaps.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.Console
import org.eclipse.xtext.generator.IFileSystemAccess
//import java.util.ArrayList
import edu.vanderbilt.riaps.generator.cpp.AppCpp
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider
import edu.vanderbilt.riaps.datatypes.FStructType
import java.util.HashSet
import edu.vanderbilt.riaps.datatypes.FType


public class CppGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider
	var HashSet<String> Appname=new HashSet<String> 

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		
		for (e : resource.allContents.toIterable.filter(Application)) {

			// var componentNames = new ArrayList<String>()
			var appCpp = new AppCpp(e, this)	
			Appname.add(e.name)
			for (comp : appCpp.compList) {

				var base_h = comp.generateBaseH()
				var base_h_path = e.name + "/include/" + comp.componentName + "Base.h"
				fsa.generateFile(
					base_h_path,
					IFileSystemAccess::DEFAULT_OUTPUT,
					base_h.beautify
				)
				Console.instance.log(java.util.logging.Level.INFO, base_h_path + " generated");

				var base_cpp = comp.generateBaseCpp()
				var base_cpp_path = e.name + "/src/" + comp.componentName + "Base.cc"
				fsa.generateFile(
					base_cpp_path,
					IFileSystemAccess::DEFAULT_OUTPUT,
					base_cpp.beautify
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var fw_h = comp.generateFW_H()
				var fw_h_path = e.name + "/include/" + comp.componentName + ".h"
				fsa.generateFile(
					fw_h_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
					fw_h.beautify
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var fw_cpp = comp.generateFW_Cpp()
				var fw_cpp_path = e.name + "/src/" + comp.componentName + ".cc"
				fsa.generateFile(
					fw_cpp_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
					fw_cpp.beautify
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var python_file_path = e.name + "//python//" + comp.componentName + ".py"
				// if (!fsa.isFile(python_file_path)) {
				fsa.generateFile(
					python_file_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
					comp.generate_python
				)
			// }	
			// else{
			// Console.instance.log(java.util.logging.Level.WARNING, python_file_path + " already exists. Please remove if you want to overwrite it.");
			// }		
			}

			var cmake = createCMakeList(appCpp)
			var cmake_path = appCpp.applicationName + "//CMakeLists.txt"
			fsa.generateFile(
				cmake_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
				cmake
			)

			fsa.generateFile(
				"..//toolchain.host.cmake",
				IFileSystemAccess::DEFAULT_OUTPUT,
				createx86ToolChain
			)

			fsa.generateFile(
				"..//toolchain.arm-linux-gnueabihf.cmake",				
				IFileSystemAccess::DEFAULT_OUTPUT,
				createArmhfToolChain
			)
			Console.instance.log(java.util.logging.Level.INFO, cmake_path + " generated");
		}
		fsa.generateFile(
				"..//CMakeLists.txt",				
				IFileSystemAccess::DEFAULT_OUTPUT,
				createTopCmakeLists
			)
	}
	
	def CharSequence beautify(CharSequence sequence){
		beautifyString(sequence.toString())
	}
	
	
	
	def beautifyString(String code) {
		var indent = 0;
		var temp = new StringBuilder
		var contents = code.split("\n")
		var SEPARATOR = "   "
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
	
	def createTopCmakeLists() {
		'''
		cmake_minimum_required(VERSION 3.0)
		«FOR a : Appname»
		add_subdirectory(devcode/«a»)
		«ENDFOR»
		'''
	}


	def String StructQualifiedName(FStructType x) {
		return x.fullyQualifiedName.toString("/");
	}

	def String StructQualifiedName(FStructType x, String y) {
		return x.fullyQualifiedName.toString(y);
	}

	def String createArmhfToolChain() {
		'''
			set(CMAKE_SYSTEM_NAME Linux)
			set(RIAPS_PREFIX /opt/riaps/armhf/)
			set(ARCH armhf)
			set(TOOLCHAIN_PREFIX arm-linux-gnueabihf)
			set(CMAKE_C_COMPILER ${TOOLCHAIN_PREFIX}-gcc)
			set(CMAKE_CXX_COMPILER ${TOOLCHAIN_PREFIX}-g++)
			set(CMAKE_FIND_ROOT_PATH /usr/${TOOLCHAIN_PREFIX})
			set (CMAKE_CXX_FLAGS "-std=c++11")
			set (CMAKE_C_FLAGS "-std=c99")
			include_directories(${RIAPS_PREFIX}/include)
		'''
	}

	def String createx86ToolChain() {
		'''
			set(CMAKE_SYSTEM_NAME Linux)
			set(RIAPS_PREFIX /opt/riaps/amd64/)
			set(ARCH amd64)
			set(CMAKE_C_COMPILER gcc)
			set(CMAKE_CXX_COMPILER g++)
			set(CMAKE_FIND_ROOT_PATH /usr/)
			set (CMAKE_CXX_FLAGS "-std=c++11")
			set (CMAKE_C_FLAGS "-std=c99")
			include_directories(${RIAPS_PREFIX}/include)			
		'''
	}

	def String createCMakeList(AppCpp app) {
		val capnpMsgs = new HashSet<FType>
		val content = '''
			#Initial Setup		
			cmake_minimum_required(VERSION 3.0)
			project («app.applicationName»)
			
			set(CMAKE_SYSTEM_NAME Linux)
			set (CMAKE_CXX_FLAGS "-std=c++11")
			set (CMAKE_C_FLAGS "-std=c99")
			
			
			set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/${ARCH}/bin)		
			set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}/${ARCH}/bin)		
			set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY  ${CMAKE_CURRENT_SOURCE_DIR}/${ARCH}/bin)
			
			#Library Dependencies
			set(DEPENDENCIES ${RIAPS_PREFIX})
			set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/include)
			set (LIBALLPATH_LIB ${DEPENDENCIES}/lib)
			link_directories(${LIBALLPATH_LIB})
			
			
			#include directories
			include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include)
			include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../../basecode/«app.applicationName»/include)
			include_directories(${CMAKE_CURRENT_SOURCE_DIR}/../../messages/)
					
			
			#capnproto files		
			«FOR c : app.compList»
				«FOR i: c.msgIncludes»
					«{capnpMsgs.add(i);""}»
					«FOR el: i.elements»
						«IF el.type.derived!==null»
							«{capnpMsgs.add(el.type.derived);""}»
						«ENDIF»
					«ENDFOR»
				«ENDFOR»
			      «ENDFOR»
			«FOR i : capnpMsgs»		
				add_custom_command(OUTPUT  "${CMAKE_CURRENT_SOURCE_DIR}/../../messages/«i.fullyQualifiedName.toString("/")».capnp.c++"
				                   DEPENDS "${CMAKE_CURRENT_SOURCE_DIR}/../../messages/«i.fullyQualifiedName.toString("/")».capnp" 
				                   WORKING_DIRECTORY "${CMAKE_CURRENT_SOURCE_DIR}/../../messages"  
				                   COMMAND capnp compile -oc++ "${CMAKE_CURRENT_SOURCE_DIR}/../../messages/«i.fullyQualifiedName.toString("/")».capnp" --import-path="${CMAKE_CURRENT_SOURCE_DIR}/../../messages"
				                   )
			«ENDFOR»
			
			#component libraries
			«FOR c : app.compList»
				
				# «c.componentName»
				add_library(«c.componentName.toLowerCase» 
							SHARED src/«c.componentName».cc
							${CMAKE_CURRENT_SOURCE_DIR}/../../basecode/«app.applicationName»/src/«c.componentName»Base.cc
							«FOR i: c.msgIncludes»
								${CMAKE_CURRENT_SOURCE_DIR}/../../messages/«i.fullyQualifiedName.toString("/")».capnp.c++
								«FOR el: i.elements»
									«IF el.type.derived!==null»
										${CMAKE_CURRENT_SOURCE_DIR}/../../messages/«el.type.derived.fullyQualifiedName.toString("/")».capnp.c++					
									«ENDIF»
								«ENDFOR»
							«ENDFOR»
							)
							
				target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj )
			«ENDFOR»
		'''
		return content
	}
}

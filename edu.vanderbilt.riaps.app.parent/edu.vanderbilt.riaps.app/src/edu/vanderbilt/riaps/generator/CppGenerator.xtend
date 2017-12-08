package edu.vanderbilt.riaps.generator

import com.google.inject.Inject
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.app.FStructType
import edu.vanderbilt.riaps.app.FType
import edu.vanderbilt.riaps.generator.cpp.AppCpp
import java.util.HashSet
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.emf.common.util.EList
import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.DeviceType
import edu.vanderbilt.riaps.app.Model

public class CppGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider
	

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var HashSet<String> Appname = new HashSet<String>
		for (e : resource.allContents.toIterable.filter(Application)) {
			generateForApp(e, fsa, null, null,Appname)
		}
		for (model : resource.allContents.toIterable.filter(Model)) {

			var globalDevices = model.collections.filter(DeviceType).filter(dt|dt.reuselib === null)

			var globalcomponents = model.collections.filter(Component).filter(co|co.reuselib === null)
			generateForApp(null, fsa, globalcomponents, globalDevices,Appname)
		}

		fsa.generateFile(
			"toolchain.host.cmake",
			IFileSystemAccess::DEFAULT_OUTPUT,
			createx86ToolChain
		)
		fsa.generateFile(
			"toolchain.arm-linux-gnueabihf.cmake",
			IFileSystemAccess::DEFAULT_OUTPUT,
			createArmhfToolChain
		)
		fsa.generateFile(
			"CMakeLists.txt",
			IFileSystemAccess::DEFAULT_OUTPUT,
			createTopCmakeLists(Appname)
		)
	}

	protected def void generateForApp(Application myapp, IFileSystemAccess2 fsa, Iterable<Component> globalcomponents,
		Iterable<DeviceType> globalDevices,HashSet<String> Appname) {

		// check and return if e contains messages that do not have a type
		var AppCpp appCpp;
		//try {
			appCpp = new AppCpp(myapp, this, globalcomponents, globalDevices)
	//	} catch (NullPointerException except) {
//Console.instance.log(java.util.logging.Level.SEVERE, except.toString);
	//		return
	//	}

		Appname.add(appCpp.applicationName)
		for (comp : appCpp.compList) {

			var base_h = comp.generateBaseH()
			var base_h_path = appCpp.applicationName + "//" + comp.componentName + "Base.h"
			fsa.generateFile(
				base_h_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_BASE_INCLUDE,
				base_h.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, base_h_path + " generated");

			var base_cpp = comp.generateBaseCpp()
			var base_cpp_path = appCpp.applicationName + "//" + comp.componentName + "Base.cc"
			fsa.generateFile(
				base_cpp_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_BASE_SRC,
				base_cpp.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

			var fw_h = comp.generateFW_H()
			var fw_h_path = appCpp.applicationName + "//" + comp.componentName + ".h"
			fsa.generateFile(
				fw_h_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_INCLUDE,
				fw_h.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

			var fw_cpp = comp.generateFW_Cpp()
			var fw_cpp_path = appCpp.applicationName + "//" + comp.componentName + ".cc"
			fsa.generateFile(
				fw_cpp_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_SRC,
				fw_cpp.beautify
			)
			Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

			var python_file_path = appCpp.applicationName + "//python//" + comp.componentName + ".py"
			// if (!fsa.isFile(python_file_path)) {
			fsa.generateFile(
				python_file_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_SRC,
				comp.generate_python
			)

		}

		var cmake = createCMakeList(appCpp)
		var cmake_path = appCpp.applicationName + ".cmake"
		fsa.generateFile(
			cmake_path,
			IFileSystemAccess::DEFAULT_OUTPUT,
			cmake
		)

	}

	def CharSequence beautify(CharSequence sequence) {
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

	def createTopCmakeLists(HashSet<String> Appname) {
		'''
			cmake_minimum_required(VERSION 3.0)
			set(CMAKE_SYSTEM_NAME Linux)
			set(CMAKE_CXX_FLAGS "-std=c++11")
			set(CMAKE_C_FLAGS "-std=c99")
			set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin/${ARCH})		
			set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin/${ARCH})		
			set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY  ${CMAKE_SOURCE_DIR}/bin/${ARCH})
			#Library Dependencies
			set(DEPENDENCIES ${RIAPS_PREFIX})
			set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/include)
			set (LIBALLPATH_LIB ${DEPENDENCIES}/lib)
			include_directories(${CMAKE_SOURCE_DIR}/messages)			
			link_directories(${LIBALLPATH_LIB})
			«FOR a : Appname»
				include(«a».cmake)		
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
			include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include/base/«app.applicationName»)
			include_directories(${CMAKE_CURRENT_SOURCE_DIR}/include/dev/«app.applicationName»)
			
			set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin/${ARCH}/«app.applicationName»)		
			set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/bin/${ARCH}/«app.applicationName»)		
			set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY  ${CMAKE_SOURCE_DIR}/bin/${ARCH}/«app.applicationName»)
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
				add_custom_command(OUTPUT  "${CMAKE_SOURCE_DIR}/messages/«i.fullyQualifiedName.toString("/")».capnp.c++"
				                   DEPENDS "${CMAKE_SOURCE_DIR}/messages/«i.fullyQualifiedName.toString("/")».capnp" 
				                   WORKING_DIRECTORY "${CMAKE_SOURCE_DIR}/messages"  
				                   COMMAND capnp compile -oc++ "${CMAKE_SOURCE_DIR}/messages/«i.fullyQualifiedName.toString("/")».capnp" --import-path="${CMAKE_SOURCE_DIR}/messages"
				                   )
			«ENDFOR»
			
			#component libraries
			«FOR c : app.compList»
				
				# «c.componentName»
				add_library(«c.componentName.toLowerCase» 
							SHARED ${CMAKE_CURRENT_SOURCE_DIR}/src/dev/«app.applicationName»/«c.componentName».cc
							${CMAKE_CURRENT_SOURCE_DIR}/src/base/«app.applicationName»/«c.componentName»Base.cc
							«FOR i: c.msgIncludes»
								${CMAKE_SOURCE_DIR}/messages/«i.fullyQualifiedName.toString("/")».capnp.c++
								«FOR el: i.elements»
									«IF el.type.derived!==null»
										${CMAKE_SOURCE_DIR}/messages/«el.type.derived.fullyQualifiedName.toString("/")».capnp.c++					
									«ENDIF»
								«ENDFOR»
							«ENDFOR»
							)
				«IF c.libraries.size==0»			
				target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj)
				«ELSE»
				target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj «FOR l:c.libraries SEPARATOR " "»«l»«ENDFOR»)
				«ENDIF»
			«ENDFOR»
		'''
		return content
	}
}

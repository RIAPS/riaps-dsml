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

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {

			// var componentNames = new ArrayList<String>()
			var appCpp = new AppCpp(e,this)
			for (comp : appCpp.compList) {

				var base_h = comp.generateBaseH()
				var base_h_path = e.name + "/include/" + comp.componentName + "Base.h"
				fsa.generateFile(
					base_h_path,
					IFileSystemAccess::DEFAULT_OUTPUT,
					base_h
				)
				Console.instance.log(java.util.logging.Level.INFO, base_h_path + " generated");

				var base_cpp = comp.generateBaseCpp()
				var base_cpp_path = e.name + "/src/" + comp.componentName + "Base.cc"
				fsa.generateFile(
					base_cpp_path,IFileSystemAccess::DEFAULT_OUTPUT,
					base_cpp
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var fw_h = comp.generateFW_H()
				var fw_h_path = e.name + "/include/" + comp.componentName + ".h"
				fsa.generateFile(
					fw_h_path,RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
					fw_h
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var fw_cpp = comp.generateFW_Cpp()
				var fw_cpp_path = e.name + "/src/" + comp.componentName + ".cc"
				fsa.generateFile(
					fw_cpp_path,RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
					fw_cpp
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");

				var python_file_path = e.name + "//python//" + comp.componentName + ".py"
				// if (!fsa.isFile(python_file_path)) {
				fsa.generateFile(
					python_file_path,RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
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
				cmake_path,RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,
				cmake
			)
			
			fsa.generateFile(
				appCpp.applicationName + "//toolchain.host.cmake",
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,createx86ToolChain
			)
			
			fsa.generateFile(
				appCpp.applicationName + "//toolchain.arm-linux-gnueabihf.cmake",
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE,createArmhfToolChain
			)
			Console.instance.log(java.util.logging.Level.INFO, cmake_path + " generated");

		}
	}
	
	def String StructQualifiedName(FStructType x)
	{
		return x.fullyQualifiedName.toString("/");
	}
	
	def String createArmhfToolChain(){
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
	
		def String createx86ToolChain(){
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
		project (�app.applicationName�)
		
		set(CMAKE_SYSTEM_NAME Linux)
		set (CMAKE_CXX_FLAGS "-std=c++11")
		set (CMAKE_C_FLAGS "-std=c99")
		
		
		set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_HOME_DIRECTORY}/${ARCH}/bin)		
		set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_HOME_DIRECTORY}/${ARCH}/bin)		
		set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY  ${CMAKE_HOME_DIRECTORY}/${ARCH}/bin)
		
		#Library Dependencies
		set(DEPENDENCIES ${RIAPS_PREFIX})
		set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/include)
		set (LIBALLPATH_LIB ${DEPENDENCIES}/lib)
		link_directories(${LIBALLPATH_LIB})
		
		
		#include directories
		include_directories(${CMAKE_HOME_DIRECTORY}/include)
		include_directories(${CMAKE_HOME_DIRECTORY}/../../basecode/�app.applicationName�/include)
		include_directories(${CMAKE_HOME_DIRECTORY}/../../messages/)
				
		
		#capnproto files		
		�FOR c: app.compList�
		�FOR i: c.msgIncludes�
		�{capnpMsgs.add(i);""}�
		�FOR el: i.elements�
		�IF el.type.derived!==null�
		�{capnpMsgs.add(el.type.derived);""}�
		�ENDIF�
		�ENDFOR�
		�ENDFOR�
        �ENDFOR�
		�FOR i: capnpMsgs�		
		add_custom_command(OUTPUT  "${CMAKE_HOME_DIRECTORY}/../../messages/�i.fullyQualifiedName.toString("/")�.capnp.c++"
		                   DEPENDS "${CMAKE_HOME_DIRECTORY}/../../messages/�i.fullyQualifiedName.toString("/")�.capnp" 
		                   WORKING_DIRECTORY "${CMAKE_HOME_DIRECTORY}/../../messages"  
		                   COMMAND capnp compile -oc++ "${CMAKE_HOME_DIRECTORY}/../../messages/�i.fullyQualifiedName.toString("/")�.capnp" --import-path="${CMAKE_HOME_DIRECTORY}/../../messages"
		                   )
		�ENDFOR�
		
		#component libraries
		�FOR c: app.compList�
		
		# �c.componentName�
		add_library(�c.componentName.toLowerCase� 
					SHARED src/�c.componentName�.cc
					${CMAKE_HOME_DIRECTORY}/../../basecode/�app.applicationName�/src/�c.componentName�Base.cc
					�FOR i: c.msgIncludes�
					${CMAKE_HOME_DIRECTORY}/../../messages/�i.fullyQualifiedName.toString("/")�.capnp.c++
					�FOR el: i.elements�
					�IF el.type.derived!==null�
					${CMAKE_HOME_DIRECTORY}/../../messages/�el.type.derived.fullyQualifiedName.toString("/")�.capnp.c++					
					�ENDIF�
					�ENDFOR�
					�ENDFOR�
					)
					
		target_link_libraries(�c.componentName.toLowerCase� czmq riaps dl capnp kj )
		�ENDFOR�
		'''
		return content
	}
}

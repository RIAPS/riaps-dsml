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

public class CppGenerator extends AbstractGenerator {

	
	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {

			// var componentNames = new ArrayList<String>()
			var appCpp = new AppCpp(e)
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
			Console.instance.log(java.util.logging.Level.INFO, cmake_path + " generated");

		}
	}
	
	def String createCMakeList(AppCpp app) {		
		val content = '''		
		cmake_minimum_required(VERSION 3.0)
		project («app.applicationName»)
		set(CMAKE_SYSTEM_NAME Linux)
		set(DEPENDENCIES ${riaps_prefix})
		set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/${arch}/include)
		set (LIBALLPATH_LIB ${DEPENDENCIES}/${arch}/lib)
		include_directories(${LIBALLPATH_INCLUDE})
		link_directories(${LIBALLPATH_LIB})
		# Debug binaries are to be copied into "./bin" directory
		set(CMAKE_RUNTIME_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		set(CMAKE_LIBRARY_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		include_directories(include)
		«FOR c: app.compList»
		add_library(«c.componentName.toLowerCase» SHARED src/«c.componentName».cc
				                                  src/«c.componentName»Base.cc
				                                  «FOR i: c.msgIncludes»
				                                   «i.fullyQualifiedName.toString("/")».capnp.c++
				                 				  «ENDFOR»
		)
		
		«ENDFOR»
		
		«FOR c: app.compList»
		target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj )
		
		«ENDFOR»
		'''
		return content
	}
}

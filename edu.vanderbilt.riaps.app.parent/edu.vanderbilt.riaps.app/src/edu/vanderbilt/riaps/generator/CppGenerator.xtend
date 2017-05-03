package edu.vanderbilt.riaps.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.generator.cpp.CompCpp
import java.util.ArrayList
import edu.vanderbilt.riaps.generator.cpp.CMake

public class CppGenerator extends AbstractGenerator {
	
	@Inject extension IQualifiedNameProvider
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {
			
			var componentNames = new ArrayList<String>()			
			
			for (c: e.components)
			{
				componentNames.add(c.name)
				
				var comp = new CompCpp(c, e)
				var base_h = comp.generateBaseH()
				var base_h_path = e.name + "//include//base//" + c.name + "Base.h"
				fsa.generateFile(
					base_h_path,
					base_h
				)
				Console.instance.log(java.util.logging.Level.INFO, base_h_path + " generated");
				
				var base_cpp = comp.generateBaseCpp()
				var base_cpp_path = e.name + "//src//base//" + c.name + "Base.cc"
				fsa.generateFile(
					base_cpp_path,
					base_cpp
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");
				
				var fw_h = comp.generateFW_H()
				var fw_h_path = e.name + "//include//" + c.name + ".h"
				fsa.generateFile(
					fw_h_path,
					fw_h
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");
				
				
				var fw_cpp = comp.generateFW_Cpp()
				var fw_cpp_path = e.name + "//src//" + c.name + ".cc"
				fsa.generateFile(
					fw_cpp_path,
					fw_cpp
				)
				Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");			
			
			}
			
			var cmake = CMake::generateCMake(e.name, componentNames)
			var cmake_path = e.name + "//CMakeLists.txt"
				fsa.generateFile(
					cmake_path,
					cmake
				)
			Console.instance.log(java.util.logging.Level.INFO, cmake_path + " generated");		
			
		}
	}	
}
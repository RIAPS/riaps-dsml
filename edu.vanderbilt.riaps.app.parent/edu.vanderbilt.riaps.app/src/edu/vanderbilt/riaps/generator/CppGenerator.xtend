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
import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.DeviceType
import edu.vanderbilt.riaps.app.Model
import java.nio.file.Paths
import java.util.HashMap
import edu.vanderbilt.riaps.generator.cpp.CompCpp
import org.eclipse.swt.internal.Platform
import org.eclipse.core.runtime.URIUtil
import org.eclipse.core.runtime.FileLocator
import org.eclipse.xtext.generator.IFileSystemAccessExtension2
import org.eclipse.emf.common.CommonPlugin
import edu.vanderbilt.riaps.app.SupportLanguages

public class CppGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var HashSet<String> Appname = new HashSet<String>
		var HashMap<CompCpp, CharSequence> libraryTarget = new HashMap<CompCpp, CharSequence>
		var HashMap<FType, CharSequence> MessageTarget = new HashMap<FType, CharSequence>

		for (e : resource.allContents.toIterable.filter(Application)) {
			generateForApp(e, fsa, null, null, Appname, libraryTarget, MessageTarget)
		}
		for (model : resource.allContents.toIterable.filter(Model)) {

			var globalDevices = model.collections.filter(DeviceType) // .filter(dt|dt.reuselib === null)
			var globalcomponents = model.collections.filter(Component) // .filter(co|co.reuselib === null)
			generateForApp(null, fsa, globalcomponents, globalDevices, Appname, libraryTarget, MessageTarget)
		}

		fsa.generateFile(
			".toolchain.amd64.cmake",
			RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE,
			createx86ToolChain
		)
		fsa.generateFile(
			".toolchain.arm-linux-gnueabihf.cmake",
			RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE,
			createArmhfToolChain
		)

		var uri = (fsa as IFileSystemAccessExtension2).getURI(".toolchain.arm-linux-gnueabihf.cmake")
		// Console.instance.log(java.util.logging.Level.INFO, "generated "+CommonPlugin.resolve(uri));
		// Console.instance.log(java.util.logging.Level.INFO, "generated "+CommonPlugin.resolve(resource.URI));
//		var path = Paths.get("./apps/CMakeLists.txt");
//		var currentRelativePath = Paths.get("");
//		var s = currentRelativePath.toAbsolutePath().toString();
//
//		Console.instance.log(java.util.logging.Level.INFO, s + " is current");
//
//		// if (Files.exists(path))
//		// {
//		if (fsa.isFile("CMakeLists.txt", IFileSystemAccess::DEFAULT_OUTPUT)) {
//			var seq = fsa.readTextFile("CMakeLists.txt", IFileSystemAccess::DEFAULT_OUTPUT)
//			var StringBuilder data = new StringBuilder(seq)
//
//			Console.instance.log(java.util.logging.Level.SEVERE, data.toString);
//			for (a : Appname) {
//				var contentToCheck = appEntry(a)
//				if (!data.toString.contains(contentToCheck)) {
//					data.append(contentToCheck)
//				}
//			}
//			fsa.generateFile(
//				"CMakeLists.txt",
//				IFileSystemAccess::DEFAULT_OUTPUT,
//				data
//			)
//		} else {
//
//			// }
//			
//
//		}
		fsa.generateFile(
			"CMakeLists.txt",
			RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE,
			createTopCmakeLists(Appname, libraryTarget, MessageTarget)
		)
		fsa.generateFile(
			".clang-format",
			RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE,
			clangformatter
		)
	}

	def appEntry(String a) {
		'''
			add_subdirectory(${CMAKE_SOURCE_DIR}/«a»)
		'''
	}

	protected def void generateForApp(Application myapp, IFileSystemAccess2 fsa, Iterable<Component> globalcomponents,
		Iterable<DeviceType> globalDevices, HashSet<String> Appname, HashMap<CompCpp, CharSequence> libraryTarget,
		HashMap<FType, CharSequence> MessageTarget) {

		// check and return if e contains messages that do not have a type
		
		var AppCpp appCpp;
		try {
			appCpp = new AppCpp(myapp, this, globalcomponents, globalDevices)
			Appname.add(appCpp.applicationName)
		for (comp : appCpp.compList) {

			var base_h = comp.generateBaseH()
			var base_h_path = "//include//" + comp.componentName + "Base.h"
			fsa.generateFile(
				base_h_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_BASE_INCLUDE,
				base_h.beautify
			)
			// Console.instance.log(java.util.logging.Level.INFO, base_h_path + " generated");
			var base_cpp = comp.generateBaseCpp()
			var base_cpp_path = comp.componentName + "Base.cc"
			fsa.generateFile(
				base_cpp_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_BASE_SRC,
				base_cpp.beautify
			)
///			Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");
			var fw_h = comp.generateFW_H()
			var fw_h_path = "//include//" + comp.componentName + ".h"
			fsa.generateFile(
				fw_h_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_INCLUDE,
				fw_h.beautify
			)
			// Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");
			var fw_cpp = comp.generateFW_Cpp()
			var fw_cpp_path = comp.componentName + ".cc"
			fsa.generateFile(
				fw_cpp_path,
				RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_SRC,
				fw_cpp.beautify
			)
			// Console.instance.log(java.util.logging.Level.INFO, base_cpp_path + " generated");
			if (comp.comp_.getLanguage() == null || comp.comp_.getLanguage() == SupportLanguages.PY ||
				comp.comp_.getLanguage() == SupportLanguages.PYTHON) {
				var python_file_path = comp.componentName + ".py"
				// if (!fsa.isFile(python_file_path)) {
				fsa.generateFile(
					python_file_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_PYTHON,
					comp.generate_python
				)
			}
		}
		createCMakeList(appCpp, libraryTarget, MessageTarget)
		return
		} catch (NullPointerException except) {
			Console.instance.log(java.util.logging.Level.SEVERE,
				"@todo You probably have an untyped message. C++ code will not be generated. But we still need to check and generate python code");			
		}		
		
		//try to generate python code
		

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

	def createTopCmakeLists(HashSet<String> Appname, HashMap<CompCpp, CharSequence> libraryTarget,
		HashMap<FType, CharSequence> MessageTarget) {
		'''
			cmake_minimum_required(VERSION 3.0)
			set(CMAKE_SYSTEM_NAME Linux)
			set(CMAKE_CXX_FLAGS "-std=c++11")
			set(CMAKE_C_FLAGS "-std=c99")
			set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${CMAKE_SOURCE_DIR}/build/${ARCH}/bin)
			set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${CMAKE_RUNTIME_OUTPUT_DIRECTORY})
			set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY  ${CMAKE_RUNTIME_OUTPUT_DIRECTORY})
			#Library Dependencies
			set(DEPENDENCIES ${RIAPS_PREFIX})
			set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/include)
			set (LIBALLPATH_LIB ${DEPENDENCIES}/lib)
			link_directories(${LIBALLPATH_LIB})
			include_directories(${CMAKE_SOURCE_DIR}//messages-gen)
			include_directories(${CMAKE_SOURCE_DIR}/cpp/include)
			«««			«FOR a : Appname»
«««				include(«a».cmake)
«««			«ENDFOR»
			«FOR m : MessageTarget.keySet»
				
				# Generating the headers and cpp for message «m»
				«MessageTarget.get(m)»
			«ENDFOR»
			«FOR m : libraryTarget.keySet»
				
				«IF m.comp_==null»
					# Creating Libraries for Component «m.device_»
				«ELSE»
					# Creating Libraries for Component «m.comp_»
				«ENDIF»
				«libraryTarget.get(m)»
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

	def void createCMakeList(AppCpp app, HashMap<CompCpp, CharSequence> libraryTarget,
		HashMap<FType, CharSequence> MessageTarget) {
		val capnpMsgs = new HashSet<FType>
		for (c : app.compList) {
			for (i : c.msgIncludes) {
				capnpMsgs.add(i)
				for (e1 : i.elements) {
					if (e1.type.derived !== null) {
						capnpMsgs.add(e1.type.derived)
					}
				}
			}
			var libout = '''
				add_library(«c.componentName» 
							SHARED ${CMAKE_CURRENT_SOURCE_DIR}/cpp/«c.componentName».cc
							${CMAKE_CURRENT_SOURCE_DIR}/cpp/«c.componentName»Base.cc
							«FOR i : c.msgIncludes»
								${CMAKE_SOURCE_DIR}/messages-gen/«i.fullyQualifiedName.toString("/")».capnp.c++
								«FOR el: i.elements»
									«IF el.type.derived!==null»
										${CMAKE_SOURCE_DIR}/messages-gen/«el.type.derived.fullyQualifiedName.toString("/")».capnp.c++					
									«ENDIF»
								«ENDFOR»
							«ENDFOR»
							)
							
				«IF c.libraries.size==0»			
					target_link_libraries(«c.componentName» czmq riaps dl capnp kj)
				«ELSE»
					target_link_libraries(«c.componentName» czmq riaps dl capnp kj «FOR l:c.libraries SEPARATOR " "»«l»«ENDFOR»)
				«ENDIF»
				install(TARGETS «c.componentName» DESTINATION lib)
			'''
			libraryTarget.put(c, libout)

		}
		for (i : capnpMsgs) {
			var out = '''
				add_custom_command(OUTPUT  "${CMAKE_SOURCE_DIR}/messages-gen/«i.fullyQualifiedName.toString("/")».capnp.c++"
								   DEPENDS "${CMAKE_SOURCE_DIR}/messages-gen/«i.fullyQualifiedName.toString("/")».capnp" 
								   WORKING_DIRECTORY "${CMAKE_SOURCE_DIR}//messages-gen"  
								   COMMAND ${CMAKE_COMMAND} -E env "PATH=/opt/riaps/amd64/bin" capnp compile -oc++ "${CMAKE_SOURCE_DIR}/messages-gen/«i.fullyQualifiedName.toString("/")».capnp" --import-path="${CMAKE_SOURCE_DIR}//messages-gen"
								   )
			'''
			MessageTarget.put(i, out)
		}

	}

	def String clangformatter() {
		'''
			---
			Language:        Cpp
			# BasedOnStyle:  LLVM
			AccessModifierOffset: -2
			AlignAfterOpenBracket: Align
			AlignConsecutiveAssignments: false
			AlignConsecutiveDeclarations: false
			AlignEscapedNewlinesLeft: false
			AlignOperands:   true
			AlignTrailingComments: true
			AllowAllParametersOfDeclarationOnNextLine: true
			AllowShortBlocksOnASingleLine: false
			AllowShortCaseLabelsOnASingleLine: false
			AllowShortFunctionsOnASingleLine: All
			AllowShortIfStatementsOnASingleLine: false
			AllowShortLoopsOnASingleLine: false
			AlwaysBreakAfterDefinitionReturnType: None
			AlwaysBreakAfterReturnType: None
			AlwaysBreakBeforeMultilineStrings: false
			AlwaysBreakTemplateDeclarations: false
			BinPackArguments: true
			BinPackParameters: true
			BraceWrapping:   
			  AfterClass:      false
			  AfterControlStatement: false
			  AfterEnum:       false
			  AfterFunction:   false
			  AfterNamespace:  false
			  AfterObjCDeclaration: false
			  AfterStruct:     false
			  AfterUnion:      false
			  BeforeCatch:     false
			  BeforeElse:      false
			  IndentBraces:    false
			BreakBeforeBinaryOperators: None
			BreakBeforeBraces: Attach
			BreakBeforeTernaryOperators: true
			BreakConstructorInitializersBeforeComma: false
			ColumnLimit:     80
			CommentPragmas:  '^ IWYU pragma:'
			ConstructorInitializerAllOnOneLineOrOnePerLine: false
			ConstructorInitializerIndentWidth: 4
			ContinuationIndentWidth: 4
			Cpp11BracedListStyle: true
			DerivePointerAlignment: false
			DisableFormat:   false
			ExperimentalAutoDetectBinPacking: false
			ForEachMacros:   [ foreach, Q_FOREACH, BOOST_FOREACH ]
			IncludeCategories: 
			  - Regex:           '^"(llvm|llvm-c|clang|clang-c)/'
			    Priority:        2
			  - Regex:           '^(<|"(gtest|isl|json)/)'
			    Priority:        3
			  - Regex:           '.*'
			    Priority:        1
			IndentCaseLabels: false
			IndentWidth:     2
			IndentWrappedFunctionNames: false
			KeepEmptyLinesAtTheStartOfBlocks: true
			MacroBlockBegin: ''
			MacroBlockEnd:   ''
			MaxEmptyLinesToKeep: 1
			NamespaceIndentation: All 
			ObjCBlockIndentWidth: 2
			ObjCSpaceAfterProperty: false
			ObjCSpaceBeforeProtocolList: true
			PenaltyBreakBeforeFirstCallParameter: 19
			PenaltyBreakComment: 300
			PenaltyBreakFirstLessLess: 120
			PenaltyBreakString: 1000
			PenaltyExcessCharacter: 1000000
			PenaltyReturnTypeOnItsOwnLine: 60
			PointerAlignment: Right
			ReflowComments:  true
			SortIncludes:    true
			SpaceAfterCStyleCast: false
			SpaceBeforeAssignmentOperators: true
			SpaceBeforeParens: ControlStatements
			SpaceInEmptyParentheses: false
			SpacesBeforeTrailingComments: 1
			SpacesInAngles:  false
			SpacesInContainerLiterals: true
			SpacesInCStyleCastParentheses: false
			SpacesInParentheses: false
			SpacesInSquareBrackets: false
			Standard:        Cpp11
			TabWidth:        8
			UseTab:          Never
			...
		'''
	}
}

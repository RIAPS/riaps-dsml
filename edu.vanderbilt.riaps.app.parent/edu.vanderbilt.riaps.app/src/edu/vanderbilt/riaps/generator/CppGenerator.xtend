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
import edu.vanderbilt.riaps.app.Model
import java.nio.file.Paths
import java.util.HashMap
import edu.vanderbilt.riaps.generator.cpp.CompCpp
import org.eclipse.swt.internal.Platform
import org.eclipse.core.runtime.URIUtil
import org.eclipse.core.runtime.FileLocator
import org.eclipse.xtext.generator.IFileSystemAccessExtension2
import org.eclipse.emf.common.CommonPlugin
import java.util.ArrayList
import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.generator.cpp.TimerPortCpp
import edu.vanderbilt.riaps.generator.json.TimePort
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.InsPort
import edu.vanderbilt.riaps.app.AnswerPort
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.TimPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.RepPort
import java.util.Properties
import java.io.StringReader

public class CppGenerator extends AbstractGenerator {

	var cppProjectType=true
	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var HashSet<String> Appname = new HashSet<String>
		var HashMap<CompCpp, CharSequence> libraryTarget = new HashMap<CompCpp, CharSequence>
		var HashMap<FType, CharSequence> MessageTarget = new HashMap<FType, CharSequence>
		if (fsa.isFile(".project.props", RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE)) {
			var seq = fsa.readTextFile(".project.props", RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE)
			var StringBuilder data = new StringBuilder(seq)
			 val p = new Properties();
   			p.load(new StringReader(data.toString));
			Console.instance.log(java.util.logging.Level.SEVERE, p.getProperty("ProjectType"));
			if(p.getProperty("ProjectType").toLowerCase.equals("pyapp"))
			{
				cppProjectType=false
				Console.instance.log(java.util.logging.Level.SEVERE, "setting cpp project type to false");
			}
		} else {
			Console.instance.log(java.util.logging.Level.SEVERE, ".project.props not found");
		}

		for (e : resource.allContents.toIterable.filter(Application)) {
			generateForApp(e, fsa, null,  Appname, libraryTarget, MessageTarget)
			fsa.generateFile(
				"package.sh",
				RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_CMAKE,
				createPackage(e)
			)
		}
		for (model : resource.allContents.toIterable.filter(Model)) {

			
			var globalcomponents = model.collections.filter(Component) // .filter(co|co.reuselib === null)
			generateForApp(null, fsa, globalcomponents, Appname, libraryTarget, MessageTarget)
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

		// var uri = (fsa as IFileSystemAccessExtension2).getURI(".toolchain.arm-linux-gnueabihf.cmake")
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
		fsa.generateFile(
			"readme.txt",
			RiapsOutputConfigurationProvider::DEFAULT_OUTPUT_THIRD_PARTY,
			"Put third party artifacts here"
		)
	}

	def createPackage(Application myapp) {

		var contents = '''			   
			set +e
			«IF cppProjectType==false»
			mkdir -p pkg
			cp -r python/* pkg
			cp -r json-gen/* pkg						
			«ENDIF»	
			export outputdir=`mktemp -d`
			mkdir $outputdir/«myapp.name»
			cp -r pkg/* $outputdir/«myapp.name»
			export currentdir=`pwd`
			cd  $outputdir
			tar czvf «myapp.name».tar.gz «myapp.name»/*
			cd $currentdir
			mv $outputdir/«myapp.name».tar.gz .   
			
		'''
		return contents
	}

	def appEntry(String a) {
		'''
			add_subdirectory(${CMAKE_SOURCE_DIR}/«a»)
		'''
	}

	protected def void generateForApp(Application myapp, IFileSystemAccess2 fsa, Iterable<Component> globalcomponents,
		 HashSet<String> Appname, HashMap<CompCpp, CharSequence> libraryTarget,
		HashMap<FType, CharSequence> MessageTarget) {

		// check and return if e contains messages that do not have a type
		var AppCpp appCpp = null;
		try {
			appCpp = new AppCpp(myapp, this, globalcomponents)
			Appname.add(appCpp.applicationName)

		} catch (NullPointerException except) {
			Console.instance.log(java.util.logging.Level.SEVERE,
				"@todo You probably have an untyped message. C++ code will not be generated. But we still need to check and generate python code");
		}

		if ((appCpp !== null) && (appCpp.compList !== null)) {
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
				// if (comp.comp_.getLanguage() === null || comp.comp_.getLanguage() == SupportLanguages.PY || comp.comp_.getLanguage() == SupportLanguages.PYTHON) {
				var python_file_path = comp.componentName + ".py"
				// if (!fsa.isFile(python_file_path)) {
				fsa.generateFile(
					python_file_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_PYTHON,
					comp.generate_python
				)
			// }
			}
			createCMakeList(appCpp, libraryTarget, MessageTarget)
		} else {
			for (comp : myapp.components) {
				var python_file_path = comp.name + ".py"
				// if (!fsa.isFile(python_file_path)) {
				fsa.generateFile(
					python_file_path,
					RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_DEV_PYTHON,
					comp.generate_python
				)
			}

		}

	// try to generate python code
	}

	def CharSequence generate_python(Component component) {
		var componentName = component.name
		var initialParams = new ArrayList<String>
		initialParams.add("self")
		for (ComponentFormal formal : component.getFormals()) {
			initialParams.add(formal.name)
		}
		'''
			#«componentName».py
			from riaps.run.comp import Component
			import os
			import logging
			
			class «componentName»(Component):
			    def __init__(«FOR p : initialParams SEPARATOR ','»«p»«ENDFOR»):
			        super(«componentName», self).__init__()
			        self.pid = os.getpid()
			        self.logger.info("(PID %s) - starting «componentName»",str(self.pid))
			        
			«FOR p : component.ports»
				«p.generate_python()»
			«ENDFOR»    
			    
			    def __destroy__(self):
			    self.logger.info("(PID %s) - stopping «componentName»",str(self.pid))   	        	        
		'''

	}

	def CharSequence generate_python(Port port) {
		if (port instanceof PubPort) {
		}

		if (port instanceof SubPort) {
			val content = '''
				
				    def on_«port.name»(self):
				        msg = self.«port.name».recv_pyobj()
				        self.logger.info("PID (%s) - on_«port.name»():%s",str(self.pid), str(msg))
			'''
			return content
		}

		if (port instanceof ClntPort) {
			var portName = port.name
			val content = '''
				
				    def on_«port.name»(self):
				        req = self.«port.name».recv_pyobj()
				        self.logger.info("PID (%s) - on_«portName»():%s",str(self.pid),str(req))
			'''
			return content
		}

		if (port instanceof SrvPort) {

			val content = '''
				
				    def on_«port.name»(self):
				       msg = self.«port.name».recv_pyobj()
				       self.logger.info("PID (%s) - on_query():%s",str(self.pid),str(msg))
			'''
			return content
		}

		if (port instanceof ReqPort) {

			val content = '''
				
				    def on_«port.name»(self):
				       req = self.«port.name».recv_pyobj()
				       self.logger.info("PID (%s) - on_«port.name»():%s",str(self.pid),str(req))
			'''
			return content
		}
		if (port instanceof RepPort) {
			val content = '''
				
				    def on_«port.name»(self):
				       msg = self.«port.name».recv_pyobj()
				       self.logger.info("PID (%s) - on_query():%s",str(self.pid),str(msg))
			'''
			return content
		}

		if (port instanceof TimPort) {
			val content = '''
				
				    def on_«port.name»(self):
				       now = self.«port.name».recv_pyobj()
				       self.logger.info('PID(%s) - on_«port.name»(): %s',str(self.pid),str(now))
			'''
			return content
		}
		if (port instanceof QueryPort) {
		}
		if (port instanceof AnswerPort) {
		}
		if (port instanceof InsPort) {
		}

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
					# Creating Libraries for Component «m.comp_»
				
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
				add_library(«c.componentName.toLowerCase» 
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
					target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj)
				«ELSE»
					target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj «FOR l:c.libraries SEPARATOR " "»«l»«ENDFOR»)
				«ENDIF»
				install(TARGETS «c.componentName.toLowerCase» DESTINATION lib)
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
			PenaltyExcessCharacter: 0.9.1900
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

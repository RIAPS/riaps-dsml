package edu.vanderbilt.riaps.ui

import java.net.URI
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import java.util.ArrayList
import edu.vanderbilt.riaps.Console
import java.util.List
import java.util.Collections
import org.eclipse.core.resources.IFile
import java.io.InputStream
import java.io.ByteArrayInputStream
import org.eclipse.emf.edit.command.CreateChildCommand.Helper
import org.eclipse.core.resources.IResourceFilterDescription
import org.eclipse.core.resources.FileInfoMatcherDescription

class NewAppSupport {

	static val riapsNatures = #{'org.eclipse.cdt.make.core.makeNature', 'org.eclipse.cdt.make.core.ScannerConfigNature',
		'org.eclipse.cdt.core.ccnature', 'org.eclipse.cdt.core.cnature', 'org.eclipse.xtext.ui.shared.xtextNature'}

	// static val riapsNatures = #{'org.eclipse.xtext.ui.shared.xtextNature'}
	/** 
	 * For this marvelous project we need to:
	 * - create the default Eclipse project
	 * - add the custom project nature
	 * - create the folder structure
	 * @param projectName
	 * @param location
	 * @param natureId
	 * @return
	 */
	def static IProject createProject(String projectName, URI location) {
		Assert.isNotNull(projectName)
		Assert.isTrue(projectName.trim().length() > 0)
		var IProject project = createBaseProject(projectName, location)
	
		try {
			addNature(project)
			//var String[] paths = #["src/build/armhf", "src/build/amd64"]
			//addToProjectStructureFolder(project, paths)
			addMakefile(project)
			addCproject(project)
		} catch (CoreException e) {
			e.printStackTrace()
			project = null
		}

		return project
	}

	/** 
	 * Just do the basics: create a basic project.
	 * @param location
	 * @param projectName
	 */
	def private static IProject createBaseProject(String projectName, URI location) {
		// it is acceptable to use the ResourcesPlugin class
		var IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
		if (!newProject.exists()) {
			var URI projectLocation = location
			var IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName())
			if (location !== null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
				projectLocation = null
			}
			desc.setLocationURI(projectLocation)
			try {
				newProject.create(desc, null)
				if (!newProject.isOpen()) {
					newProject.open(null)
				}
			} catch (CoreException e) {
				e.printStackTrace()
			}

		}
		return newProject
	}

	def private static void createFolder(IFolder folder) throws CoreException {
		var IContainer parent = folder.getParent()
		if (parent instanceof IFolder) {
			createFolder((parent as IFolder))
		}
		if (!folder.exists()) {
			folder.create(false, true, null)
		}
	}

	def private static createMakefile() {
		'''
		CMAKE := $(shell which cmake 2> /dev/null)
		CLANG-FORMAT := $(shell which clang-format 2> /dev/null)
		RM-CMD := $(shell which rm 2> /dev/null)
		all: bin/armhf/build/Makefile bin/amd64/build/Makefile all-armhf all-amd64
		
		realclean:		 
		ifndef RM-CMD
			rmdir bin /s /q
		else
			$(shell rm -rf bin)
		endif
		
		bin/armhf/build/Makefile: CMakeLists.txt
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			mkdir -p bin/armhf/build
			cd bin/armhf/build/ && \
			cmake -DCMAKE_TOOLCHAIN_FILE=.toolchain.arm-linux-gnueabihf.cmake  ../../..
			@echo "done"
		endif
		
		bin/amd64/build/Makefile: CMakeLists.txt
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			mkdir -p bin/amd64/build/
			cd bin/amd64/build/ && \
			cmake -DCMAKE_TOOLCHAIN_FILE=.toolchain.amd64.cmake  ../../..
			@echo "done"
		endif
		
		all-amd64: bin/amd64/build/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C bin/amd64/build -j2
		endif
		
		all-armhf: bin/armhf/build/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C bin/armhf/build -j2
		endif
		
		
		clean-armhf: bin/armhf/build/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C bin/armhf/build clean -j2
		endif
		
		clean-amd64: bin/amd64/build/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C bin/amd64/build clean -j2
		endif
		
		reformat: cpp
		ifndef CLANG-FORMAT
			$(error "clang-format is not available. Please install")
		else
			clang-format -i -style=file cpp/*.cc
			clang-format -i -style=file cpp/include/*.h
		endif
		
		'''
	}
	
	def private static createCProject(String path){
		'''
		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
		<?fileVersion 4.0.0?><cproject>
			<storageModule moduleId="org.eclipse.cdt.core.settings">
				<cconfiguration id="org.eclipse.cdt.core.default.config.1">
					<storageModule buildSystemId="org.eclipse.cdt.core.defaultConfigDataProvider" id="org.eclipse.cdt.core.default.config.1" moduleId="org.eclipse.cdt.core.settings" name="Configuration">
						<externalSettings/>
						<extensions>
							<extension id="org.eclipse.cdt.core.ELF" point="org.eclipse.cdt.core.BinaryParser"/>
							<extension id="org.eclipse.cdt.core.GNU_ELF" point="org.eclipse.cdt.core.BinaryParser"/>
						</extensions>
					</storageModule>
					<storageModule moduleId="org.eclipse.cdt.core.language.mapping">
						<project-mappings/>
					</storageModule>
					<storageModule moduleId="org.eclipse.cdt.core.externalSettings"/>
				</cconfiguration>
			</storageModule>
			<storageModule moduleId="cdtBuildSystem" version="4.0.0">
				<project id="Project.null.1" name="Project"/>
			</storageModule>
			<storageModule moduleId="scannerConfiguration">
				<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId="org.eclipse.cdt.make.core.GCCStandardMakePerProjectProfile"/>
				<profile id="org.eclipse.cdt.make.core.GCCStandardMakePerProjectProfile">
					<buildOutputProvider>
						<openAction enabled="true" filePath=""/>
						<parser enabled="true"/>
					</buildOutputProvider>l
		<scannerInfoProvider id="specsFile">
						<runAction arguments="-E -P -v -dD ${plugin_state_location}/${specs_file}" command="/usr/bin/arm-linux-gnueabihf-gcc" useDefault="true"/>
						<parser enabled="true"/>
					</scannerInfoProvider>
				</profile>
				<profile id="org.eclipse.cdt.make.core.GCCStandardMakePerFileProfile">
					<buildOutputProvider>
						<openAction enabled="true" filePath=""/>
						<parser enabled="true"/>
					</buildOutputProvider>
					<scannerInfoProvider id="makefileGenerator">
						<runAction arguments="-f ${project_name}_scd.mk" command="make" useDefault="true"/>
						<parser enabled="true"/>
					</scannerInfoProvider>
				</profile>
			</storageModule>
			<storageModule moduleId="org.eclipse.cdt.core.pathentry">
				<pathentry excluding="**/CMakeFiles/" kind="out" path=""/>
				<pathentry kind="mac" name="__STDC__" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_VERSION__" path="" value="201112L"/>
				<pathentry kind="mac" name="__STDC_UTF_16__" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_UTF_32__" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_HOSTED__" path="" value="1"/>
				<pathentry kind="mac" name="__GNUC__" path="" value="5"/>
				<pathentry kind="mac" name="__GNUC_MINOR__" path="" value="4"/>
				<pathentry kind="mac" name="__GNUC_PATCHLEVEL__" path="" value=" "/>
				<pathentry kind="mac" name="__VERSION__" path="" value="&quot;5.4.0 20160609&quot;"/>
				<pathentry kind="mac" name="__ATOMIC_RELAXED" path="" value=" "/>
				<pathentry kind="mac" name="__ATOMIC_SEQ_CST" path="" value="5"/>
				<pathentry kind="mac" name="__ATOMIC_ACQUIRE" path="" value="2"/>
				<pathentry kind="mac" name="__ATOMIC_RELEASE" path="" value="3"/>
				<pathentry kind="mac" name="__ATOMIC_ACQ_REL" path="" value="4"/>
				<pathentry kind="mac" name="__ATOMIC_CONSUME" path="" value="1"/>
				<pathentry kind="mac" name="__FINITE_MATH_ONLY__" path="" value=" "/>
				<pathentry kind="mac" name="__SIZEOF_INT__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZEOF_LONG__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZEOF_LONG_LONG__" path="" value="8"/>
				<pathentry kind="mac" name="__SIZEOF_SHORT__" path="" value="2"/>
				<pathentry kind="mac" name="__SIZEOF_FLOAT__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZEOF_DOUBLE__" path="" value="8"/>
				<pathentry kind="mac" name="__SIZEOF_LONG_DOUBLE__" path="" value="8"/>
				<pathentry kind="mac" name="__SIZEOF_SIZE_T__" path="" value="4"/>
				<pathentry kind="mac" name="__CHAR_BIT__" path="" value="8"/>
				<pathentry kind="mac" name="__BIGGEST_ALIGNMENT__" path="" value="8"/>
				<pathentry kind="mac" name="__ORDER_LITTLE_ENDIAN__" path="" value="1234"/>
				<pathentry kind="mac" name="__ORDER_BIG_ENDIAN__" path="" value="4321"/>
				<pathentry kind="mac" name="__ORDER_PDP_ENDIAN__" path="" value="3412"/>
				<pathentry kind="mac" name="__BYTE_ORDER__" path="" value="__ORDER_LITTLE_ENDIAN__"/>
				<pathentry kind="mac" name="__FLOAT_WORD_ORDER__" path="" value="__ORDER_LITTLE_ENDIAN__"/>
				<pathentry kind="mac" name="__SIZEOF_POINTER__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZE_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__PTRDIFF_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__WCHAR_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__WINT_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__INTMAX_TYPE__" path="" value="long long int"/>
				<pathentry kind="mac" name="__UINTMAX_TYPE__" path="" value="long long unsigned int"/>
				<pathentry kind="mac" name="__CHAR16_TYPE__" path="" value="short unsigned int"/>
				<pathentry kind="mac" name="__CHAR32_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__SIG_ATOMIC_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__INT8_TYPE__" path="" value="signed char"/>
				<pathentry kind="mac" name="__INT16_TYPE__" path="" value="short int"/>
				<pathentry kind="mac" name="__INT32_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__INT64_TYPE__" path="" value="long long int"/>
				<pathentry kind="mac" name="__UINT8_TYPE__" path="" value="unsigned char"/>
				<pathentry kind="mac" name="__UINT16_TYPE__" path="" value="short unsigned int"/>
				<pathentry kind="mac" name="__UINT32_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__UINT64_TYPE__" path="" value="long long unsigned int"/>
				<pathentry kind="mac" name="__INT_LEAST8_TYPE__" path="" value="signed char"/>
				<pathentry kind="mac" name="__INT_LEAST16_TYPE__" path="" value="short int"/>
				<pathentry kind="mac" name="__INT_LEAST32_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__INT_LEAST64_TYPE__" path="" value="long long int"/>
				<pathentry kind="mac" name="__UINT_LEAST8_TYPE__" path="" value="unsigned char"/>
				<pathentry kind="mac" name="__UINT_LEAST16_TYPE__" path="" value="short unsigned int"/>
				<pathentry kind="mac" name="__UINT_LEAST32_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__UINT_LEAST64_TYPE__" path="" value="long long unsigned int"/>
				<pathentry kind="mac" name="__INT_FAST8_TYPE__" path="" value="signed char"/>
				<pathentry kind="mac" name="__INT_FAST16_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__INT_FAST32_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__INT_FAST64_TYPE__" path="" value="long long int"/>
				<pathentry kind="mac" name="__UINT_FAST8_TYPE__" path="" value="unsigned char"/>
				<pathentry kind="mac" name="__UINT_FAST16_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__UINT_FAST32_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__UINT_FAST64_TYPE__" path="" value="long long unsigned int"/>
				<pathentry kind="mac" name="__INTPTR_TYPE__" path="" value="int"/>
				<pathentry kind="mac" name="__UINTPTR_TYPE__" path="" value="unsigned int"/>
				<pathentry kind="mac" name="__has_include(STR)" path="" value="__has_include__(STR)"/>
				<pathentry kind="mac" name="__has_include_next(STR)" path="" value="__has_include_next__(STR)"/>
				<pathentry kind="mac" name="__GXX_ABI_VERSION" path="" value="1009"/>
				<pathentry kind="mac" name="__SCHAR_MAX__" path="" value="0x7f"/>
				<pathentry kind="mac" name="__SHRT_MAX__" path="" value="0x7fff"/>
				<pathentry kind="mac" name="__INT_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__LONG_MAX__" path="" value="0x7fffffffL"/>
				<pathentry kind="mac" name="__LONG_LONG_MAX__" path="" value="0x7fffffffffffffffLL"/>
				<pathentry kind="mac" name="__WCHAR_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__WCHAR_MIN__" path="" value="0U"/>
				<pathentry kind="mac" name="__WINT_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__WINT_MIN__" path="" value="0U"/>
				<pathentry kind="mac" name="__PTRDIFF_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__SIZE_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__INTMAX_MAX__" path="" value="0x7fffffffffffffffLL"/>
				<pathentry kind="mac" name="__INTMAX_C(c)" path="" value="c ## LL"/>
				<pathentry kind="mac" name="__UINTMAX_MAX__" path="" value="0xffffffffffffffffULL"/>
				<pathentry kind="mac" name="__UINTMAX_C(c)" path="" value="c ## ULL"/>
				<pathentry kind="mac" name="__SIG_ATOMIC_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__SIG_ATOMIC_MIN__" path="" value="(-__SIG_ATOMIC_MAX__ - 1)"/>
				<pathentry kind="mac" name="__INT8_MAX__" path="" value="0x7f"/>
				<pathentry kind="mac" name="__INT16_MAX__" path="" value="0x7fff"/>
				<pathentry kind="mac" name="__INT32_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__INT64_MAX__" path="" value="0x7fffffffffffffffLL"/>
				<pathentry kind="mac" name="__UINT8_MAX__" path="" value="0xff"/>
				<pathentry kind="mac" name="__UINT16_MAX__" path="" value="0xffff"/>
				<pathentry kind="mac" name="__UINT32_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__UINT64_MAX__" path="" value="0xffffffffffffffffULL"/>
				<pathentry kind="mac" name="__INT_LEAST8_MAX__" path="" value="0x7f"/>
				<pathentry kind="mac" name="__INT8_C(c)" path="" value="c"/>
				<pathentry kind="mac" name="__INT_LEAST16_MAX__" path="" value="0x7fff"/>
				<pathentry kind="mac" name="__INT16_C(c)" path="" value="c"/>
				<pathentry kind="mac" name="__INT_LEAST32_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__INT32_C(c)" path="" value="c"/>
				<pathentry kind="mac" name="__INT_LEAST64_MAX__" path="" value="0x7fffffffffffffffLL"/>
				<pathentry kind="mac" name="__INT64_C(c)" path="" value="c ## LL"/>
				<pathentry kind="mac" name="__UINT_LEAST8_MAX__" path="" value="0xff"/>
				<pathentry kind="mac" name="__UINT8_C(c)" path="" value="c"/>
				<pathentry kind="mac" name="__UINT_LEAST16_MAX__" path="" value="0xffff"/>
				<pathentry kind="mac" name="__UINT16_C(c)" path="" value="c"/>
				<pathentry kind="mac" name="__UINT_LEAST32_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__UINT32_C(c)" path="" value="c ## U"/>
				<pathentry kind="mac" name="__UINT_LEAST64_MAX__" path="" value="0xffffffffffffffffULL"/>
				<pathentry kind="mac" name="__UINT64_C(c)" path="" value="c ## ULL"/>
				<pathentry kind="mac" name="__INT_FAST8_MAX__" path="" value="0x7f"/>
				<pathentry kind="mac" name="__INT_FAST16_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__INT_FAST32_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__INT_FAST64_MAX__" path="" value="0x7fffffffffffffffLL"/>
				<pathentry kind="mac" name="__UINT_FAST8_MAX__" path="" value="0xff"/>
				<pathentry kind="mac" name="__UINT_FAST16_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__UINT_FAST32_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__UINT_FAST64_MAX__" path="" value="0xffffffffffffffffULL"/>
				<pathentry kind="mac" name="__INTPTR_MAX__" path="" value="0x7fffffff"/>
				<pathentry kind="mac" name="__UINTPTR_MAX__" path="" value="0xffffffffU"/>
				<pathentry kind="mac" name="__GCC_IEC_559" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_IEC_559_COMPLEX" path="" value="2"/>
				<pathentry kind="mac" name="__FLT_EVAL_METHOD__" path="" value=" "/>
				<pathentry kind="mac" name="__DEC_EVAL_METHOD__" path="" value="2"/>
				<pathentry kind="mac" name="__FLT_RADIX__" path="" value="2"/>
				<pathentry kind="mac" name="__FLT_MANT_DIG__" path="" value="24"/>
				<pathentry kind="mac" name="__FLT_DIG__" path="" value="6"/>
				<pathentry kind="mac" name="__FLT_MIN_EXP__" path="" value="(-125)"/>
				<pathentry kind="mac" name="__FLT_MIN_10_EXP__" path="" value="(-37)"/>
				<pathentry kind="mac" name="__FLT_MAX_EXP__" path="" value="128"/>
				<pathentry kind="mac" name="__FLT_MAX_10_EXP__" path="" value="38"/>
				<pathentry kind="mac" name="__FLT_DECIMAL_DIG__" path="" value="9"/>
				<pathentry kind="mac" name="__FLT_MAX__" path="" value="3.4028234663852886e+38F"/>
				<pathentry kind="mac" name="__FLT_MIN__" path="" value="1.1754943508222875e-38F"/>
				<pathentry kind="mac" name="__FLT_EPSILON__" path="" value="1.1920928955078125e-7F"/>
				<pathentry kind="mac" name="__FLT_DENORM_MIN__" path="" value="1.4012984643248171e-45F"/>
				<pathentry kind="mac" name="__FLT_HAS_DENORM__" path="" value="1"/>
				<pathentry kind="mac" name="__FLT_HAS_INFINITY__" path="" value="1"/>
				<pathentry kind="mac" name="__FLT_HAS_QUIET_NAN__" path="" value="1"/>
				<pathentry kind="mac" name="__DBL_MANT_DIG__" path="" value="53"/>
				<pathentry kind="mac" name="__DBL_DIG__" path="" value="15"/>
				<pathentry kind="mac" name="__DBL_MIN_EXP__" path="" value="(-1021)"/>
				<pathentry kind="mac" name="__DBL_MIN_10_EXP__" path="" value="(-307)"/>
				<pathentry kind="mac" name="__DBL_MAX_EXP__" path="" value="1024"/>
				<pathentry kind="mac" name="__DBL_MAX_10_EXP__" path="" value="308"/>
				<pathentry kind="mac" name="__DBL_DECIMAL_DIG__" path="" value="17"/>
				<pathentry kind="mac" name="__DBL_MAX__" path="" value="((double)1.7976931348623157e+308L)"/>
				<pathentry kind="mac" name="__DBL_MIN__" path="" value="((double)2.2250738585072014e-308L)"/>
				<pathentry kind="mac" name="__DBL_EPSILON__" path="" value="((double)2.2204460492503131e-16L)"/>
				<pathentry kind="mac" name="__DBL_DENORM_MIN__" path="" value="((double)4.9406564584124654e-324L)"/>
				<pathentry kind="mac" name="__DBL_HAS_DENORM__" path="" value="1"/>
				<pathentry kind="mac" name="__DBL_HAS_INFINITY__" path="" value="1"/>
				<pathentry kind="mac" name="__DBL_HAS_QUIET_NAN__" path="" value="1"/>
				<pathentry kind="mac" name="__LDBL_MANT_DIG__" path="" value="53"/>
				<pathentry kind="mac" name="__LDBL_DIG__" path="" value="15"/>
				<pathentry kind="mac" name="__LDBL_MIN_EXP__" path="" value="(-1021)"/>
				<pathentry kind="mac" name="__LDBL_MIN_10_EXP__" path="" value="(-307)"/>
				<pathentry kind="mac" name="__LDBL_MAX_EXP__" path="" value="1024"/>
				<pathentry kind="mac" name="__LDBL_MAX_10_EXP__" path="" value="308"/>
				<pathentry kind="mac" name="__DECIMAL_DIG__" path="" value="17"/>
				<pathentry kind="mac" name="__LDBL_MAX__" path="" value="1.7976931348623157e+308L"/>
				<pathentry kind="mac" name="__LDBL_MIN__" path="" value="2.2250738585072014e-308L"/>
				<pathentry kind="mac" name="__LDBL_EPSILON__" path="" value="2.2204460492503131e-16L"/>
				<pathentry kind="mac" name="__LDBL_DENORM_MIN__" path="" value="4.9406564584124654e-324L"/>
				<pathentry kind="mac" name="__LDBL_HAS_DENORM__" path="" value="1"/>
				<pathentry kind="mac" name="__LDBL_HAS_INFINITY__" path="" value="1"/>
				<pathentry kind="mac" name="__LDBL_HAS_QUIET_NAN__" path="" value="1"/>
				<pathentry kind="mac" name="__DEC32_MANT_DIG__" path="" value="7"/>
				<pathentry kind="mac" name="__DEC32_MIN_EXP__" path="" value="(-94)"/>
				<pathentry kind="mac" name="__DEC32_MAX_EXP__" path="" value="97"/>
				<pathentry kind="mac" name="__DEC32_MIN__" path="" value="1E-95DF"/>
				<pathentry kind="mac" name="__DEC32_MAX__" path="" value="9.999999E96DF"/>
				<pathentry kind="mac" name="__DEC32_EPSILON__" path="" value="1E-6DF"/>
				<pathentry kind="mac" name="__DEC32_SUBNORMAL_MIN__" path="" value="0.000001E-95DF"/>
				<pathentry kind="mac" name="__DEC64_MANT_DIG__" path="" value="16"/>
				<pathentry kind="mac" name="__DEC64_MIN_EXP__" path="" value="(-382)"/>
				<pathentry kind="mac" name="__DEC64_MAX_EXP__" path="" value="385"/>
				<pathentry kind="mac" name="__DEC64_MIN__" path="" value="1E-383DD"/>
				<pathentry kind="mac" name="__DEC64_MAX__" path="" value="9.999999999999999E384DD"/>
				<pathentry kind="mac" name="__DEC64_EPSILON__" path="" value="1E-15DD"/>
				<pathentry kind="mac" name="__DEC64_SUBNORMAL_MIN__" path="" value="0.000000000000001E-383DD"/>
				<pathentry kind="mac" name="__DEC128_MANT_DIG__" path="" value="34"/>
				<pathentry kind="mac" name="__DEC128_MIN_EXP__" path="" value="(-6142)"/>
				<pathentry kind="mac" name="__DEC128_MAX_EXP__" path="" value="6145"/>
				<pathentry kind="mac" name="__DEC128_MIN__" path="" value="1E-6143DL"/>
				<pathentry kind="mac" name="__DEC128_MAX__" path="" value="9.999999999999999999999999999999999E6144DL"/>
				<pathentry kind="mac" name="__DEC128_EPSILON__" path="" value="1E-33DL"/>
				<pathentry kind="mac" name="__DEC128_SUBNORMAL_MIN__" path="" value="0.000000000000000000000000000000001E-6143DL"/>
				<pathentry kind="mac" name="__SFRACT_FBIT__" path="" value="7"/>
				<pathentry kind="mac" name="__SFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__SFRACT_MIN__" path="" value="(-0.5HR-0.5HR)"/>
				<pathentry kind="mac" name="__SFRACT_MAX__" path="" value="0X7FP-7HR"/>
				<pathentry kind="mac" name="__SFRACT_EPSILON__" path="" value="0x1P-7HR"/>
				<pathentry kind="mac" name="__USFRACT_FBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__USFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__USFRACT_MIN__" path="" value="0.0UHR"/>
				<pathentry kind="mac" name="__USFRACT_MAX__" path="" value="0XFFP-8UHR"/>
				<pathentry kind="mac" name="__USFRACT_EPSILON__" path="" value="0x1P-8UHR"/>
				<pathentry kind="mac" name="__FRACT_FBIT__" path="" value="15"/>
				<pathentry kind="mac" name="__FRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__FRACT_MIN__" path="" value="(-0.5R-0.5R)"/>
				<pathentry kind="mac" name="__FRACT_MAX__" path="" value="0X7FFFP-15R"/>
				<pathentry kind="mac" name="__FRACT_EPSILON__" path="" value="0x1P-15R"/>
				<pathentry kind="mac" name="__UFRACT_FBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__UFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__UFRACT_MIN__" path="" value="0.0UR"/>
				<pathentry kind="mac" name="__UFRACT_MAX__" path="" value="0XFFFFP-16UR"/>
				<pathentry kind="mac" name="__UFRACT_EPSILON__" path="" value="0x1P-16UR"/>
				<pathentry kind="mac" name="__LFRACT_FBIT__" path="" value="31"/>
				<pathentry kind="mac" name="__LFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__LFRACT_MIN__" path="" value="(-0.5LR-0.5LR)"/>
				<pathentry kind="mac" name="__LFRACT_MAX__" path="" value="0X7FFFFFFFP-31LR"/>
				<pathentry kind="mac" name="__LFRACT_EPSILON__" path="" value="0x1P-31LR"/>
				<pathentry kind="mac" name="__ULFRACT_FBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__ULFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__ULFRACT_MIN__" path="" value="0.0ULR"/>
				<pathentry kind="mac" name="__ULFRACT_MAX__" path="" value="0XFFFFFFFFP-32ULR"/>
				<pathentry kind="mac" name="__ULFRACT_EPSILON__" path="" value="0x1P-32ULR"/>
				<pathentry kind="mac" name="__LLFRACT_FBIT__" path="" value="63"/>
				<pathentry kind="mac" name="__LLFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__LLFRACT_MIN__" path="" value="(-0.5LLR-0.5LLR)"/>
				<pathentry kind="mac" name="__LLFRACT_MAX__" path="" value="0X7FFFFFFFFFFFFFFFP-63LLR"/>
				<pathentry kind="mac" name="__LLFRACT_EPSILON__" path="" value="0x1P-63LLR"/>
				<pathentry kind="mac" name="__ULLFRACT_FBIT__" path="" value="64"/>
				<pathentry kind="mac" name="__ULLFRACT_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__ULLFRACT_MIN__" path="" value="0.0ULLR"/>
				<pathentry kind="mac" name="__ULLFRACT_MAX__" path="" value="0XFFFFFFFFFFFFFFFFP-64ULLR"/>
				<pathentry kind="mac" name="__ULLFRACT_EPSILON__" path="" value="0x1P-64ULLR"/>
				<pathentry kind="mac" name="__SACCUM_FBIT__" path="" value="7"/>
				<pathentry kind="mac" name="__SACCUM_IBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__SACCUM_MIN__" path="" value="(-0X1P7HK-0X1P7HK)"/>
				<pathentry kind="mac" name="__SACCUM_MAX__" path="" value="0X7FFFP-7HK"/>
				<pathentry kind="mac" name="__SACCUM_EPSILON__" path="" value="0x1P-7HK"/>
				<pathentry kind="mac" name="__USACCUM_FBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__USACCUM_IBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__USACCUM_MIN__" path="" value="0.0UHK"/>
				<pathentry kind="mac" name="__USACCUM_MAX__" path="" value="0XFFFFP-8UHK"/>
				<pathentry kind="mac" name="__USACCUM_EPSILON__" path="" value="0x1P-8UHK"/>
				<pathentry kind="mac" name="__ACCUM_FBIT__" path="" value="15"/>
				<pathentry kind="mac" name="__ACCUM_IBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__ACCUM_MIN__" path="" value="(-0X1P15K-0X1P15K)"/>
				<pathentry kind="mac" name="__ACCUM_MAX__" path="" value="0X7FFFFFFFP-15K"/>
				<pathentry kind="mac" name="__ACCUM_EPSILON__" path="" value="0x1P-15K"/>
				<pathentry kind="mac" name="__UACCUM_FBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__UACCUM_IBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__UACCUM_MIN__" path="" value="0.0UK"/>
				<pathentry kind="mac" name="__UACCUM_MAX__" path="" value="0XFFFFFFFFP-16UK"/>
				<pathentry kind="mac" name="__UACCUM_EPSILON__" path="" value="0x1P-16UK"/>
				<pathentry kind="mac" name="__LACCUM_FBIT__" path="" value="31"/>
				<pathentry kind="mac" name="__LACCUM_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__LACCUM_MIN__" path="" value="(-0X1P31LK-0X1P31LK)"/>
				<pathentry kind="mac" name="__LACCUM_MAX__" path="" value="0X7FFFFFFFFFFFFFFFP-31LK"/>
				<pathentry kind="mac" name="__LACCUM_EPSILON__" path="" value="0x1P-31LK"/>
				<pathentry kind="mac" name="__ULACCUM_FBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__ULACCUM_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__ULACCUM_MIN__" path="" value="0.0ULK"/>
				<pathentry kind="mac" name="__ULACCUM_MAX__" path="" value="0XFFFFFFFFFFFFFFFFP-32ULK"/>
				<pathentry kind="mac" name="__ULACCUM_EPSILON__" path="" value="0x1P-32ULK"/>
				<pathentry kind="mac" name="__LLACCUM_FBIT__" path="" value="31"/>
				<pathentry kind="mac" name="__LLACCUM_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__LLACCUM_MIN__" path="" value="(-0X1P31LLK-0X1P31LLK)"/>
				<pathentry kind="mac" name="__LLACCUM_MAX__" path="" value="0X7FFFFFFFFFFFFFFFP-31LLK"/>
				<pathentry kind="mac" name="__LLACCUM_EPSILON__" path="" value="0x1P-31LLK"/>
				<pathentry kind="mac" name="__ULLACCUM_FBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__ULLACCUM_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__ULLACCUM_MIN__" path="" value="0.0ULLK"/>
				<pathentry kind="mac" name="__ULLACCUM_MAX__" path="" value="0XFFFFFFFFFFFFFFFFP-32ULLK"/>
				<pathentry kind="mac" name="__ULLACCUM_EPSILON__" path="" value="0x1P-32ULLK"/>
				<pathentry kind="mac" name="__QQ_FBIT__" path="" value="7"/>
				<pathentry kind="mac" name="__QQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__HQ_FBIT__" path="" value="15"/>
				<pathentry kind="mac" name="__HQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__SQ_FBIT__" path="" value="31"/>
				<pathentry kind="mac" name="__SQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__DQ_FBIT__" path="" value="63"/>
				<pathentry kind="mac" name="__DQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__TQ_FBIT__" path="" value="127"/>
				<pathentry kind="mac" name="__TQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__UQQ_FBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__UQQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__UHQ_FBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__UHQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__USQ_FBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__USQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__UDQ_FBIT__" path="" value="64"/>
				<pathentry kind="mac" name="__UDQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__UTQ_FBIT__" path="" value="128"/>
				<pathentry kind="mac" name="__UTQ_IBIT__" path="" value=" "/>
				<pathentry kind="mac" name="__HA_FBIT__" path="" value="7"/>
				<pathentry kind="mac" name="__HA_IBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__SA_FBIT__" path="" value="15"/>
				<pathentry kind="mac" name="__SA_IBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__DA_FBIT__" path="" value="31"/>
				<pathentry kind="mac" name="__DA_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__TA_FBIT__" path="" value="63"/>
				<pathentry kind="mac" name="__TA_IBIT__" path="" value="64"/>
				<pathentry kind="mac" name="__UHA_FBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__UHA_IBIT__" path="" value="8"/>
				<pathentry kind="mac" name="__USA_FBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__USA_IBIT__" path="" value="16"/>
				<pathentry kind="mac" name="__UDA_FBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__UDA_IBIT__" path="" value="32"/>
				<pathentry kind="mac" name="__UTA_FBIT__" path="" value="64"/>
				<pathentry kind="mac" name="__UTA_IBIT__" path="" value="64"/>
				<pathentry kind="mac" name="__REGISTER_PREFIX__" path="" value=" "/>
				<pathentry kind="mac" name="__USER_LABEL_PREFIX__" path="" value=" "/>
				<pathentry kind="mac" name="__GNUC_STDC_INLINE__" path="" value="1"/>
				<pathentry kind="mac" name="__NO_INLINE__" path="" value="1"/>
				<pathentry kind="mac" name="__CHAR_UNSIGNED__" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_BOOL_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_CHAR_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_CHAR16_T_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_CHAR32_T_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_WCHAR_T_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_SHORT_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_INT_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_LONG_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_LLONG_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_TEST_AND_SET_TRUEVAL" path="" value="1"/>
				<pathentry kind="mac" name="__GCC_ATOMIC_POINTER_LOCK_FREE" path="" value="2"/>
				<pathentry kind="mac" name="__PRAGMA_REDEFINE_EXTNAME" path="" value="1"/>
				<pathentry kind="mac" name="__SSP_STRONG__" path="" value="3"/>
				<pathentry kind="mac" name="__SIZEOF_WCHAR_T__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZEOF_WINT_T__" path="" value="4"/>
				<pathentry kind="mac" name="__SIZEOF_PTRDIFF_T__" path="" value="4"/>
				<pathentry kind="mac" name="__ARM_FEATURE_DSP" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FEATURE_QBIT" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FEATURE_SAT" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FEATURE_UNALIGNED" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_32BIT_STATE" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FEATURE_LDREX" path="" value="15"/>
				<pathentry kind="mac" name="__ARM_FEATURE_CLZ" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FEATURE_SIMD32" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_SIZEOF_MINIMAL_ENUM" path="" value="4"/>
				<pathentry kind="mac" name="__ARM_SIZEOF_WCHAR_T" path="" value="4"/>
				<pathentry kind="mac" name="__ARM_ARCH_PROFILE" path="" value="65"/>
				<pathentry kind="mac" name="__arm__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_ARCH" path="" value="7"/>
				<pathentry kind="mac" name="__ARM_ARCH_ISA_ARM" path="" value="1"/>
				<pathentry kind="mac" name="__APCS_32__" path="" value="1"/>
				<pathentry kind="mac" name="__thumb__" path="" value="1"/>
				<pathentry kind="mac" name="__thumb2__" path="" value="1"/>
				<pathentry kind="mac" name="__THUMBEL__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_ARCH_ISA_THUMB" path="" value="2"/>
				<pathentry kind="mac" name="__ARMEL__" path="" value="1"/>
				<pathentry kind="mac" name="__VFP_FP__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_FP" path="" value="12"/>
				<pathentry kind="mac" name="__THUMB_INTERWORK__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_ARCH_7A__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_PCS_VFP" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_EABI__" path="" value="1"/>
				<pathentry kind="mac" name="__ARM_ASM_SYNTAX_UNIFIED__" path="" value="1"/>
				<pathentry kind="mac" name="__GXX_TYPEINFO_EQUALITY_INLINE" path="" value=" "/>
				<pathentry kind="mac" name="__gnu_linux__" path="" value="1"/>
				<pathentry kind="mac" name="__linux" path="" value="1"/>
				<pathentry kind="mac" name="__linux__" path="" value="1"/>
				<pathentry kind="mac" name="linux" path="" value="1"/>
				<pathentry kind="mac" name="__unix" path="" value="1"/>
				<pathentry kind="mac" name="__unix__" path="" value="1"/>
				<pathentry kind="mac" name="unix" path="" value="1"/>
				<pathentry kind="mac" name="__ELF__" path="" value="1"/>
				<pathentry kind="mac" name="_STDC_PREDEF_H" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_IEC_559__" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_IEC_559_COMPLEX__" path="" value="1"/>
				<pathentry kind="mac" name="__STDC_ISO_10646__" path="" value="201505L"/>
				<pathentry kind="mac" name="__STDC_NO_THREADS__" path="" value="1"/>
				<pathentry kind="mac" name="__cplusplus" path="" value="201103L"/>
				<pathentry kind="mac" name="__GNUG__" path="" value="5"/>
				<pathentry kind="mac" name="__GXX_WEAK__" path="" value="1"/>
				<pathentry kind="mac" name="__DEPRECATED" path="" value="1"/>
				<pathentry kind="mac" name="__GXX_RTTI" path="" value="1"/>
				<pathentry kind="mac" name="__cpp_rtti" path="" value="199711"/>
				<pathentry kind="mac" name="__GXX_EXPERIMENTAL_CXX0X__" path="" value="1"/>
				<pathentry kind="mac" name="__cpp_binary_literals" path="" value="201304"/>
				<pathentry kind="mac" name="__cpp_runtime_arrays" path="" value="198712"/>
				<pathentry kind="mac" name="__cpp_unicode_characters" path="" value="200704"/>
				<pathentry kind="mac" name="__cpp_raw_strings" path="" value="200710"/>
				<pathentry kind="mac" name="__cpp_unicode_literals" path="" value="200710"/>
				<pathentry kind="mac" name="__cpp_user_defined_literals" path="" value="200809"/>
				<pathentry kind="mac" name="__cpp_lambdas" path="" value="200907"/>
				<pathentry kind="mac" name="__cpp_constexpr" path="" value="200704"/>
				<pathentry kind="mac" name="__cpp_range_based_for" path="" value="200907"/>
				<pathentry kind="mac" name="__cpp_static_assert" path="" value="200410"/>
				<pathentry kind="mac" name="__cpp_decltype" path="" value="200707"/>
				<pathentry kind="mac" name="__cpp_attributes" path="" value="200809"/>
				<pathentry kind="mac" name="__cpp_rvalue_reference" path="" value="200610"/>
				<pathentry kind="mac" name="__cpp_variadic_templates" path="" value="200704"/>
				<pathentry kind="mac" name="__cpp_initializer_lists" path="" value="200806"/>
				<pathentry kind="mac" name="__cpp_delegating_constructors" path="" value="200604"/>
				<pathentry kind="mac" name="__cpp_nsdmi" path="" value="200809"/>
				<pathentry kind="mac" name="__cpp_inheriting_constructors" path="" value="200802"/>
				<pathentry kind="mac" name="__cpp_ref_qualifiers" path="" value="200710"/>
				<pathentry kind="mac" name="__cpp_alias_templates" path="" value="200704"/>
				<pathentry kind="mac" name="__EXCEPTIONS" path="" value="1"/>
				<pathentry kind="mac" name="__cpp_exceptions" path="" value="199711"/>
				<pathentry kind="mac" name="__STRICT_ANSI__" path="" value="1"/>
				<pathentry kind="mac" name="__WCHAR_UNSIGNED__" path="" value="1"/>
				<pathentry kind="mac" name="_GNU_SOURCE" path="" value="1"/>
				<pathentry include="/opt/riaps/armhf/include" kind="inc" path="" system="true"/>
				<pathentry include="messages-gen" kind="inc" path="" system="true"/>
				<pathentry include="cpp/include/" kind="inc" path="" system="true"/>
				<pathentry include="/usr/lib/gcc-cross/arm-linux-gnueabihf/5/include" kind="inc" path="" system="true"/>
				<pathentry include="/usr/lib/gcc-cross/arm-linux-gnueabihf/5/include-fixed" kind="inc" path="" system="true"/>
				<pathentry include="/usr/arm-linux-gnueabihf/include" kind="inc" path="" system="true"/>
				<pathentry include="/usr/include/arm-linux-gnueabihf" kind="inc" path="" system="true"/>
				<pathentry include="/usr/include" kind="inc" path="" system="true"/>
				<pathentry include="/usr/arm-linux-gnueabihf/include/c++/5" kind="inc" path="" system="true"/>
				<pathentry include="/usr/arm-linux-gnueabihf/include/c++/5/arm-linux-gnueabihf" kind="inc" path="" system="true"/>
				<pathentry include="/usr/arm-linux-gnueabihf/include/c++/5/backward" kind="inc" path="" system="true"/>
			</storageModule>
			<storageModule moduleId="org.eclipse.cdt.core.LanguageSettingsProviders"/>
			<storageModule moduleId="org.eclipse.cdt.make.core.buildtargets">
				<buildTargets>
					<target name="all-armhf" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildArguments/>
						<buildTarget>all-armhf</buildTarget>
						<stopOnError>true</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="clean-armhf" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildArguments/>
						<buildTarget>clean-armhf</buildTarget>
						<stopOnError>true</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="clean-amd64" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildArguments/>
						<buildTarget>clean-amd64</buildTarget>
						<stopOnError>true</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="reset" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildTarget>realclean all</buildTarget>
						<stopOnError>true</stopOnError>
						<useDefaultCommand>false</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="all-amd64" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildArguments/>
						<buildTarget>all-amd64</buildTarget>
						<stopOnError>true</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="realclean" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildTarget>realclean</buildTarget>
						<stopOnError>false</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
					<target name="reformat" path="" targetID="org.eclipse.cdt.make.MakeTargetBuilder">
						<buildCommand>make</buildCommand>
						<buildArguments/>
						<buildTarget>reformat</buildTarget>
						<stopOnError>false</stopOnError>
						<useDefaultCommand>true</useDefaultCommand>
						<runAllBuilders>true</runAllBuilders>
					</target>
				</buildTargets>
			</storageModule>
		</cproject>
				
		'''
	}

	/** 
	 * Create a folder structure with a parent root, overlay, and a few child
	 * folders.
	 * @param newProject
	 * @param paths
	 * @throws CoreException
	 */
	def private static void addToProjectStructureFolder(IProject newProject, String[] paths) throws CoreException {
		for (String path : paths) {
			var etcFolders = newProject.getFolder(path);
			createFolder(etcFolders);
		}
	}

	def private static void addMakefile(IProject newProject) throws CoreException {
		var IFile file = newProject.getFile("makefile"); // such as file.exists() == false
		var contents = createMakefile.toString.getBytes;
		var source = new ByteArrayInputStream(contents);
		if (!file.exists) {
			file.create(source, false, null);
		}
	}
	
	def private static void addresourcefilters(IProject newProject) throws CoreException{
		var folder = newProject.getFolder(".");
		folder.createFilter(
    	IResourceFilterDescription.FILES,
        new FileInfoMatcherDescription("cmake",  
            "*.cmake"), 0, null);
	}
	
	def private static void addCproject(IProject newProject) throws CoreException {
		
		var currentpath=newProject.getLocation.toOSString
		var IFile file = newProject.getFile(".cproject"); // such as file.exists() == false
		var contents = createCProject(currentpath).toString.getBytes;
		var source = new ByteArrayInputStream(contents);
		if (!file.exists) {
			file.create(source, false, null);
		}
	}
	

	def private static void addNature(IProject project) throws CoreException {

		var IProjectDescription description = project.getDescription()
		var String[] prevNatures = description.getNatureIds();
		var List<String> newNatures = new ArrayList<String>();
		for (nature : prevNatures) {
			newNatures.add(nature);
		}

		for (nature : riapsNatures) {
			if (!project.hasNature(nature)) {
				newNatures.add(nature);
			}
		}
		description.setNatureIds(newNatures);
		var IProgressMonitor monitor = null;
		try {
			project.setDescription(description, monitor);

		} catch (org.eclipse.core.runtime.CoreException e) {
			Console.instance.log(java.util.logging.Level.INFO,
				"Problem encountered while setting natures. Check if you have cdt environment installed");
			description.setNatureIds(prevNatures);
			project.setDescription(description, monitor);
		}

	}

}

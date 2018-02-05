package edu.vanderbilt.riaps.ui

import java.util.Random

class CProjectSetting {

	def static String gen() {
		var String randomNumString = "";

		var Random r = new Random();

		// Generate the first digit from 1-9
		randomNumString += (r.nextInt(9) + 1);

		// Generate the remaining digits between 0-9
		for (var int x = 1; x < 9; x++) {
			randomNumString += r.nextInt(9);
		}

		// Parse and return
		return randomNumString;
	}

	def public static createSettings() {
		var rand1 = gen
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<project>
				<configuration id="cdt.managedbuild.toolchain.gnu.base.«rand1»" name="Default">
					<extension point="org.eclipse.cdt.core.LanguageSettingsProvider">
						<provider copy-of="extension" id="org.eclipse.cdt.ui.UserLanguageSettingsProvider"/>
						<provider-reference id="org.eclipse.cdt.core.ReferencedProjectsLanguageSettingsProvider" ref="shared-provider"/>
						<provider copy-of="extension" id="org.eclipse.cdt.managedbuilder.core.GCCBuildCommandParser"/>
						<provider class="org.eclipse.cdt.managedbuilder.language.settings.providers.GCCBuiltinSpecsDetector" console="false" env-hash="-1679679420796077310" id="org.eclipse.cdt.managedbuilder.core.GCCBuiltinSpecsDetector" keep-relative-paths="false" name="CDT GCC Built-in Compiler Settings" parameter="${COMMAND} ${FLAGS} -E -P -v -dD &quot;${INPUTS}&quot; -std=c++0x" prefer-non-shared="true">
							<language-scope id="org.eclipse.cdt.core.gcc"/>
							<language-scope id="org.eclipse.cdt.core.g++"/>
						</provider>
						<provider-reference id="org.eclipse.cdt.managedbuilder.core.MBSLanguageSettingsProvider" ref="shared-provider"/>
					</extension>
				</configuration>
			</project>
		'''
	}

	// 2045585562
	def public static createCProject(String Project) {
		var rand1 = gen
		var rand2 = gen
		var rand3 = gen
		var rand4 = gen
		var rand5 = gen
		var rand6 = gen
		var rand7 = gen
		var rand8 = gen
		var rand9 = gen
		var rand10 = gen
		var rand11 = gen
		var rand12 = gen
		var rand13 = gen
		var rand14 = gen
		var rand15 = gen
		var rand16 = gen
		var rand17 = gen
		var rand18 = gen
		'''
			<?xml version="1.0" encoding="UTF-8" standalone="no"?>
			<?fileVersion 4.0.0?><cproject storage_type_id="org.eclipse.cdt.core.XmlProjectDescriptionStorage">
				<storageModule moduleId="org.eclipse.cdt.core.settings">
					<cconfiguration id="cdt.managedbuild.toolchain.gnu.base.«rand1»">
						<storageModule buildSystemId="org.eclipse.cdt.managedbuilder.core.configurationDataProvider" id="cdt.managedbuild.toolchain.gnu.base.«rand1»" moduleId="org.eclipse.cdt.core.settings" name="Default">
							<externalSettings/>
							<extensions>
								<extension id="org.eclipse.cdt.core.GNU_ELF" point="org.eclipse.cdt.core.BinaryParser"/>
								<extension id="org.eclipse.cdt.core.GASErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
								<extension id="org.eclipse.cdt.core.GmakeErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
								<extension id="org.eclipse.cdt.core.GLDErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
								<extension id="org.eclipse.cdt.core.CWDLocator" point="org.eclipse.cdt.core.ErrorParser"/>
								<extension id="org.eclipse.cdt.core.GCCErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
							</extensions>
						</storageModule>
						<storageModule moduleId="cdtBuildSystem" version="4.0.0">
							<configuration artifactName="${ProjName}" buildProperties="" description="" id="cdt.managedbuild.toolchain.gnu.base.«rand1»" name="Default" parent="org.eclipse.cdt.build.core.emptycfg">
								<folderInfo id="cdt.managedbuild.toolchain.gnu.base.«rand1».«rand2»" name="/" resourcePath="">
									<toolChain id="cdt.managedbuild.toolchain.gnu.base.«rand3»" name="Linux GCC" superClass="cdt.managedbuild.toolchain.gnu.base">
										<targetPlatform archList="all" binaryParser="org.eclipse.cdt.core.GNU_ELF" id="cdt.managedbuild.target.gnu.platform.base.1745065708" name="Debug Platform" osList="linux,hpux,aix,qnx" superClass="cdt.managedbuild.target.gnu.platform.base"/>
										<builder id="cdt.managedbuild.target.gnu.builder.base.«rand4»" keepEnvironmentInBuildfile="false" managedBuildOn="false" name="Gnu Make Builder" superClass="cdt.managedbuild.target.gnu.builder.base"/>
										<tool id="cdt.managedbuild.tool.gnu.archiver.base.«rand5»" name="GCC Archiver" superClass="cdt.managedbuild.tool.gnu.archiver.base"/>
										<tool id="cdt.managedbuild.tool.gnu.cpp.compiler.base.«rand6»" name="GCC C++ Compiler" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.base">
											<option id="gnu.cpp.compiler.option.include.paths.«rand7»" name="Include paths (-I)" superClass="gnu.cpp.compiler.option.include.paths" useByScannerDiscovery="false" valueType="includePath">
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
												<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
											</option>
											<inputType id="cdt.managedbuild.tool.gnu.cpp.compiler.input.«rand8»" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.input"/>
										</tool>
										<tool id="cdt.managedbuild.tool.gnu.c.compiler.base.«rand9»" name="GCC C Compiler" superClass="cdt.managedbuild.tool.gnu.c.compiler.base">
											<option id="gnu.c.compiler.option.include.paths.«rand10»" name="Include paths (-I)" superClass="gnu.c.compiler.option.include.paths" useByScannerDiscovery="false" valueType="includePath">
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
												<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
											</option>
											<inputType id="cdt.managedbuild.tool.gnu.c.compiler.input.«rand11»" superClass="cdt.managedbuild.tool.gnu.c.compiler.input"/>
										</tool>
										<tool id="cdt.managedbuild.tool.gnu.c.linker.base.«rand12»" name="GCC C Linker" superClass="cdt.managedbuild.tool.gnu.c.linker.base"/>
										<tool id="cdt.managedbuild.tool.gnu.cpp.linker.base.«rand13»" name="GCC C++ Linker" superClass="cdt.managedbuild.tool.gnu.cpp.linker.base">
											<inputType id="cdt.managedbuild.tool.gnu.cpp.linker.input.«rand14»" superClass="cdt.managedbuild.tool.gnu.cpp.linker.input">
												<additionalInput kind="additionalinputdependency" paths="$(USER_OBJS)"/>
												<additionalInput kind="additionalinput" paths="$(LIBS)"/>
											</inputType>
										</tool>
										<tool id="cdt.managedbuild.tool.gnu.assembler.base.«rand15»" name="GCC Assembler" superClass="cdt.managedbuild.tool.gnu.assembler.base">
											<option id="gnu.both.asm.option.include.paths.«rand16»" name="Include paths (-I)" superClass="gnu.both.asm.option.include.paths" valueType="includePath">
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
												<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
												<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
											</option>
											<inputType id="cdt.managedbuild.tool.gnu.assembler.input.«rand17»" superClass="cdt.managedbuild.tool.gnu.assembler.input"/>
										</tool>
									</toolChain>
								</folderInfo>
							</configuration>
						</storageModule>
						<storageModule moduleId="org.eclipse.cdt.core.externalSettings"/>
					</cconfiguration>
				</storageModule>
				<storageModule moduleId="cdtBuildSystem" version="4.0.0">
					<project id="«Project».null.«rand18»" name="«Project»"/>
				</storageModule>
				<storageModule moduleId="org.eclipse.cdt.core.LanguageSettingsProviders"/>
				<storageModule moduleId="refreshScope" versionNumber="2">
					<configuration configurationName="Default">
						<resource resourceType="PROJECT" workspacePath="/«Project»"/>
					</configuration>
				</storageModule>
				<storageModule moduleId="org.eclipse.cdt.make.core.buildtargets">
					<buildTargets>
						<target name="all-armhf" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
							<buildCommand>make</buildCommand>
							<buildArguments/>
							<buildTarget>all-armhf</buildTarget>
							<stopOnError>true</stopOnError>
							<useDefaultCommand>true</useDefaultCommand>
							<runAllBuilders>true</runAllBuilders>
						</target>
						<target name="realclean" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
							<buildCommand>make</buildCommand>
							<buildArguments/>
							<buildTarget>realclean</buildTarget>
							<stopOnError>true</stopOnError>
							<useDefaultCommand>true</useDefaultCommand>
							<runAllBuilders>true</runAllBuilders>
						</target>
						<target name="all-amd64" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
							<buildCommand>make</buildCommand>
							<buildArguments/>
							<buildTarget>all-amd64</buildTarget>
							<stopOnError>true</stopOnError>
							<useDefaultCommand>true</useDefaultCommand>
							<runAllBuilders>true</runAllBuilders>
						</target>
						<target name="reformat" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
							<buildCommand>make</buildCommand>
							<buildArguments/>
							<buildTarget>reformat</buildTarget>
							<stopOnError>true</stopOnError>
							<useDefaultCommand>true</useDefaultCommand>
							<runAllBuilders>true</runAllBuilders>
						</target>
						<target name="package" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
							<buildCommand>make</buildCommand>
							<buildArguments/>
							<buildTarget>package</buildTarget>
							<stopOnError>true</stopOnError>
							<useDefaultCommand>true</useDefaultCommand>
							<runAllBuilders>true</runAllBuilders>
						</target>
					</buildTargets>
				</storageModule>
				<storageModule moduleId="scannerConfiguration">
					<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
					<scannerConfigBuildInfo instanceId="cdt.managedbuild.toolchain.gnu.base.«rand1»;cdt.managedbuild.toolchain.gnu.base.«rand1».«rand2»;cdt.managedbuild.tool.gnu.c.compiler.base.«rand9»;cdt.managedbuild.tool.gnu.c.compiler.input.«rand11»">
						<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
					</scannerConfigBuildInfo>
					<scannerConfigBuildInfo instanceId="cdt.managedbuild.toolchain.gnu.base.«rand1»;cdt.managedbuild.toolchain.gnu.base.«rand1».«rand2»;cdt.managedbuild.tool.gnu.cpp.compiler.base.«rand6»;cdt.managedbuild.tool.gnu.cpp.compiler.input.«rand8»">
						<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
					</scannerConfigBuildInfo>
				</storageModule>
				<storageModule moduleId="org.eclipse.cdt.internal.ui.text.commentOwnerProjectMappings"/>
			</cproject>
		'''
	}

//	def public static createCProject(String Project){
//		'''
//		<?xml version="1.0" encoding="UTF-8" standalone="no"?>
//		<?fileVersion 4.0.0?><cproject storage_type_id="org.eclipse.cdt.core.XmlProjectDescriptionStorage">
//			<storageModule moduleId="org.eclipse.cdt.core.settings">
//				<cconfiguration id="cdt.managedbuild.toolchain.gnu.base.1969425846">
//					<storageModule buildSystemId="org.eclipse.cdt.managedbuilder.core.configurationDataProvider" id="cdt.managedbuild.toolchain.gnu.base.1969425846" moduleId="org.eclipse.cdt.core.settings" name="Default">
//						<externalSettings/>
//		
//						<extensions>
//		
//							<extension id="org.eclipse.cdt.core.GNU_ELF" point="org.eclipse.cdt.core.BinaryParser"/>
//		
//							<extension id="org.eclipse.cdt.core.GASErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
//		
//							<extension id="org.eclipse.cdt.core.GmakeErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
//		
//							<extension id="org.eclipse.cdt.core.GLDErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
//		
//							<extension id="org.eclipse.cdt.core.CWDLocator" point="org.eclipse.cdt.core.ErrorParser"/>
//		
//							<extension id="org.eclipse.cdt.core.GCCErrorParser" point="org.eclipse.cdt.core.ErrorParser"/>
//		
//						</extensions>
//		
//					</storageModule>
//		
//					<storageModule moduleId="cdtBuildSystem" version="4.0.0">
//		
//						<configuration artifactName="${ProjName}" buildProperties="" description="" id="cdt.managedbuild.toolchain.gnu.base.1969425846" name="Default" parent="org.eclipse.cdt.build.core.emptycfg">
//		
//							<folderInfo id="cdt.managedbuild.toolchain.gnu.base.1969425846.1030987787" name="/" resourcePath="">
//		
//								<toolChain id="cdt.managedbuild.toolchain.gnu.base.1467286353" name="Linux GCC" superClass="cdt.managedbuild.toolchain.gnu.base">
//		
//									<targetPlatform archList="all" binaryParser="org.eclipse.cdt.core.GNU_ELF" id="cdt.managedbuild.target.gnu.platform.base.198205872" name="Debug Platform" osList="linux,hpux,aix,qnx" superClass="cdt.managedbuild.target.gnu.platform.base"/>
//		
//									<builder enabledIncrementalBuild="true" id="cdt.managedbuild.target.gnu.builder.base.607130730" keepEnvironmentInBuildfile="false" managedBuildOn="false" name="Gnu Make Builder" superClass="cdt.managedbuild.target.gnu.builder.base"/>
//		
//									<tool id="cdt.managedbuild.tool.gnu.archiver.base.758121820" name="GCC Archiver" superClass="cdt.managedbuild.tool.gnu.archiver.base"/>
//		
//									<tool id="cdt.managedbuild.tool.gnu.cpp.compiler.base.215666321" name="GCC C++ Compiler" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.base">
//		
//										<option id="gnu.cpp.compiler.option.include.paths.1979511005" name="Include paths (-I)" superClass="gnu.cpp.compiler.option.include.paths" useByScannerDiscovery="false" valueType="includePath">
//		
//											<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
//		
//										</option>
//		
//										<inputType id="cdt.managedbuild.tool.gnu.cpp.compiler.input.928864219" superClass="cdt.managedbuild.tool.gnu.cpp.compiler.input"/>
//		
//									</tool>
//		
//									<tool id="cdt.managedbuild.tool.gnu.c.compiler.base.1282613706" name="GCC C Compiler" superClass="cdt.managedbuild.tool.gnu.c.compiler.base">
//		
//										<option id="gnu.c.compiler.option.include.paths.2015638444" name="Include paths (-I)" superClass="gnu.c.compiler.option.include.paths" useByScannerDiscovery="false" valueType="includePath">
//		
//											<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
//		
//										</option>
//		
//										<inputType id="cdt.managedbuild.tool.gnu.c.compiler.input.1335734128" superClass="cdt.managedbuild.tool.gnu.c.compiler.input"/>
//		
//									</tool>
//		
//									<tool id="cdt.managedbuild.tool.gnu.c.linker.base.1637874901" name="GCC C Linker" superClass="cdt.managedbuild.tool.gnu.c.linker.base"/>
//		
//									<tool id="cdt.managedbuild.tool.gnu.cpp.linker.base.1098453185" name="GCC C++ Linker" superClass="cdt.managedbuild.tool.gnu.cpp.linker.base">
//		
//										<inputType id="cdt.managedbuild.tool.gnu.cpp.linker.input.384582710" superClass="cdt.managedbuild.tool.gnu.cpp.linker.input">
//		
//											<additionalInput kind="additionalinputdependency" paths="$(USER_OBJS)"/>
//		
//											<additionalInput kind="additionalinput" paths="$(LIBS)"/>
//		
//										</inputType>
//		
//									</tool>
//		
//									<tool id="cdt.managedbuild.tool.gnu.assembler.base.1190873916" name="GCC Assembler" superClass="cdt.managedbuild.tool.gnu.assembler.base">
//		
//										<option id="gnu.both.asm.option.include.paths.811812624" name="Include paths (-I)" superClass="gnu.both.asm.option.include.paths" valueType="includePath">
//		
//											<listOptionValue builtIn="false" value="/opt/riaps/amd64/include"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/messages-gen}&quot;"/>
//		
//											<listOptionValue builtIn="false" value="&quot;${workspace_loc:/«Project»/cpp/include}&quot;"/>
//		
//										</option>
//		
//										<inputType id="cdt.managedbuild.tool.gnu.assembler.input.541874386" superClass="cdt.managedbuild.tool.gnu.assembler.input"/>
//		
//									</tool>
//		
//								</toolChain>
//		
//							</folderInfo>
//		
//						</configuration>
//		
//					</storageModule>
//		
//					<storageModule moduleId="org.eclipse.cdt.core.externalSettings"/>
//		
//				</cconfiguration>
//		
//			</storageModule>
//		
//			<storageModule moduleId="cdtBuildSystem" version="4.0.0">
//		
//				<project id="«Project».null.854007512" name="«Project»"/>
//		
//			</storageModule>
//		
//			<storageModule moduleId="org.eclipse.cdt.core.LanguageSettingsProviders"/>
//		
//			<storageModule moduleId="refreshScope" versionNumber="2">
//		
//				<configuration configurationName="Default">
//		
//					<resource resourceType="PROJECT" workspacePath="/«Project»"/>
//		
//				</configuration>
//		
//			</storageModule>
//		
//			<storageModule moduleId="scannerConfiguration">
//		
//				<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
//		
//				<scannerConfigBuildInfo instanceId="cdt.managedbuild.toolchain.gnu.base.1969425846;cdt.managedbuild.toolchain.gnu.base.1969425846.1030987787;cdt.managedbuild.tool.gnu.cpp.compiler.base.215666321;cdt.managedbuild.tool.gnu.cpp.compiler.input.928864219">
//		
//					<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
//		
//				</scannerConfigBuildInfo>
//		
//				<scannerConfigBuildInfo instanceId="cdt.managedbuild.toolchain.gnu.base.1969425846;cdt.managedbuild.toolchain.gnu.base.1969425846.1030987787;cdt.managedbuild.tool.gnu.c.compiler.base.1282613706;cdt.managedbuild.tool.gnu.c.compiler.input.1335734128">
//		
//					<autodiscovery enabled="true" problemReportingEnabled="true" selectedProfileId=""/>
//		
//				</scannerConfigBuildInfo>
//		
//			</storageModule>
//		
//			<storageModule moduleId="org.eclipse.cdt.make.core.buildtargets">
//		
//				<buildTargets>
//		
//					<target name="clean-armhf" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildTarget>clean-armhf</buildTarget>
//		
//						<stopOnError>true</stopOnError>
//		
//						<useDefaultCommand>false</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//					<target name="clean-amd64" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildTarget>clean-amd64</buildTarget>
//		
//						<stopOnError>true</stopOnError>
//		
//						<useDefaultCommand>false</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//					<target name="realclean" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildArguments/>
//		
//						<buildTarget>realclean</buildTarget>
//		
//						<stopOnError>false</stopOnError>
//		
//						<useDefaultCommand>false</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//					<target name="reformat" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildTarget>reformat</buildTarget>
//		
//						<stopOnError>false</stopOnError>
//		
//						<useDefaultCommand>false</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//					<target name="all-amd64" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildTarget>all-amd64</buildTarget>
//		
//						<stopOnError>true</stopOnError>
//		
//						<useDefaultCommand>true</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//					<target name="all-armhf" path="" targetID="org.eclipse.cdt.build.MakeTargetBuilder">
//		
//						<buildCommand>make</buildCommand>
//		
//						<buildTarget>all-armhf</buildTarget>
//		
//						<stopOnError>true</stopOnError>
//		
//						<useDefaultCommand>true</useDefaultCommand>
//		
//						<runAllBuilders>false</runAllBuilders>
//		
//					</target>
//		
//				</buildTargets>
//		
//			</storageModule>
//		
//		</cproject>				
//		'''
//	}
}

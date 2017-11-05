package edu.vanderbilt.riaps

import static com.google.common.collect.Sets.newHashSet
import java.util.Set
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration

class RiapsOutputConfigurationProvider implements IOutputConfigurationProvider {
	public final static String DEFAULT_OUTPUT_APPCODE = "DEFAULT_OUTPUT_APPCODE"
	public final static String DEFAULT_OUTPUT_JSON = "DEFAULT_OUTPUT_JSON"

	/** 
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	override Set<OutputConfiguration> getOutputConfigurations() {
		var OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess::DEFAULT_OUTPUT)
		defaultOutput.setDescription("Output Folder")
		defaultOutput.setOutputDirectory("./apps/")
		defaultOutput.setOverrideExistingResources(true)
		defaultOutput.setCreateOutputDirectory(true)
		defaultOutput.setCleanUpDerivedResources(true)
		defaultOutput.setSetDerivedProperty(true)
		
		var OutputConfiguration onceOutput = new OutputConfiguration(DEFAULT_OUTPUT_APPCODE)
		onceOutput.setDescription("Output Folder (once)")
		onceOutput.setOutputDirectory("./apps/")
		onceOutput.setOverrideExistingResources(false)
		onceOutput.setCreateOutputDirectory(true)
		onceOutput.setCleanUpDerivedResources(false)
		onceOutput.setSetDerivedProperty(false)
		
		var hash1= newHashSet(defaultOutput, onceOutput)
		var OutputConfiguration onceOutput2 = new OutputConfiguration(DEFAULT_OUTPUT_JSON)
		onceOutput2.setDescription("Output JSON")
		onceOutput2.setOutputDirectory("./apps/configs/")
		onceOutput2.setOverrideExistingResources(true)
		onceOutput2.setCreateOutputDirectory(true)
		onceOutput2.setCleanUpDerivedResources(true)
		onceOutput2.setSetDerivedProperty(true)
		
		hash1.add(onceOutput2)
		return hash1
	}
}

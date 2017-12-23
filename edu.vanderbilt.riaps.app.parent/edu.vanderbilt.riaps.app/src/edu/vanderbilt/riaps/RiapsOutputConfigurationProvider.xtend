package edu.vanderbilt.riaps

import static com.google.common.collect.Sets.newHashSet
import java.util.Set
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import org.eclipse.xtext.generator.OutputConfiguration

class RiapsOutputConfigurationProvider implements IOutputConfigurationProvider {
	public final static String DEFAULT_OUTPUT_BASE_INCLUDE = "DEFAULT_OUTPUT_BASE_INCLUDE"
	public final static String DEFAULT_OUTPUT_DEV_INCLUDE = "DEFAULT_OUTPUT_DEV_INCLUDE"
	public final static String DEFAULT_OUTPUT_DEV_SRC = "DEFAULT_OUTPUT_DEV_SRC"
	public final static String DEFAULT_OUTPUT_DEV_PYTHON = "DEFAULT_OUTPUT_DEV_PYTHON"
	public final static String DEFAULT_OUTPUT_BASE_SRC = "DEFAULT_OUTPUT_BASE_SRC"
	public final static String DEFAULT_OUTPUT_JSON_APP = "DEFAULT_OUTPUT_JSON"
	public final static String DEFAULT_OUTPUT_MESSAGE = "DEFAULT_OUTPUT_MESSAGE"
	public final static String DEFAULT_OUTPUT_CMAKE = "DEFAULT_OUTPUT_CMAKE"

	/** 
	 * @return a set of {@link OutputConfiguration} available for the generator
	 */
	override Set<OutputConfiguration> getOutputConfigurations() {
		
		var OutputConfiguration outputconfig = new OutputConfiguration(IFileSystemAccess::DEFAULT_OUTPUT)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./cpp/")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		//outputconfig.setCleanUpDerivedResources(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		var hash1= newHashSet(outputconfig)
		
		outputconfig = new OutputConfiguration(DEFAULT_OUTPUT_CMAKE)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory(".")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		//outputconfig.setCleanUpDerivedResources(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		hash1.add(outputconfig)

		outputconfig= new OutputConfiguration(DEFAULT_OUTPUT_BASE_INCLUDE)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./cpp/")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		hash1.add(outputconfig)
		
		
		outputconfig= new OutputConfiguration(DEFAULT_OUTPUT_BASE_SRC)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./cpp/")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		hash1.add(outputconfig)
		
		outputconfig= new OutputConfiguration(DEFAULT_OUTPUT_DEV_PYTHON)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./python/")
		outputconfig.setOverrideExistingResources(false)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		hash1.add(outputconfig)
		
		
		
		
		outputconfig= new OutputConfiguration(DEFAULT_OUTPUT_DEV_INCLUDE)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./cpp/")
		outputconfig.setOverrideExistingResources(false)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(false)
		hash1.add(outputconfig)
		
		
		outputconfig= new OutputConfiguration(DEFAULT_OUTPUT_DEV_SRC)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./cpp/")
		outputconfig.setOverrideExistingResources(false)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(false)
		hash1.add(outputconfig)
		
			
		outputconfig = new OutputConfiguration(DEFAULT_OUTPUT_JSON_APP)
		outputconfig.setDescription("Output JSON")
		outputconfig.setOutputDirectory("./json-gen/")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		
		hash1.add(outputconfig)
		
		outputconfig  = new OutputConfiguration(DEFAULT_OUTPUT_MESSAGE)
		outputconfig.setDescription("Output Folder")
		outputconfig.setOutputDirectory("./messages-gen/")
		outputconfig.setOverrideExistingResources(true)
		outputconfig.setCreateOutputDirectory(true)
		outputconfig.setCleanUpDerivedResources(false)
		outputconfig.setSetDerivedProperty(true)
		hash1.add(outputconfig)

		return hash1
	}
}

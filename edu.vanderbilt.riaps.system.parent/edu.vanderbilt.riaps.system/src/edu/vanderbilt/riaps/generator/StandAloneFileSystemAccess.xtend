package edu.vanderbilt.riaps.generator

import org.eclipse.xtext.generator.JavaIoFileSystemAccess
import org.eclipse.xtext.generator.OutputConfiguration

import org.eclipse.xtext.generator.IFileSystemAccess

import java.util.Map
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider
import java.util.HashMap

class StandAloneFileSystemAccess extends JavaIoFileSystemAccess {
	override void generateFile(String fileName, String outputConfigName, CharSequence contents) {
		var OutputConfiguration outputConfig = getOutputConfig(outputConfigName);
		var file = getFile(fileName, outputConfigName);
		//if (file.exists() && outputConfig.isOverrideExistingResources()) {
			super.generateFile(fileName, outputConfigName, contents);
		//}
		
		
	}
	
	override Map<String, OutputConfiguration> getOutputConfigurations() {
		var Map<String, OutputConfiguration> hash1= new HashMap<String, OutputConfiguration>()
		var OutputConfiguration defaultOutput = new OutputConfiguration(IFileSystemAccess::DEFAULT_OUTPUT)
		defaultOutput.setDescription("Output Folder")
		defaultOutput.setOutputDirectory("./apps/basecode")
		defaultOutput.setOverrideExistingResources(true)
		defaultOutput.setCreateOutputDirectory(true)
		defaultOutput.setCleanUpDerivedResources(true)
		defaultOutput.setSetDerivedProperty(true)
		hash1.put(IFileSystemAccess::DEFAULT_OUTPUT, defaultOutput)
		
		
		var OutputConfiguration onceOutput = new OutputConfiguration(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE)
		onceOutput.setDescription("Output Folder (once)")
		onceOutput.setOutputDirectory("./apps/devcode")
		onceOutput.setOverrideExistingResources(false)
		onceOutput.setCreateOutputDirectory(true)
		onceOutput.setCleanUpDerivedResources(false)
		onceOutput.setSetDerivedProperty(false)
		hash1.put(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_APPCODE, onceOutput)
		
		
		var OutputConfiguration onceOutput2 = new OutputConfiguration(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_JSON)
		onceOutput2.setDescription("Output JSON")
		onceOutput2.setOutputDirectory("./apps/configs/")
		onceOutput2.setOverrideExistingResources(true)
		onceOutput2.setCreateOutputDirectory(true)
		onceOutput2.setCleanUpDerivedResources(true)
		onceOutput2.setSetDerivedProperty(true)
		
		hash1.put(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_JSON, onceOutput2)
		
		var OutputConfiguration defaultOutputmessage = new OutputConfiguration(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_MESSAGE)
		defaultOutputmessage.setDescription("Output Folder")
		defaultOutputmessage.setOutputDirectory("./apps/messages/")
		defaultOutputmessage.setOverrideExistingResources(true)
		defaultOutputmessage.setCreateOutputDirectory(true)
		defaultOutputmessage.setCleanUpDerivedResources(true)
		defaultOutputmessage.setSetDerivedProperty(true)
		hash1.put(RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_MESSAGE, defaultOutputmessage)
		
		return hash1
	}

}

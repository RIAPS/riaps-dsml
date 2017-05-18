package edu.vanderbilt.riaps.generator.chariot;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import edu.vanderbilt.riaps.app.Component;
import edu.vanderbilt.riaps.app.Requirement;

@SuppressWarnings("unused")
public class CompType {
	
	private String name;

	@SerializedName("JavaClass")
	private String javaClass;

	private Map<String, Object> requiredMemory;
	private Map<String, Object> requiredStorage;
	private List<String> requiredDevices;
	private List<String> requiredArtifacts;
	private String startScript;
	private String stopScript;
	
	public CompType(Component c) {
		this.name = c.getName();
		this.requiredArtifacts = new ArrayList<String>();
		this.requiredDevices = new ArrayList<String>();
		this.requiredMemory = new HashMap<String, Object>();
		this.requiredStorage = new HashMap<String, Object>();
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.ComponentType.DM_ComponentType";
		this.startScript = c.getName() + "Start.sh";
		this.stopScript = c.getName() + "Stop.sh";
		
		for (Requirement r : c.getRequirements()){
			if (r.getMemoryRequirement() != 0 && r.getMemoryunit() != null){
				this.requiredMemory.put(
						"JavaClass", 
						"edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_Memory");
				this.requiredMemory.put("memory", r.getMemoryRequirement());
				String unit = "KB";
				if (r.getMemoryunit().isMb()){
					unit = "MB";
				} else if (r.getMemoryunit().isGb()){
					unit = "GB";
				}
				this.requiredMemory.put("unit", unit);
			}
			if (r.getStorageRequirement() != 0 && r.getStorageunit() != null){
				this.requiredStorage.put(
						"JavaClass", 
						"edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_Storage");
				this.requiredStorage.put("storage", r.getStorageRequirement());
				String unit = "KB";
				if (r.getStorageunit().isMb()){
					unit = "MB";
				} else if (r.getStorageunit().isGb()){
					unit = "GB";
				}
				this.requiredStorage.put("unit", unit);
			}
			if (r.getDeviceRequirement() != null){
				this.requiredDevices.add(r.getDeviceRequirement());
			}
			if (r.getArtifactrequirement() != null){
				this.requiredArtifacts.add(r.getArtifactrequirement().getName());
			}
		}
		
	}
}

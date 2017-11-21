package edu.vanderbilt.riaps.generator.chariot;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import java.util.HashMap;

import edu.vanderbilt.riaps.system.DeviceSupported;
import edu.vanderbilt.riaps.system.NodeType;
import edu.vanderbilt.riaps.system.KnownNodes;
import edu.vanderbilt.riaps.system.MemoryProvision;
import edu.vanderbilt.riaps.system.StorageProvision;
import edu.vanderbilt.riaps.system.DeviceSupported;

@SuppressWarnings("unused")
public class NodeTemplate {

	@SerializedName("JavaClass")
	private String javaClass;
	private String name;
	private Map<String, Object> availableMemory;
	private Map<String, Object> availableStorage;
	private List<Object> devices;
	private String OS = "";
	private String middleware = "";
	private List<Object> artifacts;
	
	public NodeTemplate(NodeType nt){
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_NodeTemplate";
		this.name = nt.getName();
		this.availableMemory = new HashMap<String, Object>();
		this.availableStorage = new HashMap<String, Object>();
		this.devices = new ArrayList<Object>();
		this.artifacts = new ArrayList<Object>();
		
		this.setMemory(nt.getMemory());
		this.setStorage(nt.getStorage());
		this.setDeviceSupport(nt.getDeviceSupport());
	}
	
	public NodeTemplate(KnownNodes kn){
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_NodeTemplate";
		this.name = kn.getName();
		this.availableMemory = new HashMap<String, Object>();
		this.availableStorage = new HashMap<String, Object>();
		this.devices = new ArrayList<Object>();
		
		this.setMemory(kn.getMemory());
		this.setStorage(kn.getStorage());
		this.setDeviceSupport(kn.getDeviceSupport());
	}
	
	private void setMemory(MemoryProvision mp){
		this.availableMemory.put(
				"JavaClass", 
				"edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_Memory");
		this.availableMemory.put("memory", 0);
		this.availableMemory.put("unit", "");
		if (mp != null){
			this.availableMemory.put("memory", mp.getValue());
			String unit = "KB";
			if (mp.getUnit().isMb()){
				unit = "MB";
			} else if (mp.getUnit().isMb()){
				unit = "MB";
			}
			this.availableMemory.put("unit", unit);
		}
	}
	
	private void setStorage(StorageProvision sp){
		this.availableStorage.put(
				"JavaClass", 
				"edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_Storage");
		this.availableStorage.put("storage", 0);
		this.availableStorage.put("unit", "");
		if (sp != null){
			this.availableStorage.put("storage", sp.getStorage());
			String unit = "KB";
			if (sp.getUnit().isMb()){
				unit = "MB";
			} else if (sp.getUnit().isMb()){
				unit = "GB";
			}
			this.availableStorage.put("unit", unit);
		}
	}
	
	private void setDeviceSupport(EList<DeviceSupported> supportedDevices){
		if (supportedDevices != null && !supportedDevices.isEmpty()){
			for (DeviceSupported ds : supportedDevices){
				HashMap<String, Object> device = new HashMap<String, Object>();
				device.put(
						"JavaClass",
						"edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_Device");
				device.put("name", ds.getDevice().getName());
				this.devices.add(device);
			}
			
		}
	}
}

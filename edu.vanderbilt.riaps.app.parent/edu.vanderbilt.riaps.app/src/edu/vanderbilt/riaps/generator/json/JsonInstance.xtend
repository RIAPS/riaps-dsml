package edu.vanderbilt.riaps.generator.json

import java.util.List
import java.util.ArrayList
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.Actual
import edu.vanderbilt.riaps.app.CompDeviceRequirement
import edu.vanderbilt.riaps.app.DeviceInstance

@SuppressWarnings(#["unused", "unchecked", "rawtypes"]) class JsonInstance {
	transient String name
	String type
	List actuals

//	new(CompDeviceRequirement i){
//		this.name=i.deviceRequirement.name+"_instance"
//		this.type=i.deviceRequirement.name
//		this.actuals = new ArrayList<String>()
//		for (Actual a : i.getActuals()) {
//			this.actuals.add(new JsonActual(a))
//		}
//	}
	new(Instance i) {
		this.name = i.getName()
		this.type = i.getType().getName()
		this.actuals = new ArrayList<String>()
		for (Actual a : i.getActuals()) {
			this.actuals.add(new JsonActual(a))
		}
	}
	
		new(DeviceInstance i) {
		this.name = i.getName()
		this.type = i.deviceRequirement.getName()
		this.actuals = new ArrayList<String>()
		for (Actual a : i.getActuals()) {
			this.actuals.add(new JsonActual(a))
		}
	}
	

	def String getName() {
		return name
	}

	def void setName(String name) {
		this.name = name
	}
}

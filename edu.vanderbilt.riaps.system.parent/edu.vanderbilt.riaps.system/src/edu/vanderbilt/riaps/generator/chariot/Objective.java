package edu.vanderbilt.riaps.generator.chariot;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.annotations.SerializedName;

import edu.vanderbilt.riaps.system.ActorAssignment;

public class Objective {
	
	@SerializedName("JavaClass")
	private String javaClass;
	private String name;
	private List<Object> functionalities;
	
	public Objective(ActorAssignment aa){
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.GoalDescription.DM_Objective";
		this.name = aa.getActor().getName();
		this.functionalities = new ArrayList<Object>();
		
		HashMap<String,Object> functionality = new HashMap<String,Object>();
		functionality.put("JavaClass", "edu.vanderbilt.isis.chariot.datamodel.GoalDescription.DM_Functionality");
		functionality.put("name", this.name);
		functionality.put("dependsOn", new ArrayList<Object>());
		this.functionalities.add(functionality);
		
	}
}

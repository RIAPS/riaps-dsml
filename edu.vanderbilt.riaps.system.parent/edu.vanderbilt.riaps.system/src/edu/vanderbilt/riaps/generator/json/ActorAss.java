package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.List;

import edu.vanderbilt.riaps.app.ActorFormal;
import edu.vanderbilt.riaps.system.ActorAssignment;
import edu.vanderbilt.riaps.system.ActorFormalAssignment;

import edu.vanderbilt.riaps.generator.json.Argument;

@SuppressWarnings({"unused", "unchecked", "rawtypes"})
public class ActorAss {
	
	private String name;
	private List actuals;
	
	public ActorAss(ActorAssignment aa){
		this.name = aa.getActor().getName();
		this.actuals = new ArrayList<>();
		
		for (ActorFormalAssignment afa : aa.getFormals()){
			this.actuals.add(new Argument(afa));
		}
	}
	
}

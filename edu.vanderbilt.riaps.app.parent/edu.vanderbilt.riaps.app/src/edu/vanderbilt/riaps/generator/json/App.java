package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import edu.vanderbilt.riaps.app.Application;
import edu.vanderbilt.riaps.app.Component;
import edu.vanderbilt.riaps.app.AppComponent;
import edu.vanderbilt.riaps.app.Actor;
import edu.vanderbilt.riaps.app.Artifact;
import edu.vanderbilt.riaps.app.DeploymentConstraint;
import edu.vanderbilt.riaps.app.MessageRef;
import edu.vanderbilt.riaps.datatypes.Message;

import edu.vanderbilt.riaps.generator.json.Comp;

@SuppressWarnings("unused")
public class App {

	private String name;
	private Map<String,Comp> devices;
	private Map<String,Comp> components;
	private Map<String,JsonActor> actors;
	private List<HashMap<String,String>> messages;
	
	public App(Application a) {
		this.name = a.getName();
		this.devices = new HashMap<String,Comp>();
		this.components = new HashMap<String,Comp>();
		this.actors = new HashMap<String,JsonActor>();
		this.messages = new ArrayList<HashMap<String,String>>();
		
		for (Component c : a.getComponents()){
			if (c instanceof AppComponent){
				Comp ac = new Comp(c);
				this.components.put(ac.getName(), ac);
			} else {
				Comp dc = new Comp(c);
				this.devices.put(dc.getName(), dc);
			}
		}
		
		for (Actor ac : a.getActors()){
			JsonActor jac = new JsonActor(ac);
			actors.put(jac.getName(), jac);
		}
		
		for (Artifact af : a.getArtifacts()){
			// TODO: Fill in
		}
		
		for (DeploymentConstraint dc : a.getDeploymentConstraints()){
			// TODO: Fill in
		}
		
		for (MessageRef m : a.getMessages()){
			HashMap<String,String> mm = new HashMap<String,String>();
			mm.put("name", m.getType().getName());
			this.messages.add(mm);
		}
		
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

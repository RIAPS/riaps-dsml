package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.vanderbilt.riaps.app.Actor;
import edu.vanderbilt.riaps.app.ComponentFormal;
import edu.vanderbilt.riaps.app.ActorFormal;
import edu.vanderbilt.riaps.app.Message;

@SuppressWarnings({"unused", "unchecked", "rawtypes"})
public class JsonActor {

	private transient String name;
	
	private List internals;
	private List locals;
	private List criticals;
	private List formals;
	private List wires;
	private Map instances;
	
	public JsonActor(Actor a) {
		this.name = a.getName();
		this.internals = new ArrayList<>();
		this.locals = new ArrayList<>();
		this.criticals = new ArrayList<>();		
		this.formals = new ArrayList<>();
		this.wires = new ArrayList<>();
		
		for (ActorFormal af : a.getFormals()){
			this.formals.add(new Argument(af));
		}
		
		for (Message l : a.getInternals()){
			HashMap<String, String> internal = new HashMap<String, String>();
			internal.put("type", l.getName());
			this.internals.add(internal);
		}
		
		for (Message l : a.getLocals()){
			HashMap<String, String> local = new HashMap<String, String>();
			local.put("type", l.getName());
			this.locals.add(local);
		}
		
		for (Message l : a.getCriticals()){
			HashMap<String, String> critical = new HashMap<String, String>();
			critical.put("type", l.getName());
			this.locals.add(critical);
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

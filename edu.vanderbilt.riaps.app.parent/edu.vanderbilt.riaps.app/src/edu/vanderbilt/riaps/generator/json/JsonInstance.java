package edu.vanderbilt.riaps.generator.json;

import java.util.List;
import java.util.ArrayList;

import edu.vanderbilt.riaps.app.Instance;
import edu.vanderbilt.riaps.app.Actual;;


@SuppressWarnings({"unused", "unchecked", "rawtypes"})
public class JsonInstance {
	
	private transient String name;
	private String type;
	private List actuals;
	
	public JsonInstance(Instance i){
		this.name = i.getName();
		this.type = i.getType().getName();
		this.actuals = new ArrayList<String>();
		
		for (Actual a : i.getActuals()){
			this.actuals.add(new JsonActual(a));
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

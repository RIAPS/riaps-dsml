package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.InsPort;

@SuppressWarnings("unused")
public class BoolPort {

	private transient String name;
	private Boolean spec;
	
	public BoolPort(InsPort p) {
		this.name = p.getName();
		this.spec = p.isSpec();
	}

}

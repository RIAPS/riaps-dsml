package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.PubPort;
import edu.vanderbilt.riaps.app.SubPort;

@SuppressWarnings("unused")
public class PubSubPort {

	private transient String name;
	private String type;
	
	public PubSubPort(PubPort p) {
		this.name = p.getName();
		this.type = p.getType().getName();
	}

	public PubSubPort(SubPort p) {
		this.name = p.getName();
		this.type = p.getType().getName();
	}
}

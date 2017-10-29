package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.TimPort;

@SuppressWarnings("unused")
public class TimePort {
	
	private transient String name;
	private int period;
	
	public TimePort(TimPort p) {
		this.name = p.getName();
		this.period = p.getSpec();
	}

}

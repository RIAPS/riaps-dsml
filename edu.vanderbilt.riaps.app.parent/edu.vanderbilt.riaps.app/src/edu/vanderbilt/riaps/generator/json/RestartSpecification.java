package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.RestartSpec;;

@SuppressWarnings("unused")
public class RestartSpecification {
	
	private int maxtries;
	private int delay;
	
	public RestartSpecification(RestartSpec p) {
		this.maxtries = p.getMaxtries();
		this.delay = p.getDelay();
	}

}

package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.TimeUnit
import edu.vanderbilt.riaps.generator.AppGenerator

@SuppressWarnings("unused") class PubSubPort {
	transient String name
	String type

    Boolean timed
    int deadline
	new(PubPort p) {
		this.name = p.getName()
		this.type = p.getType().getName()
		timed=p.timed
				
	}

	new(SubPort p) {
		this.name = p.getName()
		this.type = p.getType().getName()
		this.timed=p.timed
		if (p.deadline>0)
		{
			this.deadline=AppGenerator.convert(p.deadline,p.unit)
		}
		
	}
	
	
}

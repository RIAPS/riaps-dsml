package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.TimPort

@SuppressWarnings("unused") class TimePort {
	transient String name
	int period

	new(TimPort p) {
		this.name = p.getName()
		this.period = p.getSpec()
	}
}

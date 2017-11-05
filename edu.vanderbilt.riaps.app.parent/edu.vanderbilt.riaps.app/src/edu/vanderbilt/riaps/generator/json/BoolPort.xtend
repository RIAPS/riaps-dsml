package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.InsPort

@SuppressWarnings("unused") class BoolPort {
	transient String name
	Boolean spec

	new(InsPort p) {
		this.name = p.getName()
		this.spec = p.isSpec()
	}
}

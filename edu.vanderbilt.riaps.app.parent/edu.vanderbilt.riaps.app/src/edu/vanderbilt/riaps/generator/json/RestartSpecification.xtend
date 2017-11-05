package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.RestartSpec

@SuppressWarnings("unused") class RestartSpecification {
	int maxtries
	int delay

	new(RestartSpec p) {
		this.maxtries = p.getMaxtries()
		this.delay = p.getDelay()
	}
}

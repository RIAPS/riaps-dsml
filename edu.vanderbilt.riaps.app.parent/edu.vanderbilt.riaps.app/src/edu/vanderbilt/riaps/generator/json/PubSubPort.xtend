package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.SubPort

@SuppressWarnings("unused") class PubSubPort {
	transient String name
	String type
	int upperlimit
	int lowerlimit

	new(PubPort p) {
		this.name = p.getName()
		this.type = p.getType().getName()
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNolower()) {
				this.lowerlimit = 0
			} else
				this.lowerlimit = p.getRatelimit().getLower()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNoupper()) {
				this.upperlimit = -1
			} else
				this.upperlimit = p.getRatelimit().getUpper()
		}
	}

	new(SubPort p) {
		this.name = p.getName()
		this.type = p.getType().getName()
	}
}

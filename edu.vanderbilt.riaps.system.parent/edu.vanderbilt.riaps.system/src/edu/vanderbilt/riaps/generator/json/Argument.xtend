package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.FormalDefault
import edu.vanderbilt.riaps.app.StringDefault
import edu.vanderbilt.riaps.app.BoolDefault
import edu.vanderbilt.riaps.app.NumberDefault
import edu.vanderbilt.riaps.system.ActorFormalAssignment
import edu.vanderbilt.riaps.system.ActualValue

@SuppressWarnings("unused") class Argument {
	String name
	Object value

	new(ActorFormalAssignment afa) {
		this.name = afa.getArgName().getName()
		var ActualValue av = afa.getArgValue()
		if (av.stringdefault !== null) {
			this.value = av.stringdefault.value
		} else if (av.boolDefault !== null) {
			this.value = av.boolDefault.value
		} else if (av.numberdefault !== null) {
			this.value = av.numberdefault.value
		}

	}
}

package edu.vanderbilt.riaps.generator.json

import java.util.List
import java.util.ArrayList
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.Actual

@SuppressWarnings(#["unused", "unchecked", "rawtypes"]) class JsonInstance {
	transient String name
	String type
	List actuals

	new(Instance i) {
		this.name = i.getName()
		this.type = i.getType().getName()
		this.actuals = new ArrayList<String>()
		for (Actual a : i.getActuals()) {
			this.actuals.add(new JsonActual(a))
		}
	}

	def String getName() {
		return name
	}

	def void setName(String name) {
		this.name = name
	}
}

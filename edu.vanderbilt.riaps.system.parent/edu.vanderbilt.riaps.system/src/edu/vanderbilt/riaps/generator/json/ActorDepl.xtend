package edu.vanderbilt.riaps.generator.json

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import edu.vanderbilt.riaps.system.ActorAssignment
import edu.vanderbilt.riaps.system.ActorDeployment
import edu.vanderbilt.riaps.system.Location
import edu.vanderbilt.riaps.system.LocationNodes
import edu.vanderbilt.riaps.system.LocationNodeTypes
import edu.vanderbilt.riaps.system.KnownNodes

@SuppressWarnings(#["unused", "unchecked", "rawtypes"]) class ActorDepl {
	List<String> target
	List actors

	new(ActorDeployment ad) {
		this.target = new ArrayList()
		this.actors = new ArrayList()
		for (ActorAssignment aa : ad.getActors()) {
			this.actors.add(new ActorAss(aa))
		}
		var Location loc = ad.getLocation()
		if (loc instanceof LocationNodes) {
			var LocationNodes locs = (loc as LocationNodes)
			for (KnownNodes kn : locs.getHosts()) {
				if (kn.getNetinterface().size() > 0) {
					target.add(kn.getNetinterface().get(0).getIp())
				}
			}
		}
	}
}

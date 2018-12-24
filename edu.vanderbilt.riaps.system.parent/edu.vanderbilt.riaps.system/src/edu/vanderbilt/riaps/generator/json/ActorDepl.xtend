package edu.vanderbilt.riaps.generator.json

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import edu.vanderbilt.riaps.system.ActorAssignment
import edu.vanderbilt.riaps.system.ActorDeployment
//import edu.vanderbilt.riaps.system.Location
//import edu.vanderbilt.riaps.system.LocationNodes
//import edu.vanderbilt.riaps.system.LocationNodeTypes
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
		if(ad.all) return;
		var allHostedNodes = ad.hosts
		// target.add(kn.trim.replaceAll("^\"|\"$", ""))
		for (hostedNode : allHostedNodes) {
			target.add(hostedNode.trim.replaceAll("^\"|\"$", ""))
		}
	}
}

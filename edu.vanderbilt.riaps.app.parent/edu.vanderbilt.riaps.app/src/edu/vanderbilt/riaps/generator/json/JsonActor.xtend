package edu.vanderbilt.riaps.generator.json

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import edu.vanderbilt.riaps.app.Actor
import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.ComponentRequirement
import edu.vanderbilt.riaps.app.EXIT
import edu.vanderbilt.riaps.app.IGNORE
import edu.vanderbilt.riaps.app.ActorFormal
import edu.vanderbilt.riaps.app.ActorRequirement
import edu.vanderbilt.riaps.app.CPURequirement
import edu.vanderbilt.riaps.app.Message
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.MemoryRequirement
import edu.vanderbilt.riaps.app.NAMEDHANDLER
import edu.vanderbilt.riaps.app.StorageRequirement
import edu.vanderbilt.riaps.app.NetworkRequirement

@SuppressWarnings(#["unused", "unchecked", "rawtypes"]) class JsonActor {
	transient String name
	List internals
	List locals
	//List criticals
	List formals
	//List wires
	Map instances
	//List devices
	SpaceConstraint spc
	Memoryconstraint mem
	CPUConstraint cpu
	NetConstraint net 


	new(Actor a) {
		this.name = a.getName()
		
		this.internals = new ArrayList()
		this.locals = new ArrayList()
	//	this.criticals = new ArrayList()
		this.formals = new ArrayList()
		//this.wires = new ArrayList()
		this.instances = new HashMap<String, Object>()
		//this.devices = new ArrayList<String>()
	
		if (a.getConstraint() !== null) {
			if (a.getConstraint().getRequirements() !== null) {
				for (ActorRequirement x : a.getConstraint().getRequirements()) {
					if (x instanceof MemoryRequirement) {
						this.mem = new Memoryconstraint(x)
					}
					if (x instanceof StorageRequirement) {
						this.spc = new SpaceConstraint(x)
					}
					if (x instanceof CPURequirement) {
						this.cpu = new CPUConstraint(x)

					}
					if (x instanceof NetworkRequirement) {
						this.net = new NetConstraint(x)		}
				}
			}
		}
		for (ActorFormal af : a.getFormals()) {
			this.formals.add(new ComponentArgument(af))
		}
		for (Message l : a.getInternals()) {
			var HashMap<String, String> internal = new HashMap<String, String>()
			internal.put("type", l.getName())
			this.internals.add(internal)
		}
		for (Message l : a.getLocals()) {
			var HashMap<String, String> local = new HashMap<String, String>()
			local.put("type", l.getName())
			this.locals.add(local)
		}

		for (Instance i : a.getCompsection().compInstances) {
			var JsonInstance instance = new JsonInstance(i)
			this.instances.put(instance.getName(), instance)
		}

//		if(a.constraint!=null)
//		{
//			for ( i : a.constraint.requirements) {
//				if(i instanceof ActorDeviceRequirement)
//				{
//					var JsonInstance instance = new JsonInstance(i.requ)
//					this.instances.put(instance.getName(), instance)
//				}
//			}
//		}		
	}

	def String getName() {
		return name
	}

	def void setName(String name) {
		this.name = name
	}
}

class SpaceConstraint {
	int use=0
	new(StorageRequirement k)
	{
		if(k.unit===null || k.unit.kilobytes) use=k.number
		if( k.unit.megabytes) use=k.number*1024
		if( k.unit.gigabytes) use=k.number*1024*1024
		
	}
}

class Memoryconstraint {
	int use=0
	new(MemoryRequirement k)
	{
		if(k.unit===null || k.unit.kilobytes) use=k.number
		if( k.unit.megabytes) use=k.number*1024
		if( k.unit.gigabytes) use=k.number*1024*1024
		
	}
}

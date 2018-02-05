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
import edu.vanderbilt.riaps.app.CompDeviceRequirement
import edu.vanderbilt.riaps.app.Message
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.MemoryRequirement
import edu.vanderbilt.riaps.app.NAMEDHANDLER
import edu.vanderbilt.riaps.app.StorageRequirement
import edu.vanderbilt.riaps.app.DeviceInstance
import edu.vanderbilt.riaps.app.NetworkRequirement

@SuppressWarnings(#["unused", "unchecked", "rawtypes"]) class JsonActor {
	transient String name
	List internals
	List locals
	List criticals
	List formals
	List wires
	Map instances
	List devices
	int memory = -1
	int space = -1
	CPUConstraint cpu
	NetConstraint net
	String exceptHandler
	RestartSpecification restart

	new(Actor a) {
		this.name = a.getName()
		this.exceptHandler = ""
		this.internals = new ArrayList()
		this.locals = new ArrayList()
		this.criticals = new ArrayList()
		this.formals = new ArrayList()
		this.wires = new ArrayList()
		this.instances = new HashMap<String, Object>()
		this.devices = new ArrayList<String>()
		if (a.getRestartspec() !== null) {
			restart = new RestartSpecification(a.getRestartspec())
		}
		if (a.getHandler() !== null) {
			if (a.getHandler() instanceof IGNORE) {
				this.exceptHandler = "IGNORE"
			}
			if (a.getHandler() instanceof EXIT) {
				this.exceptHandler = "EXIT"
			}
			if (a.getHandler() instanceof NAMEDHANDLER) {
				this.exceptHandler = ((a.getHandler() as NAMEDHANDLER)).getName()
			}
		}
		if (a.getConstraint() !== null) {
			if (a.getConstraint().getRequirements() !== null) {
				for (ActorRequirement x : a.getConstraint().getRequirements()) {
					if (x instanceof MemoryRequirement) {
						this.memory = ((x as MemoryRequirement)).getNumber()
					}
					if (x instanceof StorageRequirement) {
						this.space = ((x as StorageRequirement)).getNumber()
					}
					if (x instanceof CPURequirement) {
						this.cpu = new CPUConstraint
						this.cpu.max=x.max 
						this.cpu.period = ((x as CPURequirement)).getTimeInterval_Number()
						if(this.cpu.period == 0) this.cpu.period = 1000000
						this.cpu.quota = ((x as CPURequirement)).getPercentage()
						var double tmp = this.cpu.period
						tmp = tmp / 100.0
						this.cpu.quota = (this.cpu.quota * tmp).intValue

					}
					if (x instanceof NetworkRequirement) {
						if(this.net === null) this.net = new NetConstraint
						this.net.max=x.max 
						this.net.period = ((x as NetworkRequirement)).getTimeInterval_Number()
						this.net.quota = ((x as NetworkRequirement)).getNumber()
					}
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
		for (Message l : a.getCriticals()) {
			var HashMap<String, String> critical = new HashMap<String, String>()
			critical.put("type", l.getName())
			this.locals.add(critical)
		}
		for (Instance i : a.getCompsection().compInstances) {
			var JsonInstance instance = new JsonInstance(i)
			this.instances.put(instance.getName(), instance)
		}
		for (DeviceInstance i : a.getCompsection().devInstances) {
			var JsonInstance instance = new JsonInstance(i)
			this.instances.put(instance.getName(), instance)
			this.devices.add(i.deviceRequirement.name)
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

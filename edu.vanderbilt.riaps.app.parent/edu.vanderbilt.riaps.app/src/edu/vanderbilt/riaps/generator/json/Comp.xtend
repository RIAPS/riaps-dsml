package edu.vanderbilt.riaps.generator.json

import java.util.ArrayList
import java.util.HashMap
import java.util.List
import java.util.Map
import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.CPURequirement
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.CompDeviceRequirement
import edu.vanderbilt.riaps.app.TimPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.InsPort
import edu.vanderbilt.riaps.app.Library
import edu.vanderbilt.riaps.app.NAMEDHANDLER
import edu.vanderbilt.riaps.app.NetworkRequirement
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.ComponentRequirement
import edu.vanderbilt.riaps.app.Configuration
import edu.vanderbilt.riaps.app.EXIT
import edu.vanderbilt.riaps.app.IGNORE

@SuppressWarnings(#["unchecked", "rawtypes"]) class Comp {
	String name
	List formals
	List libraries
	List files
	List devices
	int cpu = -1
	int cpuinterval = -1
	int net = -1
	int netinterval = -1
	String exceptHandler
	Map<String, Map> ports

	new(Component c) {
		this.name = c.getName()
		this.formals = new ArrayList<String>()
		this.libraries = new ArrayList<String>()
		this.files = new ArrayList<String>()
		this.exceptHandler = ""
		if (c.getHandler() !== null) {
			if (c.getHandler() instanceof IGNORE) {
				this.exceptHandler = "IGNORE"
			}
			if (c.getHandler() instanceof EXIT) {
				this.exceptHandler = "EXIT"
			}
			if (c.getHandler() instanceof NAMEDHANDLER) {
				this.exceptHandler = ((c.getHandler() as NAMEDHANDLER)).getName()
			}
		}
		this.devices = new ArrayList<String>()
		if (c.getConstraint() !== null) {
			if (c.getConstraint().getRequirements() !== null) {
				for (ComponentRequirement x : c.getConstraint().getRequirements()) {
					if (x instanceof CPURequirement) {
						this.cpuinterval = ((x as CPURequirement)).getTimeInterval_Number()
						this.cpu = ((x as CPURequirement)).getPercentage()
					}
					if (x instanceof NetworkRequirement) {
						this.netinterval = ((x as NetworkRequirement)).getTimeInterval_Number()
						this.net = ((x as NetworkRequirement)).getNumber()
					}
					if (x instanceof Library) {
						this.libraries.add(((x as Library)).getName())
					}
					if (x instanceof Configuration) {
						this.files.add(((x as Configuration)).getName())
					}
					if (x instanceof CompDeviceRequirement) {
						this.devices.add(((x as CompDeviceRequirement)).getDeviceRequirement().getName())
					}
				}
			}
		}
		this.ports = new HashMap<String, Map>()
		this.ports.put("clts", new HashMap<String, ClntSrvPort>())
		this.ports.put("srvs", new HashMap<String, ClntSrvPort>())
		this.ports.put("reqs", new HashMap<String, ClntSrvPort>())
		this.ports.put("reps", new HashMap<String, ClntSrvPort>())
		this.ports.put("pubs", new HashMap<String, PubSubPort>())
		this.ports.put("subs", new HashMap<String, PubSubPort>())
		this.ports.put("tims", new HashMap<String, TimePort>())
		this.ports.put("inss", new HashMap<String, BoolPort>())
		for (Port p : c.getPorts()) {
			if (p instanceof ClntPort) {
				var ClntSrvPort port = new ClntSrvPort((p as ClntPort))
				this.getPortMap("clts").put(p.getName(), port)
			} else if (p instanceof SrvPort) {
				var ClntSrvPort port = new ClntSrvPort((p as SrvPort))
				this.getPortMap("srvs").put(p.getName(), port)
			} else if (p instanceof ReqPort) {
				var ClntSrvPort port = new ClntSrvPort((p as ReqPort))
				this.getPortMap("reqs").put(p.getName(), port)
			} else if (p instanceof RepPort) {
				var ClntSrvPort port = new ClntSrvPort((p as RepPort))
				this.getPortMap("reps").put(p.getName(), port)
			} else if (p instanceof PubPort) {
				var PubSubPort port = new PubSubPort((p as PubPort))
				this.getPortMap("pubs").put(p.getName(), port)
			} else if (p instanceof SubPort) {
				var PubSubPort port = new PubSubPort((p as SubPort))
				this.getPortMap("subs").put(p.getName(), port)
			} else if (p instanceof TimPort) {
				var TimePort port = new TimePort((p as TimPort))
				this.getPortMap("tims").put(p.getName(), port)
			} else if (p instanceof InsPort) {
				var BoolPort port = new BoolPort((p as InsPort))
				this.getPortMap("inss").put(p.getName(), port)
			}
		}
		for (ComponentFormal cf : c.getFormals()) {
			this.formals.add(new Argument(cf))
		}
	}

	def private Map getPortMap(String name) {
		return this.ports.get(name)
	}

	def String getName() {
		return name
	}

	def void setName(String name) {
		this.name = name
	}
}

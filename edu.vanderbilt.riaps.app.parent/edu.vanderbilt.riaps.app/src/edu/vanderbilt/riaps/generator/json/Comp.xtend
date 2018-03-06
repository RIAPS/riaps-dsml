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
import edu.vanderbilt.riaps.app.DeviceType
import edu.vanderbilt.riaps.app.DeviceRequirement
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.AnswerPort
import edu.vanderbilt.riaps.app.clibrary
import edu.vanderbilt.riaps.app.pylibrary

@SuppressWarnings(#["unchecked", "rawtypes"]) class Comp {
	String name
	List formals
	// List libraries
	List<HashMap<String, String>> libraries
	List files
	List devices
	CPUConstraint cpu
	NetConstraint net
	String exceptHandler
	Map<String, Map> ports

	new(DeviceType c) {

		this.name = c.getName()
		this.formals = new ArrayList<String>()
		// this.libraries = new ArrayList<String>()
		this.libraries = new ArrayList<HashMap<String, String>>()
		this.files = new ArrayList<String>()
		this.exceptHandler = ""

		this.devices = new ArrayList<String>()
		if (c.constraint !== null && c.constraint.size >= 1) {
			if (c.getConstraint().get(0).getRequirements() !== null) {
				for (DeviceRequirement x : c.getConstraint().get(0).getRequirements()) {
					if (x instanceof CPURequirement) {
						if(this.cpu === null) this.cpu = new CPUConstraint

						this.cpu.period = ((x as CPURequirement)).getTimeInterval_Number()
						this.cpu.max = x.max
						if(this.cpu.period == 0) this.cpu.period = 1000000
						this.cpu.quota = ((x as CPURequirement)).getPercentage()
						var double tmp = this.cpu.period
						tmp = tmp / 100.0
						this.cpu.quota = (this.cpu.quota * tmp).intValue
					}
					if (x instanceof NetworkRequirement) {
						if(this.net === null) this.net = new NetConstraint
						this.net.max = x.max
						this.net.period = ((x as NetworkRequirement)).getTimeInterval_Number()
						this.net.quota = ((x as NetworkRequirement)).getNumber()
					}
					if (x instanceof Library) {
						var mm = new HashMap<String, String>();
						mm.put("name", (x as Library).getName());
						this.libraries.add(mm)
					// this.libraries.add(((x as Library)).getName())
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
		this.ports.put("qrys", new HashMap<String, ClntSrvPort>())
		this.ports.put("anss", new HashMap<String, ClntSrvPort>())
		for (Port p : c.getPorts()) {
			if (p instanceof ClntPort) {
				var ClntSrvPort port = new ClntSrvPort((p as ClntPort))
				this.getPortMap("clts").put(p.getName(), port)
			} else if (p instanceof SrvPort) {
				var ClntSrvPort port = new ClntSrvPort((p as SrvPort))
				this.getPortMap("srvs").put(p.getName(), port)
			} else if (p instanceof QueryPort) {
				var ClntSrvPort port = new ClntSrvPort((p as QueryPort))
				this.getPortMap("qrys").put(p.getName(), port)
			} else if (p instanceof AnswerPort) {
				var ClntSrvPort port = new ClntSrvPort((p as AnswerPort))
				this.getPortMap("anss").put(p.getName(), port)
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
			this.formals.add(new ComponentArgument(cf))
		}
	}

	new(Component c) {
		this.name = c.getName()
		this.formals = new ArrayList<String>()
		// this.libraries = new ArrayList<String>()
		this.libraries = new ArrayList<HashMap<String, String>>()
		this.files = new ArrayList<String>()
		this.exceptHandler = ""
		if (c.handler !== null && c.handler.size() > 1) {
			var handler = c.handler.get(0)
			if (handler instanceof IGNORE) {
				this.exceptHandler = "IGNORE"
			}
			if (handler instanceof EXIT) {
				this.exceptHandler = "EXIT"
			}
			if (handler instanceof NAMEDHANDLER) {
				this.exceptHandler = ((handler as NAMEDHANDLER)).getName()
			}
		}
		this.devices = new ArrayList<String>()
		// System.out.println("here in constraint")
		if (c.constraint !== null && c.constraint.size() >= 1) {
			// System.out.println("here in constraint is not null")
			if (c.constraint.get(0).getRequirements() !== null) {
				for (ComponentRequirement x : c.constraint.get(0).getRequirements()) {
					if (x instanceof CPURequirement) {
						if(this.cpu === null) this.cpu = new CPUConstraint
						this.cpu.max = x.max

						this.cpu.period = ((x as CPURequirement)).getTimeInterval_Number()
						if(this.cpu.period == 0) this.cpu.period = 1000000
						this.cpu.quota = ((x as CPURequirement)).getPercentage()
						var double tmp = this.cpu.period
						tmp = tmp / 100.0
						this.cpu.quota = (this.cpu.quota * tmp).intValue
					}
					if (x instanceof NetworkRequirement) {
						if(this.net === null) this.net = new NetConstraint
						this.net.max = x.max
						this.net.period = ((x as NetworkRequirement)).getTimeInterval_Number()
						this.net.quota = ((x as NetworkRequirement)).getNumber()
					}
					if (x instanceof Library) {
						var mm = new HashMap<String, String>();
						mm.put("name", (x as Library).getName());
						this.libraries.add(mm)
					// this.libraries.add(((x as Library)).getName())
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
		this.ports.put("qrys", new HashMap<String, ClntSrvPort>())
		this.ports.put("anss", new HashMap<String, ClntSrvPort>())
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
			} else if (p instanceof QueryPort) {
				var ClntSrvPort port = new ClntSrvPort((p as QueryPort))
				this.getPortMap("qrys").put(p.getName(), port)
			} else if (p instanceof AnswerPort) {
				var ClntSrvPort port = new ClntSrvPort((p as AnswerPort))
				this.getPortMap("anss").put(p.getName(), port)
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
			this.formals.add(new ComponentArgument(cf))
		}
	}

	def String getName(Library library) {
		if(library === null) return "";
		if (library.lib instanceof clibrary)
			return (library.lib as clibrary).name

		if (library.lib instanceof pylibrary)
			return (library.lib as pylibrary).name
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

class NetConstraint {
	public int quota
	public int period
	public boolean max
}

class CPUConstraint {
	public int quota
	public int period
	public boolean max
}

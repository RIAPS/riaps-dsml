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
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.AnswerPort
import edu.vanderbilt.riaps.app.clibrary
import edu.vanderbilt.riaps.app.pylibrary
import edu.vanderbilt.riaps.generator.AppGenerator

@SuppressWarnings(#["unchecked", "rawtypes"]) class Comp {
	List formals 
	String language;
	String name
	// List libraries
	List<HashMap<String, String>> libraries
	//List files
	//List devices
	Map<String, Map> ports
	

	new(Component c) {
		this.language="default"
		this.name = c.getName()
		if (c.language!=null)
		{
			if(c.language.cppImpl)
				this.language="cpp"
			
			if(c.language.pyImpl)
			this.language="py"
			
		}
		this.formals = new ArrayList<String>()
		// this.libraries = new ArrayList<String>()
		this.libraries = new ArrayList<HashMap<String, String>>()
		//this.files = new ArrayList<String>()
		//this.devices = new ArrayList<String>()
		// System.out.println("here in constraint")
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
	public int burst
	public int ceil
	public int rate

	new(NetworkRequirement x) {

		this.rate=AppGenerator.convert(x.rate,x.rateUnit)
		this.ceil=AppGenerator.convert(x.ceil,x.ceilUnit)
		this.burst=AppGenerator.convert(x.burst,x.burstUnit)
	}
}

class CPUConstraint {
	public int interval
	public int use
	public boolean max

	new(CPURequirement x) {
		this.max = x.max
		this.use = x.percentage
		if (x.timeInterval == 0)
			interval = 0
		else
			this.interval = AppGenerator.convert(x.timeInterval, x.unit)

	}
}

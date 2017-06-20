package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.vanderbilt.riaps.app.Component;
import edu.vanderbilt.riaps.app.SrvPort;
import edu.vanderbilt.riaps.app.SubPort;
import edu.vanderbilt.riaps.app.PubPort;
import edu.vanderbilt.riaps.app.ClntPort;
import edu.vanderbilt.riaps.app.TimPort;
import edu.vanderbilt.riaps.app.ReqPort;
import edu.vanderbilt.riaps.app.RepPort;
import edu.vanderbilt.riaps.app.InsPort;
import edu.vanderbilt.riaps.app.Port;
import edu.vanderbilt.riaps.app.ComponentFormal;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Comp {

	private String name;
	private List formals;
	private Map<String, Map> ports;
	
	public Comp(Component c) {
		this.name = c.getName();
		this.formals = new ArrayList<String>();
		this.ports = new HashMap<String, Map>();

		this.ports.put("clts", new HashMap<String, ClntSrvPort>());
		this.ports.put("srvs", new HashMap<String, ClntSrvPort>());
		this.ports.put("reqs", new HashMap<String, ClntSrvPort>());
		this.ports.put("reps", new HashMap<String, ClntSrvPort>());
		this.ports.put("pubs", new HashMap<String, PubSubPort>());
		this.ports.put("subs", new HashMap<String, PubSubPort>());
		this.ports.put("tims", new HashMap<String, TimePort>());
		this.ports.put("inss", new HashMap<String, BoolPort>());
		
		for (Port p : c.getPorts()){
			if (p instanceof ClntPort){
				ClntSrvPort port = new ClntSrvPort((ClntPort)p);
				this.getPortMap("clts").put(p.getName(), port);
			} else if (p instanceof SrvPort){
				ClntSrvPort port = new ClntSrvPort((SrvPort)p);
				this.getPortMap("srvs").put(p.getName(), port);
			} else if (p instanceof ReqPort){
				ClntSrvPort port = new ClntSrvPort((ReqPort)p);
				this.getPortMap("reqs").put(p.getName(), port);
			} else if (p instanceof RepPort){
				ClntSrvPort port = new ClntSrvPort((RepPort)p);
				this.getPortMap("reps").put(p.getName(), port);
			} else if (p instanceof PubPort){
				PubSubPort port = new PubSubPort((PubPort)p);
				this.getPortMap("pubs").put(p.getName(), port);
			} else if (p instanceof SubPort){
				PubSubPort port = new PubSubPort((SubPort)p);
				this.getPortMap("subs").put(p.getName(), port);
			} else if (p instanceof TimPort){
				TimePort port = new TimePort((TimPort)p);
				this.getPortMap("tims").put(p.getName(), port);
			} else if (p instanceof InsPort){
				BoolPort port = new BoolPort((InsPort)p);
				this.getPortMap("inss").put(p.getName(), port);
			}
		}
		for (ComponentFormal cf : c.getFormals()){
			this.formals.add(new Argument(cf));
		}
	}
	
	private Map getPortMap(String name){
		return this.ports.get(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

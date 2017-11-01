package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.vanderbilt.riaps.app.Component;
import edu.vanderbilt.riaps.app.SrvPort;
import edu.vanderbilt.riaps.app.SubPort;
import edu.vanderbilt.riaps.app.PubPort;
import edu.vanderbilt.riaps.app.CPURequirement;
import edu.vanderbilt.riaps.app.ClntPort;
import edu.vanderbilt.riaps.app.CompDeviceRequirement;
import edu.vanderbilt.riaps.app.TimPort;
import edu.vanderbilt.riaps.app.ReqPort;
import edu.vanderbilt.riaps.app.RepPort;
import edu.vanderbilt.riaps.app.InsPort;
import edu.vanderbilt.riaps.app.Library;
import edu.vanderbilt.riaps.app.NAMEDHANDLER;
import edu.vanderbilt.riaps.app.NetworkRequirement;
import edu.vanderbilt.riaps.app.Port;
import edu.vanderbilt.riaps.app.ComponentFormal;
import edu.vanderbilt.riaps.app.ComponentRequirement;
import edu.vanderbilt.riaps.app.Configuration;
import edu.vanderbilt.riaps.app.EXIT;
import edu.vanderbilt.riaps.app.IGNORE;

@SuppressWarnings({"unchecked", "rawtypes"})
public class Comp {

	private String name;
	private List formals;
	private List libraries;
	private List files;
	
	private List devices;
	
	private int cpu=-1;
	private int cpuinterval=-1;
	private int net=-1;
	private int netinterval=-1;
	private String exceptHandler;
	private Map<String, Map> ports;
	
	public Comp(Component c) {
		this.name = c.getName();
		this.formals = new ArrayList<String>();
		this.libraries = new ArrayList<String>();
		this.files = new ArrayList<String>();
		
		this.exceptHandler="";
		
		if(c.getHandler()!=null)
		{
			if(c.getHandler() instanceof IGNORE)
			{
				this.exceptHandler="IGNORE";
			}
			if(c.getHandler() instanceof EXIT)
			{
				this.exceptHandler="EXIT";
			}
			if(c.getHandler() instanceof NAMEDHANDLER)
			{
				this.exceptHandler=((NAMEDHANDLER)c.getHandler()).getName();
			}
		}
		

		this.devices = new ArrayList<String>();
		if (c.getConstraint()!=null) {
			if (c.getConstraint().getRequirements()!=null)
			{
				for (ComponentRequirement x: c.getConstraint().getRequirements())
				{
					if (x instanceof CPURequirement)
					{
						this.cpuinterval=((CPURequirement)x).getTimeInterval_Number();
						this.cpu=((CPURequirement)x).getPercentage();
					}
					if (x instanceof NetworkRequirement)
					{
						this.netinterval=((NetworkRequirement)x).getTimeInterval_Number();
						this.net=((NetworkRequirement)x).getNumber();
					}
					
					if (x instanceof Library)
					{
						this.libraries.add(((Library)x).getName());
					}
					if (x instanceof Configuration)
					{
						this.files.add(((Configuration)x).getName());
					}
					if(x instanceof CompDeviceRequirement)
					{
						this.devices.add(((CompDeviceRequirement)x).getDeviceRequirement().getName());
					}
				}
			}
			
		}
		
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

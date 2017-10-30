package edu.vanderbilt.riaps.generator.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.List;

import edu.vanderbilt.riaps.app.Application;
import edu.vanderbilt.riaps.app.Component;
//import edu.vanderbilt.riaps.app.AppComponent;
import edu.vanderbilt.riaps.app.Actor;

import edu.vanderbilt.riaps.app.ClntPort;
import edu.vanderbilt.riaps.app.DeploymentConstraint;
import edu.vanderbilt.riaps.app.Port;
import edu.vanderbilt.riaps.app.PubPort;
import edu.vanderbilt.riaps.app.RepPort;
import edu.vanderbilt.riaps.app.ReqPort;
import edu.vanderbilt.riaps.app.SrvPort;
import edu.vanderbilt.riaps.app.SubPort;
//import edu.vanderbilt.riaps.app.MessageRef;
import edu.vanderbilt.riaps.datatypes.Message;

import edu.vanderbilt.riaps.generator.json.Comp;

@SuppressWarnings("unused")
public class App {

	private String name;
	private Map<String,Comp> devices;
	private Map<String,Comp> components;
	private Map<String,JsonActor> actors;
	private List<HashMap<String,String>> messages;
	
	public App(Application a) {
		this.name = a.getName();
		this.devices = new HashMap<String,Comp>();
		this.components = new HashMap<String,Comp>();
		this.actors = new HashMap<String,JsonActor>();
		this.messages = new ArrayList<HashMap<String,String>>();
		HashSet<String> messageSet= new HashSet<String>();
		
		for (Component c : a.getComponents()){
			if (c instanceof Component){
				for (Port p : c.getPorts())
				{
					if(p instanceof PubPort)
					{						
						messageSet.add(((PubPort)p).getType().getName());						
					}
					if(p instanceof SubPort)
					{						
						messageSet.add(((SubPort)p).getType().getName());						
					}
					if(p instanceof ClntPort)
					{
						messageSet.add(((ClntPort)p).getRep_type().getName());
						messageSet.add(((ClntPort)p).getReq_type().getName());										
					}
					if(p instanceof SrvPort)
					{
						messageSet.add(((SrvPort)p).getRep_type().getName());
						messageSet.add(((SrvPort)p).getReq_type().getName());										
					}
					if(p instanceof ReqPort)
					{
						messageSet.add(((ReqPort)p).getRep_type().getName());
						messageSet.add(((ReqPort)p).getReq_type().getName());										
					}
					if(p instanceof RepPort)
					{
						messageSet.add(((RepPort)p).getRep_type().getName());
						messageSet.add(((RepPort)p).getReq_type().getName());										
					}
				}			
				
			} 
		}
		
		for (String s: messageSet)
		{
			HashMap<String,String> mm = new HashMap<String,String>();
			mm.put("name", s);
			this.messages.add(mm);
		}
		
		for (Component c : a.getComponents()){
			if (c instanceof Component){
				Comp ac = new Comp(c);
				this.components.put(ac.getName(), ac);
			} else {
				Comp dc = new Comp(c);
				this.devices.put(dc.getName(), dc);
			}
		}
		
		for (Actor ac : a.getActors()){
			JsonActor jac = new JsonActor(ac);
			actors.put(jac.getName(), jac);
		}
		
	
		
		for (DeploymentConstraint dc : a.getDeploymentConstraints()){
			// TODO: Fill in
		}
		
		//for (MessageRef m : a.getMessages()){
	//		HashMap<String,String> mm = new HashMap<String,String>();
	//		mm.put("name", m.getType().getName());
	//		this.messages.add(mm);
	//	}
		
		
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

package edu.vanderbilt.riaps.generator.json

import java.util.ArrayList
import java.util.HashMap
import java.util.HashSet
import java.util.Map
import java.util.List
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.app.Component
//import edu.vanderbilt.riaps.app.AppComponent;
import edu.vanderbilt.riaps.app.Actor
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.DeploymentConstraint
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.SubPort
//import edu.vanderbilt.riaps.app.MessageRef;
import edu.vanderbilt.riaps.app.Message
import edu.vanderbilt.riaps.generator.json.Comp
import edu.vanderbilt.riaps.app.DeviceType

@SuppressWarnings("unused") class App {
	String name
	Map<String, Comp> devices
	Map<String, Comp> components
	Map<String, JsonActor> actors
	List<HashMap<String, String>> messages
	List <String> libraries

	new(Application a) {
		this.name = a.getName()
		this.libraries = new ArrayList <String>()
		this.devices = new HashMap<String, Comp>()
		this.components = new HashMap<String, Comp>()
		this.actors = new HashMap<String, JsonActor>()
		this.messages = new ArrayList<HashMap<String, String>>()
		var HashSet<String> messageSet = new HashSet<String>()
		for (Component c : a.getComponents()) {
			if (c instanceof Component) {
				for (Port p : c.getPorts()) {
					if (p instanceof PubPort) {
						messageSet.add(((p as PubPort)).getType().getName())
					}
					if (p instanceof SubPort) {
						messageSet.add(((p as SubPort)).getType().getName())
					}
					if (p instanceof ClntPort) {
						messageSet.add(((p as ClntPort)).getRep_type().getName())
						messageSet.add(((p as ClntPort)).getReq_type().getName())
					}
					if (p instanceof SrvPort) {
						messageSet.add(((p as SrvPort)).getRep_type().getName())
						messageSet.add(((p as SrvPort)).getReq_type().getName())
					}
					if (p instanceof ReqPort) {
						messageSet.add(((p as ReqPort)).getRep_type().getName())
						messageSet.add(((p as ReqPort)).getReq_type().getName())
					}
					if (p instanceof RepPort) {
						messageSet.add(((p as RepPort)).getRep_type().getName())
						messageSet.add(((p as RepPort)).getReq_type().getName())
					}
				}
			}
		}
		for (String s : messageSet) {
			var HashMap<String, String> mm = new HashMap<String, String>()
			mm.put("name", s)
			this.messages.add(mm)
		}
		for (Component c : a.getComponents()) {
			if (c instanceof Component) {
				var Comp ac = new Comp(c)
				this.components.put(ac.getName(), ac)
			} else {
				var Comp dc = new Comp(c)
				this.devices.put(dc.getName(), dc)
			}
		}
		
		for (DeviceType c : a.devices) {
				var Comp dc = new Comp(c)
				this.devices.put(dc.getName(), dc)
			
		}
		for (Actor ac : a.getActors()) {
			var JsonActor jac = new JsonActor(ac)
			actors.put(jac.getName(), jac)
		}
		for (DeploymentConstraint dc : a.getDeploymentConstraints()) { // TODO: Fill in
		} // for (MessageRef m : a.getMessages()){
		// HashMap<String,String> mm = new HashMap<String,String>();
		// mm.put("name", m.getType().getName());
		// this.messages.add(mm);
		// }
	}

	def String getName() {
		return this.name
	}

	def void setName(String name) {
		this.name = name
	}
}

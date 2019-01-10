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
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.Library
import edu.vanderbilt.riaps.app.clibrary
import edu.vanderbilt.riaps.app.pylibrary

@SuppressWarnings("unused") class App {
	String name
	Map<String, AppGroups> groups
	Map<String, Comp> devices
	Map<String, Comp> components
	Map<String, JsonActor> actors
	List<HashMap<String, String>> messages
	List<HashMap<String, String>> libraries
	

	new(Application a) { 
		this.name = a.getName()
		
		this.devices = new HashMap<String, Comp>()
		this.groups = new HashMap<String, AppGroups>()
		this.components = new HashMap<String, Comp>()
		this.actors = new HashMap<String, JsonActor>()
		this.messages = new ArrayList<HashMap<String, String>>()
		this.libraries = new ArrayList<HashMap<String, String>>()
		var HashSet<String> messageSet = new HashSet<String>()
//		for (g : a.groups) {
//			var AppGroups group = new AppGroups(g)
//			groups.put(g.name, group)
//		}

		for (Component c : a.collectComponents()) {
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
		for ( c : a.collectComponents()) {
			
				var Comp ac = new Comp(c)
				this.components.put(ac.getName(), ac)
			
		}

		for ( c : a.collectdevices) {
			var Comp dc = new Comp(c)
			this.devices.put(dc.getName(), dc)

		}
//		for(Library x:a.libraries){
//			var mm = new HashMap<String,String>();
//			mm.put("name", (x as Library).getName());
//			this.libraries.add(mm)
//		}
		for (Actor ac : a.getActors()) {
			var JsonActor jac = new JsonActor(ac)
			actors.put(jac.getName(), jac)
		}
//		for (DeploymentConstraint dc : a.getDeploymentConstraints()) { // TODO: Fill in
//		} // for (MessageRef m : a.getMessages()){
		// HashMap<String,String> mm = new HashMap<String,String>();
		// mm.put("name", m.getType().getName());
		// this.messages.add(mm);
		// }
	}
	
	def String getName(Library library){
		if (library===null) return "";
		if(library.lib instanceof clibrary)
			return (library.lib as clibrary).name
		
		if(library.lib instanceof pylibrary)
			return (library.lib as pylibrary).name
	}

	def Iterable<? extends Component> collectComponents(Application application) {
		var dt = application.components.filter[appComponent].toList
//		for (Actor ac : application.getActors()) {
//			if (ac.compsection !== null) {
//				for (Instance i : ac.getCompsection().compInstances) {
//					if (!dt.contains(i.type)) {
//						dt.add(i.type)
//					}
//
//				}
//
//			}
//
//		}
		return dt
	}

	def Iterable<? extends Component> collectdevices(Application application) {
		var dt = application.components.filter[ioComponent].toList
//		for (Actor ac : application.getActors()) {
//			if (ac.compsection !== null) {
//				for ( i : ac.getCompsection().compInstances) {
//					if (!dt.contains(i.type)) {
//						dt.add(i.type)
//					}
//
//				}
//
//			}
//
//		}
		return dt
	}

	def String getName() {
		return this.name
	}

	def void setName(String name) {
		this.name = name
	}
}

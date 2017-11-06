package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Application
import java.util.HashMap
import java.util.ArrayList
import java.lang.Runtime
import java.io.BufferedReader
import java.io.InputStreamReader
import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.generator.CppGenerator

class AppCpp {	
	public var String applicationName
	public var portMsgTypeMap = new HashMap<String, String>
	public var compList = new ArrayList<CompCpp>
	public var CppGenerator generator
	
	new (Application app, CppGenerator gen) {
		applicationName = app.name
		generator=gen
		for (Component c : app.components){			
				for (Port p : c.getPorts())
				{
					if(p instanceof PubPort)
					{						
						portMsgTypeMap.put(p.type.name, p.type.type.name);						
					}
					if(p instanceof SubPort)
					{						
						portMsgTypeMap.put(p.type.name, p.type.type.name);											
					}
					if(p instanceof ClntPort)
					{
						portMsgTypeMap.put(p.req_type.name, p.req_type.type.name);				
						portMsgTypeMap.put(p.rep_type.name, p.rep_type.type.name);				
															
					}
					if(p instanceof SrvPort)
					{
						
						portMsgTypeMap.put(p.req_type.name, p.req_type.type.name);				
						portMsgTypeMap.put(p.rep_type.name, p.rep_type.type.name);									
					}
					if(p instanceof ReqPort)
					{
						
					portMsgTypeMap.put(p.req_type.name, p.req_type.type.name);				
						portMsgTypeMap.put(p.rep_type.name, p.rep_type.type.name);										
					}
					if(p instanceof RepPort)
					{
						
						portMsgTypeMap.put(p.req_type.name, p.req_type.type.name);				
						portMsgTypeMap.put(p.rep_type.name, p.rep_type.type.name);									
					}
						
				
			} 
		}
		
	
		
		//for (MessageRef msgRef: app.messages) {
			//var msg = msgRef.type
		//	portMsgTypeMap.put(msg.name, msg.type.name)
	//	}
		
		for (comp: app.components) {
			var compCpp = new CompCpp(comp, app.name, portMsgTypeMap,gen)
			compList.add(compCpp)
		}
		
	}
	
	
	
	def createCapnp() {
		// create id
		var rt = Runtime.getRuntime();
		var pr = rt.exec("capnp id");

		var stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()))
	    var s = new String()
	    s = null
		s = stdInput.readLine()

		var msgTypes = portMsgTypeMap.values.toSet
		if (s == null) {
			var content = '''
			«FOR msgType: msgTypes»
			struct «msgType» {
				
			}
			
			«ENDFOR»
			'''
			return content
		}
		else
		{
			var content = '''
			«s»;
			
			«FOR msgType: msgTypes»
			struct «msgType» {
				
			}
			
			«ENDFOR»
			'''
			return content	
		}
	
	}
	

}
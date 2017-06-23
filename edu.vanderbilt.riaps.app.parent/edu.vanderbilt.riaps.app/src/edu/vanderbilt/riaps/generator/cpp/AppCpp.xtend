package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Application
import java.util.HashMap
import edu.vanderbilt.riaps.app.MessageRef
import java.util.ArrayList
import java.lang.Runtime
import java.io.BufferedReader
import java.io.InputStreamReader

class AppCpp {
	public var String applicationName
	protected var portMsgTypeMap = new HashMap<String, String>
	public var compList = new ArrayList<CompCpp>
	
	new (Application app) {
		applicationName = app.name
		
		for (MessageRef msgRef: app.messages) {
			var msg = msgRef.type
			portMsgTypeMap.put(msg.name, msg.type.name)
		}
		
		for (comp: app.components) {
			var compCpp = new CompCpp(comp, app.name, portMsgTypeMap)
			compList.add(compCpp)
		}
		
	}
	
	def String createCMakeList() {
		val capnpMsgs = portMsgTypeMap.values.toSet
	
		val content = '''
		include_directories(include)
		
		«FOR m: capnpMsgs»
       	add_custom_command(
       			OUTPUT  include/messages/«m».capnp.c++ include/messages/«m».capnp.h
       			DEPENDS include/messages/«m».capnp
       			COMMAND capnp compile -oc++ include/messages/«m».capnp
       			VERBATIM
       	)

		«ENDFOR»
		
		«FOR c: compList»
		add_library(«c.componentName.toLowerCase» SHARED src/«c.componentName».cc
				                                  src/base/«c.componentName»Base.cc
				                                  «FOR i: c.msgIncludes»
				                                  include/messages/«i».capnp.c++
				                 				  «ENDFOR»
		)
		
		«ENDFOR»
		
		«FOR c: compList»
		target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj )
		
		«ENDFOR»
		'''
		return content
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
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
import java.util.HashSet
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.datatypes.Message

class AppCpp {
	public var String applicationName
	protected var portMsgTypeMap = new HashMap<String, String>
	public var compList = new ArrayList<CompCpp>
	
	new (Application app) {
		applicationName = app.name
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
			var compCpp = new CompCpp(comp, app.name, portMsgTypeMap)
			compList.add(compCpp)
		}
		
	}
	
	def String createCMakeList() {
		val capnpMsgs = portMsgTypeMap.values.toSet
	
		val content = '''
		
		cmake_minimum_required(VERSION 3.0)
		project («this.applicationName»)
		set(CMAKE_SYSTEM_NAME Linux)
				
		set(DEPENDENCIES ${riaps_prefix})
		set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/${arch}/include)
		set (LIBALLPATH_LIB ${DEPENDENCIES}/${arch}/lib)
		include_directories(${LIBALLPATH_INCLUDE})
		link_directories(${LIBALLPATH_LIB})
		
		# Debug binaries are to be copied into "./bin" directory
		set(CMAKE_RUNTIME_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		set(CMAKE_LIBRARY_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		
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
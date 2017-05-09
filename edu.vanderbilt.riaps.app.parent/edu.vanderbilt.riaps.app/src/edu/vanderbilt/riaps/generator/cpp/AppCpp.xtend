package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Application
import java.util.HashMap
import edu.vanderbilt.riaps.app.Message
import java.util.ArrayList

class AppCpp {
	public var String applicationName
	protected var portMsgTypeMap = new HashMap<String, String>
	public var compList = new ArrayList<CompCpp>
	
	new (Application app) {
		applicationName = app.name
		
		for (Message msg: app.messages) {
			portMsgTypeMap.put(msg.name, msg.type.name)
		}
		
		for (comp: app.components) {
			var compCpp = new CompCpp(comp, app.name, portMsgTypeMap)
			compList.add(compCpp)
		}
		
	}
	
	def createCMakeList() '''
		include_directories(include)
		
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
	
}
package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import java.util.HashMap
import edu.vanderbilt.riaps.app.PubPort

class PubPortCpp extends PortCppBase {
	String msgType
	
	new(Port port, String appName, HashMap<String, String> portMsgTypeMap) {
		super(port, appName)
		
		var pubPort = port as PubPort
		msgType = portMsgTypeMap.get(pubPort.type.name)
	}
	
	override String getPortType(Port port) {
		return "pub"
	}
	
	override String generateBaseH() {   
		 var content =	'''
		 				virtual bool Send«portName»(capnp::MallocMessageBuilder&    messageBuilder, messages::«msgType»::Builder& message);
		 				'''
         return content
	}
	
	
	override String generateBaseCpp() {
		var content = '''
	        bool «componentName»Base::Send«portName»(capnp::MallocMessageBuilder &messageBuilder,
	                                              messages::«msgType»::Builder &message) {
	            return SendMessageOnPort(messageBuilder, «portMacroName»);
	        }
		'''
		
		return content
	}	
}
package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.RepPort
import java.util.HashMap

class RepPortCpp extends PortCppBase{
	String reqType
	String repType
	
	new(Port port, String appName, HashMap<String, String> portMsgTypeMap) {
		super(port, appName)
		
		val reqPort = port as RepPort
		reqType = portMsgTypeMap.get(reqPort.req_type.name)
		repType = portMsgTypeMap.get(reqPort.rep_type.name)
	}
	
	override String getPortType(Port port) {
		return "rep"
	}
	
	override String generateBaseH() { 
		val content = '''
            virtual void On«portName»(const messages::«reqType»::Reader &message, riaps::ports::PortBase *port)=0;
                        
            virtual bool Send«portName»(capnp::MallocMessageBuilder& messageBuilder, messages::«repType»::Builder& message);
		'''
		return content
	}
	
	override String generateBaseCpp() {
		val content = '''
	        bool «componentName»Base::Send«portName»(capnp::MallocMessageBuilder& messageBuilder, messages::«repType»::Builder& message) {
	            return SendMessageOnPort(messageBuilder, «macroName»);
	        }
		'''
		return content
	}
	
	override String generateFW_H() {
		val content = '''
			virtual void On«portName»(const messages::«reqType»::Reader &message, riaps::ports::PortBase *port);
			'''
		return content
	}
	
	override String generateFW_Cpp() {
		val content = '''
	        void «componentName»::On«portName»(const messages::«reqType»::Reader &message,
	                                    riaps::ports::PortBase *port) {
	        }
		'''
		return content
	}
	
	override String generateBaseDispatch() {
		val content = '''
			if (portName == PORT_REP_REQUEST) {
			                auto reader = capnpreader->getRoot<messages::«reqType»>();
			                On«portName»(reader, port);
			}
		'''
		return content
	}
	
}
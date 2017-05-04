package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.ReqPort
import java.util.HashMap

@SuppressWarnings("unused", "unchecked")
class ReqPortCpp extends PortCppBase {
	String reqType
	String repType
	
	new(Port port, String compName, HashMap<String, String> portMsgTypeMap) {
		super(port, compName)
		
		val reqPort = port as ReqPort
		reqType = portMsgTypeMap.get(reqPort.req_type.name)
		repType = portMsgTypeMap.get(reqPort.rep_type.name)
	}
	
	override String getPortType(Port port) {
		return "req"
	}
	
	override String generateBaseH() {   
		val content = '''
			bool Send«portName»(capnp::MallocMessageBuilder&    messageBuilder, messages::«reqType»::Builder& message);
			bool Recv«portName»(messages::«repType»::Reader &message);
        '''
        return content                    
    }
    
    override String generateBaseCpp() {
    	val content = '''
	        bool «componentName»Base::Send«portName»(capnp::MallocMessageBuilder &messageBuilder, messages::«reqType»::Builder &message) {
	            return SendMessageOnPort(messageBuilder, «macroName»);
	        }
	
	        bool «componentName»Base::Recv«portName»(messages::«repType»::Reader &message) {
	            auto port = GetRequestPortByName(«macroName»);
	            if (port == NULL) return false;
	
	            capnp::FlatArrayMessageReader* messageReader;
	
	            if (port->Recv(&messageReader)){
	                message = messageReader->getRoot<messages::«repType»>();
	                return true;
	            }
	            return false;
	        }
    	'''
    	
    	return content
    }
            
}
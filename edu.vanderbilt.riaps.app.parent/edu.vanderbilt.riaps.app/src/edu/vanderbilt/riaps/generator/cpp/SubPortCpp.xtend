package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SubPort
import java.util.HashMap

class SubPortCpp extends PortCppBase {
	public String msgType
	
	new (Port port, String compName, HashMap<String, String> portMsgTypeMap) {
		super(port, compName)
		
		var subPort = port as SubPort
		msgType = portMsgTypeMap.get(subPort.type.name)
	}
	
	override String getPortType(Port port) {
		return "sub"
	}
	
	override String generateBaseH() {
		val content = '''
			virtual void On«portFcnName» (const messages::«msgType»::Reader &message, riaps::ports::PortBase *port)=0;
		'''
		return content
	}
	
	override String generateBaseCpp() {
		
	}
	
	override String generateBaseDispatch() {
		val content = '''            
			if (portName == «macroName») {
				messages::«msgType»::Reader «portFcnName» = capnpreader->getRoot<messages::«msgType»>();
				On«portFcnName»(«portFcnName», port);
			}'''
	    return content
	}
	
	override String generateFW_H() {
		val content = '''
			virtual void On«portFcnName»(const messages::«msgType»::Reader &message, riaps::ports::PortBase *port);
			'''      
		return content	
	}
	
	override String generateFW_Cpp() {
		val content = '''
	        void «componentName»::On«portFcnName»(const messages::«msgType»::Reader &message, riaps::ports::PortBase *port) {
	            std::cout << "«componentName»::On«portFcnName»(): " << std::endl;	
	        }
			'''      
		return content	
	}
	
}
package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.RepPort
import java.util.HashMap

class RepPortCpp extends PortCppBase{
	public String reqType
	public String repType
	
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
            virtual void On«portFcnName»(const messages::«reqType»::Reader &message, riaps::ports::PortBase *port)=0;
                        
            virtual bool Send«portFcnName»(capnp::MallocMessageBuilder& messageBuilder, messages::«repType»::Builder& message);
		'''
		return content
	}
	
	override String generateBaseCpp() {
		val content = '''
	        bool «componentName»Base::Send«portFcnName»(capnp::MallocMessageBuilder& messageBuilder, messages::«repType»::Builder& message) {
	        	std::cout<< "«componentName»Base::Send«portFcnName»()"<< std::endl;
	            return SendMessageOnPort(messageBuilder, «macroName»);
	        }
		'''
		return content
	}
	
	override String generateFW_H() {
		val content = '''
			virtual void On«portFcnName»(const messages::«reqType»::Reader &message, riaps::ports::PortBase *port);
			'''
		return content
	}
	
	override String generateFW_Cpp() {
		val content = '''
	        void «componentName»::On«portFcnName»(const messages::«reqType»::Reader &message, riaps::ports::PortBase *port) {
	        	std::cout<< "«componentName»::On«portFcnName»()"<< std::endl;
	        }
		'''
		return content
	}
	
	override String generateBaseDispatch() {
		val content = '''
			if (portName == PORT_REP_REQUEST) {
			                auto reader = capnpreader->getRoot<messages::«reqType»>();
			                On«portFcnName»(reader, port);
			}
		'''
		return content
	}
	
	override String generate_python() {
		val content = '''
		    def on_«portName»(self):
		        msg = self.«portName».recv_pyobj()
		        self.logger.info("PID (%s) - on_query():%s",str(self.pid),str(msg))
		'''		
		return content
	}
	
}
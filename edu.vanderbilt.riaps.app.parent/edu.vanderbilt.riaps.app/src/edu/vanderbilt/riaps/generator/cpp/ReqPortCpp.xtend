package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.ReqPort
import java.util.HashMap
import edu.vanderbilt.riaps.generator.CppGenerator
import edu.vanderbilt.riaps.app.FStructType

@SuppressWarnings("unused", "unchecked")
class ReqPortCpp extends PortCppBase {
	public FStructType reqType
	public FStructType repType
	public  CppGenerator gen
	
	new(Port port, String compName, HashMap<String, String> portMsgTypeMap, CppGenerator generator) {
		super(port, compName)
		gen=generator
		
		val reqPort = port as ReqPort
		reqType = (reqPort.req_type.type)
		repType = (reqPort.rep_type.type)
	}
	
	override String getPortType(Port port) {
		return "req"
	}
	
	override String generateBaseH() {   
		val content = '''
			bool Send«portFcnName»(capnp::MallocMessageBuilder&    messageBuilder, 
			«gen.StructQualifiedName(reqType,"::")»::Builder& message);
			
			bool Recv«portFcnName»(«gen.StructQualifiedName(repType,"::")»::Reader &message);
        '''
        return content                    
    }
    
    override String generateBaseCpp() {
    	val content = '''
	        bool «componentName»Base::Send«portFcnName»(capnp::MallocMessageBuilder &messageBuilder, 
	        «gen.StructQualifiedName(reqType,"::")»::Builder &message) {
	        	std::cout<< "«componentName»Base::Send«portFcnName»()"<< std::endl;
	            return SendMessageOnPort(messageBuilder, «macroName»);
	        }
	
	        bool «componentName»Base::Recv«portFcnName»(«gen.StructQualifiedName(repType,"::")»::Reader &message) {
	        	std::cout<< "«componentName»Base::Recv«portFcnName»()"<< std::endl;
	            auto port = GetRequestPortByName(«macroName»);
	            if (port == NULL) return false;
	
	            capnp::FlatArrayMessageReader* messageReader;
	
	            if (port->Recv(&messageReader)){
	                message = messageReader->getRoot<«gen.StructQualifiedName(repType,"::")»>();
	                return true;
	            }
	            return false;
	        }
    	'''
    	
    	return content
    }
    
    override String generate_python() {
    	val content = '''
    	    def on_«portName»(self):
    	        req = self.«portName».recv_pyobj()
    	        self.logger.info("PID (%s) - on_«portName»():%s",str(self.pid),str(req))
    	'''
    	return content
    }
            
}
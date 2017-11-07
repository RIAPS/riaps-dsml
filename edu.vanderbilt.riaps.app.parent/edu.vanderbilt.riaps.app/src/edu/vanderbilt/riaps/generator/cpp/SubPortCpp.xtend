package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SubPort
import java.util.HashMap
import edu.vanderbilt.riaps.datatypes.FStructType
import edu.vanderbilt.riaps.generator.CppGenerator

class SubPortCpp extends PortCppBase {
	public var FStructType msgType
	public  CppGenerator gen
	
	new (Port port, String compName, HashMap<String, String> portMsgTypeMap, CppGenerator generator ) {
		super(port, compName)
		gen=generator
		
		var subPort = port as SubPort
		msgType = subPort.type.type
	}
	
	override String getPortType(Port port) {
		return "sub"
	}
	
	override String generateBaseH() {
		val content = '''
			virtual void On«portFcnName» (const «gen.StructQualifiedName(msgType,"::")»::Reader &message, 
			riaps::ports::PortBase *port)=0;
		'''
		return content
	}
	
	override String generateBaseCpp() {
		
	}
	
	override String generateBaseDispatch() {
		val content = '''            
			if (portName == «macroName») {
				«gen.StructQualifiedName(msgType,"::")»::Reader «portFcnName» = 
					capnpreader->getRoot<«gen.StructQualifiedName(msgType,"::")»>();
				On«portFcnName»(«portFcnName», port);
			}'''
	    return content
	}
	
	override String generateFW_H() {
		val content = '''
			virtual void On«portFcnName»(const «gen.StructQualifiedName(msgType,"::")»::Reader &message, 
										 riaps::ports::PortBase *port);
			'''      
		return content	
	}
	
	override String generateFW_Cpp() {
		val content = '''
	        void «componentName»::On«portFcnName»(const «gen.StructQualifiedName(msgType,"::")»::Reader &message,
	        									  riaps::ports::PortBase *port)
	        {
	            std::cout << "«componentName»::On«portFcnName»(): " << std::endl;	
	        }
			'''      
		return content	
	}
	
	override String generate_python() {
		val content = '''
		    def on_«portName»(self):
		        msg = self.«portName».recv_pyobj()
		        self.logger.info("PID (%s) - on_«portName»():%s",str(self.pid), str(msg))
		'''
		return content
	}
	
}
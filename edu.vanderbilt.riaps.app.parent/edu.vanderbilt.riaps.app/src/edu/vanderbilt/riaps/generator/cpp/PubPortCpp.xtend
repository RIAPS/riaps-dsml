package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import java.util.HashMap
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.generator.CppGenerator
import edu.vanderbilt.riaps.datatypes.FStructType

class PubPortCpp extends PortCppBase {
	public FStructType msgType
	public CppGenerator gen
	
	new(Port port, String appName, HashMap<String, String> portMsgTypeMap, CppGenerator generator) {
		super(port, appName)
		
		var pubPort = port as PubPort
		msgType = pubPort.type.type
		gen=generator
	}
	
	override String getPortType(Port port) {
		return "pub"
	}
	
	override String generateBaseH() {   
		 var content =	'''
			virtual bool Send«portFcnName»(capnp::MallocMessageBuilder& messageBuilder, 
											«gen.StructQualifiedName(msgType,"::")»::Builder& message);
			'''
         return content
	}
	
	
	override String generateBaseCpp() {
		var content = '''
	        bool «componentName»Base::Send«portFcnName»(capnp::MallocMessageBuilder &messageBuilder, 
	        											«gen.StructQualifiedName(msgType,"::")»::Builder &message) {
	        	std::cout<< "«componentName»Base::Send«portFcnName»()"<< std::endl;
	            return SendMessageOnPort(messageBuilder, «portMacroName»);
	        }
		'''
		
		return content
	}	
}
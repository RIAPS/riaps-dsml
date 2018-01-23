package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.RepPort
import java.util.HashMap
import edu.vanderbilt.riaps.generator.CppGenerator
import edu.vanderbilt.riaps.app.FStructType

class RepPortCpp extends PortCppBase {
	public FStructType reqType
	public FStructType repType
	public CppGenerator gen

	new(Port port, String appName, HashMap<String, String> portMsgTypeMap, CppGenerator generator) {
		super(port, appName)
		gen = generator
		val repPort = port as RepPort
		reqType = (repPort.req_type.type)
		repType = (repPort.rep_type.type)
	}

	override String getPortType(Port port) {
		return "rep"
	}

	override String generateBaseH() {
		val content = '''
			virtual void On«portFcnName»(const «gen.StructQualifiedName(reqType,"::")»::Reader &message,
			 riaps::ports::PortBase *port)=0;
			            
			virtual bool Send«portFcnName»(capnp::MallocMessageBuilder& messageBuilder,
			«gen.StructQualifiedName(repType,"::")»::Builder& message);
		'''
		return content
	}

	override String generateBaseCpp() {
		val content = '''
			bool «componentName»Base::Send«portFcnName»(capnp::MallocMessageBuilder& messageBuilder,
			 «gen.StructQualifiedName(repType,"::")»::Builder& message) {
			 std::cout<< "«componentName»Base::Send«portFcnName»()"<< std::endl;
			    return SendMessageOnPort(messageBuilder, «macroName»);
			}
		'''
		return content
	}

	override String generateFW_H() {
		val content = '''
			virtual void On«portFcnName»(const «gen.StructQualifiedName(reqType,"::")»::Reader &message, riaps::ports::PortBase *port);
		'''
		return content
	}

	override String generateFW_Cpp() {
		val content = '''
			void «componentName»::On«portFcnName»(const «gen.StructQualifiedName(reqType,"::")»::Reader &message, 
			riaps::ports::PortBase *port) 
			{
				std::cout<< "«componentName»::On«portFcnName»()"<< std::endl;
			}
		'''
		return content
	}

	override String generateBaseDispatch() {
		val content = '''
			if (portName == «macroName») {
			                auto reader = capnpreader->getRoot<«gen.StructQualifiedName(reqType,"::")»>();
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

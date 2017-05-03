package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.InsPort
import edu.vanderbilt.riaps.app.TimPort

@SuppressWarnings("unused", "unchecked")
class PortCppBase {

	// timer clock 1000				(portType portName)
	// pub ready : sensorReady		(portType portName : msgType)
	protected String portType
	protected String portName
	protected String macroName
	protected String componentName
	
	new (Port port, String appName) {
		portName = port.name		
		portType = getPortType(port)
		macroName = getPortMacroName()	
		componentName = appName
	}
	
	def String getPortType(Port port) {
		if (port instanceof SrvPort) {
			return "srv"
		}
		else if (port instanceof ClntPort) {
			return "clnt"			
		}
		else if (port instanceof InsPort) {
			return "ins"
		}
		else if (port instanceof PubPort) {
			return "pub"
		}
		else if (port instanceof SubPort) {
			return "sub"
		}
		else if (port instanceof ReqPort) {
			return "req"
		}
		else if (port instanceof TimPort) {
			return "tim"
		}
	} 
	
	
	def public String getPortMacroName() {
		return "PORT_" + portType.toUpperCase + "_" + portName.toUpperCase
	}
	
	def public String generateBaseH() {
		return ""		
	}
	
	def public String generateBaseCpp() {
		return ""
	}
		
	def public String generateBaseDispatch() {
		return ""
	}
	
	def public String generateFW_H() {
		return ""
	}
	
	def public String generateFW_Cpp() {
		return ""
	}

}
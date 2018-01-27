package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Port
import edu.vanderbilt.riaps.app.TimPort

class TimerPortCpp extends PortCppBase {
	String spec

	new(Port port, String compName) {
		super(port, compName)

		val timPort = port as TimPort
		spec = timPort.spec.toString
	}

	override String getPortType(Port port) {
		return "timer"
	}

	override String generateBaseH() {
		val content = '''
			virtual void On«portFcnName»(riaps::ports::PortBase *port)=0;
		'''
		return content
	}

	override String generateBaseDispatch() {
		val content = '''
			if (portName == «macroName») {
				On«portFcnName»(port);
			}
		'''
		return content
	}

	override String generateFW_H() {
		val content = '''
			virtual void On«portFcnName»(riaps::ports::PortBase *port);
		'''
		return content
	}

	override String generateFW_Cpp() {
		val content = '''
			void «componentName»::On«portFcnName»(riaps::ports::PortBase *port) {
				std::cout << "«componentName»::On«portFcnName»(): " << port->GetPortName() << std::endl;
			}
		'''
		return content
	}

	override String generate_python() {
		val content = '''
			
			    def on_«portName»(self):
			        now = self.«portName».recv_pyobj()
			        self.logger.info('PID(%s) - on_«portName»(): %s',str(self.pid),str(now))
		'''
		return content
	}

}

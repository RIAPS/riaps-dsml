package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.Port
import java.util.HashMap
import java.util.ArrayList
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.TimPort
import edu.vanderbilt.riaps.app.RepPort
import java.util.HashSet
import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.FStructType
import edu.vanderbilt.riaps.generator.CppGenerator
import edu.vanderbilt.riaps.app.DeviceType
import java.util.List
import java.util.Set
import edu.vanderbilt.riaps.app.Library

@SuppressWarnings("unused", "unchecked")
class CompCpp {
	public String componentName
	public Component comp_
	public DeviceType device_
	protected String applicationName
	public var CppGenerator generator
	public var Set<String> libraries = new HashSet<String>
	protected var ports = new ArrayList<PortCppBase>
	public var msgIncludes = new HashSet<FStructType>
	protected var initialParams = new ArrayList<String>

	new(Component comp, String appName, HashMap<String, String> portMsgType, CppGenerator gen) {
		componentName = comp.name
		applicationName = appName
		generator = gen
		comp_=comp
		createPorts(comp, portMsgType)
		device_=null

		initialParams.add("self")
		for (ComponentFormal formal : comp.getFormals()) {
			initialParams.add(formal.name)
		}

		for (use : comp.constraint) {
			for (req : use.requirements) {
				if (req instanceof Library) {
					libraries.add(req.name.substring(3, req.name.length - 3))
				}
			}

		}
	}

	new(DeviceType comp, String appName, HashMap<String, String> portMsgType, CppGenerator gen) {
		componentName = comp.name
		comp_=null
		device_=comp
		
		applicationName = appName
		generator = gen
		createPorts(comp, portMsgType)
		for (use : comp.constraint) {
			for (req : use.requirements) {
				if (req instanceof Library) {
					libraries.add(req.name.substring(3, req.name.length - 3))
				}
			}

		}
		initialParams.add("self")
		for (ComponentFormal formal : comp.getFormals()) {
			initialParams.add(formal.name)
		}
	}

	def void createPorts(DeviceType riapsComponent, HashMap<String, String> portMsgTypeMap) {
		for (Port port : riapsComponent.getPorts()) {
			if (port instanceof PubPort) {
				var pubPort = new PubPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(pubPort)
				var aStruct = port.type.type
				msgIncludes.add(aStruct)
			} else if (port instanceof SubPort) {
				var subPort = new SubPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(subPort)
				msgIncludes.add((port as SubPort).type.type)
			} else if (port instanceof ReqPort) {
				var reqPort = new ReqPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(reqPort)
				msgIncludes.add((port as ReqPort).req_type.type)
				msgIncludes.add((port as ReqPort).rep_type.type)
			} else if (port instanceof RepPort) {
				var repPort = new RepPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(repPort)
				msgIncludes.add((port as RepPort).req_type.type)
				msgIncludes.add((port as RepPort).rep_type.type)
			} else if (port instanceof TimPort) {
				ports.add(new TimerPortCpp(port, riapsComponent.name))
			}
		}
	}

	def void createPorts(Component riapsComponent, HashMap<String, String> portMsgTypeMap) {
		for (Port port : riapsComponent.getPorts()) {
			if (port instanceof PubPort) {
				var pubPort = new PubPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(pubPort)
				var aStruct = port.type.type
				msgIncludes.add(aStruct)
			} else if (port instanceof SubPort) {
				var subPort = new SubPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(subPort)
				msgIncludes.add((port as SubPort).type.type)
			} else if (port instanceof ReqPort) {
				var reqPort = new ReqPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(reqPort)
				msgIncludes.add((port as ReqPort).req_type.type)
				msgIncludes.add((port as ReqPort).rep_type.type)
			} else if (port instanceof RepPort) {
				var repPort = new RepPortCpp(port, riapsComponent.name, portMsgTypeMap, generator)
				ports.add(repPort)
				msgIncludes.add((port as RepPort).req_type.type)
				msgIncludes.add((port as RepPort).rep_type.type)
			} else if (port instanceof TimPort) {
				ports.add(new TimerPortCpp(port, riapsComponent.name))
			}
		}
	}

	// ////////////////////////////////////////////////////////////////////////////
	// Base Gen Functions
	// ////////////////////////////////////////////////////////////////////////////
	def generateBaseH() '''
		//
		// Auto-generated by edu.vanderbilt.riaps.generator.ComponenetGenerator.xtend
		//
		
		#ifndef RIAPS_CORE_�componentName.toUpperCase�_H
		#define RIAPS_CORE_�componentName.toUpperCase�_H
		
		#include "componentmodel/r_componentbase.h"	
		�FOR include : msgIncludes�
			#include "�generator.StructQualifiedName(include)�.capnp.h"
		�ENDFOR�
		
		// Name of the ports from the model file
		�FOR PortCppBase p : ports�
			#define �p.portMacroName� "�p.portName�"
		�ENDFOR�
		
		namespace �applicationName.toLowerCase� {
		    namespace components {
		    	
		    	class �componentName�Base : public riaps::ComponentBase {
		    		
		    	public:
		    		�componentName�Base(_component_conf &config, riaps::Actor &actor);
		    		
		    		�FOR PortCppBase p : ports�
		    			�p.generateBaseH�
		    			
		    		�ENDFOR�	    		
		    		virtual ~�componentName�Base();
		    	protected:
		    		virtual void DispatchMessage(capnp::FlatArrayMessageReader* capnpreader, riaps::ports::PortBase *port,std::shared_ptr<riaps::MessageParams> params=nullptr );
		    		virtual void DispatchInsideMessage(zmsg_t* zmsg, riaps::ports::PortBase* port);
		    		  };
		    }
		}
		#endif //RIAPS_CORE_�componentName.toUpperCase�_H	
	'''

	def generateBaseCpp() '''
		//
		// Auto-generated by edu.vanderbilt.riaps.generator.ComponenetGenerator.xtend
		//
		#include <�componentName�Base.h>
		
		namespace �applicationName.toLowerCase� {
		    namespace components {
		    	
		    	�componentName�Base::�componentName�Base(_component_conf &config, riaps::Actor &actor) : ComponentBase(config, actor) {
		    	
		    	}
		    	
		    	void �componentName�Base::DispatchMessage(capnp::FlatArrayMessageReader* capnpreader, riaps::ports::PortBase *port,std::shared_ptr<riaps::MessageParams> params) {
		    		auto portName = port->GetPortName();
					�FOR PortCppBase p : ports�
						�p.generateBaseDispatch()�
						
					�ENDFOR�
					}
					
					void �componentName�Base::DispatchInsideMessage(zmsg_t* zmsg, riaps::ports::PortBase* port) {
						    		//empty the header
						    			}
					 	
					 	�FOR PortCppBase p : ports�
					 		�p.generateBaseCpp()�
					 	�ENDFOR�
					 	
					 	�componentName�Base::~�componentName�Base() {
					 	
					 	}
					 }
		}	
	'''

	// ////////////////////////////////////////////////////////////////////////////
	// FW Gen Functions
	// ////////////////////////////////////////////////////////////////////////////
	def generateFW_H() '''
		//
		// Auto-generated by edu.vanderbilt.riaps.generator.ComponenetGenerator.xtend
		//
		#ifndef RIAPS_FW_�componentName.toUpperCase�_H
		#define RIAPS_FW_�componentName.toUpperCase�_H
		
		#include "�componentName�Base.h"
		
		namespace �applicationName.toLowerCase� {
		    namespace components {
		
		        class �componentName� : public �componentName�Base {
		
		        public:
		
		            �componentName�(_component_conf &config, riaps::Actor &actor);		
		
		            �FOR p : ports�
		            	�p.generateFW_H()�
		            	
					�ENDFOR�
					void OnGroupMessage(const riaps::groups::GroupId& groupId, capnp::FlatArrayMessageReader& capnpreader, riaps::ports::PortBase* port);
					
		      virtual ~�componentName�();
		
		        };
		    }
		}
		
		extern "C" riaps::ComponentBase* create_component(_component_conf&, riaps::Actor& actor);
		extern "C" void destroy_component(riaps::ComponentBase*);
		
		
		#endif //RIAPS_FW_�componentName.toUpperCase�_H		
	'''

	def generateFW_Cpp() '''
		#include <�componentName�.h>
		
		namespace �applicationName.toLowerCase� {
		    namespace components {		
		
		        �componentName�::�componentName�(_component_conf &config, riaps::Actor &actor) :
		                �componentName�Base(config, actor) {
		        }
		
				�FOR p : ports�
					�p.generateFW_Cpp()�
					
				�ENDFOR�
				void �componentName�::OnGroupMessage(const riaps::groups::GroupId& groupId,
									 capnp::FlatArrayMessageReader& capnpreader, riaps::ports::PortBase* port){
				
				}
		
		      �componentName�::~�componentName�() {
		
		        }
		    }
		}
		
		riaps::ComponentBase *create_component(_component_conf &config, riaps::Actor &actor) {
		    auto result = new �applicationName.toLowerCase�::components::�componentName�(config, actor);
		    return result;
		}
		
		void destroy_component(riaps::ComponentBase *comp) {
		    delete comp;
		}
	'''

	def generate_python() '''
		#�componentName�.py
		from riaps.run.comp import Component
		import os
		import logging
		
		class �componentName�(Component):
		    def __init__(�FOR p : initialParams SEPARATOR ','��p��ENDFOR�):
		        super(�componentName�, self).__init__()	        
		        self.pid = os.getpid()
		        self.logger.info("(PID %s) - starting �componentName�, %s",str(self.pid),str(now))
		        
		    �FOR p : ports�
		    	�p.generate_python()�
		    �ENDFOR�    
		    
			def __destroy__(self):			
				self.logger.info("(PID %s) - stopping �componentName�, %s",str(self.pid),now)   	        	        
	'''

}

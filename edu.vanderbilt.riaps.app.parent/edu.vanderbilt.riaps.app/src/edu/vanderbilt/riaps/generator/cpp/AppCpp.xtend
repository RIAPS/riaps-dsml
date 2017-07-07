package edu.vanderbilt.riaps.generator.cpp

import edu.vanderbilt.riaps.app.Application
import java.util.HashMap
import edu.vanderbilt.riaps.app.MessageRef
import java.util.ArrayList
import java.lang.Runtime
import java.io.BufferedReader
import java.io.InputStreamReader

class AppCpp {
	public var String applicationName
	protected var portMsgTypeMap = new HashMap<String, String>
	public var compList = new ArrayList<CompCpp>
	
	new (Application app) {
		applicationName = app.name
		
		for (MessageRef msgRef: app.messages) {
			var msg = msgRef.type
			portMsgTypeMap.put(msg.name, msg.type.name)
		}
		
		for (comp: app.components) {
			var compCpp = new CompCpp(comp, app.name, portMsgTypeMap)
			compList.add(compCpp)
		}
		
	}
	
	def String createCMakeList() {
		val capnpMsgs = portMsgTypeMap.values.toSet
	
		val content = '''
		
		cmake_minimum_required(VERSION 3.0)
		
		option(arch "amd64/armhf" "amd64")
		set(CMAKE_SYSTEM_NAME Linux)
		
		set(riaps_prefix "/opt/riaps/" CACHE STRING "the riaps prefix")
		#Set the platform
		if (${arch} STREQUAL "armhf")
			set(TOOLCHAIN_PREFIX arm-linux-gnueabihf)
			set(CMAKE_C_COMPILER ${TOOLCHAIN_PREFIX}-gcc)
			set(CMAKE_CXX_COMPILER ${TOOLCHAIN_PREFIX}-g++)
			set(CMAKE_FIND_ROOT_PATH /usr/${TOOLCHAIN_PREFIX})
			set (CMAKE_CXX_FLAGS "-std=c++11")
			set (CMAKE_C_FLAGS "-std=c99")
		else()
			set(CMAKE_C_COMPILER gcc-5)
			set(CMAKE_CXX_COMPILER g++-5)
			set (CMAKE_CXX_FLAGS "-std=c++11 -D_GLIBCXX_USE_CXX11_ABI=0")
			set (CMAKE_C_FLAGS "-std=c99")
		endif()
		
		
		set(CMAKE_INSTALL_PREFIX ${riaps_prefix}/${arch})
		
		set(DEPENDENCIES ${riaps_prefix})
		set (LIBALLPATH_INCLUDE ${DEPENDENCIES}/${arch}/include)
		set (LIBALLPATH_LIB ${DEPENDENCIES}/${arch}/lib)
		include_directories(${LIBALLPATH_INCLUDE})
		link_directories(${LIBALLPATH_LIB})
		
		
		# Debug binaries are to be copied into "./bin" directory
		set(CMAKE_RUNTIME_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		set(CMAKE_LIBRARY_OUTPUT_DIRECTORY_DEBUG ${CMAKE_HOME_DIRECTORY}/bin)
		
		include_directories(include)
		
		«FOR m: capnpMsgs»
       	add_custom_command(
       			OUTPUT  include/messages/«m».capnp.c++ include/messages/«m».capnp.h
       			DEPENDS include/messages/«m».capnp
       			COMMAND capnp compile -oc++ include/messages/«m».capnp
       			VERBATIM
       	)

		«ENDFOR»
		
		«FOR c: compList»
		add_library(«c.componentName.toLowerCase» SHARED src/«c.componentName».cc
				                                  src/base/«c.componentName»Base.cc
				                                  «FOR i: c.msgIncludes»
				                                  include/messages/«i».capnp.c++
				                 				  «ENDFOR»
		)
		
		«ENDFOR»
		
		«FOR c: compList»
		target_link_libraries(«c.componentName.toLowerCase» czmq riaps dl capnp kj )
		
		«ENDFOR»
		'''
		return content
	}
	
	def createCapnp() {
		// create id
		var rt = Runtime.getRuntime();
		var pr = rt.exec("capnp id");

		var stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()))
	    var s = new String()
	    s = null
		s = stdInput.readLine()

		var msgTypes = portMsgTypeMap.values.toSet
		if (s == null) {
			var content = '''
			«FOR msgType: msgTypes»
			struct «msgType» {
				
			}
			
			«ENDFOR»
			'''
			return content
		}
		else
		{
			var content = '''
			«s»;
			
			«FOR msgType: msgTypes»
			struct «msgType» {
				
			}
			
			«ENDFOR»
			'''
			return content	
		}
	
	}
	

}
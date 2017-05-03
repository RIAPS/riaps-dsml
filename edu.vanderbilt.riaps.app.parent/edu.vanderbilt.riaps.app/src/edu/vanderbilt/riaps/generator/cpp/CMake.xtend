package edu.vanderbilt.riaps.generator.cpp

import java.util.List
import edu.vanderbilt.riaps.app.Application

public class CMake {	
	
	static def generateCMake(String appName, List<String> componentNames) '''
	include_directories(include)
	
	«FOR name: componentNames»
		add_library(«name.toLowerCase» SHARED src/«name».cc
		                                   src/base/«name»Base.cc
		                                   include/messages/«appName.toLowerCase».capnp.c++)
	«ENDFOR»

	«FOR name: componentNames»
	target_link_libraries(«name.toLowerCase» czmq riaps dl capnp kj )
	«ENDFOR»	
	'''
}
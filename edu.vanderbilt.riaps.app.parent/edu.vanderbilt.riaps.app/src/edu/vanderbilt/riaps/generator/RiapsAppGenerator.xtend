package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import java.util.logging.Logger
import java.util.logging.Level
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.MessageConsoleStream
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.app.Actor
import edu.vanderbilt.riaps.app.Component


import java.util.Map
import java.util.List
import edu.vanderbilt.riaps.app.Message
import edu.vanderbilt.riaps.app.Artifact
import edu.vanderbilt.riaps.app.DeploymentConstraint
import edu.vanderbilt.riaps.app.SrvPort
import java.util.HashSet
import edu.vanderbilt.riaps.app.SubPort
import edu.vanderbilt.riaps.app.PubPort
import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.TimPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.InsPort
import edu.vanderbilt.riaps.app.Port
import java.util.ArrayList
import edu.vanderbilt.riaps.app.AppComponent
import edu.vanderbilt.riaps.app.DeviceComponent
import edu.vanderbilt.riaps.app.NumberDefault
import edu.vanderbilt.riaps.app.Instance
import edu.vanderbilt.riaps.app.FormalDefault
import edu.vanderbilt.riaps.app.StringDefault
import java.util.HashMap
import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.Actual

class RiapsAppGenerator extends AbstractGenerator {
	
	
	//@Inject extension IQualifiedNameProvider
	private final Logger LOGGER = Logger.getLogger(typeof(RiapsAppGenerator).name);
	
	@Inject extension IQualifiedNameProvider
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {
			var messageString = e.compileToString
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".json",
				messageString
			)
			
			/*
			var builder = new GsonBuilder;
        	var gson = builder.create();
			var formattedString = gson.toJson(messageString) 
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".json",
				formattedString
			)*/
			Console.instance.log(java.util.logging.Level.INFO,e.fullyQualifiedName.toString("/") + ".json generated");
		}	

	}
	
	def compileToString(Application message) '''
	«var apps = new ArrayList<String>»
	«var devices = new ArrayList<String>»
	«FOR j : message.components»		
		«addComponentString(apps, devices, j)»
	«ENDFOR»
	{
	"«message.name»": {	
	"name": "«message.name»",
	"devices" : {
		«FOR i: devices SEPARATOR ","»
			«i»
		«ENDFOR»
	},
	
	"components" : {
		«FOR i: apps SEPARATOR ","»
			«i»
		«ENDFOR»
	},
	"actors" : {
	«FOR j : message.actors SEPARATOR ","»
		«j.compileToString»
	«ENDFOR»
	},
	"messages" : [
	«FOR j : message.messages SEPARATOR ","»
		«j.compileToString»
	«ENDFOR»
	]
	}
	}
	'''
	
	def isAppComponent(Component component) {
		if (component instanceof AppComponent)
			return true
		else
			return false		
	}

	def addComponentString(ArrayList<String> appList, ArrayList<String> deviceList, Component component)
	{
		var strData = component.compileToString.toString()
		if (component instanceof AppComponent)
			appList.add(strData)
		else
			deviceList.add(strData)
		return;
	}	
	
	def compileToString(Actor message) '''
		«var internalList = new ArrayList<String>»
		«var localList = new ArrayList<String>»
		«var criticalList = new ArrayList<String>»
		«var formalList = new ArrayList<String>»
		«var wireList = new ArrayList<String>»
		«var instanceList = new ArrayList<String>»


		«compileToString(message, 
			internalList, 
			localList,
			criticalList,
			formalList,
			wireList,
			instanceList)»
			
		"«message.name»": {
		"internals":[
		«FOR i: internalList SEPARATOR ","»
		«i»
		«ENDFOR»
		],
		
		"locals":[
		«FOR i: localList SEPARATOR ","»
		«i»
		«ENDFOR»
		],
		
		"formals":[
		«FOR i: formalList SEPARATOR ","»
		«i»
		«ENDFOR»
		],
		
		"wires":[
		«FOR i: wireList SEPARATOR ","»
		«i»
		«ENDFOR»
		],
		
		"instances": {
		«FOR i: instanceList SEPARATOR ","»
		«i»
		«ENDFOR»
		}
		}
	'''
	
	def compileToString(Actor actor, 
		ArrayList<String> internalList, 
		ArrayList<String> localList, 
		ArrayList<String> criticalList, 
		ArrayList<String> formalList, 
		ArrayList<String> wireList, 
		ArrayList<String> instanceList) {
		
		if (actor.locals != null) {
			for(k: actor.locals) {			
				var dataStr = "{\"type\":\"" + k.name + "\"}"
				localList.add(dataStr)				
			}
		}

		if (actor.internals != null) {
			for (k: actor.internals) {
				var dataStr = "{\"type\":\"" + k.name + "\"}"
				internalList.add(dataStr)
			}
		}

		if (actor.criticals != null) {
			for (k: actor.criticals) {
				var dataStr = "{\"type\":\"" + k.name + "\"}"
				criticalList.add(dataStr)
			}
		}

		if (actor.formals != null) {
			for (k: actor.formals) {
				var dataStr = "{"
				if (k.argDefault != null) {
					dataStr = dataStr.concat(k.argDefault.compileToString.toString())
					dataStr = dataStr.concat(",")
				}
				dataStr = dataStr.concat("\"name\": \"" + k.name + "\"")
				dataStr = dataStr.concat("}")
				formalList.add(dataStr)
			}
		}

		if (actor.compsection != null) {
			var instances = actor.compsection.instances
			if (instances != null) {
				for (i: instances) {
					instanceList.add(i.compileToString.toString())
				}
			}	
		}

		if (actor.wires != null) {
			for (k: actor.wires)
			{
			}

		}
		return;
	}
	
	def compileToString(FormalDefault formal) '''		 
		«IF formal instanceof StringDefault»
		"default":"«formal.value»"
		«ELSE»
		"default":«formal.value»
		«ENDIF»
	'''
	
	def compileToString(Instance instance) '''
		«var strData = new ArrayList<String>»
		«FOR i: instance.actuals»
		«var temp = strData.add(i.compileToString)»
		«ENDFOR»
		"«instance.name»": {
		"actuals": [

		«FOR i: strData SEPARATOR ","»
		{
			«i»	
		}
		«ENDFOR»

		],
		"type":"«instance.type.name»"
		}
	'''
	
	def compileToString(Actual actual) {
		
	var name = '''"name":"«actual.argName.name»",'''
	if (actual.argValue != null)
		name = name + '''"param":"«actual.argValue.name»"'''
	else {
		if (actual.tringdefault != null)
			name = name + '''"value":"«actual.tringdefault.value»"'''
		else if (actual.numberdefault != null)
			name = name + '''"value":«actual.numberdefault.value»'''
		else if (actual.boolDefault != null)
			name = name + '''"value":«actual.boolDefault.value»'''			
		}
		
		return name
	}

	def compileToString(Component component) '''
		«var formalList = new ArrayList<String>»
		«FOR j: component.formals»
			«compileToString(j, formalList)»
		«ENDFOR»
		"«component.name»": {
			"formals": [
			«FOR i: formalList SEPARATOR ","»
			«i»
			«ENDFOR»
			],
				
			«FOR j: component.requirements»
			«ENDFOR»
			"name" : "«component.name»",
			"ports": {
			«var portString = component.ports.compileToString»
			«portString»
			}

		}

	'''

	
	
		def compileToString(List<Port> ports) 		'''
		«var srvs = new ArrayList<String>»
		«var pubs = new ArrayList<String>»
		«var inss = new ArrayList<String>»
		«var tims = new ArrayList<String>»
		«var subs = new ArrayList<String>»
		«var clnts = new ArrayList<String>»
		«var reqs = new ArrayList<String>»
		«FOR j: ports»
			«compileToString(j, srvs, pubs, inss, tims, subs, clnts, reqs)»
		«ENDFOR»	
		"clts": {
		«FOR i: clnts SEPARATOR ','»
		«i»
		«ENDFOR»
		},		
		"inss": {
		«FOR i: inss SEPARATOR ','»
		«i»
		«ENDFOR»
		},	
		"reqs":{
		«FOR i: reqs SEPARATOR ','»
		«i»
		«ENDFOR»
		},
		"pubs": {
		«FOR i: pubs SEPARATOR ','»
		«i»
		«ENDFOR»
		},
		"tims": {
		«FOR i: tims SEPARATOR ','»
		«i»
		«ENDFOR»
		},
		"srvs": {
		«FOR i: srvs SEPARATOR ','»
			«i»
		«ENDFOR»
		},		
		"subs": {
		«FOR i: subs SEPARATOR ','»
		«i»
		«ENDFOR»
		}

	'''
	
	def compileToString(Port port,
		ArrayList<String> srvs,
		ArrayList<String> pubs,
		ArrayList<String> inss,
		ArrayList<String> tims,
		ArrayList<String> subs,
		ArrayList<String> clnts,
		ArrayList<String> reqs) {
		
		if (port instanceof SrvPort) {			
				var srvPort = port as SrvPort
				var portString = "\"" + srvPort.name + "\": {" + "\"req_type\": \"" + srvPort.req_type.name + "\"," + "\"rep_type\": \"" + srvPort.rep_type.name + "\"}"
				srvs.add(portString)							
		}
		else if (port instanceof ClntPort) {
			var clntPort = port as ClntPort
			var portString = "\"" + clntPort.name + "\": {\"req_type\": \"" + clntPort.req_type.name + "\",\"rep_type\": \"" + clntPort.rep_type.name + "\"}"
			clnts.add(portString)
		}
		else if (port instanceof ReqPort) {
			var reqPort = port as ReqPort
			var portString = "\"" + reqPort.name + "\": {\"req_type\": \"" + reqPort.req_type.name + "\",\"rep_type\": \"" + reqPort.rep_type.name + "\"}"
			reqs.add(portString)				
		}
		else if (port instanceof SubPort) {
			var subPort = port as SubPort
			var portString = "\"" + subPort.name + "\": {\"type\": \""+ subPort.type.name + "\" }"
			subs.add(portString)				
		}
		else if (port instanceof PubPort) {
			var pubPort = port as PubPort
			var portString = "\"" + pubPort.name + "\": {\"type\": \""+ pubPort.type.name + "\" }"
			pubs.add(portString)				
		}
		else if (port instanceof InsPort) {
			var insPort = port as InsPort
			var portString = "\"" + insPort.name + "\": {\"spec\": \""
			if (insPort.spec)
				portString = portString + "true"
			else
				portString = portString + "false"
			portString = portString + "\" }"
			inss.add(portString)	
		}
		else if (port instanceof TimPort) {
			var timPort = port as TimPort
			if (timPort.spec != null) {			
				var portString = "\"" + timPort.name + "\": {\"period\":" + timPort.spec + "}"
				tims.add(portString)
			}
		}
		
		return		
	}
	
	def compileToString(ComponentFormal formal,
		ArrayList<String> formalList) {
		var dataStr = "{"
		var arg = formal.argDefault
		if (arg != null) {
			dataStr = dataStr + arg.compileToString.toString() + ","
		}
		dataStr = dataStr + "\"name\" : \"" + formal.name + "\"}"
		formalList.add(dataStr)
		
		return		
	}
	
	def compileToString(Message message) '''
	{
		"name":"«message.name»"
	}
	'''
	
	def compileToString(Artifact message) '''
	'''
	
	def compileToString(DeploymentConstraint message)'''
	'''
	
	// Questions:
	// Artifact, DeploymentConstraint
	// Actor:Wires - new grammar different than the existing grammar see sample.riaps file
	// OpalIO has a "libraries" keyword, what's the equivalent in the new grammar?
	//    "libraries":[
   	//   {
   	//     "name":"pypmu"
   	//   }
   	// ],
   	// repPort is missing in new grammar
	
}

package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.app.Application

import edu.vanderbilt.riaps.generator.json.App
import com.google.gson.GsonBuilder;
import java.util.Map
import java.util.HashMap

public class RiapsAppGenerator extends AbstractGenerator {
	
	@Inject extension IQualifiedNameProvider
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {
			var gson = new GsonBuilder().setPrettyPrinting().create();
			var app = new App(e);
			var Map<String, App> container = new HashMap<String, App>();
			container.put(app.getName(), app);
			var formattedString = gson.toJson(container);
			fsa.generateFile(
				e.fullyQualifiedName.toString("/") + ".json",
				formattedString
			)
			Console.instance.log(java.util.logging.Level.INFO, e.fullyQualifiedName.toString("/") + ".json generated");
		}

	}
	
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
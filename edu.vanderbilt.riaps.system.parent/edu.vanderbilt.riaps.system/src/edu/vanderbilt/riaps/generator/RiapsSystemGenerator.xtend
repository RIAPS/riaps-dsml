package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

import com.google.gson.GsonBuilder

import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.system.AppDeployment
import edu.vanderbilt.riaps.generator.json.ActorDepl
import java.util.ArrayList
import edu.vanderbilt.riaps.system.ActorDeployment
import java.io.File
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider

class RiapsSystemGenerator extends AbstractGenerator{

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		var ArrayList<ActorDepl> container = new ArrayList<ActorDepl>();
		
		var File file = new File(resource.URI.toString);
		var String fileName = file.getName().replaceFirst("[.][^.]+$", "") + ".json";
		for (e : resource.allContents.toIterable.filter(AppDeployment)) {
			for (ActorDeployment ad: e.actorDeployments ){
				var ActorDepl actorDepl = new ActorDepl(ad);
				container.add(actorDepl);
			}
		}

		var formattedString = gson.toJson(container);
		fsa.generateFile('/deployments/'+fileName, RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_JSON, formattedString);
		Console.getInstance().log(java.util.logging.Level.INFO, fileName + " generated");
	}
}
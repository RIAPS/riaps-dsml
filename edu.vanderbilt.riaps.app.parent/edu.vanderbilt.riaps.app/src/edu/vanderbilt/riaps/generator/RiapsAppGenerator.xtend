package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IFileSystemAccessExtension2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.app.Application

import edu.vanderbilt.riaps.generator.json.App
import com.google.gson.GsonBuilder;
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider

public class RiapsAppGenerator extends AbstractGenerator {

	
	@Inject extension IQualifiedNameProvider
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Application)) {
			var gson = new GsonBuilder().setPrettyPrinting().create();
			var app = new App(e);
			var formattedString = gson.toJson(app);
			fsa.generateFile(
				e.name + "_app.json", RiapsOutputConfigurationProvider.DEFAULT_OUTPUT_JSON_APP,
				formattedString
			)
			Console.instance.log(java.util.logging.Level.INFO, e.fullyQualifiedName.toString("/") + 
			".json generated");
		}

	}
	
	
}

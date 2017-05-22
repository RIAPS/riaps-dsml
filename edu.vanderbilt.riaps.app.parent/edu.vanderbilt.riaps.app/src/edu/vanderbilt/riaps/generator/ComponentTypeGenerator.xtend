package edu.vanderbilt.riaps.generator;

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.app.Component

import edu.vanderbilt.riaps.generator.chariot.CompType
import com.google.gson.GsonBuilder;

public class ComponentTypeGenerator extends AbstractGenerator {

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		var formattedString = "";
		
		for (c : resource.allContents.toIterable.filter(Component)) {
			var compType = new CompType(c);
			formattedString += gson.toJson(compType);
		}
		fsa.generateFile(
			"ComponentTypes.json",
			formattedString
		)
		Console.instance.log(java.util.logging.Level.INFO, "ComponentTypes.json generated");

	}
}
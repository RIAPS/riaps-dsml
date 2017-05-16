package edu.vanderbilt.riaps.generator;

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.app.Component

import edu.vanderbilt.riaps.generator.chariot.CompType
import com.google.gson.GsonBuilder;
import java.util.List
import java.util.ArrayList

public class ComponentTypeGenerator extends AbstractGenerator {

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		var List<CompType> container = new ArrayList<CompType>();
		
		for (c : resource.allContents.toIterable.filter(Component)) {
			var compType = new CompType(c);
			container.add(compType);
		}
		var formattedString = gson.toJson(container);
		fsa.generateFile(
			"ComponentTypes.json",
			formattedString
		)
		Console.instance.log(java.util.logging.Level.INFO, "ComponentTypes.json generated");

	}
}
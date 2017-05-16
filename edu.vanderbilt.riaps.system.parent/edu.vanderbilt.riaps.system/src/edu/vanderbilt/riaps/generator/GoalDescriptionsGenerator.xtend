package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.system.AppDeployment

import edu.vanderbilt.riaps.generator.chariot.GoalDescription
import com.google.gson.GsonBuilder;
import java.util.List
import java.util.ArrayList


class GoalDescriptionsGenerator extends AbstractGenerator  {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		var List<GoalDescription> container = new ArrayList<GoalDescription>();
		
		for (e : resource.allContents.toIterable.filter(AppDeployment)) {
			var GoalDescription gd = new GoalDescription(e);
			container.add(gd);
		}
		
		var formattedString = gson.toJson(container);
		fsa.generateFile(
			"GoalDescriptions.json",
			formattedString
		)
		Console.instance.log(java.util.logging.Level.INFO, "GoalDescriptions.json generated");

	}
}
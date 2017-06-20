package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.system.NodeType

import edu.vanderbilt.riaps.generator.chariot.NodeCategory
import com.google.gson.GsonBuilder;


class NodeCategoryGenerator extends AbstractGenerator  {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		
		var formattedString = "";
		for (nt : resource.allContents.toIterable.filter(NodeType)){
			var NodeCategory nc = new NodeCategory(nt);
			formattedString += gson.toJson(nc);
		}
		fsa.generateFile(
			"NodeCategories.json",
			formattedString
		)
		Console.instance.log(java.util.logging.Level.INFO, "NodeCategories.json generated");

	}
}
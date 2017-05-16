package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.system.NodeType
import edu.vanderbilt.riaps.system.KnownNodes

import edu.vanderbilt.riaps.generator.chariot.NodeCategory
import com.google.gson.GsonBuilder;
import java.util.List
import java.util.ArrayList


class NodeCategoryGenerator extends AbstractGenerator  {
	
	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		var gson = new GsonBuilder().setPrettyPrinting().create();
		var List<NodeCategory> container = new ArrayList<NodeCategory>();
		
		var NodeCategory nc = new NodeCategory(
			"EdgeNode",
			resource.allContents.toIterable.filter(NodeType),
			resource.allContents.toIterable.filter(KnownNodes));
		container.add(nc);
		var formattedString = gson.toJson(container);
		fsa.generateFile(
			"NodeCategories.json",
			formattedString
		)
		Console.instance.log(java.util.logging.Level.INFO, "NodeCategories.json generated");

	}
}
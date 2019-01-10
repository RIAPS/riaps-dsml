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
import java.io.IOException
import java.io.BufferedReader
import java.io.InputStreamReader
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path
import java.io.File

public class RiapsAppGenerator extends AbstractGenerator {

	@Inject extension IQualifiedNameProvider

	override doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {	
					
		for (e : resource.allContents.toIterable.filter(Application)) {
			var gson = new GsonBuilder().setPrettyPrinting().create();
			var app = new App(e);
			var formattedString = gson.toJson(app);
			fsa.generateFile(
				e.name + ".json",				
				formattedString
			)
			 
			runRiapsGen(e.name + ".json",resource)
			Console.instance.log(java.util.logging.Level.INFO, e.fullyQualifiedName.toString("/") + ".json generated.");
		}

	}
	def runRiapsGen(String string, Resource resource) {
		var execution_string = "riaps_gen -m " + string
		Console.instance.log(java.util.logging.Level.SEVERE, "Trying command ...." + execution_string);
		try {
			var ProcessBuilder proc = new ProcessBuilder("riaps_gen","-m",string,"-o",".");
			proc.directory(new File(resource.dir));
			proc.redirectErrorStream(true);
			var pr = proc.start
			var stdInput = new BufferedReader(new InputStreamReader(pr.getInputStream()))
			var String line
			while ((line = stdInput.readLine()) !== null) {
				Console.instance.log(java.util.logging.Level.SEVERE, line);
			}
			pr.waitFor 

		} catch (IOException e) {
			Console.instance.log(java.util.logging.Level.SEVERE, "error running command " + execution_string);
		}

	}
	
	def getPath(Resource resource) {
		var String libraryFile = ""
		val theRelativeFile = resource.URI.trimFileExtension.appendFileExtension('riaps')
		if (resource.URI.isPlatform) {
			libraryFile = ResourcesPlugin.workspace.root.getFile(new Path(theRelativeFile.toPlatformString(true))).
				rawLocation.toOSString
		} else {
			libraryFile = resource.resourceSet.URIConverter.normalize(theRelativeFile).toFileString
		}
		return libraryFile
	}
	
	def getDir(Resource resource) {
		var java.nio.file.Path p = java.nio.file.Paths.get(resource.path);
		var java.nio.file.Path parent1 = p.getParent();
		return parent1.toString		
	}

}

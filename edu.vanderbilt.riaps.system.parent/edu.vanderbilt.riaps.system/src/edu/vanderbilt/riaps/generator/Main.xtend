/*
 * generated by Xtext 2.13.0
 */
package edu.vanderbilt.riaps.generator

import com.google.inject.Inject
import com.google.inject.Provider
import edu.vanderbilt.riaps.SystemStandaloneSetup
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.generator.GeneratorDelegate
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.validation.CheckMode
import org.eclipse.xtext.validation.IResourceValidator
import edu.vanderbilt.riaps.AppStandaloneSetup
import edu.vanderbilt.riaps.DatatypesStandaloneSetup
import java.util.HashSet
import org.eclipse.emf.ecore.resource.Resource


class Main {

	def static main(String[] args) {
		if (args.empty) {
			System::err.println('Aborting: no path to EMF resource provided!')
			return
		}
		val cons= edu.vanderbilt.riaps.Console.getHeadlessInstance()
		//cons.log(java.util.logging.Level.INFO, "starting the interpreter")
		val injector = new SystemStandaloneSetup().createInjectorAndDoEMFRegistration
		val injectorApp = new AppStandaloneSetup().createInjectorAndDoEMFRegistration()
		val injectorData = new DatatypesStandaloneSetup().createInjectorAndDoEMFRegistration()
		val main = injector.getInstance(Main)
		val generatorApp = injectorApp.getInstance(AppGenerator);
		val generatorData = injectorData.getInstance(DatatypesGenerator);
		main.runGenerator(args,generatorApp,generatorData)
	}

	@Inject Provider<ResourceSet> resourceSetProvider
	@Inject IResourceValidator validator
	@Inject GeneratorDelegate generator
	@Inject StandAloneFileSystemAccess fileAccess

	def protected runGenerator(String [] strings, AppGenerator appgenerator, DatatypesGenerator generatorData)  {
		// Load the resource
		val set = resourceSetProvider.get
		var rX = new HashSet<Resource>()
		for (x : strings) {
			val resource2 = set.getResource(URI.createFileURI(x), true)
			rX.add(resource2)
		}

		var noIssues = true
		// Validate the resource
		for (resource : rX) {
			val issues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl)
			if (!issues.empty) {
				issues.forEach[System.err.println(it)]
				noIssues = false
			// return
			}
		}

		if (!noIssues) {
			return
		}
		
	

		// Configure and start the generator
		fileAccess.outputPath = '.'
		val context = new GeneratorContext => [
			cancelIndicator = CancelIndicator.NullImpl
		]
		for (resource : rX) {
			generator.generate(resource, fileAccess, context)
			appgenerator.doGenerate(resource, fileAccess, context)
			generatorData.doGenerate(resource, fileAccess, context)
		}
		System.out.println('Code generation finished.')
	}
}

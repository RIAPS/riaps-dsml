/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import com.google.inject.Inject
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider
import edu.vanderbilt.riaps.app.Model
import edu.vanderbilt.riaps.app.FStructType
import edu.vanderbilt.riaps.app.TimeUnit
import edu.vanderbilt.riaps.app.RateUnit
import edu.vanderbilt.riaps.app.BurstUnit

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AppGenerator extends AbstractGenerator {

	@Inject RiapsAppGenerator g1
	// @Inject ComponentTypeGenerator g2
	@Inject CppGenerator g3
	@Inject CapnProtoGenerator g4

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		//g1.doGenerate(resource, fsa, context);
		//g3.doGenerate(resource, fsa, context);
		//g4.doGenerate(resource, fsa, context);

		//for (e : resource.allContents.toIterable.filter(Model)) {
		//	if(e.collections.filter(FStructType).size() == 0) return
		//}

	}

	def static int convert(int i, TimeUnit unit) {

		if (unit === null || unit.millisecond) {
			return i;
		} else if (unit.minute) {
			return (i * 60 * 1000);
		} else if (unit.second) {
			return (i * 1000);
		} 
		//else if (unit.microsecond) {
			//return (i / 1000)

		//} 
		else
			return 0
	}

	def static int convert(String i, RateUnit rateUnit) {
		if (i===null) return 0
		
		var float rate = Float.parseFloat((i))

		if (rateUnit === null || rateUnit.kbps) {
			return ((rate * 1024) as int)

		} else {
			return ((rate * 1024 * 1024) as int);
		}

	}
	def static int convert(String i, BurstUnit rateUnit) {
		if (i===null) return 0
		
		var float rate = Float.parseFloat((i))

		if (rateUnit === null || rateUnit.kilo) {
			return ((rate * 1024) as int)

		} else {
			return ((rate * 1024 ) as int);
		}

	}

}

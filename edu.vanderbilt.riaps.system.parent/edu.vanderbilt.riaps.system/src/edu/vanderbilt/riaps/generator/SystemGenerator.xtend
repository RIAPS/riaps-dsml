/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import com.google.inject.Inject
/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class SystemGenerator extends AbstractGenerator {

	@Inject RiapsSystemGenerator g1
	//@Inject NodeCategoryGenerator g2
	//@Inject GoalDescriptionsGenerator g3
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		g1.doGenerate(resource, fsa, context);
	//	g2.doGenerate(resource, fsa, context);
	//	g3.doGenerate(resource, fsa, context);
	}
}

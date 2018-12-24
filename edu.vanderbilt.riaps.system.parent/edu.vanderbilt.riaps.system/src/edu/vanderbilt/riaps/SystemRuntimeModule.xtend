/*
 * generated by Xtext 2.16.0
 */
package edu.vanderbilt.riaps

import com.google.inject.Binder
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import com.google.inject.Singleton
/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
class SystemRuntimeModule extends AbstractSystemRuntimeModule {
	override configure(Binder binder) {
		super.configure(binder);
		binder.bind(typeof(IOutputConfigurationProvider)).to(typeof(RiapsOutputConfigurationProvider)).in(typeof(Singleton));
	} 
}

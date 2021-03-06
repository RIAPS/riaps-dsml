/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.ui

import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import com.google.inject.Binder;
import org.eclipse.xtext.generator.IOutputConfigurationProvider
import com.google.inject.Singleton
import edu.vanderbilt.riaps.RiapsOutputConfigurationProvider

/**
 * Use this class to register components to be used within the Eclipse IDE.
 */
@FinalFieldsConstructor
class AppUiModule extends AbstractAppUiModule {
 
	override configure(Binder binder) {
		super.configure(binder);
		binder.bind(typeof(IOutputConfigurationProvider)).to(typeof(RiapsOutputConfigurationProvider)).in(typeof(Singleton));
	}
}

/*
 * generated by Xtext 2.16.0
 */
package edu.vanderbilt.riaps


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class AppStandaloneSetup extends AppStandaloneSetupGenerated {

	def static void doSetup() {
		new AppStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}

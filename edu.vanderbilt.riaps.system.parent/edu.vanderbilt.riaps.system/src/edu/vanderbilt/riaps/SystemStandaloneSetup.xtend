/*
 * generated by Xtext 2.16.0
 */
package edu.vanderbilt.riaps


/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class SystemStandaloneSetup extends SystemStandaloneSetupGenerated {

	def static void doSetup() {
		new SystemStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
}

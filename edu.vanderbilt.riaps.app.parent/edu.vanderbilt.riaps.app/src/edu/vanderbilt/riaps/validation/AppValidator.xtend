/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.validation

import org.eclipse.xtext.validation.Check
import edu.vanderbilt.riaps.app.AppPackage
import edu.vanderbilt.riaps.app.Group
import edu.vanderbilt.riaps.app.Leader
import edu.vanderbilt.riaps.app.Consensus
import java.util.HashSet
import edu.vanderbilt.riaps.app.GMessageBlock
import edu.vanderbilt.riaps.app.UsesBlock
import edu.vanderbilt.riaps.app.Component
import edu.vanderbilt.riaps.app.Actor
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.app.DeviceType
import edu.vanderbilt.riaps.app.Library
import edu.vanderbilt.riaps.app.Configuration
import org.eclipse.core.runtime.Path
import edu.vanderbilt.riaps.app.FStructType
import edu.vanderbilt.riaps.app.Message
import edu.vanderbilt.riaps.app.FEnumerationType
import edu.vanderbilt.riaps.app.FEnumerator
import edu.vanderbilt.riaps.app.Model
import edu.vanderbilt.riaps.app.FField

/**
 * This class contains custom validation rules. 
 *  
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class AppValidator extends AbstractAppValidator {

	public static val INVALID_NAME = 'invalidName'

	@Check
	def checkFStructTypeStartsWithCapital(FStructType message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}

	}

	@Check
	def checkDeviceTypeNoReuseWithinApp(DeviceType dev) {
		if (dev.eContainer instanceof Application) {
			if (dev.reuselib !== null) {
				error('A device within an application cannot be imported from a library',
					AppPackage.Literals.COLLECTION__NAME)
			}
		}
	}
	
	
	@Check
	def checkComponentTypeNoReuseWithinApp(Component dev) {
		if (dev.eContainer instanceof Application) {
			if (dev.getReuselib() !== null) {
				error('A device within an application cannot be imported from a library',
					AppPackage.Literals.COLLECTION__NAME)
			}
		}
	}
	

	@Check
	def checkFStructNameDoesNotContainUnderscore(FStructType message) {
		if (message.name.contains('_')) {
			error('Name cannot contain underscore', AppPackage.Literals.COLLECTION__NAME)
		}

	}

	@Check
	def checkEnumNameDoesNotContainUnderscore(FEnumerationType message) {
		if (message.name.contains('_')) {
			error('Name cannot contain underscore', AppPackage.Literals.COLLECTION__NAME)
		}

	}

	@Check
	def checkEnumStartsWithCapital(FEnumerationType message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}

	}

	@Check
	def checkEnumStartsWithCapital(FEnumerator message) {
		if (!Character.isLowerCase(message.name.charAt(0))) {
			error('Name should start with a lower case letter', AppPackage.Literals.FENUMERATOR__NAME)
		}

	}
	
	@Check
	def checkElementStartsWithCapital(FField message) {
		if (!Character.isLowerCase(message.name.charAt(0))) {
			error('Name should start with a lower case letter', AppPackage.Literals.FFIELD__NAME)
		}

	}
	
		
	
	

	@Check
	def checkMessageDeclarationStartsWithCapital(Message message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkMessageTypeNull(Message message) {

		if (message.type === null) {
			warning('Only python applications can use this message type. c++ applications cannot.',
				AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkGroupProperties(UsesBlock group) {
		var leaders = group.property.filter(Leader)

		if (leaders.size() > 1) {
			error('duplicate leader definition found', null)
		}
	}

	@Check
	def checkGroupPropertiesConsensus(UsesBlock group) {

		var consensus = group.property.filter(Consensus)
		if (consensus.size() > 1) {
			error('duplicate consensus definition found', null)
		}
	}

	@Check
	def checkAppNameStartsWithCapital(Application message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkModelOnlyConstainsOneApp(Application app) {
		var model = (app.eContainer as Model)
		var apps = model.collections.filter(Application)

		if (apps.size() > 1) {
			error('One model should only contain one application', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkAppNameNotKeyword(Application app) {
		if (app.name.toLowerCase == edu.vanderbilt.riaps.generator.cpp.AppCpp.defaultName) {
			error('Name cannot be ' + app.name, AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkDeviceTypeStartsWithCapital(DeviceType message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	// Message not referenced
	@Check
	def checkLibraryName(Library lib) {
		if (!lib.name.startsWith("lib")) {
			error('library name must start with lib', AppPackage.Literals.LIBRARY__NAME)
		}
	}

	// Message not referenced
	@Check
	def checkConfigurationName(Configuration f) {
		if (!Path.isValidPosixPath(f.name)) {
			error('not a valid path', AppPackage.Literals.CONFIGURATION__NAME)
		}
	}

	@Check
	def checkComponentNameStartsWithCapital(Component message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkActorNameStartsWithCapital(Actor message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', AppPackage.Literals.ACTOR__NAME)
		}
	}

	@Check
	def checkGroupUsesBlock(Group group) {
		var messageblock = group.useclauses
		if (messageblock.size() > 1) {
			error('only one message block is allowed in a group', AppPackage.Literals.GROUP__NAME)
		}
	}

	@Check
	def checkComponentUsesBlock(Component component) {
		var block = component.constraint

		if (block.size() > 1) {
			error('only one uses block is allowed in a component', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkDeviceTypeUsesBlock(DeviceType component) {
		var block = component.constraint

		if (block.size() > 1) {
			error('only one uses block is allowed in a Device', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkComponentHandler(Component component) {
		var block = component.handler

		if (block.size() > 1) {
			error('only one exceptionHandler is allowed in a component', AppPackage.Literals.COLLECTION__NAME)
		}
	}

	@Check
	def checkGroupMessageBlock(Group group) {
		var messageblock = group.gmessageblock
		if (messageblock.size() > 1) {
			error('only one message block is allowed in a group', AppPackage.Literals.GROUP__NAME)
		}
	}

	@Check
	def checkGroupConsensusMessageUnique(GMessageBlock group) {
		var consensusMessage = group.consensusMessages
		var consensusMessageunique = new HashSet<Message>()
		for (Message x : consensusMessage) {
			if (!consensusMessageunique.add(x)) {
				error('duplicate entry ' + x.name + ' found in consensus Messages', null)
			}
		}
	}

	@Check
	def checkGroupGroupMessageUnique(GMessageBlock group) {
		var consensusMessage = group.groupMessages
		var consensusMessageunique = new HashSet<Message>()
		for (Message x : consensusMessage) {
			if (!consensusMessageunique.add(x)) {
				error('duplicate entry ' + x.name + ' found in group Messages', null)
			}
		}
	}
}

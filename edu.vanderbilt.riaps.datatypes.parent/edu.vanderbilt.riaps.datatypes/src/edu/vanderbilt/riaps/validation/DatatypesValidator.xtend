/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.validation

import edu.vanderbilt.riaps.datatypes.DatatypesPackage
import edu.vanderbilt.riaps.datatypes.FStructType
import org.eclipse.xtext.validation.Check

import org.eclipse.core.runtime.Path
import edu.vanderbilt.riaps.datatypes.Message


/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class DatatypesValidator extends AbstractDatatypesValidator {

	public static val INVALID_NAME = 'invalidName'

	@Check
	def checkFStructTypeStartsWithCapital(FStructType message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', DatatypesPackage.Literals.MODEL_COLLECTION__NAME)
		}

	}
	
	@Check
	def checkMessageDeclarationStartsWithCapital(Message message) {
		if (!Character.isUpperCase(message.name.charAt(0))) {
			error('Name should start with a capital', DatatypesPackage.Literals.MODEL_COLLECTION__NAME)
		}
	}
	


}
 
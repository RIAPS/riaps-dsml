/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.validation;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;

public abstract class AbstractAppValidator extends AbstractDeclarativeValidator {
	
	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(edu.vanderbilt.riaps.app.AppPackage.eINSTANCE);
		return result;
	}
	
}

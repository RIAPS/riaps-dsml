package edu.vanderbilt.riaps.ui

import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.jface.wizard.Wizard
import org.eclipse.ui.INewWizard
import org.eclipse.ui.IWorkbench
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage
import java.net.URI

class RIAPSPyApp extends Wizard implements INewWizard {
	private WizardNewProjectCreationPage _pageOne

	new() { // TODO Auto-generated constructor stub
		windowTitle = "New RIAPS Python Application"
	}

	override void init(IWorkbench workbench, IStructuredSelection selection) { // TODO Auto-generated method stub
	}

	override boolean performFinish() {
		// TODO Auto-generated method stub
		var name = _pageOne.getProjectName();
		var URI location = null;
		if (!_pageOne.useDefaults()) {
			location = _pageOne.getLocationURI();
		} // else location == null
		RIAPSAppSupport.createProject(name, location, RiapsAPPType.PYAPP);
		return true
	}

	override void addPages() {
		super.addPages();

		_pageOne = new WizardNewProjectCreationPage("New RIAPS Python APP Wizard");
		_pageOne.setTitle("New RIAPS Python APP");
		_pageOne.setDescription("Create RIAPS Python APP.");

		addPage(_pageOne);
	}
}

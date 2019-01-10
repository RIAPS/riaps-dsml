package edu.vanderbilt.riaps.ui

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IProject
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.generator.IGenerator2
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import com.google.inject.Inject
import com.google.inject.Provider
import edu.vanderbilt.riaps.generator.RiapsAppGenerator

class ContextMenuGenerator extends AbstractHandler implements IHandler {
	@Inject IGenerator2 generator
	@Inject Provider<EclipseResourceFileSystemAccess2> fileAccessProvider
	@Inject package IResourceDescriptions resourceDescriptions
	@Inject package IResourceSetProvider resourceSetProvider
	@Inject RiapsAppGenerator g1

	override Object execute(ExecutionEvent event) throws ExecutionException {
		var ISelection selection = HandlerUtil.getCurrentSelection(event)
		System.out.println("executed generator")
		if (selection instanceof IStructuredSelection) {
			var IStructuredSelection structuredSelection = (selection as IStructuredSelection)
			var Object firstElement = structuredSelection.getFirstElement()
			if (firstElement instanceof IFile) {
				var IFile file = (firstElement as IFile)
				var IProject project = file.getProject()
//				var IFolder srcGenFolder = project.getFolder("src-gen")
//				if (!srcGenFolder.exists()) {
//					try {
//						srcGenFolder.create(true, true, new NullProgressMonitor())
//					} catch (CoreException e) {
//						return null
//					}
//
//				}
				val EclipseResourceFileSystemAccess2 fsa = fileAccessProvider.get()
				fsa.setProject(project)
				fsa.setOutputPath(".")
				fsa.setMonitor(new NullProgressMonitor())
				var URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true)
				var ResourceSet rs = resourceSetProvider.get(project)
				var Resource r = rs.getResource(uri, true)
				g1.doGenerate(r, fsa, new GeneratorContext())
			}
		}
		System.out.println("finished generator")
		return null
	}

	override boolean isEnabled() {
		return true
	}
}

package edu.vanderbilt.riaps.datatypes

import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.IHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import edu.vanderbilt.riaps.generator.CapnProtoGenerator
import com.google.inject.Inject
import com.google.inject.Provider;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.runtime.CoreException
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.GeneratorContext

class MenuHandler extends AbstractHandler implements IHandler {

	@Inject CapnProtoGenerator g1
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileAccessProvider;

	@Inject
	IResourceDescriptions resourceDescriptions;

	@Inject
	IResourceSetProvider resourceSetProvider;

	override execute(ExecutionEvent event) throws ExecutionException {
		var selection = HandlerUtil.getCurrentSelection(event);
		if (selection instanceof IStructuredSelection) {
			var structuredSelection = selection as IStructuredSelection;
			var firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof IFile) {
				var file = firstElement as IFile;
				var project = file.getProject();
				var srcGenFolder = project.getFolder("src-gen");
				if (!srcGenFolder.exists()) {
					try {
						srcGenFolder.create(true, true, new NullProgressMonitor());
					} catch (CoreException e) {
						return null;
					}
				}
				var fsa = fileAccessProvider.get();
				fsa.setOutputPath(srcGenFolder.getFullPath().toString());
				var uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				var rs = resourceSetProvider.get(project);
				var r = rs.getResource(uri, true);
				g1.doGenerate(r, fsa, new GeneratorContext());
			}

			return null;
		}
	}

}

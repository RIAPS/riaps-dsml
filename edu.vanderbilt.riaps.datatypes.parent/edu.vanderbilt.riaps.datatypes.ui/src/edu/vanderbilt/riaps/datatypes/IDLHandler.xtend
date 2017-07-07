package edu.vanderbilt.riaps.datatypes

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import edu.vanderbilt.riaps.Console
import edu.vanderbilt.riaps.DatatypesStandaloneSetup
import edu.vanderbilt.riaps.generator.IDLGenerator
import org.eclipse.core.commands.AbstractHandler
import org.eclipse.core.commands.ExecutionEvent
import org.eclipse.core.commands.ExecutionException
import org.eclipse.core.commands.IHandler
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.handlers.HandlerUtil
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2
import org.eclipse.xtext.generator.GeneratorContext
import org.eclipse.xtext.resource.IResourceDescriptions
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.resource.IResourceSetProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess

//import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess
class IDLHandler extends AbstractHandler implements IHandler {

	@Inject IDLGenerator g1
	// private EclipseResourceFileSystemAccess2 fileAccessProvider	
	// IResourceSetProvider resourceSetProvider
	@Inject
	private Provider<EclipseResourceFileSystemAccess> fileAccessProvider;
	@Inject
	IResourceDescriptions resourceDescriptions;
	@Inject
	IResourceSetProvider resourceSetProvider;
	// private static Injector injector = new DatatypesStandaloneSetup().createInjectorAndDoEMFRegistration()
	override execute(ExecutionEvent event) throws ExecutionException {
		var selection = HandlerUtil.getCurrentSelection(event);
		// var fileAccessProvider =  injector.getProvider(typeof(EclipseResourceFileSystemAccess))
		var fsa = fileAccessProvider.get()
		// resourceSetProvider = new IResourceSetProvider
		// g1 = new CapnProtoGenerator
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
				fsa.setOutputPath(srcGenFolder.getFullPath().toString());

				var uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);

				var rs = resourceSetProvider.get(project);

				var r = rs.getResource(uri, true);

				g1.doGenerate(r, fsa, new GeneratorContext);

			}

			return null;
		}
	}

}

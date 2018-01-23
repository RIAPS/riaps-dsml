package edu.vanderbilt.riaps.ui

import java.net.URI
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IProjectDescription
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import java.util.ArrayList
import edu.vanderbilt.riaps.Console
import java.util.List
import org.eclipse.core.resources.IFile
import java.io.ByteArrayInputStream

class RIAPSAppSupport {

//	static val riapsNatures = #{'org.eclipse.cdt.make.core.makeNature', 'org.eclipse.cdt.make.core.ScannerConfigNature',
	//	'org.eclipse.cdt.core.ccnature', 'org.eclipse.cdt.core.cnature', 'org.eclipse.xtext.ui.shared.xtextNature','org.python.pydev.pythonNature'}
static val riapsNatures = #{'org.eclipse.cdt.core.cnature', 'org.eclipse.cdt.core.ccnature',
		'org.eclipse.cdt.core.ccnature', 'org.eclipse.cdt.core.cnature', 'org.eclipse.xtext.ui.shared.xtextNature','org.python.pydev.pythonNature'}

	// static val riapsNatures = #{'org.eclipse.xtext.ui.shared.xtextNature'}
	/** 
	 * For this marvelous project we need to:
	 * - create the default Eclipse project
	 * - add the custom project nature
	 * - create the folder structure
	 * @param projectName
	 * @param location
	 * @param natureId
	 * @return
	 */
	def static IProject createProject(String projectName, URI location) {
		Assert.isNotNull(projectName)
		Assert.isTrue(projectName.trim().length() > 0)
		var IProject project = createBaseProject(projectName, location)
	
		try {
			addNature(project)
			//var String[] paths = #["src/build/armhf", "src/build/amd64"]
			//addToProjectStructureFolder(project, paths)
			addMakefile(project)
			addCprojectAndPydev(project)
		} catch (CoreException e) {
			e.printStackTrace()
			project = null
		}

		return project
	}

	/** 
	 * Just do the basics: create a basic project.
	 * @param location
	 * @param projectName
	 */
	def private static IProject createBaseProject(String projectName, URI location) {
		// it is acceptable to use the ResourcesPlugin class
		var IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName)
		if (!newProject.exists()) {
			var URI projectLocation = location
			var IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName())
			if (location !== null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)) {
				projectLocation = null
			}
			desc.setLocationURI(projectLocation)
			try {
				newProject.create(desc, null)
				if (!newProject.isOpen()) {
					newProject.open(null)
				}
			} catch (CoreException e) {
				e.printStackTrace()
			}

		}
		return newProject
	}

/*/	def private static void createFolder(IFolder folder) throws CoreException {
		var IContainer parent = folder.getParent()
		if (parent instanceof IFolder) {
			createFolder((parent as IFolder))
		}
		if (!folder.exists()) {
			folder.create(false, true, null)
		}
	}
*/
    def private static createPyDev(){
    	'''
    	<?xml version="1.0" encoding="UTF-8" standalone="no"?>
    	<?eclipse-pydev version="1.0"?><pydev_project>
    	<pydev_property name="org.python.pydev.PYTHON_PROJECT_INTERPRETER">Default</pydev_property>
    	<pydev_property name="org.python.pydev.PYTHON_PROJECT_VERSION">python interpreter</pydev_property>
    	</pydev_project>
    	'''
    }
	def private static createMakefile() {
		'''
		CMAKE := $(shell which cmake 2> /dev/null)
		CLANG-FORMAT := $(shell which clang-format 2> /dev/null)
		RM-CMD := $(shell which rm 2> /dev/null)
		all: build/armhf/Makefile build/amd64/Makefile all-armhf all-amd64
		
		realclean:		 
		ifndef RM-CMD
			rmdir build /s /q
		else
			$(shell rm -rf build)
		endif
		
		build/armhf/Makefile: CMakeLists.txt
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			mkdir -p build/armhf/
			cd build/armhf/ && \
			cmake -DCMAKE_TOOLCHAIN_FILE=.toolchain.arm-linux-gnueabihf.cmake -DCMAKE_INSTALL_PREFIX="/"  ../..
			@echo "done"
		endif
		
		build/amd64/Makefile: CMakeLists.txt
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			mkdir -p build/amd64/
			cd build/amd64/ && \
			cmake -DCMAKE_TOOLCHAIN_FILE=.toolchain.amd64.cmake  -DCMAKE_INSTALL_PREFIX="/" ../..
			@echo "done"
		endif
		
		all-amd64: build/amd64/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C build/amd64/ -j2
		endif
		
		all-armhf: build/armhf/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C build/armhf -j2
		endif
		
		
		clean-armhf: build/armhf/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C build/armhf clean -j2
		endif
		
		clean-amd64: build/amd64/Makefile
		ifndef CMAKE
			$(error "cmake is not available. Please install")
		else
			make -C build/amd64 clean -j2
		endif
		
		reformat: cpp
		ifndef CLANG-FORMAT
			$(error "clang-format is not available. Please install")
		else
			clang-format -i -style=file cpp/*.cc
			clang-format -i -style=file cpp/include/*.h
		endif
		
		'''
	}
	
	
	
	/** 
	 * Create a folder structure with a parent root, overlay, and a few child
	 * folders.
	 * @param newProject
	 * @param paths
	 * @throws CoreException
	 
	def private static void addToProjectStructureFolder(IProject newProject, String[] paths) throws CoreException {
		for (String path : paths) {
			var etcFolders = newProject.getFolder(path);
			createFolder(etcFolders);
		}
	}*/

	def private static void addMakefile(IProject newProject) throws CoreException {
		var IFile file = newProject.getFile("makefile"); // such as file.exists() == false
		var contents = createMakefile.toString.getBytes;
		var source = new ByteArrayInputStream(contents);
		if (!file.exists) {
			file.create(source, false, null);
		}
	}
	

	
	def private static void addCprojectAndPydev(IProject newProject) throws CoreException {
		
		var currentpath=newProject.getLocation.toOSString
		var IFile file = newProject.getFile(".cproject"); // such as file.exists() == false
		var contents = CProjectSetting.createCProject(newProject.name).toString.getBytes;
		
		var source = new ByteArrayInputStream(contents);
		if (!file.exists) {
			file.create(source, false, null);
		}
		var settingsFolder = newProject.getFolder(".settings")
		if(!settingsFolder.exists){
			settingsFolder.create(false, true, null)
		}
		
		file = settingsFolder.getFile("language.settings.xml");
		source =new ByteArrayInputStream(CProjectSetting.createSettings.toString.getBytes);
		if (!file.exists) {
			file.create(source, false, null);
		}
		
		file = newProject.getFile(".pydevproject"); // such as file.exists() == false
		 contents = createPyDev.toString.getBytes;
		 source = new ByteArrayInputStream(contents);
		if (!file.exists) {
			file.create(source, false, null);
		}
	}
	
	def private static void addNature(IProject project, String nature)
	{
		var IProjectDescription description = project.getDescription()
		var String[] prevNatures = description.getNatureIds();
		var List<String> newNatures = new ArrayList<String>();
		for (nature1 : prevNatures) {
			newNatures.add(nature1);
		}
		if (!project.hasNature(nature)) {
			newNatures.add(nature)
			description.setNatureIds(newNatures)
		}
		var IProgressMonitor monitor = null;
		try {
			project.setDescription(description, monitor);

		} catch (org.eclipse.core.runtime.CoreException e) {
			Console.instance.log(java.util.logging.Level.INFO, "Problem encountered while setting nature " + nature);
			description.setNatureIds(prevNatures);
			project.setDescription(description, monitor);
		}
			 
	}
	

	def private static void addNature(IProject project) throws CoreException {

	//	var IProjectDescription description = project.getDescription()		
	//	var List<String> newNatures = new ArrayList<String>();
		for (nature : riapsNatures) {
			if (!project.hasNature(nature)) {
				addNature(project,nature)
			}
		}
//		description.setNatureIds(newNatures);
//		var IProgressMonitor monitor = null;
//		try {
//			project.setDescription(description, monitor);
//
//		} catch (org.eclipse.core.runtime.CoreException e) {
//			Console.instance.log(java.util.logging.Level.INFO,
//				"Problem encountered while setting natures. Check if you have cdt environment installed");
//			description.setNatureIds(prevNatures);
//			project.setDescription(description, monitor);
//		}

	}

}

[![Build Status](https://travis-ci.com/RIAPS/riaps-dsml.svg?token=pyUEeBLkG7FqiYPhyfxp&branch=master)](https://travis-ci.com/RIAPS/riaps-dsml)
# riaps-dsml
RIAPS Modeling Language


# Updating version

Edit the updateversion.sh and execute to set the version correctly.

# How to use the releases?
- Download the release tar ball to your machine.
- untar it ```$ tar -xf riapsdsmlplugin.tar.gz```
- Add the local folder as an update site to your eclipse.
	- Open Eclipse --> Help --> Install New Software -- Add... --> Local...
	- Browse to location of untar-ed release and click ok.
	- install the available plugins.

# Setup system before development
    '''
    $ export JAVA_HOME=/usr/lib/jvm/java-1.8.0-openjdk-amd64
    $ apt-get install maven

- Eclipse Plugins to install
    - Using Help --> Install New Software ... --> Work with: Neon - http://download.eclipse.org/releases/neon (from dropdown)
    	- in "type filter text" box search for : m2e – Extensions Development Support
    - Using Help --> Eclipse Marketplace ...
    	- Eclipse Xtext 2.11.0 and Eclipse Xtend 2.11.0

# To start with the development
- Clone the git repository
- Run the mvn build once inside edu.vanderbilt.riaps.system.parent project directory. This step is necessary to create the src-gen and xtend-gen folders. These folders are not tracked in the git repository because they are generated.

    ```
    $ pushd edu.vanderbilt.riaps.system.parent && mvn clean install && popd
    ```

- Then import the workspace into eclipse.
	- File --> Import --> General --> Projects from Folder or Archive --> Directory
	- browse to project git repository
	- **Ensure that you select the option for searching for nested projects.**
![import](docs/media/eclipse_import.png)

- Once you have imported the project into workspace, start compiling the projects in the following sequence
    1. edu.vanderbilt.riaps.app
	- Expand the project selection to
	edu.vanderbilt.riaps.app->src->edu.vanderbilt.riaps->GenerateApp.mwe2
	- Then right click on the mwe2 file and select "Run As --> MWE2 Workflow"
    2. edu.vanderbilt.riaps.system
	- Expand the project selection to
	edu.vanderbilt.riaps.system->src->edu.vanderbilt.riaps->GenerateSystem.mwe2
	- Then right click on the mwe2 file and select "Run As --> MWE2 Workflow"

# To use the language
- Right click edu.vanderbilt.riaps.app or edu.vanderbilt.riaps.system
- Run As --> Eclipse Application
- In new Eclipse environment
	- File --> Open Projects from File System... --> Directory
	- Browse to git repository --> examples --> example_Weather_Monitor --> OK --> Finish
If everything worked correctly the riaps example models will have syntax highlighting and autocomplete among other useful features.

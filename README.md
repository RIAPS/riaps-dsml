[![Build Status](https://travis-ci.com/RIAPS/riapsml.svg?token=pyUEeBLkG7FqiYPhyfxp&branch=master)](https://travis-ci.com/RIAPS/riapsml)

# riapsml
RIAPS Modeling Language
# To start with the development
- clone the git repository
- run the mvn build once. This step is necessary to create the src-gen and xtend-gen folders. These folders are not tracked in the git repository because they are generated.

```
pushd edu.vanderbilt.riaps.system.parent && mvn clean install && popd
```

- Then you have to import the workspace into eclipse. Ensure that you select the option for searching for nested projects.
![import](docs/media/eclipse_import.png)
- Once you have imported the project into workspace, start compiling the projects in the following sequence 
    - edu.vanderbilt.riaps.datatypes. To compile the project. Exapnd the project selecion, edu.vanderbilt.riaps.datatypes->src->edu.vanderbilt.riaps->GenerateDatatypes.mwe2, rightclick on the mwe2 file, select run as MWE2 workflow.
  - edu.vanderbilt.riaps.app. Compile similarly/
  -  edu.vanderbilt.riaps.system . Compile Similarly

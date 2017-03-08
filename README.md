[![Build Status](https://travis-ci.com/RIAPS/riapsml.svg?token=pyUEeBLkG7FqiYPhyfxp&branch=master)](https://travis-ci.com/RIAPS/riapsml)

# riapsml
RIAPS Modeling Language
# To start with the development
- clone the git repository
- run the mvn build once. This step is necessary to create the src-gen and xtend-gen folders. These folders are not tracked in the git repository because they are generated.

```
pushd edu.vanderbilt.riaps.system.parent && mvn clean install && popd
```

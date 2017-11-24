import static groovy.io.FileType.FILES

// Collect all jars.
def jars = []
def root = new File(project.getBasedir(), 'target/classes')

root.eachFileRecurse (FILES) { file ->
  jars << root.toURI().relativize(file.toURI()).toString()
}

// Write the manifest file.
def manifest = new File(project.getBasedir(), 'target/classes/META-INF/MANIFEST.MF')

manifest.write ''

manifest << 'Manifest-Version: 1.0\n'
manifest << 'Class-Path: . '  + '\n'
manifest << 'Rsrc-Main-Class: edu.vanderbilt.riaps.generator.SystemGenerator\n'
manifest << 'Main-Class: edu.vanderbilt.riaps.generator.SystemGenerator\n'
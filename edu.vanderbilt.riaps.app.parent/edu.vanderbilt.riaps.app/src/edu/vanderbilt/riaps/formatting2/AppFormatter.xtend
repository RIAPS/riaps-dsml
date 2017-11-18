/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.formatting2

import com.google.inject.Inject
import edu.vanderbilt.riaps.app.Component

import edu.vanderbilt.riaps.app.Import
import edu.vanderbilt.riaps.app.Model
import edu.vanderbilt.riaps.services.AppGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import edu.vanderbilt.riaps.app.Application
import edu.vanderbilt.riaps.app.Actor

import edu.vanderbilt.riaps.app.InstanceSection
import edu.vanderbilt.riaps.app.DeploymentConstraint
import edu.vanderbilt.riaps.app.ComponentUses
import edu.vanderbilt.riaps.app.Group
import edu.vanderbilt.riaps.app.GMessageBlock

class AppFormatter extends AbstractFormatter2 {

	@Inject extension AppGrammarAccess

	def dispatch void format(Model model, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		for (Import imports : model.getImports()) {
			imports.format;
			imports.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		model.prepend[noSpace].append[noSpace; newLine]

		for (collection : model.getCollections()) {
			if (collection instanceof Application)
				(collection as Application).format
		}
	}



	def dispatch void format(Application app, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		val open = app.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = app.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
		for (Component component : app.getComponents()) {
			component.format;
			component.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		for (Group group : app.getGroups()) {
			group.format;
			group.prepend[noSpace; newLine].append[noSpace; newLine]
		}
	
	
		for (Actor actor : app.getActors()) {
			actor.format;
			actor.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		for(DeploymentConstraint c: app.deploymentConstraints){
			c.format;
			c.prepend[noSpace; newLine].append[noSpace; newLine]
		}

	}
	
	def dispatch void format(Group component, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		val open = component.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = component.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
		for (GMessageBlock components : component.gmessageblock) {
			components.format;
		}
	}
	
	def dispatch void format(GMessageBlock component, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		val open = component.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = component.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
	}

//	def dispatch void format(ComponentCollection collection, extension IFormattableDocument document) {
//		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
//		val open = collection.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
//		val close = collection.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
//		interior(open, close)[indent]
//		for (Component components : collection.getComponents()) {
//			components.format;
//		}
//	}

	def dispatch void format(Component component, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		val open = component.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = component.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
		component.constraint.format
		

	}
	
	
		def dispatch void format(ComponentUses collection, extension IFormattableDocument document) {
		val open = collection.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = collection.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
		collection.prepend[noSpace; newLine].append[noSpace; newLine]

	}
	

	def dispatch void format(InstanceSection actor, extension IFormattableDocument document) {
		val open = actor.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = actor.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]
		for (instance : actor.instances) {
			instance.format
			instance.prepend[noSpace; newLine].append[noSpace; newLine]
		}
	}

	def dispatch void format(Actor actor, extension IFormattableDocument document) {
		// TODO: format HiddenRegions around keywords, attributes, cross references, etc. 
		val open = actor.regionFor.keyword("{").prepend[noSpace; newLine].append[noSpace; newLine]
		val close = actor.regionFor.keyword("}").prepend[noSpace; newLine].append[noSpace; newLine]
		interior(open, close)[indent]

		for (entry : actor.locals) {
			entry.format
			entry.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		actor.compsection.format
		actor.compsection.prepend[noSpace; newLine].append[noSpace; newLine]

		for (entry : actor.internals) {
			entry.format
			entry.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		
		for (entry : actor.criticals) {
			entry.format
			entry.prepend[noSpace; newLine].append[noSpace; newLine]
		}
		for (entry : actor.wires) {
			entry.format
			entry.prepend[noSpace; newLine].append[noSpace; newLine]
		}

	}

// TODO: implement for application, MessageCollection, DeviceComponent, AppComponent, ComponentFormal, ActorFormal, Actor, Actual, ActualValue, Instance
}

/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.ui.contentassist

import org.eclipse.xtext.Assignment
import edu.vanderbilt.riaps.Console
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.CrossReference
import edu.vanderbilt.riaps.app.Actor
import edu.vanderbilt.riaps.system.ActorDeployment
import edu.vanderbilt.riaps.system.AppDeployment
import edu.vanderbilt.riaps.app.Application

/**
 * See https://www.eclipse.org/Xtext/documentation/304_ide_concepts.html#content-assist
 * on how to customize the content assistant.
 */
class SystemProposalProvider extends AbstractSystemProposalProvider {

//	override completeActorAssignment_Actor(EObject model, Assignment assignment, ContentAssistContext context,
//		ICompletionProposalAcceptor acceptor) {
//		if (model instanceof ActorDeployment) {
//			var app = model.eContainer
//			if (app instanceof AppDeployment) {
//				val Application realapp = app.app
//
//				//Console.instance.log(java.util.logging.Level.INFO,
//			//		"proposal: " + model.toString + "real app" + realapp.name)
//					
//					for(actor:realapp.actors)
//					{
//						
//						val proposal = valueConverter.toString(actor.name,
//                     	  actor.name)
//					
//						 acceptor.accept(createCompletionProposal(proposal, context))
//					
//						
//					}
//
//			}
//
//		}
//
//	} 
}

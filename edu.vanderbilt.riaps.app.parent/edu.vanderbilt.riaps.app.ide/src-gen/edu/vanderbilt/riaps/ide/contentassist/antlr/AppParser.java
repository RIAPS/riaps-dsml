/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.ide.contentassist.antlr;

import com.google.inject.Inject;
import edu.vanderbilt.riaps.ide.contentassist.antlr.internal.InternalAppParser;
import edu.vanderbilt.riaps.services.AppGrammarAccess;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

public class AppParser extends AbstractContentAssistParser {

	@Inject
	private AppGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalAppParser createParser() {
		InternalAppParser result = new InternalAppParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getFormalDefaultAccess().getAlternatives(), "rule__FormalDefault__Alternatives");
					put(grammarAccess.getNumberAccess().getAlternatives_0(), "rule__Number__Alternatives_0");
					put(grammarAccess.getNumberAccess().getAlternatives_1_1(), "rule__Number__Alternatives_1_1");
					put(grammarAccess.getCollectionAccess().getAlternatives(), "rule__Collection__Alternatives");
					put(grammarAccess.getApplicationAccess().getAlternatives_5(), "rule__Application__Alternatives_5");
					put(grammarAccess.getDeploymentConstraintAccess().getAlternatives(), "rule__DeploymentConstraint__Alternatives");
					put(grammarAccess.getArtifactAccess().getAlternatives_0(), "rule__Artifact__Alternatives_0");
					put(grammarAccess.getComponentAccess().getAlternatives(), "rule__Component__Alternatives");
					put(grammarAccess.getDeviceComponentAccess().getAlternatives_4(), "rule__DeviceComponent__Alternatives_4");
					put(grammarAccess.getAppComponentAccess().getAlternatives_4(), "rule__AppComponent__Alternatives_4");
					put(grammarAccess.getMemoryUnitsAccess().getAlternatives(), "rule__MemoryUnits__Alternatives");
					put(grammarAccess.getRequirementAccess().getAlternatives_1(), "rule__Requirement__Alternatives_1");
					put(grammarAccess.getPortAccess().getAlternatives(), "rule__Port__Alternatives");
					put(grammarAccess.getRateLimitAccess().getAlternatives_2(), "rule__RateLimit__Alternatives_2");
					put(grammarAccess.getRateLimitAccess().getAlternatives_4(), "rule__RateLimit__Alternatives_4");
					put(grammarAccess.getTimeUnitAccess().getAlternatives(), "rule__TimeUnit__Alternatives");
					put(grammarAccess.getActorAccess().getAlternatives_4(), "rule__Actor__Alternatives_4");
					put(grammarAccess.getWireAccess().getAlternatives_1(), "rule__Wire__Alternatives_1");
					put(grammarAccess.getActualValueAccess().getAlternatives(), "rule__ActualValue__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getNumberAccess().getGroup(), "rule__Number__Group__0");
					put(grammarAccess.getNumberAccess().getGroup_1(), "rule__Number__Group_1__0");
					put(grammarAccess.getComponentCollectionAccess().getGroup(), "rule__ComponentCollection__Group__0");
					put(grammarAccess.getApplicationAccess().getGroup(), "rule__Application__Group__0");
					put(grammarAccess.getApplicationAccess().getGroup_3(), "rule__Application__Group_3__0");
					put(grammarAccess.getCollocateConstraintAccess().getGroup(), "rule__CollocateConstraint__Group__0");
					put(grammarAccess.getCollocateConstraintAccess().getGroup_4(), "rule__CollocateConstraint__Group_4__0");
					put(grammarAccess.getDistributeConstraintAccess().getGroup(), "rule__DistributeConstraint__Group__0");
					put(grammarAccess.getDistributeConstraintAccess().getGroup_4(), "rule__DistributeConstraint__Group_4__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getImportedFQNAccess().getGroup(), "rule__ImportedFQN__Group__0");
					put(grammarAccess.getImportedFQNAccess().getGroup_1(), "rule__ImportedFQN__Group_1__0");
					put(grammarAccess.getFQNAccess().getGroup(), "rule__FQN__Group__0");
					put(grammarAccess.getFQNAccess().getGroup_1(), "rule__FQN__Group_1__0");
					put(grammarAccess.getMessageCollectionAccess().getGroup(), "rule__MessageCollection__Group__0");
					put(grammarAccess.getMessageAccess().getGroup(), "rule__Message__Group__0");
					put(grammarAccess.getMessageAccess().getGroup_4(), "rule__Message__Group_4__0");
					put(grammarAccess.getArtifactAccess().getGroup(), "rule__Artifact__Group__0");
					put(grammarAccess.getDeviceComponentAccess().getGroup(), "rule__DeviceComponent__Group__0");
					put(grammarAccess.getDeviceComponentAccess().getGroup_2(), "rule__DeviceComponent__Group_2__0");
					put(grammarAccess.getDeviceComponentAccess().getGroup_2_2(), "rule__DeviceComponent__Group_2_2__0");
					put(grammarAccess.getAppComponentAccess().getGroup(), "rule__AppComponent__Group__0");
					put(grammarAccess.getAppComponentAccess().getGroup_2(), "rule__AppComponent__Group_2__0");
					put(grammarAccess.getAppComponentAccess().getGroup_2_2(), "rule__AppComponent__Group_2_2__0");
					put(grammarAccess.getRequirementAccess().getGroup(), "rule__Requirement__Group__0");
					put(grammarAccess.getRequirementAccess().getGroup_1_0(), "rule__Requirement__Group_1_0__0");
					put(grammarAccess.getRequirementAccess().getGroup_1_1(), "rule__Requirement__Group_1_1__0");
					put(grammarAccess.getRequirementAccess().getGroup_1_2(), "rule__Requirement__Group_1_2__0");
					put(grammarAccess.getRequirementAccess().getGroup_1_3(), "rule__Requirement__Group_1_3__0");
					put(grammarAccess.getRateLimitAccess().getGroup(), "rule__RateLimit__Group__0");
					put(grammarAccess.getPubPortAccess().getGroup(), "rule__PubPort__Group__0");
					put(grammarAccess.getSubPortAccess().getGroup(), "rule__SubPort__Group__0");
					put(grammarAccess.getDeadlineAccess().getGroup(), "rule__Deadline__Group__0");
					put(grammarAccess.getClntPortAccess().getGroup(), "rule__ClntPort__Group__0");
					put(grammarAccess.getSrvPortAccess().getGroup(), "rule__SrvPort__Group__0");
					put(grammarAccess.getReqPortAccess().getGroup(), "rule__ReqPort__Group__0");
					put(grammarAccess.getTimPortAccess().getGroup(), "rule__TimPort__Group__0");
					put(grammarAccess.getTimPortAccess().getGroup_2(), "rule__TimPort__Group_2__0");
					put(grammarAccess.getInsPortAccess().getGroup(), "rule__InsPort__Group__0");
					put(grammarAccess.getComponentFormalAccess().getGroup(), "rule__ComponentFormal__Group__0");
					put(grammarAccess.getComponentFormalAccess().getGroup_1(), "rule__ComponentFormal__Group_1__0");
					put(grammarAccess.getActorFormalAccess().getGroup(), "rule__ActorFormal__Group__0");
					put(grammarAccess.getActorFormalAccess().getGroup_1(), "rule__ActorFormal__Group_1__0");
					put(grammarAccess.getActorAccess().getGroup(), "rule__Actor__Group__0");
					put(grammarAccess.getActorAccess().getGroup_2(), "rule__Actor__Group_2__0");
					put(grammarAccess.getActorAccess().getGroup_2_2(), "rule__Actor__Group_2_2__0");
					put(grammarAccess.getActorAccess().getGroup_4_0(), "rule__Actor__Group_4_0__0");
					put(grammarAccess.getActorAccess().getGroup_4_0_2(), "rule__Actor__Group_4_0_2__0");
					put(grammarAccess.getActorAccess().getGroup_4_1(), "rule__Actor__Group_4_1__0");
					put(grammarAccess.getActorAccess().getGroup_4_1_2(), "rule__Actor__Group_4_1_2__0");
					put(grammarAccess.getActorAccess().getGroup_4_2(), "rule__Actor__Group_4_2__0");
					put(grammarAccess.getActorAccess().getGroup_4_2_2(), "rule__Actor__Group_4_2_2__0");
					put(grammarAccess.getInstanceSectionAccess().getGroup(), "rule__InstanceSection__Group__0");
					put(grammarAccess.getWireAccess().getGroup(), "rule__Wire__Group__0");
					put(grammarAccess.getWireAccess().getGroup_1_0(), "rule__Wire__Group_1_0__0");
					put(grammarAccess.getWireAccess().getGroup_1_1(), "rule__Wire__Group_1_1__0");
					put(grammarAccess.getActualAccess().getGroup(), "rule__Actual__Group__0");
					put(grammarAccess.getInstanceAccess().getGroup(), "rule__Instance__Group__0");
					put(grammarAccess.getInstanceAccess().getGroup_3(), "rule__Instance__Group_3__0");
					put(grammarAccess.getInstanceAccess().getGroup_3_2(), "rule__Instance__Group_3_2__0");
					put(grammarAccess.getModelAccess().getNameAssignment_2(), "rule__Model__NameAssignment_2");
					put(grammarAccess.getModelAccess().getImportsAssignment_3(), "rule__Model__ImportsAssignment_3");
					put(grammarAccess.getModelAccess().getCollectionsAssignment_4(), "rule__Model__CollectionsAssignment_4");
					put(grammarAccess.getStringDefaultAccess().getValueAssignment(), "rule__StringDefault__ValueAssignment");
					put(grammarAccess.getNumberDefaultAccess().getValueAssignment(), "rule__NumberDefault__ValueAssignment");
					put(grammarAccess.getBoolDefaultAccess().getValueAssignment(), "rule__BoolDefault__ValueAssignment");
					put(grammarAccess.getComponentCollectionAccess().getNameAssignment_2(), "rule__ComponentCollection__NameAssignment_2");
					put(grammarAccess.getComponentCollectionAccess().getComponentsAssignment_4(), "rule__ComponentCollection__ComponentsAssignment_4");
					put(grammarAccess.getApplicationAccess().getNameAssignment_2(), "rule__Application__NameAssignment_2");
					put(grammarAccess.getApplicationAccess().getBaseappAssignment_3_1(), "rule__Application__BaseappAssignment_3_1");
					put(grammarAccess.getApplicationAccess().getArtifactsAssignment_5_0(), "rule__Application__ArtifactsAssignment_5_0");
					put(grammarAccess.getApplicationAccess().getActorsAssignment_5_1(), "rule__Application__ActorsAssignment_5_1");
					put(grammarAccess.getApplicationAccess().getComponentsAssignment_5_2(), "rule__Application__ComponentsAssignment_5_2");
					put(grammarAccess.getApplicationAccess().getMessagesAssignment_5_3(), "rule__Application__MessagesAssignment_5_3");
					put(grammarAccess.getApplicationAccess().getDeploymentConstraintsAssignment_6(), "rule__Application__DeploymentConstraintsAssignment_6");
					put(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistAssignment_1(), "rule__CollocateConstraint__ActorcollocatelistAssignment_1");
					put(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistAssignment_3(), "rule__CollocateConstraint__ActorcollocatelistAssignment_3");
					put(grammarAccess.getCollocateConstraintAccess().getActorcollocatelistAssignment_4_1(), "rule__CollocateConstraint__ActorcollocatelistAssignment_4_1");
					put(grammarAccess.getDistributeConstraintAccess().getActordistributelistAssignment_1(), "rule__DistributeConstraint__ActordistributelistAssignment_1");
					put(grammarAccess.getDistributeConstraintAccess().getActordistributelistAssignment_3(), "rule__DistributeConstraint__ActordistributelistAssignment_3");
					put(grammarAccess.getDistributeConstraintAccess().getActordistributelistAssignment_4_1(), "rule__DistributeConstraint__ActordistributelistAssignment_4_1");
					put(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1(), "rule__Import__ImportedNamespaceAssignment_1");
					put(grammarAccess.getMessageCollectionAccess().getNameAssignment_2(), "rule__MessageCollection__NameAssignment_2");
					put(grammarAccess.getMessageCollectionAccess().getMessagesAssignment_4(), "rule__MessageCollection__MessagesAssignment_4");
					put(grammarAccess.getMessageAccess().getNameAssignment_1(), "rule__Message__NameAssignment_1");
					put(grammarAccess.getMessageAccess().getTypeAssignment_3(), "rule__Message__TypeAssignment_3");
					put(grammarAccess.getMessageAccess().getKeyAssignment_4_1(), "rule__Message__KeyAssignment_4_1");
					put(grammarAccess.getArtifactAccess().getJarAssignment_0_0(), "rule__Artifact__JarAssignment_0_0");
					put(grammarAccess.getArtifactAccess().getSharedObjectAssignment_0_1(), "rule__Artifact__SharedObjectAssignment_0_1");
					put(grammarAccess.getArtifactAccess().getConfigurationFileAssignment_0_2(), "rule__Artifact__ConfigurationFileAssignment_0_2");
					put(grammarAccess.getArtifactAccess().getNameAssignment_1(), "rule__Artifact__NameAssignment_1");
					put(grammarAccess.getArtifactAccess().getPathAssignment_3(), "rule__Artifact__PathAssignment_3");
					put(grammarAccess.getDeviceComponentAccess().getNameAssignment_1(), "rule__DeviceComponent__NameAssignment_1");
					put(grammarAccess.getDeviceComponentAccess().getFormalsAssignment_2_1(), "rule__DeviceComponent__FormalsAssignment_2_1");
					put(grammarAccess.getDeviceComponentAccess().getFormalsAssignment_2_2_1(), "rule__DeviceComponent__FormalsAssignment_2_2_1");
					put(grammarAccess.getDeviceComponentAccess().getRequirementsAssignment_4_0(), "rule__DeviceComponent__RequirementsAssignment_4_0");
					put(grammarAccess.getDeviceComponentAccess().getPortsAssignment_4_1(), "rule__DeviceComponent__PortsAssignment_4_1");
					put(grammarAccess.getAppComponentAccess().getNameAssignment_1(), "rule__AppComponent__NameAssignment_1");
					put(grammarAccess.getAppComponentAccess().getFormalsAssignment_2_1(), "rule__AppComponent__FormalsAssignment_2_1");
					put(grammarAccess.getAppComponentAccess().getFormalsAssignment_2_2_1(), "rule__AppComponent__FormalsAssignment_2_2_1");
					put(grammarAccess.getAppComponentAccess().getRequirementsAssignment_4_0(), "rule__AppComponent__RequirementsAssignment_4_0");
					put(grammarAccess.getAppComponentAccess().getPortsAssignment_4_1(), "rule__AppComponent__PortsAssignment_4_1");
					put(grammarAccess.getMemoryUnitsAccess().getKbAssignment_0(), "rule__MemoryUnits__KbAssignment_0");
					put(grammarAccess.getMemoryUnitsAccess().getMbAssignment_1(), "rule__MemoryUnits__MbAssignment_1");
					put(grammarAccess.getMemoryUnitsAccess().getGbAssignment_2(), "rule__MemoryUnits__GbAssignment_2");
					put(grammarAccess.getRequirementAccess().getArtifactrequirementAssignment_1_0_1(), "rule__Requirement__ArtifactrequirementAssignment_1_0_1");
					put(grammarAccess.getRequirementAccess().getMemoryRequirementAssignment_1_1_1(), "rule__Requirement__MemoryRequirementAssignment_1_1_1");
					put(grammarAccess.getRequirementAccess().getMemoryunitAssignment_1_1_2(), "rule__Requirement__MemoryunitAssignment_1_1_2");
					put(grammarAccess.getRequirementAccess().getStorageRequirementAssignment_1_2_1(), "rule__Requirement__StorageRequirementAssignment_1_2_1");
					put(grammarAccess.getRequirementAccess().getStorageunitAssignment_1_2_2(), "rule__Requirement__StorageunitAssignment_1_2_2");
					put(grammarAccess.getRequirementAccess().getDeviceRequirementAssignment_1_3_1(), "rule__Requirement__DeviceRequirementAssignment_1_3_1");
					put(grammarAccess.getRateLimitAccess().getLowerAssignment_2_0(), "rule__RateLimit__LowerAssignment_2_0");
					put(grammarAccess.getRateLimitAccess().getNolowerAssignment_2_1(), "rule__RateLimit__NolowerAssignment_2_1");
					put(grammarAccess.getRateLimitAccess().getUpperAssignment_4_0(), "rule__RateLimit__UpperAssignment_4_0");
					put(grammarAccess.getRateLimitAccess().getNoupperAssignment_4_1(), "rule__RateLimit__NoupperAssignment_4_1");
					put(grammarAccess.getPubPortAccess().getNameAssignment_1(), "rule__PubPort__NameAssignment_1");
					put(grammarAccess.getPubPortAccess().getTypeAssignment_3(), "rule__PubPort__TypeAssignment_3");
					put(grammarAccess.getPubPortAccess().getRatelimitAssignment_4(), "rule__PubPort__RatelimitAssignment_4");
					put(grammarAccess.getSubPortAccess().getNameAssignment_1(), "rule__SubPort__NameAssignment_1");
					put(grammarAccess.getSubPortAccess().getTypeAssignment_3(), "rule__SubPort__TypeAssignment_3");
					put(grammarAccess.getSubPortAccess().getRatelimitAssignment_4(), "rule__SubPort__RatelimitAssignment_4");
					put(grammarAccess.getDeadlineAccess().getDeadlineAssignment_1(), "rule__Deadline__DeadlineAssignment_1");
					put(grammarAccess.getDeadlineAccess().getUnitsAssignment_2(), "rule__Deadline__UnitsAssignment_2");
					put(grammarAccess.getClntPortAccess().getNameAssignment_1(), "rule__ClntPort__NameAssignment_1");
					put(grammarAccess.getClntPortAccess().getReq_typeAssignment_4(), "rule__ClntPort__Req_typeAssignment_4");
					put(grammarAccess.getClntPortAccess().getRep_typeAssignment_6(), "rule__ClntPort__Rep_typeAssignment_6");
					put(grammarAccess.getClntPortAccess().getDeadlineAssignment_7(), "rule__ClntPort__DeadlineAssignment_7");
					put(grammarAccess.getClntPortAccess().getRatelimitAssignment_9(), "rule__ClntPort__RatelimitAssignment_9");
					put(grammarAccess.getSrvPortAccess().getNameAssignment_1(), "rule__SrvPort__NameAssignment_1");
					put(grammarAccess.getSrvPortAccess().getReq_typeAssignment_4(), "rule__SrvPort__Req_typeAssignment_4");
					put(grammarAccess.getSrvPortAccess().getRep_typeAssignment_6(), "rule__SrvPort__Rep_typeAssignment_6");
					put(grammarAccess.getSrvPortAccess().getRatelimitAssignment_8(), "rule__SrvPort__RatelimitAssignment_8");
					put(grammarAccess.getReqPortAccess().getNameAssignment_1(), "rule__ReqPort__NameAssignment_1");
					put(grammarAccess.getReqPortAccess().getReq_typeAssignment_4(), "rule__ReqPort__Req_typeAssignment_4");
					put(grammarAccess.getReqPortAccess().getRep_typeAssignment_6(), "rule__ReqPort__Rep_typeAssignment_6");
					put(grammarAccess.getReqPortAccess().getDeadlineAssignment_7(), "rule__ReqPort__DeadlineAssignment_7");
					put(grammarAccess.getReqPortAccess().getRatelimitAssignment_9(), "rule__ReqPort__RatelimitAssignment_9");
					put(grammarAccess.getTimeUnitAccess().getMonthsAssignment_0(), "rule__TimeUnit__MonthsAssignment_0");
					put(grammarAccess.getTimeUnitAccess().getDaysAssignment_1(), "rule__TimeUnit__DaysAssignment_1");
					put(grammarAccess.getTimeUnitAccess().getSecondsAssignment_2(), "rule__TimeUnit__SecondsAssignment_2");
					put(grammarAccess.getTimeUnitAccess().getMillisecondsAssignment_3(), "rule__TimeUnit__MillisecondsAssignment_3");
					put(grammarAccess.getTimeUnitAccess().getNanosecondsAssignment_4(), "rule__TimeUnit__NanosecondsAssignment_4");
					put(grammarAccess.getTimeUnitAccess().getMicrosecondsAssignment_5(), "rule__TimeUnit__MicrosecondsAssignment_5");
					put(grammarAccess.getTimPortAccess().getNameAssignment_1(), "rule__TimPort__NameAssignment_1");
					put(grammarAccess.getTimPortAccess().getSpecAssignment_2_0(), "rule__TimPort__SpecAssignment_2_0");
					put(grammarAccess.getTimPortAccess().getUnitAssignment_2_1(), "rule__TimPort__UnitAssignment_2_1");
					put(grammarAccess.getInsPortAccess().getNameAssignment_1(), "rule__InsPort__NameAssignment_1");
					put(grammarAccess.getInsPortAccess().getSpecAssignment_2(), "rule__InsPort__SpecAssignment_2");
					put(grammarAccess.getComponentFormalAccess().getNameAssignment_0(), "rule__ComponentFormal__NameAssignment_0");
					put(grammarAccess.getComponentFormalAccess().getArgDefaultAssignment_1_1(), "rule__ComponentFormal__ArgDefaultAssignment_1_1");
					put(grammarAccess.getActorFormalAccess().getNameAssignment_0(), "rule__ActorFormal__NameAssignment_0");
					put(grammarAccess.getActorFormalAccess().getArgDefaultAssignment_1_1(), "rule__ActorFormal__ArgDefaultAssignment_1_1");
					put(grammarAccess.getActorAccess().getNameAssignment_1(), "rule__Actor__NameAssignment_1");
					put(grammarAccess.getActorAccess().getFormalsAssignment_2_1(), "rule__Actor__FormalsAssignment_2_1");
					put(grammarAccess.getActorAccess().getFormalsAssignment_2_2_1(), "rule__Actor__FormalsAssignment_2_2_1");
					put(grammarAccess.getActorAccess().getLocalsAssignment_4_0_1(), "rule__Actor__LocalsAssignment_4_0_1");
					put(grammarAccess.getActorAccess().getLocalsAssignment_4_0_2_1(), "rule__Actor__LocalsAssignment_4_0_2_1");
					put(grammarAccess.getActorAccess().getInternalsAssignment_4_1_1(), "rule__Actor__InternalsAssignment_4_1_1");
					put(grammarAccess.getActorAccess().getInternalsAssignment_4_1_2_1(), "rule__Actor__InternalsAssignment_4_1_2_1");
					put(grammarAccess.getActorAccess().getCriticalsAssignment_4_2_1(), "rule__Actor__CriticalsAssignment_4_2_1");
					put(grammarAccess.getActorAccess().getCriticalsAssignment_4_2_2_1(), "rule__Actor__CriticalsAssignment_4_2_2_1");
					put(grammarAccess.getActorAccess().getCompsectionAssignment_5(), "rule__Actor__CompsectionAssignment_5");
					put(grammarAccess.getActorAccess().getWiresAssignment_6(), "rule__Actor__WiresAssignment_6");
					put(grammarAccess.getInstanceSectionAccess().getInstancesAssignment_2(), "rule__InstanceSection__InstancesAssignment_2");
					put(grammarAccess.getWireAccess().getClntAssignment_1_0_0(), "rule__Wire__ClntAssignment_1_0_0");
					put(grammarAccess.getWireAccess().getServerAssignment_1_0_2(), "rule__Wire__ServerAssignment_1_0_2");
					put(grammarAccess.getWireAccess().getAmiAssignment_1_1_0(), "rule__Wire__AmiAssignment_1_1_0");
					put(grammarAccess.getWireAccess().getReqAssignment_1_1_1(), "rule__Wire__ReqAssignment_1_1_1");
					put(grammarAccess.getWireAccess().getServerAssignment_1_1_3(), "rule__Wire__ServerAssignment_1_1_3");
					put(grammarAccess.getActualAccess().getArgNameAssignment_0(), "rule__Actual__ArgNameAssignment_0");
					put(grammarAccess.getActualAccess().getArgValueAssignment_2(), "rule__Actual__ArgValueAssignment_2");
					put(grammarAccess.getActualValueAccess().getStringdefaultAssignment_0(), "rule__ActualValue__StringdefaultAssignment_0");
					put(grammarAccess.getActualValueAccess().getNumberdefaultAssignment_1(), "rule__ActualValue__NumberdefaultAssignment_1");
					put(grammarAccess.getActualValueAccess().getBoolDefaultAssignment_2(), "rule__ActualValue__BoolDefaultAssignment_2");
					put(grammarAccess.getActualValueAccess().getParamAssignment_3(), "rule__ActualValue__ParamAssignment_3");
					put(grammarAccess.getInstanceAccess().getNameAssignment_0(), "rule__Instance__NameAssignment_0");
					put(grammarAccess.getInstanceAccess().getTypeAssignment_2(), "rule__Instance__TypeAssignment_2");
					put(grammarAccess.getInstanceAccess().getActualsAssignment_3_1(), "rule__Instance__ActualsAssignment_3_1");
					put(grammarAccess.getInstanceAccess().getActualsAssignment_3_2_1(), "rule__Instance__ActualsAssignment_3_2_1");
				}
			};
		}
		return nameMappings.get(element);
	}

	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			InternalAppParser typedParser = (InternalAppParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public AppGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AppGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

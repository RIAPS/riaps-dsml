package edu.vanderbilt.riaps.generator.chariot;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import edu.vanderbilt.riaps.system.AppDeployment;
import edu.vanderbilt.riaps.system.ActorDeployment;
import edu.vanderbilt.riaps.system.ActorAssignment;

@SuppressWarnings("unused")
public class GoalDescription {

	@SerializedName("JavaClass")
	private String javaClass;
	private String name;
	
	private List<ReplicationConstraint> replicationConstraints;
	
	public GoalDescription(AppDeployment ad){
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.GoalDescription.DM_GoalDescription";
		this.name = ad.getApp().getName();
		this.replicationConstraints = new ArrayList<ReplicationConstraint>();
		
		for (ActorDeployment acd : ad.getActorDeployments()){
			for (ActorAssignment aa: acd.getActors()){
				ReplicationConstraint rc = new ReplicationConstraint(acd, aa);
				this.replicationConstraints.add(rc);
			}
		}
	}
}

package edu.vanderbilt.riaps.generator.chariot;

import java.util.List;
import java.util.ArrayList;

import com.google.gson.annotations.SerializedName;

import edu.vanderbilt.riaps.system.ActorDeployment;
import edu.vanderbilt.riaps.system.KnownNodes;
import edu.vanderbilt.riaps.system.ActorAssignment;
import edu.vanderbilt.riaps.system.Location;
import edu.vanderbilt.riaps.system.LocationNodeTypes;
import edu.vanderbilt.riaps.system.NodeType;
import edu.vanderbilt.riaps.system.LocationNodes;

@SuppressWarnings("unused")
public class ReplicationConstraint {
	@SerializedName("JavaClass")
	private String javaClass;
	private String functionality;
	private int maxInstances = 0;
	private int numInstances = 0;
	private int minInstances = 0;
	private List<String> nodeCategories;
	private String kind;
	
	public ReplicationConstraint(ActorDeployment ad, ActorAssignment aa){
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.GoalDescription.DM_ReplicationConstraint";
		this.functionality = aa.getActor().getName();
		this.nodeCategories = new ArrayList<String>();
		Location loc = ad.getLocation();
		
		if (loc instanceof LocationNodeTypes){
			LocationNodeTypes lnt = (LocationNodeTypes)loc;
			if (lnt.getUp() == 0){
				this.numInstances = lnt.getLb();
			} else {
				this.minInstances = lnt.getLb();
				this.maxInstances = lnt.getUp();
			}
			for (NodeType nt : lnt.getTarget()){
				this.nodeCategories.add(nt.getName());
			}
		} else if (loc instanceof LocationNodes){
			LocationNodes ln = (LocationNodes)loc;
			this.numInstances = 1;
			for (KnownNodes kn : ln.getHosts()){
				this.nodeCategories.add(kn.getName());
			}
		}
		
	}
	
}

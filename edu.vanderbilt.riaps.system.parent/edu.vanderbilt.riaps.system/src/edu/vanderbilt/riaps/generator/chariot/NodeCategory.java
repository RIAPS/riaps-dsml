package edu.vanderbilt.riaps.generator.chariot;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.ArrayList;

import edu.vanderbilt.riaps.system.NodeType;
import edu.vanderbilt.riaps.system.KnownNodes;

@SuppressWarnings("unused")
public class NodeCategory {
	
	@SerializedName("JavaClass")
	private String javaClass;
	private String name; 
	private List<NodeTemplate> nodeTemplates;
	
	public NodeCategory(String name, Iterable<NodeType> nts, Iterable<KnownNodes> kns){
		this.name = name;
		this.javaClass = "edu.vanderbilt.isis.chariot.datamodel.NodeCategory.DM_NodeCategory";
		this.nodeTemplates = new ArrayList<NodeTemplate>();
		
		for (NodeType nt : nts){
			NodeTemplate nodeTemplate = new NodeTemplate(nt);
			this.nodeTemplates.add(nodeTemplate);
		}
		
		for (KnownNodes kn : kns){
			NodeTemplate nodeTemplate = new NodeTemplate(kn);
			this.nodeTemplates.add(nodeTemplate);
		}
	}

}

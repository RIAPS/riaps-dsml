package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.ClntPort;
import edu.vanderbilt.riaps.app.SrvPort;
import edu.vanderbilt.riaps.app.ReqPort;

@SuppressWarnings("unused")
public class ClntSrvPort {

	private transient String name;
	private String req_type;
	private String rep_type;
	
	public ClntSrvPort(ClntPort p) {
		this.name = p.getName();
		this.req_type = p.getReq_type().getName();
		this.rep_type = p.getRep_type().getName();
	}

	public ClntSrvPort(SrvPort p) {
		this.name = p.getName();
		this.req_type = p.getReq_type().getName();
		this.rep_type = p.getRep_type().getName();
	}

	public ClntSrvPort(ReqPort p) {
		this.name = p.getName();
		this.req_type = p.getReq_type().getName();
		this.rep_type = p.getRep_type().getName();
	}
}

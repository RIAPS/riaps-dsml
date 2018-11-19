package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.AnswerPort
import java.util.concurrent.TimeUnit
import edu.vanderbilt.riaps.generator.AppGenerator

@SuppressWarnings("unused") class ClntSrvPort {
	transient String name
	String req_type
	String rep_type
	int deadline
	
	Boolean timed

	new(ClntPort p) {
		this.name = p.getName()

		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		this.timed = p.timed

	}

	new(SrvPort p) {
		this.name = p.getName()
		this.timed = p.timed
		this.deadline = 0
		if (p.deadline > 0) {
			this.deadline = AppGenerator.convert(p.deadline, p.unit)
		}
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()

	}

	new(AnswerPort p) {
		this.name = p.getName()
		this.deadline = 0
		if (p.deadline > 0) {
			this.deadline = AppGenerator.convert(p.deadline, p.unit)
		}
		this.timed = p.timed
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()

	}

	new(QueryPort p) {
		this.name = p.getName()
		this.deadline = 0
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.deadline > 0) {
			this.deadline = AppGenerator.convert(p.deadline, p.unit)
		}
		this.timed = p.timed
	}

	new(ReqPort p) {
		this.deadline = 0
		this.name = p.getName()
		this.deadline = p.getDeadline()
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.deadline > 0) {
			this.deadline = AppGenerator.convert(p.deadline, p.unit)
		}
		this.timed = p.timed
	}

	new(RepPort p) {
		this.deadline = 0
		this.name = p.getName()
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.deadline > 0) {
			this.deadline = AppGenerator.convert(p.deadline, p.unit)
		}
		this.timed = p.timed
	}
}

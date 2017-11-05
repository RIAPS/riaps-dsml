package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.RepPort

@SuppressWarnings("unused") class ClntSrvPort {
	transient String name
	String req_type
	String rep_type
	int deadline
	int upperlimit
	int lowerlimit

	new(ClntPort p) {
		this.name = p.getName()
		this.deadline = 0
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.getDeadline() !== null) {
			this.deadline = p.getDeadline().getDeadline()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNolower()) {
				this.lowerlimit = 0
			} else
				this.lowerlimit = p.getRatelimit().getLower()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNoupper()) {
				this.upperlimit = -1
			} else
				this.upperlimit = p.getRatelimit().getUpper()
		}
	}

	new(SrvPort p) {
		this.name = p.getName()
		this.deadline = 0
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNolower()) {
				this.lowerlimit = 0
			} else
				this.lowerlimit = p.getRatelimit().getLower()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNoupper()) {
				this.upperlimit = -1
			} else
				this.upperlimit = p.getRatelimit().getUpper()
		}
	}

	new(ReqPort p) {
		this.deadline = 0
		this.name = p.getName()
		if (p.getDeadline() !== null) {
			this.deadline = p.getDeadline().getDeadline()
		}
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNolower()) {
				this.lowerlimit = 0
			} else
				this.lowerlimit = p.getRatelimit().getLower()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNoupper()) {
				this.upperlimit = -1
			} else
				this.upperlimit = p.getRatelimit().getUpper()
		}
	}

	new(RepPort p) {
		this.deadline = 0
		this.name = p.getName()
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNolower()) {
				this.lowerlimit = 0
			} else
				this.lowerlimit = p.getRatelimit().getLower()
		}
		if (p.getRatelimit() !== null) {
			if (p.getRatelimit().isNoupper()) {
				this.upperlimit = -1
			} else
				this.upperlimit = p.getRatelimit().getUpper()
		}
	}
}

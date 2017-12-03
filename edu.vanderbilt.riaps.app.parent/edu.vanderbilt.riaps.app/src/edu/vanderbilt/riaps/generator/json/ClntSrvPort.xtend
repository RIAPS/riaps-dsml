package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.ClntPort
import edu.vanderbilt.riaps.app.SrvPort
import edu.vanderbilt.riaps.app.ReqPort
import edu.vanderbilt.riaps.app.RepPort
import edu.vanderbilt.riaps.app.QueryPort
import edu.vanderbilt.riaps.app.AnswerPort
import java.util.concurrent.TimeUnit
import edu.vanderbilt.riaps.app.DeadlineLimit

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
		this.deadline = p.getDeadline()
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

	def int getDeadline(ClntPort port) {
		if (port.deadlinelimit === null)
			return 0

		return getDeadline(port.deadlinelimit)
	}


	def int getDeadline(QueryPort port) {
		if (port.deadlinelimit === null)
			return 0

		return getDeadline(port.deadlinelimit)
	}

	def int getDeadline(ReqPort port) {
		if (port.deadlinelimit === null)
			return 0

		return getDeadline(port.deadlinelimit)
	}

	def int getDeadline(DeadlineLimit deadlinelimit) {
		var real_deadline_ms = 0
		if (deadlinelimit.units.milliseconds) {
			real_deadline_ms = deadlinelimit.deadline
			return real_deadline_ms
		} else if (deadlinelimit.units.seconds) {
			real_deadline_ms = deadlinelimit.deadline * 1000
			return real_deadline_ms
		} else
			(deadlinelimit.units.microseconds)
		{
			real_deadline_ms = deadlinelimit.deadline / 1000
			return real_deadline_ms
		}
	}

	new(AnswerPort p) {
		this.name = p.getName()
		this.deadline = 0
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
		//this.deadline = p.getDeadline()
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

	new(QueryPort p) {
		this.name = p.getName()
		this.deadline = 0
		this.req_type = p.getReq_type().getName()
		this.rep_type = p.getRep_type().getName()
	this.deadline = p.getDeadline()
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
		this.deadline = p.getDeadline()
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

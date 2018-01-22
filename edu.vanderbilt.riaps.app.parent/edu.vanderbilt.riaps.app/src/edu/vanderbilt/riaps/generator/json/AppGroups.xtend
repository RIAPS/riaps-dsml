package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.Group
import edu.vanderbilt.riaps.app.Leader
import edu.vanderbilt.riaps.app.Consensus
import java.util.List
import java.util.ArrayList

class AppGroups {
	Boolean leader = false
	Boolean consensus = false
	List<String> groupMessages = new ArrayList<String>()
	List<String> consensusMessages = new ArrayList<String>()

	new(Group group) {
		var u = group.useclauses
		if (u !== null) {
			var u1 = u.get(0)
			var pr = u1.property
			for (p : pr) {
				if (p instanceof Leader) {
					leader = true
				}
				if (p instanceof Consensus) {
					consensus = true
				}
			}
		}
		var gblocklist = group.gmessageblock
		if (gblocklist !== null) {
			if (gblocklist.size > 0) {
				var gblock = gblocklist.get(0)
				var gmessages = gblock.groupMessages
				if (gmessages !== null) {
					for (m : gmessages) {
						groupMessages.add(m.name)
					}

				}
				var cmessage = gblock.consensusMessages
				if (cmessage !== null) {
					for (m : cmessage) {
						consensusMessages.add(m.name)
					}
				}

			}

		}
	}

}

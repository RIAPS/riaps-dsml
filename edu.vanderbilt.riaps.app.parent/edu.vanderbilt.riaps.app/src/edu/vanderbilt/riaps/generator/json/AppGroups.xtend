package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.Group
import edu.vanderbilt.riaps.app.Leader
import edu.vanderbilt.riaps.app.Consensus

class AppGroups {
	Boolean leader = false
	Boolean consensus = false 
	

	new(Group group) {
		var properties = group.groupProperty
		for (x:properties)
		{
			if(x instanceof Leader)
			{
				leader = true
				
			}
			if(x instanceof Consensus)
			{
				consensus = true
				
			}
			
		}
	

	}

}

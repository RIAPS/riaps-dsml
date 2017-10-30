package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.PubPort;
import edu.vanderbilt.riaps.app.SubPort;

@SuppressWarnings("unused")
public class PubSubPort {

	private transient String name;
	private String type;
	private int upperlimit;
	private int lowerlimit;
	
	public PubSubPort(PubPort p) {
		this.name = p.getName();
		this.type = p.getType().getName();
		if (p.getRatelimit() != null)
		{
			if (p.getRatelimit().isNolower())
			{
				this.lowerlimit=0;
				
				
			}
			else
				this.lowerlimit=p.getRatelimit().getLower();
			
		}
		
		if (p.getRatelimit() != null)
		{
			if (p.getRatelimit().isNoupper())
			{
				this.upperlimit=-1;
			}
			else
				this.upperlimit=p.getRatelimit().getUpper();
			
		}
		
	}

	public PubSubPort(SubPort p) {
		this.name = p.getName();
		this.type = p.getType().getName();
	}
}

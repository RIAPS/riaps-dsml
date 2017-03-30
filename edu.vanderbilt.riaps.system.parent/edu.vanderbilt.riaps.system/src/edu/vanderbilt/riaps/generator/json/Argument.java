package edu.vanderbilt.riaps.generator.json;

import edu.vanderbilt.riaps.app.FormalDefault;
import edu.vanderbilt.riaps.app.StringDefault;
import edu.vanderbilt.riaps.app.BoolDefault;
import edu.vanderbilt.riaps.app.NumberDefault;

import edu.vanderbilt.riaps.system.ActorFormalAssignment;
import edu.vanderbilt.riaps.system.ActualValue;

@SuppressWarnings("unused")
public class Argument {

	private String name;
	private Object value;

	public Argument(ActorFormalAssignment afa) {
		this.name = afa.getArgName().getName();
		ActualValue av = afa.getArgValue();
		FormalDefault fd = afa.getArgName().getArgDefault();
		if (fd != null){
			if (fd instanceof StringDefault){
				this.value = av.getStringdefault().getValue();
			} else if (fd instanceof BoolDefault){
				this.value = new Boolean(av.getBoolDefault().getValue());
			} else if (fd instanceof NumberDefault){
				try {
					this.value = Integer.parseInt(av.getNumberdefault().getValue());
				} catch (Exception e){
					try {
						this.value = Double.parseDouble(av.getNumberdefault().getValue());
					} catch (Exception ex){}
				}
				
			}
		}
	}
	
}

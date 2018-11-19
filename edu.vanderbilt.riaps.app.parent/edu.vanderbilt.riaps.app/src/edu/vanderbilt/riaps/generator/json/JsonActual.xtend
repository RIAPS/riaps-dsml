package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.Actual

@SuppressWarnings("unused") class JsonActual {
	String name
	Object value
	Object param

	new(Actual a) {
		this.name = a.getArgName().getName()
		this.param=null
		if (a.getTringdefault() !== null) {
			this.value = a.getTringdefault().getValue() 
		} else if (a.getBoolDefault() !== null) {
			this.value = new Boolean(a.getBoolDefault().getValue())
		} else if (a.getNumberdefault() !== null) {
			try {
				this.value = Integer.parseInt(a.getNumberdefault().getValue())
			} catch (Exception e) {
				try {
					this.value = Double.parseDouble(a.getNumberdefault().getValue())
				} catch (Exception ex) {
				}

			}

		}else if(a.getArgValue!==null ){
			var actorarg=a.argValue
			this.value=null
			this.param=actorarg.name
		}
	}
}

package edu.vanderbilt.riaps.generator.json

import edu.vanderbilt.riaps.app.ComponentFormal
import edu.vanderbilt.riaps.app.ActorFormal
import edu.vanderbilt.riaps.app.FormalDefault
import edu.vanderbilt.riaps.app.StringDefault
import edu.vanderbilt.riaps.app.BoolDefault
import edu.vanderbilt.riaps.app.NumberDefault
import com.google.gson.annotations.SerializedName

@SuppressWarnings("unused") class Argument {
	String name
	@SerializedName("default") Object ^def

	new(ComponentFormal f) {
		this.name = f.getName()
		this.setDefault(f.getArgDefault())
	}

	new(ActorFormal f) {
		this.name = f.getName()
		this.setDefault(f.getArgDefault())
	}

	def private void setDefault(FormalDefault fd) {
		if (fd !== null) {
			if (fd instanceof StringDefault) {
				this.^def = fd.getValue()
			} else if (fd instanceof BoolDefault) {
				this.^def = new Boolean(fd.getValue())
			} else if (fd instanceof NumberDefault) {
				try {
					this.^def = Integer.parseInt(fd.getValue())
				} catch (Exception e) {
					try {
						this.^def = Double.parseDouble(fd.getValue())
					} catch (Exception ex) {
					}

				}

			}
		}
	}
}

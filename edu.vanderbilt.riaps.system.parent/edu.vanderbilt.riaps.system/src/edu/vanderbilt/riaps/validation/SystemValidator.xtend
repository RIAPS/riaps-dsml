/*
 * generated by Xtext 2.10.0
 */
package edu.vanderbilt.riaps.validation

import org.eclipse.xtext.validation.Check

import java.util.regex.Pattern
import edu.vanderbilt.riaps.system.SystemPackage
import edu.vanderbilt.riaps.system.NetworkInterface
import edu.vanderbilt.riaps.Console

/**
 * This class contains custom validation rules. 
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class SystemValidator extends AbstractSystemValidator {

	private static final Pattern PATTERN = Pattern.compile(
		"^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");

	@Check
	def checkCorrectAddress(NetworkInterface net) {
		val s = net.ip
		//Console.instance.log(java.util.logging.Level.INFO, "Ipaddress is " + s);
		//val isWhitespace = s.matches("^\\s*$");
		if (!PATTERN.matcher(s as String).matches)
			error('Address is not a valid IP Address',null)
//		if (isWhitespace) {
//			error('Ip Address cannot contain spaces',null)
//			Console.instance.log(java.util.logging.Level.INFO, "Ip Address cannot contain space");
//		}
	}

}

package edu.vanderbilt.riaps.generator;
import java.security.SecureRandom;
public class randomNumber {
	static Long Number(){
		SecureRandom random = new SecureRandom();
		long challenge = random.nextLong();
		long number = 1L <<63;	
		long result =number | challenge;	
		return result;
	}
}

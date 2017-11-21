package edu.vanderbilt.riaps.generator

import java.security.SecureRandom

class randomNumber {
	def static package Long Number() {
		var SecureRandom random = new SecureRandom()
		var long challenge = random.nextLong()
		var long number = 1L << 63
		var long result = number.bitwiseOr(challenge)
		return result
	}
}

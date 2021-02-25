package app;

import java.security.SecureRandom;

public class HashMain {

	public static void main(String[] args) {
		Cifrador.cifrar("MD5");
		Cifrador.cifrar("SHA-1");
		Cifrador.cifrar("SHA-224");
		Cifrador.cifrar("SHA-256");
		Cifrador.cifrar("SHA-384");
		Cifrador.cifrar("SHA-512");
	}

}

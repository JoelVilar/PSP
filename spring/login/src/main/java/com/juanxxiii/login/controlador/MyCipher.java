package com.juanxxiii.login.controlador;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class MyCipher {
	public static String getValueHashed(String value) {
		try {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[15];
			random.nextBytes(salt);
			MessageDigest cifrador = MessageDigest.getInstance("SHA-512");
			cifrador.update(salt);
			return new String(cifrador.digest(value.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "error";
	}
}

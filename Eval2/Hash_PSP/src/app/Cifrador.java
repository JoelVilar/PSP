package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Cifrador {
	public static void cifrar(String algoritmo) {

		String password = "contraseña1234";
		MessageDigest cifrador;
		try {
			cifrador = MessageDigest.getInstance(algoritmo);
			cifrador.update(password.getBytes());
			byte[] digest = cifrador.digest();
			System.out.println("CIFRADO CON " + algoritmo + ": " + Base64.getEncoder().encodeToString(digest));
			String filename = "heroes.json";
			cifrador.update(Files.readAllBytes(Paths.get(filename)));
			digest = cifrador.digest();
			System.out.println("CIFRADO JSON CON "
					+ algoritmo
					+ ": "
					+ Base64.getEncoder().encodeToString(digest));
		} catch (NoSuchAlgorithmException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

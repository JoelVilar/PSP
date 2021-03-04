package com.juanxxiii.login.controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.juanxxiii.login.entities.User;


public class UserService {
	private static UserService userService;
	private UserService(){
		
	}
	
	public static UserService getInstance() {
		if(userService == null) userService = new UserService();
		return userService;
	}
	
	
	public String login(User user) {
		BufferedReader reader = null;
		try {
			URL url = new URL("http://localhost:8081/user/login/" + user.getName());
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			System.out.println("Respuesta");
			int response = connection.getResponseCode();
			if(response == HttpsURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line= reader.readLine();
				return line;
			}else return "Usuario incorrecto";
		}catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "Error en la petición";
	}
}

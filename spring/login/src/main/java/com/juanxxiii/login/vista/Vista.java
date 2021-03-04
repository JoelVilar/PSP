package com.juanxxiii.login.vista;

import java.util.Scanner;

import com.juanxxiii.login.controlador.MyCipher;
import com.juanxxiii.login.controlador.UserService;
import com.juanxxiii.login.entities.User;

public class Vista {
	public static void menu() {
		Scanner keyB = new Scanner(System.in);
		int option;
		do {
			System.out.println("Bienvenido, que desea hacer");
			System.out.println("1.Iniciar sesión.");
			System.out.println("2.Registrarse");
			System.out.println("0.Salir");
			option = keyB.nextInt();
			switch(option) {
			case 1:
				login(keyB);
				break;
			case 2:
				break;
			case 0:
				break;
			}
		}while(option!=0);
	}
	
	public static void login(Scanner keyB) {
		keyB.nextLine();
		System.out.println("Introduzca un nombre de usuario:");
		String name = keyB.nextLine();
		System.out.println("Introduzca una contraseña");
		String password = keyB.nextLine();
		User newUser = new User(name, MyCipher.getValueHashed(password));
		UserService.getInstance().login(newUser);
	}
}

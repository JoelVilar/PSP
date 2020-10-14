package vista;

import java.util.Scanner;


public class Menu {
	public void showMenu() {
		System.out.println("Calculadora de números primos del 1 al 100000 por hilos.");
		Scanner keyB;
		int option;
		do {
			System.out.println("\t1.Introduzca el número de hilos que desea utilizar."
					+ "\n\t0.Salir.");
			keyB = new Scanner(System.in);
			switch(option=keyB.nextInt()) {
			case 1:
				new UserThreads().howMany();
				break;
			case 0:
				System.out.println("Adiós.");
				break;
			default:
				System.out.println("Valor incorrecto, repita opción.");
				break;
			}
		}while(option!=0);
		keyB.close();
	}
}

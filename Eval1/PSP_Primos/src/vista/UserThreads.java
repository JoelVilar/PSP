package vista;

import java.util.Scanner;

import controlador.PrimesByThreads;

public class UserThreads {
	public void howMany() {
		System.out.print("En cuantos hilos deseas trabajar: ");
		Scanner keyB = new Scanner(System.in);
		int numOfThreads = keyB.nextInt();
		PrimesByThreads p = new PrimesByThreads();
		try {
			p.run(numOfThreads);
		} catch(InterruptedException e){
			System.out.println(e.getMessage());
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import modelos.Lector;

public class ClientTCPMain {
	
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader reader = null;
		Scanner keyB = null;
		try{
			socket = new Socket("localhost", 3306);
			String message;
			PrintWriter writer = new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(
										new InputStreamReader(
												socket.getInputStream()));
			keyB = new Scanner(System.in);
			Lector lector = new Lector(reader);
			lector.start();
			do {
				System.out.println("Escriba un mensaje:");
				message = keyB.nextLine();
				Arrays.stream(message.split(" ")).forEach(data -> {
					System.out.println("Envio: " + data);
					writer.println(data);
					try {
						TimeUnit.MILLISECONDS.sleep(100);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
				});
			}while(!message.equals("exit"));
			lector.join();
			writer.close();
		} catch (UnknownHostException | InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
				reader.close();
				keyB.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

package controlador;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Cliente;

public class ServidorChat {
	public void launchServer() {
		System.out.println("Iniciando conexión...");
		try(ServerSocket serverSocket = new ServerSocket(3306)){
			Socket socket;
			while(true) {
				socket = serverSocket.accept();
				new Cliente(socket).start();
			}
		}catch(IOException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
	}
}

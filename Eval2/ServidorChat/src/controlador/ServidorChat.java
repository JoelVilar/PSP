package controlador;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;

import modelos.Cliente;

public class ServidorChat {
	public void launchServer() {
		System.out.println("Iniciando conexión...");
		try(ServerSocket serverSocket = new ServerSocket(3306)){
			Socket socket;
			while(true) {
				socket = serverSocket.accept();
				System.out.println("Cliente conectado");
				new Cliente(socket).start();
			}
		}catch(IOException e) {
			System.err.println("Error con el cliente. Causa: " + e.getMessage());
		}
		System.out.println("Fin del programa.");
	}
}

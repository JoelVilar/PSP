import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import modelos.Cliente;

public abstract class ServerTCPMain {

	public static void main(String[] args) {
		System.out.println("LEVANTANDO SERVER");
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(3306);
			Socket socket;
			Cliente cliente;
			while(true) {
				socket = serverSocket.accept();
				cliente = new Cliente(socket);
				cliente.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}

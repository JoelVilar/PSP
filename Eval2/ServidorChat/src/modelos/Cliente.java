package modelos;

import java.io.IOException;
import java.net.Socket;

public class Cliente extends Thread{
	private Socket socket;

	public Cliente(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(ServerComunication comunication = new ServerComunication(socket)){
			ChatMessage data;
			while((data = (ChatMessage) comunication.getReader().readObject())!=null) {
				comunication.getWriter().writeObject(data);
				System.out.println(data.getMessage());
			}
		}catch(IOException | ClassNotFoundException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}

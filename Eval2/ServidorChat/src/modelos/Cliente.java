package modelos;

import java.io.IOException;
import java.net.Socket;

import org.json.JSONObject;

public class Cliente extends Thread{
	private Socket socket;

	public Cliente(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		try(ServerComunication comunication = new ServerComunication(socket)){
			String data;
			JSONObject message;
			while((data = comunication.getReader().readLine())!=null) {
				comunication.getWriter().println(data);
				System.out.println(data);
			}
		}catch(IOException e) {
			System.err.println("Error en el envío. Causa: " + e.getMessage());
		}
	}
	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}

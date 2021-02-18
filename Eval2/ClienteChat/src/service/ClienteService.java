package service;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import vista.ChatFrame;

public class ClienteService {
	private ClienteService service;
	
	private ClienteService() {
		
	}
	
	public ClienteService getInstance() {
		if(service==null) {
			service = new ClienteService();
		}
		return service;
	}
	
	public void launchClient() {
		try (Socket socket = new Socket("localhost",3306)){
		}catch (UnknownHostException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
		
	}
}

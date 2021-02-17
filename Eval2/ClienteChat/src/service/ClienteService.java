package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
		BufferedReader reader = null;
		try (Socket socket = new Socket("localhost",3306)){
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//startChatting(writer);
			
			writer.close();
		}catch (UnknownHostException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
		
	}
}

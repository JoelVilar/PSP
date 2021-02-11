package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

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
		Socket socket=null;
		ObjectInputStream reader = null;
		Scanner keyB = null;
		try {
			socket = new Socket("localhost",3306);
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			//startChatting(writer);
			writer.close();
		}catch (UnknownHostException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
		
	}
}

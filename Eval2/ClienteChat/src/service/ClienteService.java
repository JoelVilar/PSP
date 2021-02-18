package service;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.json.JSONObject;

import vista.ChatFrame;

public class ClienteService implements Closeable{
	private static ClienteService service;
	private PrintWriter writer;
	private BufferedReader reader;
	private Socket socket;
	
	
	private ClienteService() {
		
	}
	
	public static ClienteService getInstance() {
		if(service==null) {
			service = new ClienteService();
		}
		return service;
	}

	public void launchClient() {
		System.out.print("Introduzca la dirección ip o dominio con el que quiere comunicar: ");
		
		
		try (Scanner keyB = new Scanner(System.in)){
			String address = keyB.nextLine();
			socket = new Socket(address,3306);
			writer=new PrintWriter(socket.getOutputStream(),true);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			ChatFrame.launchFrame();
		}catch (UnknownHostException e) {
			System.err.println("Error en el servicio del cliente. Causa: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error en el servicio del cliente. Causa: " + e.getMessage());
		}
	}
	
	public void sendMessage(JSONObject chatData) {
			writer.println(chatData);
	}
	
	@Override
	public void close() throws IOException {
		try {
			socket.close();
			
		}catch(IOException e) {
			System.err.println("Error al cerrar el socket. Causa: " + e.getMessage());
		}
		writer.close();
		try {
			reader.close();
		}catch(IOException e) {
			System.err.println("Error al cerrar el flujo de entrada. Causa: " + e.getMessage());
		}
	}

	public static ClienteService getService() {
		return service;
	}

	public static void setService(ClienteService service) {
		ClienteService.service = service;
	}


	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}

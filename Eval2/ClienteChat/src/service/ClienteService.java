package service;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import modelos.ChatMessage;
import vista.ChatFrame;

public class ClienteService implements Closeable{
	private static ClienteService service;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
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
		try {
			socket = new Socket("localhost",3306);
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
			ChatFrame.launchFrame();
		}catch (UnknownHostException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}catch(IOException e) {
			System.err.println("Error. Causa: " + e.getMessage());
		}
	}
	
	public void sendMessage(ChatMessage chatData) {
		try {
			writer.writeObject(chatData);
		} catch (IOException e) {
			System.err.println("Error de envío. Causa: " + e.getMessage());
		}
	}
	
	@Override
	public void close() throws IOException {
		try {
			socket.close();
		}catch(IOException e) {
			System.err.println("Error al cerrar el socket. Causa: " + e.getMessage());
		}
		try {
			writer.close();
		}catch(IOException e) {
			System.err.println("Error al cerrar el flujo de salida. Causa: " + e.getMessage());
		}
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

	public ObjectOutputStream getWriter() {
		return writer;
	}

	public void setWriter(ObjectOutputStream writer) {
		this.writer = writer;
	}

	public ObjectInputStream getReader() {
		return reader;
	}

	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}
}

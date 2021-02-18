package modelos;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerComunication implements Closeable{
	private Socket socket;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	
	public ServerComunication(Socket socket) throws IOException{
		this.reader = new ObjectInputStream(socket.getInputStream());
		this.writer = new ObjectOutputStream(socket.getOutputStream());
	}

	@Override
	public void close() throws IOException {
		try {
			reader.close();
		}catch(IOException e) {
			System.err.println("Error al cerrar el lector, causa: " + e.getMessage());
		}
		writer.close();
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ObjectInputStream getReader() {
		return reader;
	}

	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}

	public ObjectOutputStream getWriter() {
		return writer;
	}

	public void setWriter(ObjectOutputStream writer) {
		this.writer = writer;
	}
	
}

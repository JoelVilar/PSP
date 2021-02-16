package modelos;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerComunication implements Closeable{
	private Socket socket;
	private BufferedReader reader;
	private PrintWriter writer;
	
	public ServerComunication(Socket socket) throws IOException{
		this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		this.writer = new PrintWriter(socket.getOutputStream(), true);
	}

	public BufferedReader getReader() {
		return reader;
	}

	public void setReader(BufferedReader reader) {
		this.reader = reader;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	public void setWriter(PrintWriter writer) {
		this.writer = writer;
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
}

package modelos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Cliente extends Thread{
	private Socket socket;
	
	public Cliente(Socket cliente) {
		super();
		this.socket = cliente;
	}


	@Override
	public void run() {
		BufferedReader reader = null;
		PrintWriter writer = null;
		try {	
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(),true);
			String data;
			while(!(data = reader.readLine().toUpperCase()).equals("exit")) {
				writer.println(data);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				writer.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

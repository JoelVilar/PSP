package modelos;

import java.io.BufferedReader;
import java.io.IOException;

public class Lector extends Thread{
	private BufferedReader reader;
	private String word;
	
	public Lector(BufferedReader reader) {
		super();
		this.reader = reader;
	}

	@Override
	public void run() {
		try {
			while((word=reader.readLine())!=null) {
				System.out.println("Recibido: " + word);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

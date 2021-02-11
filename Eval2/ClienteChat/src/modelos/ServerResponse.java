package modelos;

import java.io.IOException;
import java.io.ObjectInputStream;

public class ServerResponse extends Thread{
	private ObjectInputStream reader;
	private String userName;

	public ServerResponse() {
	}

	public ServerResponse(ObjectInputStream reader, String userName) {
		super();
		this.userName = userName;
		this.reader = reader;
	}

	@Override
	public void run() {
		ChatMessage response;
		try {
			while((response =(ChatMessage) reader.readObject())!=null) {
				if(response.getUserName().equals(userName)) {
					//DataToBePrinted
				}
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error en la lectura de respuesta del servidor. Causa: "
					+ e.getMessage());
		}finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el lector del servidor. Causa: "
						+ e.getMessage());
			}
		}
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ObjectInputStream getReader() {
		return reader;
	}

	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}
	
}

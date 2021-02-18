package modelos;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.table.DefaultTableModel;

import service.ClienteService;

public class ServerResponse extends Thread{
	private ObjectInputStream reader;
	private DefaultTableModel tableModel;

	public ServerResponse() {
	}

	public ServerResponse(ObjectInputStream reader, DefaultTableModel tableModel) {
		super();
		this.tableModel=tableModel;
		this.reader = reader;
	}

	@Override
	public void run() {
		ChatMessage response;
		try {
			while((response =(ChatMessage) reader.readObject())!=null) {
				tableModel.addRow(new Object[] {response.getUserName() + ": " + response.getMessage()});
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error en la lectura de respuesta del servidor. Causa: "
					+ e.getMessage());
		}finally {
			try {
				System.out.println("Cierre del servicio.");
				ClienteService.getInstance().close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public ObjectInputStream getReader() {
		return reader;
	}

	public void setReader(ObjectInputStream reader) {
		this.reader = reader;
	}
	
}

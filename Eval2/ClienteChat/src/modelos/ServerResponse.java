package modelos;

import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.table.DefaultTableModel;

import service.ClienteService;
import vista.ChatPanel;

public class ServerResponse extends Thread{
	private DefaultTableModel tableModel;

	public ServerResponse() {
	}

	public ServerResponse(DefaultTableModel tableModelGiven) {
		super();
		tableModel=tableModelGiven;
	}

	@Override
	public void run() {
		ChatMessage response;
		try (ClienteService service = ClienteService.getInstance()){
			while((response =(ChatMessage) service.getReader().readObject())!=null) {
				tableModel.addRow(new Object[] {response.getUserName()
												+ " ("
												+ response.getTime()
												+ "): " + response.getMessage()});
			}
		} catch (ClassNotFoundException | IOException e) {
			System.err.println("Error en la lectura de respuesta del servidor. Causa: "
					+ e.getMessage());
		}
	}
	
}

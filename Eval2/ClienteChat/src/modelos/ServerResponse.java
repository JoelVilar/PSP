package modelos;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.table.DefaultTableModel;

import org.json.JSONObject;

import service.ClienteService;

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
		String response;
		JSONObject json;
		try (ClienteService service = ClienteService.getInstance()){
			while((response = service.getReader().readLine())!=null) {
				json = new JSONObject(response);
				
				tableModel.addRow(new Object[] {json.get("username")
												+ " ("
												+ json.get("time")
												+ "): "
												+ json.get("message")});
			}
		} catch (IOException e) {
			System.err.println("Error en la lectura de respuesta del servidor. Causa: "
					+ e.getMessage());
		}
	}
	
}

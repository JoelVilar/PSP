import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import modelos.Cliente;

public class UDPServerMain {

	public static void main(String[] args) {
		DatagramSocket datagram = null;
		
		byte[] receive=new byte[65535];
		
		DatagramPacket datagramPacket;
		try {
			datagram = new DatagramSocket(3306);
			
			datagramPacket = new DatagramPacket(receive, receive.length);
					
			datagram.receive(datagramPacket);
			ByteArrayInputStream bytesToObject = new ByteArrayInputStream(receive);
			ObjectInputStream reader = new ObjectInputStream(bytesToObject);
			Cliente cliente = (Cliente) reader.readObject();
			System.out.println("El nombre del objeto es " + cliente.getName());
			
		} catch (SocketException |ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			datagram.close();
		}
		receive = new byte[65535];
	}

}

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import modelos.Cliente;

public class UDPClienteMain {

	public static void main(String[] args) {

		DatagramSocket dataSocket = null;
		InetAddress address = null;
		try {
			dataSocket= new DatagramSocket();
			address = InetAddress.getLocalHost();
			System.out.println("Escribe *");
			
			Scanner scanner = new Scanner(System.in);
			byte buffer[];
			System.out.println("Escriba id");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Escriba Nombre");
			String name = scanner.nextLine();
			Cliente data = new Cliente(id,name); 
			scanner.close();
			ByteArrayOutputStream objectToBytes = new ByteArrayOutputStream();
			ObjectOutputStream writer = new ObjectOutputStream(objectToBytes);
			writer.writeObject(data);
			writer.flush();
			buffer = objectToBytes.toByteArray();
			
			DatagramPacket dataPacket = new DatagramPacket(buffer,buffer.length, address,3306);
			if(dataPacket!=null) dataSocket.send(dataPacket);
		}catch(SocketException | UnknownHostException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			dataSocket.close();
		}
	}

}

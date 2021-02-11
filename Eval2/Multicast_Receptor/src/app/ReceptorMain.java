package app;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ReceptorMain {

	public static void main(String[] args) {
		try (MulticastSocket multi = new MulticastSocket(12345)){
			InetAddress address = InetAddress.getByName("127.0.0.1");
			multi.joinGroup(address);
			String text = "";
			byte[] buffer = new byte[1024];
			System.out.println("WAITING");
			while(!text.trim().equals("*")) {
				DatagramPacket datagram = new DatagramPacket(buffer, buffer.length);
				multi.receive(datagram);
				text = new String(datagram.getData());
				System.out.println("Mensaje recibido:");
			}
			multi.leaveGroup(address);
		}catch (UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}

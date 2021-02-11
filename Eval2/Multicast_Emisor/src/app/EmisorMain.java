package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;


public class EmisorMain {

	public static void main(String[] args) {
		BufferedReader terminalInput = new BufferedReader(new InputStreamReader(System.in));
		MulticastSocket multi=null;
		try {
			multi = new MulticastSocket();
			InetAddress address;
			address = InetAddress.getByName("224.0.0.251");
			String text = "";
			while(!text.trim().equals("*")){
				System.out.println("Mensaje para difusion: ");
				text = terminalInput.readLine();
				DatagramPacket datagram = new DatagramPacket(text.getBytes(), text.length(),address,12345);
				multi.send(datagram);
			} 
		
		}catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			multi.close();
		}
		System.out.println("socket closed");
	}

}

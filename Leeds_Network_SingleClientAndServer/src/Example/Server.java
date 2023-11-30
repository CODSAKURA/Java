package Example;

import java.net.*;
import java.io.*;

public class Server{
	private static String[] quotes = {"Quote1","Quote2","Quote3"};
			
	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(8787);
		
		while(true) {
		DatagramPacket rPack =new DatagramPacket(new byte[10],10);
		socket.receive(rPack);
		
		String quote = quotes[(int)(Math.random()*quotes.length)];
		DatagramPacket sPack= new DatagramPacket(quote.getBytes(), quote.length(), rPack.getAddress(), rPack.getPort());
		socket.send(sPack);

		}
	}
}
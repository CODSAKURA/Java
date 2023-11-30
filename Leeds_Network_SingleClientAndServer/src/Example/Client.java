package Example;

import java.net.*;
import java.io.*;

public class Client {
	private static int rSize = 1000;

	public static void main(String[] args) throws IOException, InterruptedException {
		InetAddress serverAddr = InetAddress.getLocalHost();
		DatagramSocket socket = new DatagramSocket();
		
		DatagramPacket sPack = new DatagramPacket(new byte[0],0,serverAddr,8787);
		
		socket.send(sPack);
		
		DatagramPacket rPack = new DatagramPacket( new byte[rSize],rSize);
		
		socket.receive(rPack);
		
		long start_time = System.nanoTime();
		Thread.sleep(4000);
		long end_time = System.nanoTime();
		double difference = (end_time - start_time) / 1e6;
				
		if(difference > 5000)
		{
			System.out.println("Error");
		}
		else if(rPack.getAddress().equals(serverAddr))
		{
			System.out.println(new String(rPack.getData(),"UTF-8"));
		}
	}

}

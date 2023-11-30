package Compareipv4;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Compareipv4 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress a = InetAddress.getByName("129.11.1.17");
		InetAddress b = InetAddress.getByName("129.11.1.17"); 
		
		if(a.getHostAddress().equals(b.getHostAddress()) == true)
		{
			System.out.println( "Common IP Address :" + a.getHostAddress() );
		}
		else
		{
			String[] aa = a.getHostAddress().split("[.]");
			String[] bb = b.getHostAddress().split("[.]");
			
			if(aa[0].equals(bb[0]) && aa[1].equals(bb[1]) && aa[2].equals(bb[2]))
			{
				System.out.print("Common IP Address: " +aa[0] + "." + aa[1] + "." + aa[2] + ".*");
			}
			else if(aa[0].equals(bb[0]) && aa[1].equals(bb[1]))
			{
				System.out.print("Common IP Address: " +aa[0] + "." + aa[1] + ".*.*");
			}
			else if(aa[0].equals(bb[0]))
			{
				System.out.print("Common IP Address: " +aa[0] + ".*.*.*");
			}
			else
			{
				System.out.print("Common IP Address: *.*.*.*");
			}
		}
	}

}

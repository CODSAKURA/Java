package Q1_Answer;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Q1_Answer_i {

	private InetAddress[] addr;

	// return multiple IP address
	public void resolve(String host) {
		try {
			addr = InetAddress.getAllByName(host);
			System.out.println( "Host name : " + host);
			
		    for (int i=0;i<addr.length;i++)
		    {
		    	System.out.println( "IP Address: " + addr[i]);
		    }
		    
			System.out.println("");
		}
		catch( UnknownHostException e ){ 	
			System.out.println( "Host name : " + host);
			System.out.println("No such host");
		}
	}

	public static void main( String[] args ) {
		Q1_Answer_i lookup = new Q1_Answer_i();
		for(int i = 0 ; i < args.length ; i++)
		{
			lookup.resolve( args[i] );	
		}
	}
}

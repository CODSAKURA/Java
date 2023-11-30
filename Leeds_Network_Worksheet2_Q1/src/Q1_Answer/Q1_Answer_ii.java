package Q1_Answer;

import java.io.*; 
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Q1_Answer_ii {

	private InetAddress[] addr = null;

	// return multiple IP address
	public void resolve(String host) throws IOException {
		
		try 
		{
			addr = InetAddress.getAllByName(host);
			System.out.println( "Host name : " + host );
		    
			for (int i=0;i<addr.length;i++)
		    {
		    	System.out.println( "IP Address: " + addr[i]);
		    	
		    	//200 is a maximum of timeOut milliseconds that wait(it could be any time)
		    	if (addr[i].isReachable(50))
		    	{
		    	   System.out.println("Host is reachable"); 
		    	}
		    	else
		    	{
		    		System.out.println("Sorry ! We can't reach to this host"); 
		    
		    	}
		    }
			
			System.out.println("");
		}
		
		catch( UnknownHostException e ){ 	
			System.out.println( "Host name : " + host);
			System.out.println("No such host");
		}
		
	}
	

	public static void main( String[] args ) throws IOException {
		Q1_Answer_ii lookup = new Q1_Answer_ii();
		
		for(int i = 0 ; i < args.length ; i++)
		{
			lookup.resolve( args[i] );	
		}
		
	}
	
}
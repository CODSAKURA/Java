package InetAddress_Example;

//
//Very simple class that uses java.net.InetAddress to convert a hostname to an IP address.
//Compile as usual (i.e. javac Lookup.java), then run with:
//
//java Lookup <hostname>
//
//... and you should get the IP address, or an error message. There are various ways
//of improving on this, such as checking the user provided a hostname, and perhaps
//looping over multiple hostnames if more than one was provided.
//

import java.net.*;								// For InetAddress and UnknownHostException.

public class InetAddress_Example {

	private InetAddress inet = null;

	public void resolve(String host) {
		try {
			// Try to create an instance of InetAddress using the factory method (public static).
			// If fails, may throw an instance of UnknownHostException.
			inet = InetAddress.getByName( host );

			// Use two getter methods to print the results. Can also just print the object itself (which combines both).
			System.out.println( "Host name : " + inet.getHostName   () );
			System.out.println( "IP Address: " + inet.getHostAddress() );
			System.out.println("");
		}
		catch( UnknownHostException e ){ 		// If an exception was thrown, echo to stdout.
			System.out.println( "Host name : " + inet.getHostName   () );
			System.out.println("No such host");
		}
	}

	public static void main( String[] args ) {
		InetAddress_Example lookup = new InetAddress_Example();
		for(int i = 0 ; i < args.length ; i++)
		{
			lookup.resolve( args[i] );				// The first command line argument is args[0].
		}
	}
}



package Coursework1;
/*
 * This class is to get the iP address from a host name and identify 
 * the IP address on either it is ipv4 or ipv6 address.
 * Also Output the highest levels of the hierarchy shared by two host names. 
 */
import java.net.*;
import java.io.IOException;

public class Coursework1 {

	private InetAddress inet = null;
	private InetAddress inet1 = null;
	private InetAddress inet2 = null;
	
	//Those two counts are used to check whether two IP address of their host names are both ipv4 or ipv6
	private static int countIpv4 = 0;		
	private static int countIpv6 = 0;
	
	//Those two array used to store the octets of both two IP address
	private String[] arrayInet1 = null;
	private String[] arrayInet2 = null;

	// This method is use for only one input in command line
	public void resolveOneArgument(String host) {
		try {
			//create an instance of InetAddress
			inet = InetAddress.getByName( host );

			System.out.println( "Host name : " + inet.getHostName   () );
			System.out.println( "IP Address: " + inet.getHostAddress() );
			
			//Check the IP address is either ipv4 or ipv6
			if(inet.getHostAddress().contains("."))
			{
				System.out.println("It is an IPV4 address");
			}
			else if (inet.getHostAddress().contains(":"))
			{
				System.out.println("It is an IPV6 address");
			}
			
		}
		catch( UnknownHostException e ){		// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}
	
	//This method is use for two inputs in command line
	public void resolveTwoArgument(String host) {
		try {
			
			inet = InetAddress.getByName( host );
			
			//count either both are ipv4 or both are ipv6 or one is ipv4 or one is ipv6
			if(inet.getHostAddress().contains("."))
			{
				countIpv4++;
			}
			else if (inet.getHostAddress().contains(":"))
			{
				countIpv6++;
			}
			
		}
		catch( UnknownHostException e ){		// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}
	
	/*This method is used to compare two IP addresses from their host names and 
	* output the highest levels of the hierarchy shared by them both.
	*/
	public void compareTwoIpAddresses(String host1 , String host2)
	{
		try
		{
			inet1 = InetAddress.getByName(host1);
			inet2 = InetAddress.getByName(host2);
			
			//If they are equal, Output the common full IP address
			if(inet1.getHostAddress().equals(inet2.getHostAddress()) == true)
			{
				System.out.println( "Highest levels of the hierarchy shared by them both :" 
						+ inet1.getHostAddress() );
			}
			else
			{
				//store the string array after split dots on both IP addresses
				arrayInet1 = inet1.getHostAddress().split("[.]");
				arrayInet2 = inet2.getHostAddress().split("[.]");
				
				//Output the Highest levels of the hierarchy in four different conditions
				if(arrayInet1[0].equals(arrayInet2[0]) && arrayInet1[1].equals(arrayInet2[1]) 
						&& arrayInet1[2].equals(arrayInet2[2]))
				{
					System.out.println("Highest levels of the hierarchy shared by them both: " 
							+arrayInet1[0] + "." + arrayInet1[1] + "." + arrayInet1[2] + ".*");
				}
				else if(arrayInet1[0].equals(arrayInet2[0]) && arrayInet1[1].equals(arrayInet2[1]))
				{
					System.out.println("Highest levels of the hierarchy shared by them both: " 
							+arrayInet1[0] + "." + arrayInet1[1] + ".*.*");
				}
				else if(arrayInet1[0].equals(arrayInet2[0]))
				{
					System.out.println("Highest levels of the hierarchy shared by them both: " 
							+arrayInet1[0] + ".*.*.*");
				}
				else
				{
					System.out.println("Highest levels of the hierarchy shared by them both: "
							+	"*.*.*.*");
				}
			}
		}
		catch( UnknownHostException e ){			// If an exception was thrown, echo to stdout.
			e.printStackTrace();
		}
	}

	//Main Entry
	public static void main( String[] args ) throws IOException{
		
		Coursework1 testArgus = new Coursework1();
		
		if(args.length == 1)
		{
			testArgus.resolveOneArgument(args[0]);			// The first command line argument is args[0].
		}
		else if(args.length == 2)
		{
			testArgus.resolveTwoArgument(args[0]);			// The first command line argument is args[0].
			testArgus.resolveTwoArgument(args[1]);			// The first command line argument is args[1].
			
			//Test both IP addresses if both are not IPV4 throw exception
			if(countIpv6 == 0 && countIpv4 == 2 )
			{
				testArgus.compareTwoIpAddresses(args[0], args[1]);
			}
			else if(countIpv6 == 1 && countIpv4 == 1)
			{
				//handling one of the arguments is IPv6
				System.out.println("One of the addresses are not IPV4 addresses");
			}
			else if(countIpv6 == 2 && countIpv4 == 0)
			{
				// handling both two arguments are IPV6
				System.out.println("Both of the addresses are not IPV4 addresses");
			}
		}
		else
		{
			// handling the error of arguments
			System.out.println("The command line must have one or two arguments.");
		}
	}	
}
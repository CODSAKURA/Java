/*
 * This class is the client class that will 
 * connect to the server.
 */
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client 
{	
	private static Socket sock = null;
	
	//Using to test whether the server has been launching or not
	//If the server does not launch then the client can not do anything
	private static boolean testConnect = false; 
	
	//Constructor of the Client Class
	public Client()
	{
	    try 
	    {
	    	
	    	sock = new Socket( "localhost", 8989 );
	    	testConnect = true;
	    	
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e);
	    }
	    
	}
	
	public void connect(String argument)
	{
		try 
		{
			//Getting the input string
			InputStream stream = new ByteArrayInputStream(argument.getBytes(StandardCharsets.UTF_8));
			BufferedReader keyRead = new BufferedReader(new InputStreamReader(stream));
			String inputString = keyRead.readLine();
		          
			//Sending the string to server
			OutputStream  ostream = sock.getOutputStream( );
			PrintWriter pwrite = new PrintWriter(ostream, true);
			pwrite.println(inputString);
		         
			//Receiving the content from server
			InputStream istream = sock.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(istream));				
			
			//Reading line-by-line
			String str;
			while((str = reader.readLine())  !=  null)  
			{ 
				System.out.println(str);          
			}

			//Closing the connection
			reader.close();
			keyRead.close();
			pwrite.close();
			sock.close();
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	//Sending Empty String to Server as the client inputs wrong command line
	public void sendEmptyToServer()
	{
		try 
		{
			
			//Sending empty string to server.
			OutputStream  ostream = sock.getOutputStream( );
			PrintWriter pwrite = new PrintWriter(ostream, true);
			pwrite.println("");            
			sock.close();	
			
		}
		catch(IOException e)
		{
			System.out.println(e);
		}			
	}
	 			 
	public static void main(String[] args)
	{
		//Testing whether the server is launching or not
		Client test = new Client();
		
		if(testConnect == true)
		{
			if( args.length == 0)
			{
				System.err.println( "Need command line argument: list/get [filename]. Try again...." );
				test.sendEmptyToServer();
				return;
			}				 
			else if( args.length == 1)
			{
				if(args[0].equals("list") == true)
				{
					test.connect(args[0]);
					return;
				} 
				System.err.println( "One argument correct but not 'list'. Try again.... " );
				test.sendEmptyToServer();
				return;
			}		 
			else if( args.length == 2)
			{
				if(args[0].equals("get") == true)
				{
					if(args[1].contains(".txt"))
					{
						test.connect(args[1]);
						return;
					}
					else
					{
						System.err.println( args[1]+": Only text file can be transferred. Try again...." );
						test.sendEmptyToServer();
						return;
					}
				}
				System.err.println( "Two arguments correct but not 'get [filename]'. Try again.... " );
				test.sendEmptyToServer();
				return;
			}		 				 
			else 
			{
				System.err.println( "I said one or two arguments. Try again.... " );
				test.sendEmptyToServer();
				return;
			}
		}
	}
}
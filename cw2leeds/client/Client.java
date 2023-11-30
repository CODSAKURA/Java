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
	
	//Constructor of the Client Class
	public Client()
	{
	    try 
	    {	    	
	    	sock = new Socket( "localhost", 8989 );
	    	
	    }
	    catch(IOException e)
	    {
	    	System.out.println(e);
	    }
	    
	}
	
	public void connect(String[] argument)
	{
		try 
		{
			//Separate Two different situation whether the command line argument is empty or not.
			if(argument.length == 0)
			{
				//If empty command line then empty string send to server
				String actualString = " ";
				
				//Getting the input string
				InputStream stream = new ByteArrayInputStream(actualString.getBytes(StandardCharsets.UTF_8));
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
			else
			{
				//Not change the format of command line argument
				StringBuilder builder = new StringBuilder();
				for(String s : argument) {
				    builder.append(s);
				    builder.append(" ");
				}
				String actualString = builder.toString();
				
				//Getting the input string
				InputStream stream = new ByteArrayInputStream(actualString.getBytes(StandardCharsets.UTF_8));
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
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}	
	 			 
	public static void main(String[] args)
	{
		Client test = new Client();
		test.connect(args);
	}
}
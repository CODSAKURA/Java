import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Client 
{
	
	private static Socket s = null;
	private static String hostname = "localhost";
	private static boolean testconnect = false;
	
	public Client(){
	    try {
	    	s = new Socket( hostname, 8989 );
	    	testconnect = true;
	    }catch(IOException e)
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
			String fname = keyRead.readLine();
		          
			//Sending the string to server
			OutputStream  ostream = s.getOutputStream( );
			PrintWriter pwrite = new PrintWriter(ostream, true);
			pwrite.println(fname);
		         
			//Receiving the content from server
			InputStream istream = s.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(istream));				
			String str;
			while((str = reader.readLine())  !=  null) // reading line-by-line 
			{ 
				System.out.println(str);          
			}

			//Closing the connection
			reader.close();
			keyRead.close();
			pwrite.close();
			s.close();
			
		}catch(IOException e)
		{
			System.out.println(e);
		}
//		//getting the input string
//		InputStream stream = new ByteArrayInputStream(args[0].getBytes(StandardCharsets.UTF_8));
//		BufferedReader keyRead = new BufferedReader(new InputStreamReader(stream));
//		String fname = keyRead.readLine();
//                        
//		//sending the string to server.
//		OutputStream  ostream = s.getOutputStream( );
//		PrintWriter pwrite = new PrintWriter(ostream, true);
//		pwrite.println(fname);            
//	         
//		// receiving the contents from server.  Uses input stream
//		InputStream istream = s.getInputStream();
//		BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
//		String advice = reader.readLine();
//		System.out.println(advice);
//	
//		// Close the reader and the connection.
//		reader.close();
//		s.close();
	}
	
	public void sendfalsetoserve()
	{
		try {
			//Sending the string to server.
			OutputStream  ostream = s.getOutputStream( );
			PrintWriter pwrite = new PrintWriter(ostream, true);
			pwrite.println("");            
			s.close();	
		}catch(IOException e)
		{
			System.out.println(e);
		}			
	}
	 			 
	public static void main(String[] args)
	{
		//Testing whether the server is launching or not
		Client test = new Client();
		
		if(testconnect == true)
		{
			if( args.length == 0)
			{
				System.err.println( "Need one or two command line arguments : list or get filename(provided). Try again...." );
				test.sendfalsetoserve();
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
				test.sendfalsetoserve();
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
						System.err.println( args[1]+": Only .txt files need to be transferred Try again...." );
						test.sendfalsetoserve();
						return;
					}
				}
				System.err.println( "Two argument correct but not 'get filename(provided)'. Try again.... " );
				test.sendfalsetoserve();
				return;
			}		 				 
			else 
			{
				System.err.println( "I said one or two arguments. Try again.... " );
				test.sendfalsetoserve();
				return;
			}
		}
	}
}
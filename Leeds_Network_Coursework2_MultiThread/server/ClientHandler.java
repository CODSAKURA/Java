import java.net.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.*;
import java.util.*;


public class ClientHandler extends Thread
{
	private Socket sock = null;
	private static InetAddress inet = null;	
	private static DateTimeFormatter dtf = null;
	private static File myObj = null;
	private static String hostname = "localhost";	
	private static String dateformat = "dd/MM/yyyy : HH:mm:ss : ";
	private static String filepath = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\log.txt";	
	private static String filepath2 = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\serverFiles";	
	
	 public ClientHandler(Socket socket) {
			super("ClientHandler");
			this.sock = socket;
	    }
	
	//Handling log.txt
	public void createlogfile(String a)
	{
		try 
		{ 
			//Getting IP address and formatting date
			inet = InetAddress.getByName(hostname);
			String ipaddress = inet.getHostAddress();		      
			dtf = DateTimeFormatter.ofPattern(dateformat);  
			LocalDateTime now = LocalDateTime.now();
		      
			//Creating a log.txt file
			myObj = new File(filepath);
		      
			if(a.equals("list") == true)
			{
				String combineString = dtf.format(now) + ipaddress + " : " + a + "\n";
			      
				if (myObj.createNewFile()) 
				{		    	      
					Files.write(Paths.get(filepath), combineString.getBytes(), StandardOpenOption.APPEND);
				} 
				else 
				{  
					Files.write(Paths.get(filepath), combineString.getBytes(), StandardOpenOption.APPEND);
				}
			}
			else
			{
				String combineString = dtf.format(now) + ipaddress + " : " + "get" + " " + a + "\n";
	      	      
				if (myObj.createNewFile()) 
				{		    	      
					Files.write(Paths.get(filepath), combineString.getBytes(), StandardOpenOption.APPEND);
				} 
				else 
				{  
					Files.write(Paths.get(filepath), combineString.getBytes(), StandardOpenOption.APPEND);
				}
			}		      
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}

	
	public void run(){		
		try
		{			
				//Print the date of connection on server
				Date date = new Date();
				System.out.println("Date " + date.toString() );
				System.out.println("Connection Successful!");
				System.out.println("");
	             
				//Reading the string from client
	            InputStream istream = sock.getInputStream( );
	            BufferedReader fileRead =new BufferedReader(new InputStreamReader(istream));
	            String fname = fileRead.readLine( );
	             
	            //Identify the string from client
	            if(fname.equals("list") == true)
	            {
	            	//Creating log file if not exist and adding the log detail to it
	            	createlogfile(fname);
	            	
	            	//Getting the list of file in the repository
	            	OutputStream ostream = sock.getOutputStream( );
		            PrintWriter writer = new PrintWriter(ostream);	             
		     		String[] pathnames;		
		            File f = new File(filepath2);	            
		            pathnames = f.list();
		            
		            //Writing those files to client
		            for(String pathname: pathnames)
		            {
		            	writer.println(pathname);
		            }
		            
		            //Closing the connection
		            writer.close();
		            sock.close();
	            }
	            
	            else if(fname.contains(".txt") == true)
	            {
	            	//Identifying the filename from client whether it exists on the repository or not
	            	String path = filepath2 +"\\"+fname;
	            	File tmpDir = new File(path);
	            	boolean exists = tmpDir.exists();
	            	
	            	if(exists == true)
	            	{
	            		//Creating log file if not exist and adding the log detail to it
	            		createlogfile(fname);
	            		
	            		//File Transfer Processing
		            	FileInputStream instream = null;
		            	FileOutputStream outstream = null;
		            	
		            	String c = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\client\\"+fname;
		            	File infile =new File(path);
		            	File outfile =new File(c);
		             
		            	instream = new FileInputStream(infile);
		            	outstream = new FileOutputStream(outfile);
		             
		            	byte[] buffer = new byte[1024];
		             
		            	int length;
		            	while ((length = instream.read(buffer)) > 0){
		            		outstream.write(buffer, 0, length);
		            	}
		            	instream.close();
		            	outstream.close();
		                	   
		            	//Sending Successful message to the client.
		            	PrintWriter writer = new PrintWriter(sock.getOutputStream());
		            	writer.println(fname + " file requests successful! Transfer completes!");// Write to client
		            	
		            	//Closing the connection
		            	writer.close();
		            	sock.close();
	            	}
	            	else
	            	{
	            		//Sending no such file exist message to the client
		            	PrintWriter writer = new PrintWriter(sock.getOutputStream());
		            	writer.println("No Such File existed");// Write to client
		            	
		            	//Closing the connection
		            	writer.close();
		            	sock.close();
	            	}
	            }
	            else
	            {
	            	//Catching the empty string message sent from the client but do nothing
		            OutputStream ostream = sock.getOutputStream( );
		            PrintWriter writer = new PrintWriter(ostream);
		            writer.close();
					sock.close();
	            }
	    }
	    catch (IOException e) 
		{
	        System.out.println(e);
	    }
	}
}
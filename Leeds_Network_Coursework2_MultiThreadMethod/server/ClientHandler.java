/*
 * This class is use to handle the connection
 * and process between the server and client.
 */
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
	private static String logFilePath = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\log.txt";	
	private static String serverFilesPath= "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\serverFiles";
	private static String clientPath = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\client\\";
	
	//Using to return message whether the file has been transfered or not to Protocol class
	private String message = "";
	
	
	//Constructor of ClientHandler Class
	public ClientHandler(Socket socket) 
	{
		super("ClientHandler");
		this.sock = socket;
	}	
	
	//Handling log.txt
	public void handleLogFile(String input)
	{
		try 
		{ 
			//Getting IP address and formatting date
			InetAddress inet = InetAddress.getByName("localhost");
			String ipAddress = inet.getHostAddress();		      
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy : HH:mm:ss : ");  
			LocalDateTime now = LocalDateTime.now();
			
			//Creating a log.txt file
			File myObj = new File(logFilePath);
		      
			if(input.equals("list") == true)
			{
				String combineString = dtf.format(now) + ipAddress + " : " + input + "\n";
			      
				if (myObj.createNewFile()) 
				{		    	      
					Files.write(Paths.get(logFilePath), combineString.getBytes(), StandardOpenOption.APPEND);
				} 
				else 
				{  
					Files.write(Paths.get(logFilePath), combineString.getBytes(), StandardOpenOption.APPEND);
				}
			}
			else
			{
				String combineString = dtf.format(now) + ipAddress + " : " + "get" + " " + input + "\n";
	      	      
				if (myObj.createNewFile()) 
				{		    	      
					Files.write(Paths.get(logFilePath), combineString.getBytes(), StandardOpenOption.APPEND);
				} 
				else 
				{  
					Files.write(Paths.get(logFilePath), combineString.getBytes(), StandardOpenOption.APPEND);
				}
			}		      
		} 
		catch (IOException e) 
		{
			System.out.println(e);
		}
	}

	
	public void run()
	{		
		try
		{			
				//Print the date of connection on server
				Date date = new Date();
				System.out.println("Date " + date.toString() );
				System.out.println("Connection Successful!");
				System.out.println("");
	             
				//Reading the string from client
	            InputStream inputStream = sock.getInputStream( );
	            BufferedReader reader =new BufferedReader(new InputStreamReader(inputStream));
	            String clientInput = reader.readLine( );	            
	             
	            //Identify the string from client
	            if(clientInput.equals("list") == true)
	            {
	            	//Creating log file if not exist and adding the log detail to it
	            	handleLogFile(clientInput);
	            	
	            	//Getting the list of file in the repository
	            	OutputStream outputStream = sock.getOutputStream( );
		            PrintWriter writer = new PrintWriter(outputStream);	             
		     		String[] pathNames;		
		            File file = new File(serverFilesPath);	            
		            pathNames = file.list();
		            
		            //Writing those files to client
		            for(String pathName: pathNames)
		            {
		            	writer.println(pathName);
		            }
		            
		            //Sending an extra message to the client from protocol
		            String outputLine;
		            Protocol pp = new Protocol();
		            outputLine = pp.processInput(clientInput);
		            writer.println(outputLine);
		            		            
		            //Closing the connection
		            writer.close();
		            sock.close();
	            }	            
	            else if(clientInput.contains(".txt") == true)
	            {
	            	//Identifying the filename from client whether it exists on the repository or not
	            	String path = serverFilesPath +"\\"+clientInput;
	            	
	            	File tmpDir = new File(path);
	            	boolean exists = tmpDir.exists();
	            	
	            	//If the file really existed then do below, Otherwise print failed message by Protocol
	            	if(exists == true)
	            	{
	            		//Creating log file if not exist and adding the log detail to it
	            		handleLogFile(clientInput);
	            		
	            		//File Transfer Processing
		            	FileInputStream inStream = null;
		            	FileOutputStream outStream = null;
		            	
		            	File infile =new File(path);
		            	File outfile =new File(clientPath +"\\" + clientInput);
		             
		            	inStream = new FileInputStream(infile);
		            	outStream = new FileOutputStream(outfile);
		             
		            	byte[] buffer = new byte[1024];
		             
		            	int length;
		            	while ((length = inStream.read(buffer)) > 0)
		            	{
		            		outStream.write(buffer, 0, length);
		            	}
		            	
		            	//Closing the file process
		            	inStream.close();
		            	outStream.close();
		            	message = "Success";
		            	
	            	}	            	
	            	//Sending Successful or Not message to the client using protocol.
	            	PrintWriter writer = new PrintWriter(sock.getOutputStream());	
	            	String outputLine;
		            Protocol pp = new Protocol();
		            outputLine = pp.processInput(message);
		            writer.println(outputLine);
	            	
	            	//Closing the connection
	            	writer.close();
	            	sock.close();
	            }
	            else
	            {
	            	//Catching the empty string message sent from the client but do nothing
		            OutputStream oStream = sock.getOutputStream( );
		            PrintWriter writer = new PrintWriter(oStream);
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
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
	private static String logFilePath = System.getProperty("user.dir") + "\\server\\log.txt";	
	private static String serverFilesPath= System.getProperty("user.dir") + "\\server\\serverFiles";
	private static String clientPath = System.getProperty("user.dir") + "\\client\\";
	
	//Using to return message to Protocol class
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
	            
	            //Creating log.txt on every client request
	            handleLogFile(clientInput);
            	
	            //As reading string contains spaces then we need to split them
	            String[] splited = clientInput.split("\\s+");
	            
	            //Identifying three cases: "list", "get lipsum.pdf","get lipsum1.txt"
	            if(splited.length == 1)
	            {
	            	if(splited[0].equals("list") == true)
	            	{       	
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
				     	message = "list";
				     	outputLine = pp.processInputString(message);
				     	writer.println(outputLine);
				            		            
				     	//Closing the connection
				     	writer.close();
				     	sock.close();
	            	}
	            	else
	            	{
	            		//Sending Nolist message to Protocol Class As single command line is wrong
	            		message = "Nolist";
			        	PrintWriter writer = new PrintWriter(sock.getOutputStream());	
			        	String outputLine;
			            Protocol pp = new Protocol();
			            outputLine = pp.processInputString(message);
			            writer.println(outputLine);
			        	
			        	//Closing the connection
			        	writer.close();
			        	sock.close();
	            	}
                	
	            }
		        else if(splited.length == 2 && splited[0].equals("get") == true)
		        {
		        	
		        	if(splited[1].contains(".txt") == true)
		        	{
			        	//Identifying the filename from client whether it exists on the repository or not
			        	String path = serverFilesPath +"\\"+splited[1];			        	
			        	File tmpDir = new File(path);
			        	boolean exists = tmpDir.exists();
			        	
			        	//If the file really existed then do below, Otherwise print failed message by Protocol
			        	if(exists == true)
			        	{	            		
			        		//File Transfer Processing
			            	FileInputStream inStream = null;
			            	FileOutputStream outStream = null;
			            	
			            	File infile =new File(path);
			            	File outfile =new File(clientPath +"\\" + splited[1]);
			             
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
			            outputLine = pp.processInputString(message);
			            writer.println(outputLine);
			        	
			        	//Closing the connection
			        	writer.close();
			        	sock.close();
		        	}
		        	else
		        	{
		        		//Sending wrong file type to the client by Protocol Class
		        		message = "Notext";
		        		PrintWriter writer = new PrintWriter(sock.getOutputStream());	
		            	String outputLine;
			            Protocol pp = new Protocol();
			            outputLine = pp.processInputString(message);
			            writer.println(outputLine);
		            	
		            	//Closing the connection
		            	writer.close();
		            	sock.close();		        		
		        	}

		        }	            	            
	            else
	            {
	            	//Sending wrong command line arguments to the client
	            	PrintWriter writer = new PrintWriter(sock.getOutputStream());	
	            	String outputLine;
		            Protocol pp = new Protocol();
		            outputLine = pp.processInputNumber(splited.length);
		            writer.println(outputLine);
	            	
	            	//Closing the connection
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
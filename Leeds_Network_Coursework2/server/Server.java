/*
 * This class is the server class which uses an Executor 
 * to manage a fixed thread-pool with 15 connections from the clients.
 */
import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class Server 
{
	private static File myObj = null;
	private static String logFilePath = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\log.txt";
	
	//Deleting log.txt
	public static void deleteLogFile()
	{
		myObj = new File(logFilePath); 
	    myObj.delete();
	}
    
	public static void main(String[] args) throws IOException 
	{

		ServerSocket server = null;
		ExecutorService service = null;

		try 
		{
			deleteLogFile();
			server = new ServerSocket(8989);
			
		} 
		catch (IOException e) 
		{
			
			System.err.println("Could not listen on port: 8989.");
			System.exit(-1);
		}

		//Initialising the executor.
		service = Executors.newFixedThreadPool(15);

		//For each new client, submit a new handler to the thread pool.
		while( true )
		{
			Socket client = server.accept();
			service.submit( new ClientHandler(client) );
		}
	}	
}


import java.net.*;
import java.io.*;

public class Server {
	
	private static File myObj = null;
	private static String filepath = "C:\\Users\\CODSAKULA\\eclipse-workspace\\Leeds_Network_Coursework2\\server\\log.txt";
	
	//Deleting log.txt
	public static void deletelogfile()
	{
		myObj = new File(filepath); 
	    myObj.delete();
	}
    
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        boolean listening = true;

        try {
            serverSocket = new ServerSocket(8989);
            deletelogfile();
        } catch (IOException e) {
            System.err.println("Could not listen on port: 8989.");
            System.exit(-1);
        }

        while (listening)
	      new ClientHandler(serverSocket.accept()).start();

        serverSocket.close();
    }
}

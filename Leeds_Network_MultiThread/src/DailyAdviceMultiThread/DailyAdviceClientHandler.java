package DailyAdviceMultiThread;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;

public class DailyAdviceClientHandler extends Thread{
	 // Feel free to add any 'hilarious' one-line advice strings here.
	 private String[] adviceList = {
	     "Take smaller bites",
	     "Go for the tight jeans. No they do NOT make you look fat",
	     "One word: inappropriate",
	     "Just for today, be honest. Tell your boss what you *really* think",
	     "You might want to rethink that haircut"
	 };
	
	 // The advice sent to the client is just randomly selected from the above list.
	 private String getAdvice() {
	     int random = (int) (Math.random() * adviceList.length);
	     return adviceList[random];
	 }
	 
    private Socket socket = null;

    public DailyAdviceClientHandler(Socket socket) {
		super("DailyAdviceClientHandler");
		this.socket = socket;
    }
    
    public void run()
    {
	     try
	     {
	    	 	PrintWriter writer = new PrintWriter(socket.getOutputStream());
	             // Get the address of the client. Also get the date. This information could be
	             // added to a log file, for instance.
	             InetAddress inet = socket.getInetAddress();
	             
	             Date date = new Date();
	             System.out.println("Date " + date.toString() );
	             System.out.println("Connection made from " + inet.getHostName() );
	             System.out.print("Server: ");
	             
	             // Send a single line of text to the client.
	             String advice = getAdvice();
	             writer.println(advice);    		 // Write to client
	             writer.close();
	             System.out.println(advice);		 // Local server echo
	             Thread.sleep(5000);	             
	             socket.close();
	             System.out.println("The client has been closed");	
	    }
	    catch (IOException e) 
	    {
			e.printStackTrace();
	    } catch (InterruptedException e) {
			e.printStackTrace();
		}
	     
    }
    
}

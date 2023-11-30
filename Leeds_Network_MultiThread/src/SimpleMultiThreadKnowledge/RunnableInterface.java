package SimpleMultiThreadKnowledge;

//
//"Hello world" the threads using the interface method.
//

public class RunnableInterface implements Runnable {

	// Define the interface method run().
	public void run() {
		System.out.println( "Hello from a thread." );
	}

	// Create a single thread with our Runnable object and start it.
	public static void main( String args[] ) {
		RunnableInterface h = new RunnableInterface();
		
		Thread t = new Thread(h);	//Initialise with h.
									//Create a thread base on that class
		
		t.start();
	}

}
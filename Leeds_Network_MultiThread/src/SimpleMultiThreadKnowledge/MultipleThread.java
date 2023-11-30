package SimpleMultiThreadKnowledge;

public class MultipleThread extends Thread {

	// Define the interface method run().
	public void run() {
		System.out.println( "Hello from a thread." );
	}

	// Create a single thread with our Runnable object and start it.
	public static void main( String args[] ) {
		MultipleThread t1 = new MultipleThread();
		t1.start();		//Start thread 1	
		
		MultipleThread t2 = new MultipleThread();
		t2.start();		//Start thread 2
		
		//May have thread 1 and thread 2 running now,
		// in addition to the main thread
	}

}

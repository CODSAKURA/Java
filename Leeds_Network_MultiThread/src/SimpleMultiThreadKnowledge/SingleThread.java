package SimpleMultiThreadKnowledge;

//
//"Hello world" the threads using the inheritance method.
//

import java.lang.Thread;

public class SingleThread extends Thread {

	// Override run().
	public void run() {
		System.out.println( "Hello from a thread." );
	}

	// Create a single thread and start it. Note we can only schedule the execution,
	// when run() is actually called depends on the OS scheduler.
	public static void main( String args[] ) {
		SingleThread t = new SingleThread();
		t.start();
	}

}

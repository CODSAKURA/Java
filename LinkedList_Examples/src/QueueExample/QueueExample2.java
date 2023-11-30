package QueueExample;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample2 {
	public static void main(String[] args) {
		Queue<String> queue = new LinkedList<String>();
		queue.add("Alice");
		queue.add("Bob");
		queue.add("Charlie");
		while (!queue.isEmpty()) {
		 System.out.println(queue.remove());
		}
	}
}

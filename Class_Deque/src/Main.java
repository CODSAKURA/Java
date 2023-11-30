

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Deque<String> stack = new ArrayDeque<>();
		stack.push("Alice");
		stack.push("Bob");
		stack.push("Charlie");
		while (!stack.isEmpty()) 
		{
		 System.out.println(stack.pop());
		}

	}
}

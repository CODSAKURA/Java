

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String line = "24/03/2011 01:00";
		String[] tokens = line.split("\\s+");

		System.out.println(Arrays.toString(tokens));
		
		System.out.println();

		
		String a = "24/03/2011 01:00";
		String[] s = a.split("/");

		System.out.println(Arrays.toString(s));
	}

}

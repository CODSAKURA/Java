package inputword;

import java.util.Scanner;

public class inputword {

	public static void main(String[] args) {
		
		System.out.print("Enter distance in miles: ");
		Scanner input = new Scanner(System.in);
		double distanceMiles = input.nextDouble();
		double distanceKm = distanceMiles * (8.0/5.0);
		System.out.println(distanceKm);
		System.out.printf("%.1f miles = %.1f km\n",distanceMiles, distanceKm);
		//%.1f means format as a floating-point value, to one decimal place.
		
		System.out.print("Enter a word: ");
		Scanner i = new Scanner(System.in);
		String d = i.next();
		System.out.println(d);
		
		
		int x = 1 + 2 * 3;
		int y = 22 % 7;
		System.out.println(x);
		System.out.print(y);		
	}
}

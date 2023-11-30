

import java.util.Scanner;

public class selectinfeet {

	public static void main(String[] args) {
		int optionNumber;   // Option number from menu, selected by user.
		double measurement; // A numerical measurement, input by the user.
		                    //    The unit of measurement depends on which
		                    //    option the user has selected.
		double inches;      // The same measurement, converted into inches.
		
		String b;
		
		/* Display menu and get user's selected option number. */
		while(true)
		{
			System.out.println("What unit of measurement does your input use?");
			System.out.println();
			System.out.println("         1.  inches");
			System.out.println("         2.  feet");
			System.out.println("         3.  yards");
			System.out.println("         4.  miles");
			System.out.println();
			System.out.print("Enter the number of your choice: ");
			Scanner input = new Scanner(System.in);
			optionNumber = input.nextInt();

			/* Read user's measurement and convert to inches. */
			switch ( optionNumber ) {
			case 1:
				System.out.print("Enter the number of inches: ");
				Scanner i = new Scanner(System.in);
				measurement = i.nextDouble();
				inches = measurement;
				System.out.println(inches + " " +"inches");
				break;//The effect of a break is to make the computer jump past the end of the switch statement, skipping over all the remaining cases.
			case 2:
				System.out.print("Enter the number of feet: ");
				Scanner in = new Scanner(System.in);
				measurement = in.nextDouble();
				inches = measurement * 12;
				System.out.println(inches + " " +"inches");
				break;          
			case 3:
				System.out.print("Enter the number of yards: ");
				Scanner ins = new Scanner(System.in);
				measurement = ins.nextDouble();
				inches = measurement * 36;
				System.out.println(inches + " " +"inches");
				break;          
			case 4:
				System.out.print("Enter the number of miles: ");
				Scanner inss = new Scanner(System.in);
				measurement = inss.nextDouble();
				inches = measurement * 12 * 5280;
				System.out.println(inches + " " +"inches");
				break;
		   
			default:
				System.out.print("Error!  Illegal option number!  I quit!");
				break;
			}
			System.out.print("Do you want to enter another one?");
			Scanner a = new Scanner(System.in);
			b = a.next();
			if(b.equals("no") || b.equals("NO") || b.equals("N"))
			{
				System.exit(1);//A parameter value of 0 indicates that the program ended normally.
							   //Any other value indicates that the program was terminated because an error was detected, so you could call System.exit(1) to indicate that the program is ending because of an error.
			}
		}
	}

}

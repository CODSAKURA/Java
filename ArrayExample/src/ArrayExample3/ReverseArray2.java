package ArrayExample3;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Reads a list of non-zero numbers from the user, then prints
 * out the input numbers in the reverse of the order in which
 * they were entered.  There is no limit on the number of inputs.
 */
//这个不管输入的数额是多大，只要电脑存的下怎么输入都可以。
public class ReverseArray2 {
    
    private static Scanner a;

	public static void main(String[] args) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("Enter some non-zero integers.  Enter 0 to end.");
        while (true) {
            System.out.print("? ");
            a = new Scanner(System.in);
            int number = a.nextInt();
            if (number == 0)
                break;
            list.add(number);
        }
        System.out.println();
        System.out.println("Your numbers in reverse are:");
        for (int i = list.size() - 1; i >= 0; i--) 
        {
            System.out.printf("%10d%n", list.get(i));
        }
    }

}

package MyAnswer;

import java.util.Arrays;

/**
 * Simulate choosing people at random and checking the day of the year they 
 * were born on.  If the birthday is the same as one that was seen previously, 
 * stop, and output the number of people who were checked.
 */
public class Main2 {

   public static void main(String[] args) {

       
       int[] peopleBirthday = new int[365];

       for(int i = 0; i < peopleBirthday.length ; i++) 
       {
             // Select a birthday at random, from 0 to 364.
             // If the birthday has already been used, quit.
             // Otherwise, record the birthday as used.

          int birthday;  // The selected birthday.
          birthday = (int)(Math.random()*365);     

          //First check whether there are same value before if so then assign 0 to previous number
          for(int j = 0; j < i; j++)
          {
        	  if(peopleBirthday[j] == birthday)
        	  {
        		  peopleBirthday[j] = 0;
        		  continue;
        	  }
          }
          
          peopleBirthday[i] = birthday;

       }
       
       /*Find all 0 in the array because those are the people that have same number with others*/
       int count = 0;
       for(int i = 0; i < peopleBirthday.length; i++)
       {
           System.out.printf("Person %d has birthday number %d%n", i, peopleBirthday[i]);
           if (peopleBirthday[i] == 0)
           {
        	   count++;
           }
       }
       
       /*Check whether there still have same value except 0 in a person or not*/
       Arrays.sort(peopleBirthday);
       System.out.println("\nThe sorted array is: ");
       for (int num : peopleBirthday) {
           System.out.print(num + " ");
       }
       
       /*Print the value which is 365 - count is the number of people that have different birthdays*/
       System.out.println();
       System.out.println("There are " + (365-count) + " different birthdays here.");
       
   }

} // end class BirthdayProblem

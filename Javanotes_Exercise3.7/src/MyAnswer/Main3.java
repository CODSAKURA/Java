package MyAnswer;

/**
 * Simulate choosing people at random and checking the day of the year they 
 * were born on.  If the birthday is the same as one that was seen previously, 
 * stop, and output the number of people who were checked.
 */
public class Main3 {

   public static void main(String[] args) {

       boolean[] used;  // For recording the possible birthdays
                        //   that have been seen so far.  A value
                        //   of true in used[i] means that a person
                        //   whose birthday is the i-th day of the
                        //   year has been found.

       int count;       // The number of people who have been checked.

       used = new boolean[365];  // Initially, all entries are false.
   
       count = 0;
       
       int birthdayFound = 0;

       /*Until 365 different birthdays have been found then end loop*/
       while (birthdayFound < 365) 
       {

          int birthday;  
          birthday = (int)(Math.random()*365);
          count++;
          
          /*Finding a never seen before birthday then add 1
           * And set it to true
           * Otherwise do nothing.
           * */
          if ( used[birthday] == false ) 
          {  
             birthdayFound++;
             used[birthday] = true;
          }
          
       } // end while

       System.out.println();
       System.out.println("365 different birthdays has been found by checking " + count + " people");
   }

} // end class BirthdayProblem

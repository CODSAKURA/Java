

public class Main {

	public static void main(String[] args) {
		String computerMove;
		switch ( (int)(3*Math.random()) ) {
		   case 0:
		      computerMove = "Rock";
		      break;
		   case 1:
		      computerMove = "Paper";
		      break;
		   default:
		      computerMove = "Scissors";
		      break;
		}
		System.out.println("The computer's move is " + computerMove);  // OK!

		
		
		/*String computerMove;
		  switch ( (int)(3*Math.random()) ) {
   		  case 0:
      			computerMove = "Rock";
      			break;
   		  case 1:
      			computerMove = "Paper";
      			break;
     	  case 2:
      			computerMove = "Scissors";
      			break;
		  }
		  System.out.println("The computer's move is " + computerMove);  // ERROR!
		 因为电脑没那么聪明电脑认为你的switch还没结束也就是说没有给computerMove赋值所以直接print出来不可以的，加一个default来结束这个switch		 
		 */
	}

}

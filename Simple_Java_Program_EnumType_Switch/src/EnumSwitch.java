
public class EnumSwitch {
	
	enum Season { SPRING, SUMMER, FALL, WINTER }

	public static void main(String[] args) 
	{
		Season currentSeason = Season.SPRING; //SPRING can be change to SUMMER, FALL, WINTER.
		
		System.out.print("The months in " + currentSeason + " are: ");

		switch ( currentSeason ) {
		   case WINTER ->   // ( NOT Season.WINTER ! )
		      System.out.println("December, January, February");
		   case SPRING ->
		      System.out.println("March, April, May");
		   case SUMMER ->
		      System.out.println("June, July, August");
		   case FALL ->
		      System.out.println("September, October, November");
		}


	}

}

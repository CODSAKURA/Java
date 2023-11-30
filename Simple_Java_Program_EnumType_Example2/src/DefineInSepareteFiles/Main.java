package DefineInSepareteFiles;

public class Main {
	
	public static void main(String[] args) {

		Season currentSeason = Season.WINTER;
		
		switch ( currentSeason ) {
		   case WINTER:    // ( NOT Season.WINTER ! )
		      System.out.println("December, January, February");
		      break;
		   case SPRING:
		      System.out.println("March, April, May");
		      break;
		   case SUMMER:
		      System.out.println("June, July, August");
		      break;
		   case FALL:
		      System.out.println("September, October, November");
		      break;
		}
	}
}

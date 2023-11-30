

public class Main {

	public static void main(String[] args) {
		double i = 0.0;
		System.out.println("+--------+--------+");
		System.out.println("|   " + "\u00b0C"+"   |"+ "   " +"\u00b0F"+"   |");
		System.out.println("+--------+--------+");
		if(i<=0.0)
		{
			while(i<=8.0) {
				System.out.println("|   " + i + "  |" + "  " + ((i*1.8)+32.0) + "  |" );
				i = i + 2;			
			}
		}
		while(i<=36.0) {
			System.out.print("|  ");
			System.out.printf("%.1f",i);
			System.out.print("  |  ");
			System.out.printf("%.1f", ((i*1.8)+32.0));
			System.out.println("  |");
			i = i + 2;			
		}
		
	}
}

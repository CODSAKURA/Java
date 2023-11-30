package FormatDecimal;

public class FormatDecimal {

	public static void main(String[] args) {
	      int i = 2;
	      double r = Math.sqrt(i);
	        
	      System.out.format("The square root of %d is %f%n", i, r);
	      System.out.println("");

	      /*d formats an integer value as a decimal value.
			f formats a floating point value as a decimal value.
			n 换行符在format里面
			x formats an integer as a hexadecimal value.
			s formats any value as a string.
			tB formats an integer as a locale-specific month name.
			
			Except for %% and %n, all format specifiers must match an argument. If they don't, an exception is thrown.*/
	      
	      
	      System.out.format("%f, %1$+020.10f %n", Math.PI);
	      System.out.println("");
	      
	      /*1$:match the same argument as the previous specifier
	       *+0:Flags就是最前面是加号，然后除去.10f后面10位小数剩下的都是0
	       *.10：小数点后面要有10位。
	       *f： Math.PI*/
	      
	      System.out.println("Pi = " + Math.PI);
	      System.out.printf("Pi = %.3f%n", Math.PI);
	      System.out.printf("Pi = %.7f%n", Math.PI);
	      System.out.printf("Pi = |%12.7f|%n", Math.PI);
	      System.out.printf("Pi = |%012.7f|%n", Math.PI);
	      System.out.printf("Pi = |%+12.7f|%n", Math.PI);
	      System.out.printf("Pi = |%+012.7f|%n", Math.PI);
	      System.out.printf("Pi = |%-12.7f|%n", Math.PI);
	      
	}

}

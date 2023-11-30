public class Main {
	  public static void main(String[] args) {
		    String s = "Hello World!";
		    System.out.printf("String content:     %s\n", s);

		    System.out.printf("length():           %d\n", s.length());
		    System.out.printf("isEmpty():          %s\n", s.isEmpty());

		    System.out.printf("charAt(1):          %c\n", s.charAt(1));
		    System.out.printf("indexOf('W'):       %d\n", s.indexOf('W'));
		    System.out.printf("startsWith(\"He\"):   %s\n", s.startsWith("He"));
		    System.out.printf("endsWith(\".\"):      %s\n", s.endsWith("."));

		    System.out.printf("substring(1, 4):    %s\n", s.substring(1, 4));

		    System.out.printf("replace('o', '*'):  %s\n", s.replace('o', '*'));
		    System.out.printf("String content:     %s\n", s);

		    System.out.printf("toUpperCase():      %s\n", s.toUpperCase());
		    System.out.printf("String content:     %s\n", s);
		    
		      
		    
		    
		    
		    
		    String str = "This is tutorials point"; 
		    String substr = "";

		    // prints the substring after index 0 till index 7
		    substr = str.substring(0, 7);		      
		    System.out.println("substring = " + substr);
		      
		    // prints the substring after index 7 till index 17		      
		    substr = str.substring(7, 17);		      
		    System.out.println("substring = " + substr);
		      		      
		    System.out.println("Castiels".indexOf("ti"));		      
		    System.out.println("Castiels".indexOf("ti",4));//To find the first occurrence of x at or after position N, you can use s1.indexOf(x,N).		      
		    System.out.println("Castiels".lastIndexOf("s"));//To find the last occurrence of x in s1, use s1.lastIndexOf(x).
		  }
}

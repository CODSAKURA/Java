//这个是检查两个string有没有相同的数字不管它们的位置是不是相同，比如说Casteil和ZhouDi因为都有一个i所以它们有相同的字母。
//然后这个是教你怎么break特定的loop在你要break的loop前面加一个特定的修饰词就好了比如bigloop

public class Main {

	public static void main(String[] args) {
		
		String s1 = "Castel";
		String s2 = "ZhouDi";
				
		boolean nothingInCommon;
		nothingInCommon = true;  // Assume s1 and s2 have no chars in common.
		int i,j;  // Variables for iterating through the chars in s1 and s2.

		i = 0;
		bigloop: while (i < s1.length()) 
		{
		   j = 0;
		   while (j < s2.length()) 
		   {
		      if (s1.charAt(i) == s2.charAt(j)) 
		      { 
		    	  // s1 and s2 have a common char...
		          nothingInCommon = false;  // so nothingInCommon is actually false.
		          System.out.print("has common");
		          break bigloop;  // break out of BOTH loops
		      }		      
		      j++;  // Go on to the next char in s2.
		   }
		   i++;  //Go on to the next char in s1.		   
		}
		System.out.print("no common");

	}

}

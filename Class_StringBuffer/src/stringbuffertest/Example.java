package stringbuffertest;

public class Example {
	public static void main(String[] args)
	{
		String word = "Hello World";
		
		if (args.length >= 1)
		{
			word = args[0];// Element 0 is the first one
		}
		
		// We are not allowed to alter the word ourselves!
		
		StringBuffer copy = new StringBuffer(word);
		
		int i = 0;		
		while ( i < copy.length() ) // While not at end of string
		{
			copy.setCharAt( i, (char)( copy.charAt(i) + 1 ) ); //因为前面有个char在casting所以当是a的话就自动变成ASCII然后加11对应的数字就是b
			i++;
		}
		
		System.out.println( "Final: " + copy );
		
	    
		//这一段来解释那个copy.setCharAt( i, (char)( copy.charAt(i) + 1 ) );
		char c='a';
	    int i2=98;
	    System.out.println((int)c);
	    System.out.println((char)(i2+1));
	}
}

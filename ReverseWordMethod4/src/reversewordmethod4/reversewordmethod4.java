package reversewordmethod4;

public class reversewordmethod4 {
	public 	static void reverse (StringBuffer message)
	{
		int len = message.length();
		for (int i = 0; i < len / 2; i++) // Corrected from <= initially!!!
		{
			char temp = message.charAt(i);
			message.setCharAt( i, message.charAt(len - i - 1));
			message.setCharAt(len - i - 1, temp);
		}
	}
	public static void main(String[] args)
	{
		if (args.length < 1) // Not enough command line arguments
		{
			System.out.println("You need to provide the word to decode on the command line.\n");
			return;
		}
		StringBuffer copyOfWord = new StringBuffer(args[0]); //String class for strings
															 //StringBuffer if mutable
															//Mutable means changeable, e.g. can change the
															//characters in a StringBuffer but not a String
		reverse(copyOfWord);
		System.out.println("Reversed word is:" + copyOfWord);
	}
}

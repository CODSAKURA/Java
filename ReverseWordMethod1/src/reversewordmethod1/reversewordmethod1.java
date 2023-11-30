package reversewordmethod1;//reverse word by using two function and args

public class reversewordmethod1 {
	public 	static StringBuffer reverse (StringBuffer message)
	{
		int len = message.length();
		StringBuffer temp = new StringBuffer(message);
		for (int i = 0; i < len / 2; i++) // Corrected from <= initially!!!
		{
			temp.setCharAt( i, message.charAt(len - i - 1));
			temp.setCharAt(len - i - 1, message.charAt(i));
		}
		return temp;
	}
	public static void main(String[] args)
	{
		if (args.length < 1) // Not enough command line arguments
		{
			System.out.println("You need to provide the word to decode on the command line.\n");
		}
		else
		{
			StringBuffer copyOfWord = new StringBuffer(args[0]);
			String a = "Reversed word is:";
			System.out.println(a + reverse(copyOfWord));
		}
	}

}

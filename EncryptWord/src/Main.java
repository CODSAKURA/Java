

public class Main {
	public static void encrypt(StringBuffer message, StringBuffer password)
	{
		int m = 0;
		int p = 0;
		
		while (message.length() > m)
		{
			message.setCharAt(m,(char)(65 + ((message.charAt(m) & 0x9F) + (password.charAt(p) & 0x9F)) % 26));
			
			m++;
			p++;
			
			if (password.length() == p) 
				p = 0;

		}
	}
	public static void main(String[] args) {
		if (args.length < 2) // Not enough command line arguments
		{
			System.out.printf("Usage: %s <word> <password>", args[0]); // You can hardcode name
			System.out.printf("Cannot decrypt without supplying both a word and a password!");
		}
			
			StringBuffer sb1 = new StringBuffer(args[0]);
			StringBuffer sb2 = new StringBuffer(args[1]);
			encrypt(sb1, sb2);
			
			
			System.out.printf("Encrypted word is: '%s'\n",sb1 );
	}

}

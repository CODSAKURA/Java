package reversewordmethod2;//reverse word by using one main function and args

public class reversewordmethod2 {
	public static void main(String[] args) {
		
		if(args.length < 1)
		{
			System.out.print("You need to provide the word to decode on the command line.");
		}
		else
		{
			StringBuffer CopyOfWord = new StringBuffer(args[0]);
			System.out.print("Reverse word is:");
			String sb = "";
			for(int i = CopyOfWord.length()-1;i>=0;i--)
			{
				sb +=CopyOfWord.charAt(i);
			}
			System.out.print(sb);
		}
	}

}

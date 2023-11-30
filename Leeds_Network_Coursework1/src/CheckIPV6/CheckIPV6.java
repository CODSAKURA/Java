package CheckIPV6;

public class CheckIPV6 {
	
	public static void main( String[] args ) {
		String a = "2001:db8:3333:4444:CCCC:DDDD:EEEE:FFFF";
		if(a.contains("."))
		{
			System.out.println("False");
			System.exit(0);
		}
		
		String[] b = a.split("[:]");
		
		int count = 0;
		int count2 = 0;
		
		for( int i=0; i<b.length; i++ )
		{
			String check = b[i];
			if(check.matches(".*[a-zA-Z0-9]+.*") == false)
			{
				count++;
			}
			count2++;
		}
		
		if(count > 0 || count2 != 8 )
		{
			System.out.print("It is not an ipv6 address");
		}
		else
		{
			System.out.print("It is an ipv6 address");
		}
	}
	
}

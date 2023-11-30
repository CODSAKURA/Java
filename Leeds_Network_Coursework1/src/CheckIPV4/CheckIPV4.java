package CheckIPV4;

public class CheckIPV4 {
	
	public static void main( String[] args ){	
		
		String ipaddress = "129.11.26.33";
		if(ipaddress.contains(":"))
		{
			System.out.println("False");
			System.exit(0);
		}
		
		String[] a = ipaddress.split("[.]");
		
		int count = 0;
		int count2 = 0;
		
		for( int i=0; i<a.length; i++ )
		{
			int number=Integer.parseInt(a[i]);
			
			if(number < 0 || number > 255)
			{
				count++;
			}			
			count2++;
		}
		
		if(count > 0 || count2 != 4 )
		{
			System.out.print("It is not an ipv4 address");
		}
		else
		{
			System.out.print("It is an ipv4 address");
		}
	}
	
}

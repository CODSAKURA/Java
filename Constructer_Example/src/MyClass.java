

public class MyClass
{
	public static int count; //Fields: class variables and instance variables are fields while local variables and parameter variables are not. 
	
	public static int getCount()
	{ 
		return count; 
	}
	
	public MyClass(){count++;} // building constructer
		
	public static void main(String[] args)
	{
		count = 0; // Set count
		MyClass object1 = new MyClass();
		MyClass object2 = new MyClass();
		System.out.println("" + getCount() + " objects created");
	}

}

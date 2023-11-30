package polymorphism1;

public class ArrayString
{
	private int size = 0;
	private String[] data = new String[0];

	public void add( String val )
	{
		String[] newData = new String[size+1];
		if ( size > 0 )
			System.arraycopy( data, 0, newData, 0, size);
		newData[size] = val;
		size++;
		data = newData;
	}
	
	// Print everything in array
	public void printAll()
	{
		for ( int i = 0 ; i < data.length ; i++ )
			System.out.print( " "+ data[i] );
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		ArrayString arr = new ArrayString();
		arr.printAll();
		arr.add("1");
		arr.printAll();
		arr.add("2");
		arr.add("4");
		arr.printAll();
	}
}


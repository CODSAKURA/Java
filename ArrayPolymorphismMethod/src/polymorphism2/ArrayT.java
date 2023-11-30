package polymorphism2;


public class ArrayT<T extends Object>
{
	private int size = 0;
	private Object[] data = new Object[0];

	public void add( T val )
	{
		Object[] newData = new Object[size+1];
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
		ArrayT<String> arr = new ArrayT<String>();
		arr.printAll();
		arr.add("1String");
		arr.printAll();
		arr.add("2String");
		arr.add("4String");
		arr.printAll();
	}
}


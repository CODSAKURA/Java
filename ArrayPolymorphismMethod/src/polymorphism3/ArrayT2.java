package polymorphism3;


public class ArrayT2<T extends Object>
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
	
	@SuppressWarnings("unchecked")
	public T get( int i )
	{
		return (T) data[i];
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
		ArrayT2<String> arr = new ArrayT2<String>();
		arr.printAll();
		arr.add("1String");
		arr.printAll();
		arr.add("2String");
		arr.add("4String");
		arr.printAll();
	}
}


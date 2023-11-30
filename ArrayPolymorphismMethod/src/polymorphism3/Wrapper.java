package polymorphism3;


public class Wrapper<T>
{
	private T data;

	public Wrapper( T init ) { this.data = init; }

	public T get() 
	{ 
		return (T) data; 
	}
	
	public void set( T val ) 
	{ 
		data = val; 
	}

	public static void main(String[] args)
	{
		Wrapper<String> s = new Wrapper<>("Hello");
		Wrapper<Integer> i = new Wrapper<>(4);
		System.out.println( s.get() +" , " +  i.get() );
	}
}

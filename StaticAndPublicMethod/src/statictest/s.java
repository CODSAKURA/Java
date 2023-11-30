package statictest;


//Static用法

public class s {

	public static void printMessage( String message)
	{
		System.out.println(message);
	}
		
	public String print( String message)
	{
		return message;
	}
	
	public static void main(String[] args)
	{
		printMessage( "Hello World" );
		s.printMessage("dsdsadsada");
		
		s a = new s();
		System.out.print(a.print("1"));
		//System.out.print(a.printMessage("2"));
		//static的方法不属于任何一个实例对象，而是被类的实例对象所共享。
	}

	
	/*
	 
	 当一个方法或者变量需要初始化加载，或者是经常被调用的时候可以加上static。
	用static修饰的方法可以用类名直接调用，不用的一定要先实例化一个对象然后才可以调用
	
	比如 person这个类里面有一个方法public static add(){}
	那么可以直接用person类调用 person.add();
	
	如果这个方法前面没有static 比如 public add(){}
	那么先要person p=new person();
	然后用p.add();
	
	
	static简单来说就不用再创建一个object关于这个class的，可以直接用method或者class.method。如果没有static就得创建关于这个class的object再来用method。
	*/
	
}

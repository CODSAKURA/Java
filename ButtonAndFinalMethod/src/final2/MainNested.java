package final2;

public class MainNested 
{
	public static void main(String[] args) 
	{
		Outer ob1 = new Outer();
		
		Outer.NestedStatic ob2 = new Outer.NestedStatic();//create Nestedstatic object
		
		Outer.InnerClass ob3 = ob1.new InnerClass();// create Innerclass object
		
		ob2.foo();
		ob3.bar();
	}
}

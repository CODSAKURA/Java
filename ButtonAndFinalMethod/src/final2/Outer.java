package final2;


public class Outer 
{
	int i = 1;
	
	public static class NestedStatic
	{
		public void foo() {}
	}
	
	public class InnerClass
	{
		public void bar() { i = 2; }
	}
}

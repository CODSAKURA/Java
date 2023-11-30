

public class Main {

	public static void main(String[] args) {
		
		int ch = 6;
		int y = ch++;
		System.out.println(y);
		//The value assigned to y is defined to be the old value of x, before the 1 is added.
		
		int dh = 6;
		int z = ++dh;
		System.out.println(z);
		//The value of ++x is defined to be the new value of x, after the 1 is added.	
		//Use ++ and -- only as stand-alone statements, not as expressions.

		int n = 0;
		++n;
		System.out.println(n);
	
		
		int a = 0;
		a++;
		System.out.println(a);
	
		//如果单独用a++的话a++和++a都一样的如果要赋值到另外一个的话就不一样了
	}

}

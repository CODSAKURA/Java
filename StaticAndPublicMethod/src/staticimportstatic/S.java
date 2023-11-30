package staticimportstatic;

import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.toRadians;
import static java.lang.System.out;

public class S {

	public static void main(String[] args) {
		out.println(cos(5.0));
		out.println(sin(5.0));
		out.println(toRadians(5.0));

		
		//一旦import static的话也可以直接用method就好了。
	}

}

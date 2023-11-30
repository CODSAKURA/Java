package ArrayExample2;

import java.util.Arrays;

public class MethodInPlayer {

	public static void main(String[] args) {
		
		//在Player Class里当delete array 删除到一定程度时用Arrays.copyof来decrease the size of arrays
		int[] a = { 1, 3, 5, 7 };
		int[] b = Arrays.copyOf( a, a.length );//原array复制到新的array里
		int[] c = a.clone();//原array复制到新的array里
		a = Arrays.copyOf( a, 2*a.length );//在原array里扩大
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(c));
		

	}

}

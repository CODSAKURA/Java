package AdjustOutputWidth;

public class AdjustOutputWidth 
{
	public static void main(String[] args) 
	{
		 	int[] x = new int[10];
		 
		 	for (int i = 0; i < 10; ++i) 
		 	{
		 		System.out.printf("%1d: %d\n", i, x[i]);
		 	}
		 	
		 	for (int i = 0; i < 10; ++i) 
		 	{
		 		System.out.printf("%2d: %d\n", i, x[i]);
		 	}
		 	
		 	for (int i = 0; i < 10; ++i) 
		 	{
		 		System.out.printf("%3d: %d\n", i, x[i]);
		 	}
	
		 	//%nd 输出的整型宽度至少为n位，右对齐，%5d即宽度至少为5位，位数大于5则输出实际位数
		 	
		 	System.out.printf("%05d\n", 1);
		 	System.out.printf("%5d\n", 1);
		 	
		 	//%0nd 用得比较多，表示输出的整型宽度至少为n位，不足n位用0填充.
	}
}

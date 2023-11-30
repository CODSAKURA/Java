package printprintfprintln;

/*此Java文件介绍了print，println以及printf的区别。
 * 总结：三者都可以单纯输出字符串，区别在于换行是否。
 * */
public class Difference {

	public static void main(String[] args) 
	{
		int Int = 10;
		double Double = 15;				
		
		/*print标准输出，不换行,字符串与字符串以及变量之间是用+隔开.*/
		System.out.print("用print输出 Int：" + Int + "\n");
		
		/*println自动换行,字符串与字符串以及变量之间也是用+隔开.*/
		System.out.println("用println输出 Int：" + Int);
		
		/*printf格式控制输出，与C用法相同。字符串与变量间用，分隔。可以同时输出多个值，由%控制格式控制输出。可用\n自动换行。*/
		System.out.printf("用printf输出： Int的值为%d， Double的值为%f",Int,Double);
	}
}

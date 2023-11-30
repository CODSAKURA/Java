
public class Output {

	public static void main(String[] args) 
	{		
		/*结果为5，按2进制输入->10进制输出*/
		System.out.println(0b101);
		
		/*结果为9，按8进制输入->10进制输出*/
		System.out.println(011);
		
		/*结果为284，按16进制输入->10进制输出*/
		System.out.println(0x11C);
		
		System.out.println("-------------------------------------");
		
		/*结果为7，10进制输入->16进制输出*/
		System.out.printf("%x\n",7);
		
		/*结果为0000000007   10进制输入->按10位16进制输出，向右靠齐，左边用0补齐*/
		System.out.printf("%010x\n",7);
		
		/*结果为15，10进制输入->8进制输出*/
		System.out.printf("%o\n",13);
		
		/*结果为0000000015    10进制输入->按10位8进制输出，向右靠齐，左边用0补齐*/
		System.out.printf("%010o\n",13);
		
		/*结果为1011		10进制输入->2进制输出*/
		System.out.println(Integer.toBinaryString(11));//1011 二进制

	}

}

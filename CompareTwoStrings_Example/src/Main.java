

public class Main {

	public static void main(String[] args) {	
		String s1 = "atw";				
		String s2 = "aTW";
		
		/*equals（）：返回的是Boolean的值。这是管大小写的！！！！*/
		System.out.println(s1.equals(s2));
		
		/*equalsIgnoreCase():这个和equals（）是一样的道理，但是是不管大小写，函数会把所有的大写变成小写！！！*/
		System.out.println(s1.equalsIgnoreCase(s2));
		
		/*compareTo():先比较对应字符的大小(ASCII码顺序)，如果第一个字符和参数的第一个字符不等，结束比较，返回他们在ASCII第一行之间的数字差值，
		 * 如果第一个字符和参数的第一个字符相等，则以第二个字符和参数的第二个字符做比较，以此类推，直至得到最终结果或者其中一个参数不符结束。
		 * {注意：这是关大小写的符号的！！！}
		 * 
		 * 以下为有大写也有小写的例子：
		 * 假如“A”和“a”进行比较，因为关系到大小写，所以“A”不等于“a”，“A”在ASCII编码里面第一行是65，“a”在ASCII编码里面第一行是97，所以65-97=-32，返回值便是-32.
		 * 再比如“castiel和”caSTIel“进行比较，因为”c“=”c”，“a“=”a“，所以比较第三个字符，“s”在ASCII编码里面第一行是115，”S“在ASCII编码里面第一行是83，所以115-83=32，立马返回值便是32.
		 * （注意：”castiel“和”caSTIel“对比的时候，当发现第一个”s“和”S“不对时就立马返回差值然后结束程序，不会继续进行比较了，不管后面”t“不等于”T“，”i“不等于”I“！）
		 * 
		 * 以下为全是小写的例子：
		 * 假如“astiel”和“ake”进行比较，则“a”=“a”。所以比较第二个字符，“s”在ASCII编码里面第一行是115，而“k”在ASCII编码里面第一行是107，所以115-107=8，返回的值便是8。
		 * 再比如“astiel”和“ike”进行比较，因为“a”在ASCII编码里面第一行是97，而“i”在ASCII编码里面第一行是105，所以97-105=-8，返回的值便是-8。
		 * 再比如“a”和“a”进行比较，因为“a”在ASCII编码里面第一行和“a”一样，所以返回0。
		 * */
		System.out.println(s1.compareTo(s2));
		
		/*compareToIgnoreCase（）：这个和compareTo（）是一样的道理，但是这个不区分大小写，因为这个函数会把里面的大写变成小写再进行比较。
		 * 例子：
		 * 例一：”castiel“和”caSTIel“在compareTo（）中的值是32，但是在compareToIgnoreCase（）中是0，因为不管大小写，他们是相同的，所以返回值是0.
		 * 例二：”ake“和"aTW”的话，因为“a“=”a“，所以比较第二个字符，”k“在ASCII编码第一行里是107，“T”先化成“t”，然后“t"在ASCII编码第一行里便是116,所以107-116=-9，返回值便是-9.
		 * */
		System.out.println(s1.compareToIgnoreCase(s2));
		
	}

}

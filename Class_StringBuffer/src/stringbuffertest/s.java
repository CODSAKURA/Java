package stringbuffertest;

public class s {
	public static void main(String[] args)
	{
		String s = "abc";
        StringBuffer sb1 = new StringBuffer("123");
        StringBuffer sb2 = new StringBuffer(s);   //String转换为StringBuffer
        String s1 = sb1.toString();   //StringBuffer转换为String
		
		StringBuffer sb3 = new StringBuffer("abc");
        System.out.println(sb3.append("dsadsa"));
        //append方法：该方法的作用是追加内容到当前StringBuffer对象的末尾，类似于字符串的连接。调用该方法以后，StringBuffer对象的内容也发生改变
        
        
        StringBuffer sb4 = new StringBuffer("Test");
        System.out.println(sb4. deleteCharAt(1));
        //deleteCharAt方法：该方法的作用是删除指定位置的字符，然后将剩余的内容形成新的字符串
        
        
        StringBuffer sb5 = new StringBuffer("TestString");
        System.out.println(sb5. delete (1,4));
        //delete方法：该方法的作用是删除指定区间以内的所有字符，包含start，不包含end索引值的区间。public StringBuffer delete(int start,int end)。
        //该代码的作用是删除索引值1(包括)到索引值4(不包括)之间的所有字符，剩余的字符形成新的字符串
        
        
        StringBuffer sb6 = new StringBuffer("TestString");
        System.out.println(sb6.insert(4,"sdasdasd"));
        //insert方法：该方法的作用是在StringBuffer对象中插入内容，然后形成新的字符串。该示例代码的作用是在对象sb的索引值4的位置插入sdasdasd，形成新的字符串，则执行以后对象sb的值是”TestfalseString”。
        
        
        StringBuffer sb7 = new StringBuffer("abc");
        System.out.println(sb7.reverse());
        //reverse方法：该方法的作用是将StringBuffer对象中的内容反转，然后形成新的字符串
        
        
        StringBuffer sb8 = new StringBuffer("abc");
        sb8.setCharAt(1,'D');
        System.out.println(sb8.toString());
        //setCharAt方法：该方法的作用是修改对象中索引值为index位置的字符为新的字符ch。
        
        
        StringBuffer sb9 = new StringBuffer("abc");
        System.out.println(sb9.charAt(2));
        //charAt方法：方法返回指定索引处的char值。索引范围是从0到length() - 1。


        
        
        
        //Example:
        StringBuilder lineBuilder = new StringBuilder("ZhouDi");
        
        int lineSize = lineBuilder.length();
		
        for (int i = 0; i < lineSize ; i++) 
		{
         lineBuilder.append('*');
        }
        
        String line = lineBuilder.toString();
        
        System.out.print(line);

	}
}

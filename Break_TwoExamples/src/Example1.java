

public class Example1 {

    public static void main(String[] args) 
    {
        StringBuffer searchstr = new StringBuffer("hehllo how are you. ");
        int length = searchstr.length();
        int count = 0;
        
        for (int i = 0; i < length; i++) 
        {
            if (searchstr.charAt(i) != 'h')
            {
            	break;
            }
            // break is to terminate a loop prematurely if a stopping condition suddenly becomes true
            //break 语句可以直接强行退出当前的循环
            //这里的话当检查第一个字符发现是h count就加1. 当检查第二个字符的时候发现不是h，直接结束整个循环不进行下一个循环然后print结果出来。
            //所以这里检查到第二个字符发现不是就直接print结果了。
            
            count++;
        }
       
        System.out.println("发现 " + count + " 个 h 字符");
        System.out.println(searchstr);
    }

}

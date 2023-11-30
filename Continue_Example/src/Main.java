

public class Main {

    public static void main(String[] args) 
    {
        StringBuffer searchstr = new StringBuffer("hehllo how are you. ");
        int length = searchstr.length();
        int count = 0;
        
        for (int i = 0; i < length; i++) 
        {
            if (searchstr.charAt(i) != 'h')
            {
            	continue;
            }
            //continue 语句用来结束当前循环，并进入下一次循环，即仅仅这一次循环结束了，不是所有循环结束了，后边的循环依旧进行.
            
            //continue 假如这个循环检查了一个字符发现是h就继续这个循环， 如果这个循环检查了一个字符发现不是h的话就直接结束这个循环然后跳到检查下一个字符循环去。
            
            count++;
        }
       
        System.out.println("发现 " + count + " 个 h 字符");
        System.out.println(searchstr);
    }

}

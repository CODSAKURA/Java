package DifferencebetweenFinalVariableAndNormalVariable;

public class FinalAndVariableDifference2 {
    
	public static String getHello() {
        return "helloWord";
    }
	
	public static void main(String[] args)  {
        String a = "helloWord2";
        final String b = getHello();  
        String c = b + 2;
        System.out.println((a == c));
    }
	//如果直接用方法的话，尽管是final修饰，值都是要在运行时初始化才被确定
}

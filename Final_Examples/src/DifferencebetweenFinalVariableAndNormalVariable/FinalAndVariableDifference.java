package DifferencebetweenFinalVariableAndNormalVariable;

public class FinalAndVariableDifference {
    public static void main(String[] args)  {
        String a = "helloWord1";

        final String b = "helloWord";
        String F = "helloWord";

        String c = b + 1;
        String e = F + 1;
        System.out.println((a == c));
        System.out.println((a == e));
    }
}

/*因为变量b被final修饰，在使用到b的地方会直接将变量b 替换为它的值所以在运行System.out.print前电脑已经知道了值所以是true。
 *而对于变量F的访问却需要在运行System.out.print时才能连接确定，所以返回false*/

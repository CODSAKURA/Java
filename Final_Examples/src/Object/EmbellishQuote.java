package Object;

class AA{
    int i=1;
}
public class EmbellishQuote {
    public static void main(String[] args) {
        
       final AA a = new AA();  //final修饰引用变量
        
//       a=new AA(); //编译失败，说明被final修饰的引用变量一旦初始化赋值之后指向的对象不可变

       System.out.println( ++a.i ); //输出值为2，说明内容可变
    }
}

//被final修饰的引用变量一旦初始化赋值之后指向的对象不可变但该对象的内容可变

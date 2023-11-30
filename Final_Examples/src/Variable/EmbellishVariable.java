package Variable;


//如果被final修饰的是基本数据类型的变量，则其数值一旦在初始化之后便不能更改；如果是引用类型的变量，则在对其初始化之后便不能再让其指向另一个对象。

public class EmbellishVariable {
    public final int a=1;

    public void method(){
       // final修饰基本数据类型的变量，其数值一旦在初始化之后便不能更改
//        a=2;
//       // final修饰引用类型的变量，其初始化之后便不能再让其指向另一个对象
//        final String str=new String();
//        str=new String();
    }
}

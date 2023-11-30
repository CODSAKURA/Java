package Constructor;

public class FinalAndVariable {
    public int t;
    public final int b; //编译成功
    public final int c = 1; //编译成功

    public FinalAndVariable() {  //构造方法
       b=2;  //在构造方法中将field varaible b进行初始化
    }
}

//成员变量必须在定义时或者构造器中进行初始化赋值
/*public class FinalAndVariable {
    public int t; //编译成功
    public final int b; //编译失败
    public final int c = 1; //编译成功
    
    public FinalAndVariable() {  //构造方法
         //在构造方法中将field variable b进行初始化
    }
}*/

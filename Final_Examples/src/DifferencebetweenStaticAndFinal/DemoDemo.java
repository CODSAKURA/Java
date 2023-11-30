package DifferencebetweenStaticAndFinal;

class FinalDemo {
    public final double i = Math.random();
    public static double t = Math.random();
}

public class DemoDemo {
    public static void main(String[] args) {

        FinalDemo demo1 = new FinalDemo();
        FinalDemo demo2 = new FinalDemo();
        System.out.println("final修饰的  i=" + demo1.i);
        System.out.println("static修饰的 t=" + demo1.t);
        System.out.println("final修饰的  i=" + demo2.i);
        System.out.println("static修饰的 t=" + demo2.t);

        System.out.println("t+1= "+ ++demo2.t );
//      System.out.println( ++demo2.i );//编译失败
      }
}

//因为final在用方法的时候是在运行时才被初始化所以值不同



//static可以用来优化程序性能，是因为它的特性:只会在类加载的时候执行一次。因此，很多时候会将一些只需要进行一次的初始化操作都放在static代码块中进行。
//而static在类加载的时候就加载完成了（初始化），而且只会加载一次也就是说初始化一次，所以不会发生变化！

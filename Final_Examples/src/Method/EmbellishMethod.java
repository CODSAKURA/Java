package Method;


//final修饰方法，方法不可以重写，但是可以被子类访问 【前提：方法不是 private 类型】。

class Fu{
    public final void speak(){
        System.out.println("粑粑：不，你不想拉粑粑");
    }
}
class  Zi extends Fu{
    //直接编译失败，被final修饰的方法不能被重写
//    public void speak(){
//        System.out.println("熊孩子：粑粑，我想拉粑粑");
//    }
}

public class EmbellishMethod {
    public static void main(String[] args) {

        Zi z =new Zi();
        z.speak();  //访问final修饰的方法
    }
}

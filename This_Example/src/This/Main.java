package This;

public class Main {
	public static void main(String [] args){

		This p1 = new This("",20,"Man");
		System.out.println(""+p1.getName()+" "+p1.getAge()+" years old Gender："+p1.getGender());
		
		This p2 = new This();
		p2.setAge(20);
		p2.setName("张三");
		p2.setGender("男");
		System.out.println(""+p2.getName()+" 今年"+p2.getAge()+"岁 性别为："+p2.getGender());
		
		This p3 = new This();
		System.out.println(""+p3.getName()+"  "+p3.getAge()+" years old Gender："+p3.getGender());
	}

}

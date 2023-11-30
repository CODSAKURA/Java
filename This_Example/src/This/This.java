package This;

public class This {
	private String name;
	private int age;
	private String gender;
	
	public This(){}
	
	public This(String name) 
	{
		this.name = name;
	}
	
	public This(String name,int age,String gender)
	{
		this("aaa");
		//1.this():访问特定的constructor of this class
		//2.this():不能使用在普通方法中 只能写在构造方法中
        //3.this():必须是构造方法中的第一条语句
		//4.this():必须在第一行，以保证在执行任何动作前，对象已经完成了初始化。
		//5.this():()中可以有参数的 如果有参数就要创建对应的constructor在这个class比如This(String a)；
		
		this.age = age;
		this.gender = gender;
		//this是用来区分成员变量和局部变量（重名问题）
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return age;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getGender()
	{
		return gender;
	}

}

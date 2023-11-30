package staticexampleofseparateclass;

public class Distance {

	public static void main(String[] args) 
	{
		System.out.println(Conversion.milesToKm(2.0));
		System.out.println(Conversion.inchestoCm(1.0));
		
		//一旦用了static主class的话就不用再创建前面一个class的object了可以直接class.method就好了
		
	}

}

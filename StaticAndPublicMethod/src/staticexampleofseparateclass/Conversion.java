package staticexampleofseparateclass;

public class Conversion {
	
	static double milesToKm(double miles) 
	{
		return miles * 1.6;
	}

	public static double inchestoCm(double inches) 
	{
		return inches * 2.54;
	}

	
	//public, private, protected are called access specifier.
	//If no access specifier is given for a method, then by default, that method can be called from anywhere in the package that contains the class , but not from outside that package.
	//public can be accessed outside package but no access modifier can not.
}

package animal1;

public class Bird extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a bird"; 
	}

	@Override
	public String getNoise()
	{
		return "squarks";
	}
	
	@Override
	public String getMovement()
	{
		return "flies";
	}
}
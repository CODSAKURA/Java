package animal1;

public class Fish extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a fish"; 
	}

	@Override
	public String getNoise()
	{
		return "glugs";
	}

	@Override
	public String getMovement()
	{
		return "swims";
	}
}
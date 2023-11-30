package animal1;

public class Lion extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a Lion"; 
	}

	@Override
	public String getNoise()
	{
		return "Roars";
	}


	@Override
	public String getMovement()
	{
		return "prowls";
	}
}
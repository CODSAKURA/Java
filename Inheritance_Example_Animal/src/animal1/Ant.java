package animal1;

public class Ant extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am an ant"; 
	}

	@Override
	public String getNoise()
	{
		return "snips";
	}


	@Override
	public String getMovement()
	{
		return "runs";
	}
}

package animal1;

public class Bear extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a bear"; 
	}

	@Override
	public String getNoise()
	{
		return "GROWLs";
	}
	
	@Override
	public String getMovement()
	{
		return "runs";
	}
}
package animal1;

public class Mouse extends Animal
{
	@Override
	public String getName() 
	{ 
		return "I am a mouse"; 
	}

	@Override
	public String getNoise()
	{
		return "squeeks";
	}
	
	@Override
	public String getMovement()
	{
		return "scurries";
	} 
}
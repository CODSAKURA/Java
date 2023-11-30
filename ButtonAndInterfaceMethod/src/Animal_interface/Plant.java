package Animal_interface;


public class Plant implements Animal
{
	public String getName() 
	{ 
		return "I am a plant"; 
	}

	public String getNoise()
	{
		return "empty";
	}

	public String getType()
	{
		return "Plant";
	}
}

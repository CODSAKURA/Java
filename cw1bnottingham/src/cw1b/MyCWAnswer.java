package cw1b;

public class MyCWAnswer extends BaseClass 
{	
	@Override
	public void createAnimals() 
	{
		storeAnimal(new Ant());
		storeAnimal(new Bear());
		storeAnimal(new Bird());
		storeAnimal(new Fish());
		storeAnimal(new Lion());
	}
	
	protected PGPText movement = new PGPText();
	protected PGPText noises = new PGPText();	
	
	@Override
	public void recordMadeSound( String str )
	{
		System.out.println(str);
		noises.addLine(str);
	}
	
	@Override
	public void recordMoved( String str ) 
	{
		System.out.println(str);
		movement.addLine(str);
	}
		
	@Override
	public void finish()
	{
		PGPFile c = new PGPFile();
		c.openWriteFile("output.txt");
		
		c.writeLine("List of noise made:");
		for(int i = 0 ; i < noises.getLineCount();i++)
		{
			c.writeLine(noises.getLine(i));
		}
		c.writeLine("List of movement made:");
		for(int i = 0 ; i < noises.getLineCount();i++)
		{
			c.writeLine(movement.getLine(i));
		}
	
		c.closeWriteFile();
	}
}

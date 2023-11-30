package cw1b;
// Note: ctrl-shift-o for import every standard thing needed
import java.util.ArrayList;

public class BaseClass
{
	public void createAnimals()
	{
		System.out.println("You need to override the createAnimals() function to create and store animals");
	}
	
	public void recordMadeSound( String str )
	{
		System.out.println("You need to implement the recordMadeSound() method in your subclass");
	}
	
	public void recordMoved( String str )
	{
		System.out.println("You need to implement the recordMoved() method in your subclass");
	}
	
	public void finish()
	{
		System.out.println("You need to implement the finish() method in your subclass to output the noises and movement lists");
	}

	

	// Don't override or change this!
	public void doStuff()
	{
		createAnimals();
		for ( Animal an : myAnimals )
		{
			recordMoved( an.getMovement() );
			recordMadeSound( an.getNoise() );
			recordMoved( an.getMovement() );
		}
		finish();
	}

	// I hid this inside by making it private
	// List of animals to 'do stuff with'
	private ArrayList<Animal> myAnimals = new ArrayList<Animal>();
	
	// Don't override or change this function!
	// Store an animal in the list - will be used later
	public void storeAnimal( Animal animalToStore )
	{
		myAnimals.add(animalToStore);
	}
}

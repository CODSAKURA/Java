package a;

import animal1.*;

public class Main5 {

	public static void main(String[] args) {
		Animal[] animals = new Animal[6];
		animals[0] = new Bear();
		animals[1] = new Mouse();
		animals[2] = new Mouse();
		animals[3] = new Fish();
		animals[4] = new Mouse();
		animals[5] = new Bear();
		for ( int i = 0 ; i < animals.length ; i++ )
		{
			System.out.println( "" + animals[i].getName() + " ... " + animals[i].getNoise() );
		}

	}

}

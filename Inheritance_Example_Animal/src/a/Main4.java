package a;

public class Main4 {

	public static void main(String[] args) {
		animal1.Animal[] animals = new animal1.Animal[6];
		animals[0] = new animal1.Bear();
		animals[1] = new animal1.Mouse();
		animals[2] = new animal1.Mouse();
		animals[3] = new animal1.Fish();
		animals[4] = new animal1.Mouse();
		animals[5] = new animal1.Bear();
		for ( int i = 0 ; i < animals.length ; i++ )
		{
			System.out.println( "" + animals[i].getName() + " ... " + animals[i].getNoise() );
		}

	}

}

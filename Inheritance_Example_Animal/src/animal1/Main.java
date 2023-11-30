package animal1;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("");
		Animal animal = new Animal();
		System.out.println("I am an : " + animal.getName() );
		System.out.println("My type is : " + animal.getType() );
		System.out.println("I go : " + animal.getNoise() );
		System.out.println("Movement: " + animal.getMovement());
		System.out.println("");
		
		Ant a2 = new Ant();
		System.out.println("I am an : " + a2.getName() );
		System.out.println("My type is : " + a2.getType() );
		System.out.println("I go : " + a2.getNoise() );
		System.out.println("Movement: " + a2.getMovement());
		System.out.println("");
		
		Animal a3 = new Bear();
		System.out.println("I am a : " + a3.getName() );
		System.out.println("My type is : " + a3.getType() );
		System.out.println("I go : " + a3.getNoise() );
		System.out.println("Movement: " + a3.getMovement());
		System.out.println("");
		
		Animal a4 = new Bird();
		System.out.println("I am a : " + a4.getName() );
		System.out.println("My type is : " + a4.getType() );
		System.out.println("I go : " + a4.getNoise() );
		System.out.println("Movement: " + a4.getMovement());
		System.out.println("");
		
		Animal a5 = new Fish();
		System.out.println("I am a : " + a5.getName() );
		System.out.println("My type is : " + a5.getType() );
		System.out.println("I go : " + a5.getNoise() );
		System.out.println("Movement: " + a5.getMovement());
		System.out.println("");
		
		Animal a6 = new Lion();
		System.out.println("I am a : " + a6.getName() );
		System.out.println("My type is : " + a6.getType() );
		System.out.println("I go : " + a6.getNoise() );
		System.out.println("Movement: " + a6.getMovement());
		System.out.println("");
		
		Animal a7 = new Mouse();
		System.out.println("I am a : " + a7.getName() );
		System.out.println("My type is : " + a7.getType() );
		System.out.println("I go : " + a7.getNoise() );
		System.out.println("Movement: " + a7.getMovement());
		System.out.println("");
	}

}

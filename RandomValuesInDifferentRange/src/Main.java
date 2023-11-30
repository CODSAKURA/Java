
public class Main {

	public static void main(String[] args) {
		
		/*This generates a random value from 0 to 5*/
		int range0To5 = (int)(6 * Math.random());
		
		/*This generates a random value from 1 to 6*/
		int range1To6 = (int)(6 * Math.random()) + 1;
		
		/*This generates a random value from 65 to 90*/
		int range65To90 = (int)(26 * Math.random()) + 65;
		
		System.out.println("A random value from a range 0 to 5:" + range0To5);
		System.out.println("A random value from a range 1 to 6:" + range1To6);
		System.out.println("A random value from a range 65 to 90:" + range65To90);

	}

}

package ZooProjectStage4_src;

public class ZooApp {

	static void process(int value)
	{
		value = 10;
	}
	
	
	
	public static void main(String[] args) {

		/* Passing by value constitutes copying of data, 
		 * where changes to the copied value are not 
		 * reflected in the original value.
		 */	
		int s = 7;
		process(s);
		System.out.println(s); 
		
		
		/*Passing by reference constitutes the aliasing
		 * of data, where changes to the aliased value 
		 * are reflected in the original value.
		 * 
		 * C++ example:
		 * 	void process(int& value){
		 * 		value = 10;
		 * 	}
		 * 	Main:
		 * 	int somevalue = 7;
		 * 	process(somevalue);
		 * 	Output:10
		 * 
		 * Java:
		 * using object to change value. 
		 * object same as C++ 
		 * like pointer.
		 */
				
		
		Zoo zoo1=new Zoo("Hamburg");
		zoo1=new Zoo("Munic"); // new object takes over reference; old object not accessible any more
		Zoo zoo2=zoo1; // references zoo1 and zoo2 point to same object
		Zoo zoo3=new Zoo();
		System.out.println("\nZoo1:"+zoo1);
		System.out.println("Zoo2:"+zoo2);
		System.out.println("Zoo3:"+zoo3);
		zoo3.setLocation("Berlin");
		zoo1.setLocation("Berlin"); // sets it for zoo1 and zoo2
		System.out.println("\nZoo1:"+zoo1);
		System.out.println("Zoo2:"+zoo2);
		System.out.println("Zoo3:"+zoo3);
		zoo1=new Zoo("SanDiego"); // sets it for zoo1 only
		System.out.println("\nZoo1:"+zoo1);
		System.out.println("Zoo2:"+zoo2);
		System.out.println("Zoo3:"+zoo3);
	}
}

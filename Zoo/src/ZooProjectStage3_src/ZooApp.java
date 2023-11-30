package ZooProjectStage3_src;

public class ZooApp {

	public static void main(String[] args) {
		//Zoo zoo=new Zoo();
		Zoo zoo=new Zoo("Hamburg");		
		Zoo zoo2 = new Zoo();
		
		System.out.println("\nZoo:"+zoo);
		System.out.println("\nZoo2:"+ zoo2.toString());
	}
}

package Lab2_Zoo_Part1;

public class ZooApp {

	public static void main(String[] args) {
		Zoo.numZoos=0;
		Zoo zoo1=new Zoo("London",20);
		Zoo zoo2=new Zoo("Tokyo",15);
		Zoo zoo3=new Zoo("New York",26);
		Zoo zoo4=new Zoo("Paris",18);
		Zoo zoo5=new Zoo("Beeston",5);
		System.out.println(zoo1.printInfo());
		System.out.println(zoo2.printInfo());
		System.out.println(zoo3.printInfo());
		System.out.println(zoo4.printInfo());
		System.out.println(zoo5.printInfo());
		System.out.println("Number of Zoos:"+Zoo.numZoos);
	}
}

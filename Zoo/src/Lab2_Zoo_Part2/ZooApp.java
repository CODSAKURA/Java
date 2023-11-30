package Lab2_Zoo_Part2;

public class ZooApp {

	public static void main(String[] args) {
		Zoo.numZoos=0;
		Zoo zoo1=new Zoo("London",20);
		ZooCorp megaZoo=new ZooCorp(zoo1);
		Zoo zoo2=new Zoo("Tokyo",15);
		megaZoo.addZoo(zoo2);
		Zoo zoo3=new Zoo("New York",26);
		Zoo zoo4=new Zoo("Paris",18);
		Zoo zoo5=new Zoo("Beeston",5);
		System.out.println(zoo1.printInfo());
		System.out.println(zoo2.printInfo());
		System.out.println(zoo3.printInfo());
		System.out.println(zoo4.printInfo());
		System.out.println(zoo5.printInfo());
		zoo5.buildNewCompound();
		System.out.println(zoo5.printInfo());
		System.out.println("Number of Zoos:"+Zoo.numZoos);
		Employee sue=new Zookeeper("Sue");
		Employee bob=new Admin("Bob");
		megaZoo.addStaff(sue);
		megaZoo.addStaff(bob);
		System.out.println(sue.getClass().getSimpleName()+":"+sue.getEmployeeName()+":"+sue.calculateChristmasBonus());
		System.out.println(bob.getClass().getSimpleName()+":"+bob.getEmployeeName()+":"+bob.calculateChristmasBonus());
	}
}

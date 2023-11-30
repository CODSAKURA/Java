package Lab2_Zoo_Part2;

public class Zookeeper extends Employee {

	public Zookeeper(String name) {
		super(name);
	}

	@Override
	public int calculateChristmasBonus() {
		return (int) (getSalary()*0.05+100);
	}

}

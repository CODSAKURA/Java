package Lab2_Zoo_Part2;

public class Admin extends Employee {

	public Admin(String name) {
		super(name);
	}

	@Override
	public int calculateChristmasBonus() {
		return (int) (getSalary()*0.08);
	}

}

package Time;
//Simulation of a clock, using the Time class

public class Clock {
	public static void main(String[] args) throws InterruptedException {
		
		Time time = new Time(0, 0, 1);

		while (true) {
			System.out.println(time);
			Thread.sleep(1000);        // pause for 1 second
			time.advance(1);
		}
	}
}
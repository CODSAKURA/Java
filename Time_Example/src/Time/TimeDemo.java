package Time;
//Program to informally test the Time class

public class TimeDemo {
public static void main(String[] args) {
	Time t1 = new Time(8, 30, 5);
	Time t2 = new Time(13, 26);

	System.out.println("t1 = " + t1);
	System.out.println("t2 = " + t2);

	System.out.println("t1 hours = " + t1.getHours());
	System.out.println("t2 minutes = " + t2.getMinutes());

	System.out.println("t2 is morning? " + t2.isMorning());
	System.out.println("t1 earlier than t2? " + t1.earlierThan(t2));

	System.out.println("Advancing t1 by 100 seconds...");
	t1.advance(60);
	System.out.println("t1 = " + t1);

	System.out.println("Trying to set t2 seconds to 60...");
	t2.setSeconds(60);
	System.out.println("t2 = " + t2);  // this should not execute
	}
}

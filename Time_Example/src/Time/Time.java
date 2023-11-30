package Time;
//Class to represent time on a 24-hour clock

public class Time {
	// Constants used by methods of Time
	// (static means they are shared by all instances)

	private static final int SEC_IN_A_MINUTE = 60;
	private static final int MIN_IN_AN_HOUR = 60;
	private static final int SEC_IN_AN_HOUR = SEC_IN_A_MINUTE * MIN_IN_AN_HOUR;
	private static final int HOURS_IN_A_DAY = 24;

	// Private fields to represent components of a time

	private int hours;
	private int minutes;
	private int seconds;

	// Constructors that initialise a Time object three different ways

	public Time() {
		this(0, 0, 0);   // calls the three-parameter constructor
	}

	public Time(int h, int m) {
		this(h, m, 0);
	}

	public Time(int h, int m, int s) {
		setHours(h); 	// different ways of initialising the fields
		setMinutes(m);	// in this case, constructor delegates field initialisation to setter method
		setSeconds(s);   
	}


	//Getters also known as accessor methods, provide information on object state
	// Even if the variable itself is private, you can allow other classes to find out what its value is by providing a public accessor method that returns the value of the variable.	
	public int getHours() 
	{
		//// Also getter method might keep track of the number of times that the variable has been accessed
		//int titleAccessCount = 0;
		//titleAccessCount++;  // Increment member variable titleAccessCount.
		return hours;
	}

	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	
	//Setters, also known as mutator methods, modify object state by changing fields to given values.
	//Setters should check the validity of the given values before modifying a field; they can throw an exception to signal that a value is not valid
	//You might also want to allow "write access" to a private variable. That is, you might want to make it possible for other classes to specify a new value for the variable. This is done with a setter method.	
	public void setHours(int h) {

		if (h < 0 || h >= HOURS_IN_A_DAY) 
		{
			throw new IllegalArgumentException("Invalid hours");
		}

		hours = h; 
		
	}

	public void setMinutes(int m) {
		
		if (m < 0 || m >= MIN_IN_AN_HOUR) 
		{
			throw new IllegalArgumentException("Invalid minutes");
		}

		minutes = m;
	}

	public void setSeconds(int s) {
		
		if (s < 0 || s >= SEC_IN_A_MINUTE) 
		{
			throw new IllegalArgumentException("Invalid seconds");
		}

		seconds = s;
	}

	// toString method, providing a string representation of times (called automatically whenever you print a Time object)

	@Override
	public String toString() {
		return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	}

	// Examples of predicate methods (returning true or false)

	public boolean isMorning() {
		return hours < 12;
	}

	public boolean isAfternoon() {
		return !isMorning();
	}

	public boolean earlierThan(Time other) {
		return secondsSinceMidnight() < other.secondsSinceMidnight();
	}

	public boolean laterThan(Time other) {
		return secondsSinceMidnight() > other.secondsSinceMidnight();
	}

	// Example of a private method - used in implementation of the class but not visible to the outside world

	private int secondsSinceMidnight() {
		return seconds + SEC_IN_A_MINUTE * minutes + SEC_IN_AN_HOUR * hours;
	}
	
	// A method to advance time by a specified number of seconds

	public void advance(int numSeconds) 
	{
		int timeInSeconds = secondsSinceMidnight() + numSeconds;

		hours = (timeInSeconds / SEC_IN_AN_HOUR) % HOURS_IN_A_DAY;

		int remainingSeconds = timeInSeconds % SEC_IN_AN_HOUR;
		minutes = remainingSeconds / SEC_IN_A_MINUTE;
		seconds = remainingSeconds % SEC_IN_A_MINUTE;
	}

}


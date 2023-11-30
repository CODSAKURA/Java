package Time;

public class Time2 {
	
	private  static final int SEC_IN_A_MINUTE = 60;
	private  static final int MIN_IN_AN_HOUR = 60;
	private  static final int HOURS_IN_A_DAY = 24;
	
	
	
	 private int hours;
	 private int minutes;
	 private int seconds;
	 
	public Time2(int h, int m, int s) {
		
		if (h < 0 || h >= HOURS_IN_A_DAY) 
		{
			throw new IllegalArgumentException("invalid hours");
		}
		
		if (m < 0 || m >= MIN_IN_AN_HOUR) 
		{
			throw new IllegalArgumentException("invalid minutes");
		}
		 
		if (s < 0 || s >= SEC_IN_A_MINUTE) 
		{
			throw new IllegalArgumentException("invalid seconds");
		}
		 	hours = h;
		 	minutes = m;
		 	seconds = s;
	}
	
}

package inheritance2;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;

public class Student extends Person {

	private String degree;
	private YearMonth start;

	public Student(String given, String family, LocalDate birth, String degree, YearMonth start) 
	{
		super(given, family, birth);  
		this.degree = degree;
		this.start = start;
	}

	public String getDegree() 
	{
		return degree;
	}

	public YearMonth getStart() 
	{
		return start;
	}

	public int getYearOfStudy() 
	{
		LocalDate today = LocalDate.now();
		return (int) (start.until(today, ChronoUnit.YEARS) + 1);
	}

	@Override
 	public String toString() 
	{
		return String.format("%s, %s Year %d",super.toString(), getDegree(), getYearOfStudy());
	}
}

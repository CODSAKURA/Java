package inheritance2;

// Small class to represent a Person

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {
	private String givenName;
	private String familyName;
	private LocalDate dateOfBirth;

	public Person(String givenname, String familyname, LocalDate birth) 
	{
		givenName = givenname;
		familyName = familyname;
		dateOfBirth = birth;
	}

	public String getGivenName()
	{
		return givenName;
	}

	public String getFamilyName() 
	{
		return familyName;
	}

	public LocalDate getDateOfBirth() 
	{
		return dateOfBirth;
	}

	public String getCharacter() 
	{
		return givenName.substring(0, 1) + familyName.substring(0, 1);
	}

	public int getAge() 
	{
		LocalDate today = LocalDate.now();
		return (int) dateOfBirth.until(today, ChronoUnit.YEARS);
	}

	public boolean isBirthday() 
	{
		LocalDate today = LocalDate.now();
		return today.getMonth() == dateOfBirth.getMonth() && today.getDayOfMonth() == dateOfBirth.getDayOfMonth();
	}

	@Override
	public String toString() 
	{
		return givenName + " " + familyName;
	}
}

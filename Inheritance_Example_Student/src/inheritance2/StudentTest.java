package inheritance2;
// Test program for Student class

import java.time.LocalDate;
import java.time.YearMonth;

import static java.lang.System.out;

public class StudentTest {
  public static void main(String[] args) {

	  // Create a Student

    LocalDate birthDate = LocalDate.of(1998, 2, 28);
    YearMonth start = YearMonth.of(2017, 9);

    Student student = new Student(
      "Sarah", "Davies", birthDate, "Computer Science", start);

    // Test inherited methods

    out.printf("Given name    : %s\n", student.getGivenName());
    out.printf("Family name   : %s\n", student.getFamilyName());
    out.printf("Character     : %s\n", student.getCharacter());
    out.printf("Date of birth : %s\n", student.getDateOfBirth());
    out.printf("Age (years)   : %d\n", student.getAge());
    out.printf("Birthday?     : %s\n", student.isBirthday());

    // Test other methods added in Student

    out.printf("Degree        : %s\n", student.getDegree());
    out.printf("Started       : %s\n", student.getStart());
    out.printf("Year of study : %d\n", student.getYearOfStudy());

    // Test overridden toString method

    out.printf("As a string   : %s\n", student);
  }
}

package ArrayExample;

import java.util.Scanner;

public class SetStudentName {

	
	private String name;

	public static void main(String[] args) {
		
		//For an array of type Student[], each element of the array is a variable of type Student. To store information about 30 students, we could use an array.
		SetStudentName[] classlist;  // Declare a variable of type Student[].
		classlist = new SetStudentName[30];  // The variable now points to an array.
		//The array has 30 elements, classlist[0], classlist[1], ... classlist[29]. When the array is created, it is filled with the default initial value, which for an object type is null. 
		//So, although we have 30 array elements of type Student, we don't yet have any actual Student objects! All we have is 30 nulls. If we want student objects, we have to create them.
		for ( int i = 0; i < 5; i++ ) {
		    classlist[i] = new SetStudentName();
		    Scanner a = new Scanner(System.in);		    
		    classlist[i].name = a.next();
		}
		
		//Once we have done this, each classlist[i] points to an object of type Student. If we want to talk about the name of student number 3, we can use classlist[3].name. You can do anything with classlist[i] that you could do with any other variable of type Student.
		System.out.println(classlist[0].name);
		System.out.println(classlist[1].name);
		System.out.println(classlist[2].name);
		System.out.println(classlist[3].name);
		System.out.println(classlist[4].name);
	}

}

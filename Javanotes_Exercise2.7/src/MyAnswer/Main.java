package MyAnswer;

import textio.TextIO;

public class Main {

	public static void main(String[] args) 
	{
		TextIO.readFile("testdata.txt");	//Getting and Opening the File
		String name = TextIO.getln();	//Assign the name to a variable
		
		double score1 = TextIO.getlnDouble();	//Assign the first score to a variable
		double score2 = TextIO.getlnDouble();	//Assign the second score to a variable
		double score3 = TextIO.getlnDouble();	//Assign the third score to a variable
		double averageScore = (score1 + score2 + score3) / 3.0;		//Calculating the average score
		
		System.out.println("Student Name: " + name);	//Print the name
		System.out.printf("Average Grade is %.2f" , averageScore);	//Print the average score
		

	}

}

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/*This class write word or sentence
 * into a file using System.println
 * */
public class WriteFile {
   
	public static void main(String args[]) throws IOException 
	{
      //Instantiating the File class
      File file = new File("D:\\Eclipse-workspace\\Write_Into_File_Using_Println\\sample.txt");
      
      //Instantiating the PrintStream class
      PrintStream stream = new PrintStream(file);
      
      //Show the message without meaning
      System.out.println("From now on "+file.getAbsolutePath()+" will be your console");
      System.setOut(stream);
      
      //Printing values to file
      System.out.println("Hello, how are you");
      System.out.println("Welcome to Tutorialspoint");
   }
}

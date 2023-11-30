/*
 * This class is the communication protocol for
 * server and client.
 */
public class Protocol 
{
	//Handling the number of command line arguments given by the Client
	public String processInputNumber(int number)
	{
		String theOutput = null;
		
		if(number == 0)
		{
			theOutput = "Need command line argument: list/get [filename]. Try again....";
		}
		else if(number == 2)
		{
			theOutput = "Two arguments correct but not 'get [filename]'. Try again.... ";
		}
		else
		{
			theOutput = "I said one or two arguments. Try again.... ";
		}
		
		return theOutput;
	}
	
	//Handling the string of command line arguments given by the Client
	public String processInputString(String input)
	{
		String theOutput = null;
		
		if(input.equals("list") == true)
		{
			theOutput = "Above Are All The Files Have Listed Choosing One Of These!";
		}
		else if(input.equals("Nolist"))
		{
			theOutput = "One argument correct but not 'list'. Try again.... ";
		}
		else if(input.equals("Success"))
		{
			theOutput = "File Successful Transfer!";
		}
		else if(input.equals("Notext"))
		{
			theOutput = "Only text file can be transferred Try again....";
		}
		else
		{
			theOutput = "No Such File Existed....";
		}
		return theOutput;		
	}

}

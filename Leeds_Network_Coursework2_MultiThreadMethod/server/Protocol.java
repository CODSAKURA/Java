/*
 * This class is the communication protocol for
 * server and client.
 */
public class Protocol 
{
	//Handling the string given by the ClientHandler Class
	public String processInput(String theInput)
	{
		String theOutput = null;
		
		if(theInput.equals("list") == true)
		{
			theOutput = "Above Are All The Files Have Listed Choosing One Of These!";
		}
		else if(theInput.equals("Success"))
		{
			theOutput = "File Successful Transfer!";
		}
		else
		{
			theOutput = "No Such File Existed....";
		}
		return theOutput;
	}

}

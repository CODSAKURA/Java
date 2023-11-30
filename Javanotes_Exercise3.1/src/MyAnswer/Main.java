package MyAnswer;

public class Main {

	public static void main(String[] args) 
	{			
		int dice1 = (int)(6*Math.random()) + 1;		//Get a random value 1-6
		int dice2 = (int)(6*Math.random()) + 1;		//Get another random value 1-6
		int count = 1;		//Because previously both dices have been rolled so it starts at 1
		
		while(true)		//The rolling keep going until find both equal to 1
		{			
			if(dice1 == 1 && dice2 == 1)
			{
				System.out.println(count + " rolls coming up snake eyes.");
				System.exit(0);
			}
			else
			{
				dice1 = (int)(6*Math.random()) + 1;
				dice2 = (int)(6*Math.random()) + 1;
				count++;
			}
		}
	}

}

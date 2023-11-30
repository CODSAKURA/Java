package ArrayExample2;

import java.util.Arrays;
import java.util.Scanner;

// A Game Program, and that players can join the game and leave the game as it progresses. 

public class Player {
	
	private String player;
	
	private static String c = "n";
	
	public static Player[] playerList = new Player[5];
	public static int playerCr = 0;

	private static Scanner a;
	private static Scanner b;
	private static Scanner s;
	private static Scanner nn;
	private static Scanner ss;
	private static Scanner ss2;
	private static Scanner tt;
	private static Scanner s2;
	private static Scanner nn2;
	private static Scanner ss3;
	private static Scanner ss4;
	private static Scanner tt2;
	private static Scanner f;
	private static Scanner tt3;

	
	//delete player number k is to move the player from the last occupied position in the array into position k and then to decrement the value of playerCr
	//把最后一个element替代掉你要remove的element里，然后长度减少。
	public static void delete(int k)
	{
		playerList[k] = playerList[playerCr - 1];
		playerCr--;
		if ( playerCr < playerList.length/4 ) 
		{
	        // More than 3/4 of the spaces are empty. Cut the array size in half.
			playerList = Arrays.copyOf( playerList, playerList.length/2 );
		}
	}
	
	
	//To do this, all the players in positions k+1 and following must move up one position in the array. Player k+1 replaces player k, who is out of the game. Player k+2 fills the spot left open when player k+1 is moved. And so on.
	//另一种方法将删掉的元素的后一个变到前面以此类推，长度减少。
	public static void delete2(int q)
	{
		for (int i = q+1; i < playerCr; i++) {
		    playerList[i-1] = playerList[i];
		}
		playerCr--;
		if ( playerCr < playerList.length/4 ) 
		{
	        // More than 3/4 of the spaces are empty. Cut the array size in half.
			playerList = Arrays.copyOf( playerList, playerList.length/2 );
		}
	}

	
	//copy the origin data to the new array and double it
	//复制旧array到新array然后新array是旧array的2倍数
	public static void extend()
	{
		if ( playerCr == playerList.length ) 
		{
	        // The number of players is already equal to the size of the array.
	        // The array is full.  Make a new array that has more space.
			Player[] temp;   // A variable to point to the new array.
			temp = new Player[ 2*playerList.length ];  // Twice as big as the old array.
			for ( int i = 0; i < playerList.length; i++ ) 
			{
				temp[i] = playerList[i];  // Copy item from old array into new array.
			}
			playerList = temp;  // playerList now points to the new, bigger array.    
		}
	}
	

	
	
	
	public static void main(String[] args) {
		
		for ( int i = 0; i < playerList.length; i++ ) {
		    playerList[i] = new Player();
		    playerCr++;

			System.out.print("Enter a Player:");
			a = new Scanner(System.in);
		    playerList[i].player =a.next();
		    
		    System.out.print("Enter 'n' to quit or continue by entering 'y':");
		    b = new Scanner(System.in);
		    		    
		    if(b.next().equals(c))
		    {
		    	System.out.print("On!! Okay!! Here are the list of player that you have entered:");
		    	for(int t = 0; t< playerCr;t++)
				{
					if(t == playerCr-1 )
					{
						System.out.print(playerList[t].player);
						continue;
					}
					System.out.print(playerList[t].player +" , ");
				}
		    	for(int r = 0; ; r++)
		    	{
		    		System.out.println("");
		    		System.out.print("Whether you want to delete an element n or y: ");
		    		s = new Scanner(System.in);
		    		if(s.next().equals(c))
		    		{
		    			System.out.print("Ok,That is it!!!");
		    			System.exit(0);
		    		}
		    		else
		    		{
		    			System.out.print("Which method you want to choose to delete element(1.last one replace the delete one/2. following one replace delete one?):");
		    			nn = new Scanner(System.in);
		    			if(nn.nextInt() == 1)
		    			{
		    				for(int rr = 0; ; rr++)
		    				{
		    					System.out.print("Which element you want to delete?:");
		    					ss = new Scanner(System.in);
		    					int ds = ss.nextInt();
		    					if(ds > playerCr)
		    					{
		    						System.out.println("Error input");
		    						continue;
		    					}
		    					delete(ds);
		    					for(int t = 0; t< playerCr;t++)
		    					{
		    						if(t == playerCr-1 )
		    						{
		    							System.out.print(playerList[t].player);
		    							continue;
		    						}
		    						System.out.print(playerList[t].player +",");
		    					}
		    					System.out.println("");
		    					System.out.print("Whether you want to delete another element n or y:");
		    					tt3 = new Scanner(System.in);
		    					if(tt3.next().equals(c))
		    					{
		    						System.out.print("Ok!That is it");
		    						System.exit(0);
		    					}
		    					continue;
		    				}
		    			}
		    			else
		    			{
		    				for(int rr = 0; ; rr++)
		    				{
		    					System.out.print("Which element you want to delete?:");
		    					ss2 = new Scanner(System.in);
		    					int ds = ss2.nextInt();
		    					if(ds > playerCr)
		    					{
		    						System.out.println("Error input");
		    						continue;
		    					}
		    					delete2(ds);
		    					for(int t = 0; t< playerCr;t++)
		    					{
		    						if(t == playerCr-1 )
		    						{
		    							System.out.print(playerList[t].player);
		    							continue;
		    						}
		    						System.out.print(playerList[t].player +",");
		    					}
		    					System.out.println("");
		    					System.out.print("Whether you want to delete another element n or y:");
		    					tt = new Scanner(System.in);
		    					if(tt.next().equals(c))
		    					{
		    						System.out.print("Ok!That is it");
		    						System.exit(0);
		    					}
		    					continue;
		    				}
		    			}
		    		}
		    	}		    	
		    }		    
		    
		    if(playerCr == playerList.length)
		    {
		    	System.out.print("On!! The Player is up to length 5!!!!!!. Here are the player that you have entered:");
		    	for ( int iii = 0; iii < playerList.length; iii++ )
		    	{
		    		if(iii == playerList.length -1)
		    		{
		    			System.out.print(playerList[iii].player);
		    			continue;
		    		}
		    		System.out.print(playerList[iii].player + ",");
		    	}
		    	
		    	
		    	for(int r = 0; ; r++)
		    	{
		    		System.out.println("");
		    		System.out.print("Whether you want to delete an element n or y: ");
		    		s2 = new Scanner(System.in);
		    		if(s2.next().equals(c))
		    		{
		    			System.out.print("Ok,That is it!!!");
		    			
		    		}
		    		else
		    		{
		    			System.out.print("Which method you want to choose to delete element(1.last one replace the delete one/2. following one replace delete one?):");
		    			nn2 = new Scanner(System.in);
		    			if(nn2.nextInt() == 1)
		    			{
		    				for(int rr = 0; ; rr++)
		    				{
		    					System.out.print("Which element you want to delete?:");
		    					ss3 = new Scanner(System.in);
		    					int ds = ss3.nextInt();
		    					if(ds > playerCr)
		    					{
		    						System.out.println("Error input");
		    						continue;
		    					}
		    					delete(ds);
		    					for(int t = 0; t< playerCr;t++)
		    					{
		    						if(t == playerCr-1 )
		    						{
		    							System.out.print(playerList[t].player);
		    							continue;
		    						}
		    						System.out.print(playerList[t].player +",");
		    					}
		    					System.out.println("");
		    					System.out.print("Whether you want to delete another element n or y:");
		    					Scanner tt = new Scanner(System.in);
		    					if(tt.next().equals(c))
		    					{
		    						System.out.print("Ok!That is it");
		    						System.exit(0);
		    					}
		    					continue;
		    				}
		    			}
		    			else
		    			{
		    				for(int rr = 0; ; rr++)
		    				{
		    					System.out.print("Which element you want to delete?:");
		    					ss4 = new Scanner(System.in);
		    					int ds = ss4.nextInt();
		    					if(ds > playerCr)
		    					{
		    						System.out.println("Error input");
		    						continue;
		    					}
		    					delete2(ds);
		    					for(int t = 0; t< playerCr;t++)
		    					{
		    						if(t == playerCr-1 )
		    						{
		    							System.out.print(playerList[t].player);
		    							continue;
		    						}
		    						System.out.print(playerList[t].player +",");
		    					}
		    					System.out.println("");
		    					System.out.print("Whether you want to delete another element n or y:");
		    					tt2 = new Scanner(System.in);
		    					if(tt2.next().equals(c))
		    					{
		    						System.out.print("Ok!That is it");
		    						System.exit(0);
		    					}
		    					continue;
		    				}
		    			}
		    		}
		    		System.out.println("");
					System.out.print("Whether you want to extend(double) your player array? n/y:");
					f = new Scanner(System.in);
					if(f.next().equals(c))
					{
						System.exit(0);
					}
					extend();
					break;
		    	}
		    }
		    continue;
		}	
	}
	
	
}

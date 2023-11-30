package Q1_3;

import java.util.ArrayList;
import java.util.Random;


public class WhatAmI {
	
	public static boolean equiv(int a, int b)
	{
		if(a == 1 || a == 2 || a == 3 || a == 4 && b == 1 || b == 2 || b == 3 || b == 4)
		{
			return true;
		}
		if(a == 5 || a == 6 || a == 7 && b == 5 || b == 6 || b == 7)
		{
			return true;
		}
		return false;
	}
	
	public static ArrayList<Integer> whatami(ArrayList<Integer> S)
	{		
		if(S.size() == 1)
		{
			return S;
		}
		
		ArrayList<Integer> L = null;
		L = new ArrayList<Integer>();
		
		ArrayList<Integer> R = null;
		R = new ArrayList<Integer>();
		
		int p = 0;
		
		for(int s : S)
		{
			if(p == 0)
			{
				L.add(s);
				p = 1;
			}
			else
			{
				R.add(s);
				p = 0;
			}
		}
		
		ArrayList<Integer> L1 = whatami(L);
		ArrayList<Integer> R1 = whatami(R);
		
		if(L1 != null)
		{
			Random r = new Random();
			int a = L1.get(r.nextInt(L1.size()));
			
			for (int b : R)
			{
				if(equiv(a,b) == true)
				{
					L1.add(b);
				}
			}
			
			if(L1.size() > ((L.size() + R.size())/2))
			{
				return L1;
			}
		}
		
		if(R1 != null )
		{
			Random r = new Random();
			int a = R1.get(r.nextInt(R1.size()));
			
			for(int b : L)
			{
				if(equiv(a,b) == true)
				{
					R1.add(b);
				}
			}
			if(R1.size() > ((L.size() + R.size())/2))
			{
				return R1;
			}
		}
		return null;
	}

	public static void main(String[] args) {

		int[] S = {1,2,3,4,5,6,7};
		ArrayList<Integer> intList = new ArrayList<Integer>(S.length);
		
		for (int i : S)
		{
		    intList.add(i);
		}
		
		System.out.print(whatami(intList));
		

	}

}

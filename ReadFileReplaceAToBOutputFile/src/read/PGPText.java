package read;

import java.util.ArrayList;

/**
 * Wrapper class created for use in G51PGP to simplify storing the text from a file
 * @author jaa
 */

//Aggregation and composition are also important relationships: one type has objects of another type
//Composition： PGPText has an internal ArrayList<>. The list is destroyed when the object is destroyed （也就是ArrayList<String>中所有的method都可以让internalArray用）
//Aggregation： The ArrayList<> contains Strings.These Strings exist outside of the ArrayList<> but references to them are added to the array

public class PGPText
{
	
	protected ArrayList<String> internalArray;
	
	public PGPText()
	{
		internalArray = new ArrayList<String>();
	}
	
	public void addLine( String strText )
	{
		internalArray.add(strText);
	}
	
	public String getLine( int iLine )
	{
		return internalArray.get(iLine);
	}

	public void setLine( int iLine, String strText )
	{
		while ( iLine >= internalArray.size() )
		{
			internalArray.add("");
		}
		internalArray.set(iLine, strText);
	}

	public int getLineCount()
	{
		return internalArray.size();
	}
	
	// A standard collection class
	
}
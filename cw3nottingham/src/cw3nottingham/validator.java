package cw3nottingham;


public class validator{

	/*build a constructor for this class*/
	public validator(){}
	
	
	/*validate the provided line which omit the line started with the capital letter*/
	public boolean validate(String a) throws Exception
	{
		String[] str = a.split("  ");
		for(String s : str)
		{
			char[] strChar = s.toCharArray();
			char firstchar = strChar[0];
			if((int)firstchar > 64 && (int)firstchar < 91)
			{
				continue;
			}
			else
			{
				return true;
			}	
		}
		throw new Exception();
	}
}

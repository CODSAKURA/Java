package cw3nottingham;

public class validator2 {
	
	protected int len;
	
	public validator2(){
		len = 12;/*a specified length (in characters), which is specified to the constructor when the object is
created.*/
	}
	
	
	/*validate the provided line which omit the line greater than specified length*/
	public boolean validate(String a) throws Exception {
		if(a.length() > len)
		{
			throw new Exception();
		}
		return true;
	}
}

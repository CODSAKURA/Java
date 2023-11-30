package CheckStringInCorrectFormat;

public class CheckStringInCorrectFormat {
	
    public static void main(String[] args) {
    	String c = "06-04-2021";
    	String d = "apple";
    	
    	if(c.matches("\\d{2}-\\d{2}-\\d{4}") == false)
    	{
    		System.out.println("You have to be in a correct format");;
    	}
    	else
    	{
    		System.out.println(c+"-"+d);
    	}
    }

}

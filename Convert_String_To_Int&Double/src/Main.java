

public class Main {

	public static void main(String[] args) {
		String str1 = "10";
		System.out.println(Integer.parseInt(str1));
		//if str is any expression of type String, then Integer.parseInt(str) is a function call that attempts to convert the value of str into a value of type int. For example, the value of Integer.parseInt("10") is the int value 10.If the parameter to Integer.parseInt does not represent a legal int value, then an error occurs.

		String str2= "20";
		System.out.print(Double.parseDouble(str2));
		//If str is a String, then the function call Double.parseDouble(str) tries to convert str into a value of type double. An error occurs if str does not represent a legal double value.
	}

}

public class Main {

	public static void main(String[] args) {
		double floatVar = 1;
		int intVar = 2;
		String stringVar = "D";
		
		String fs;
		fs = String.format("The value of the float variable is %f, while the value of the integer variable is %d, and the string is %s", floatVar, intVar, stringVar);
		System.out.println(fs);

		//the same as
		
		System.out.printf("The value of the float variable is %f, while the value of the integer variable is %d, and the string is %s", floatVar, intVar, stringVar);
	}

}

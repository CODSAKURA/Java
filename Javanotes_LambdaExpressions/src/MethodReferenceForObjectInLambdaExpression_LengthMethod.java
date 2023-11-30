/*This class introduces a method reference skill for object in Lambda Expressions.
 * Using Object(String).length() as an example.
 * */
public class MethodReferenceForObjectInLambdaExpression_LengthMethod {

	public interface SupplyInt {
	    int get( );
	}
	
	public static void main(String[] args) {
		
		String str = "Hello";
		
		SupplyInt stringLength1 = () -> {return str.length();};		
		System.out.println(stringLength1.get());
		
		SupplyInt stringLength2 = str::length;		
		System.out.println(stringLength2.get());
		
	}
	
}



public class Ex7 {
public static void main(String[] args) {
	Circle c1 = new Circle();
	Circle c2 = new Circle(3.5);
	
	System.out.println("c1 area = " + c1.getArea());
	System.out.println("c1 perimeter = " + c1.getPerimeter());
	
	System.out.println("c2 area = " + c2.getArea());
	System.out.println("c2 perimeter = " + c2.getPerimeter());
	}
}



public class Circle {
	
	private double radius;
	
	public Circle() {this.radius = 1.0;}
	public Circle(double r) { this.radius = r;}

	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return (Math.PI*radius*radius);
	}
	
	public double getPerimeter() {
		return (2*Math.PI*radius);
	}
}

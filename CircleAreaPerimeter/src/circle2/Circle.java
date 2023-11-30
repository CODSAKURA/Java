package circle2;

public class Circle {
	
	private double radius;
	
	public Circle() 
	{
		this(1.0);		
	}
	
	public Circle(double r) 
	{ 
		radius = r;
	}

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

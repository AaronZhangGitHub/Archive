
public class Circle implements Shape{

	double radius;
	String color;
	public Circle(double radius){
		this.radius = radius;
		color = null;
	}
	
	public Circle(double radius,String color){
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public void fillColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return this.color;
	}
	@Override
	public double getarea() {
		return (radius*radius*Math.PI);
	}
	
	public String toString(){
		return "Circle with radius:"+this.radius+" and color:"+this.color;
	}

}


public class Square implements Shape{

	double sideLength;
	String color;
	public Square(double sideLength){
		this.sideLength = sideLength;
		color = null;
	}
	
	public Square(double sideLength,String color){
		this.sideLength = sideLength;
		this.color = color;
	}
	
	@Override
	public void fillColor(String color) {
		// fill the method
		this.color = color;
	}

	@Override
	public String getColor() {
		//fill the method
		return this.color;
	}
	@Override
	public double getarea() {
		//fill the method
		return sideLength*sideLength;
	}
	
	public String toString(){
		return "Square with length:"+this.sideLength+" and color:"+this.color;
	}

}

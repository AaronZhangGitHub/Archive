package ex02;

public class Point<T> {
	// Point Class Encapsulates Two Coordinates
	private T x;
	private T y;
	
	// Constructor
	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}
	
	// X Getter
	public T getX() {
		return x;
	}
	
	// Y Getter
	public T getY() {
		return y;
	}
}
package ex03;

public class Point<T, S> {
	// Point Class Encapsulates Two Coordinates
	private T x;
	private S y;
	
	// Constructor
	public Point(T x, S y) {
		this.x = x;
		this.y = y;
	}
	
	// X Getter
	public T getX() {
		return x;
	}
	
	// Y Getter
	public S getY() {
		return y;
	}
}
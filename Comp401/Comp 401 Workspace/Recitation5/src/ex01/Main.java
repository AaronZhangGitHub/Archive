package ex01;

public class Main {
	public static void main(String[] args) {
		// Create New Integer Point
		Point first = new Point(5, 6);
		
		// Create New Double Point
		DPoint second = new DPoint(5.0, 6.0);

		// Print first point (int)
		System.out.println("First point: (" + first.getX() + ", " + first.getY() + ")");
		
		// Print second point (double)
		System.out.println("Second point: (" + second.getX() + ", " + second.getY() + ")");
	}
}
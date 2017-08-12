package ex02;

public class Main {
	public static void main(String[] args) {
		// Create New Integer Point
		Point<Integer> first = new Point<Integer>(5, 6);
		
		// Create New Double Point
		Point<Double> second = new Point<Double>(5.0, 6.0);

		// Print first point (int)
		System.out.println("First point: (" + first.getX() + ", " + first.getY() + ")");
		
		// Print second point (double)
		System.out.println("Second point: (" + second.getX() + ", " + second.getY() + ")");
	}
}
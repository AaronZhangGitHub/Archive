package ex03;

public class Main {
	public static void main(String[] args) {
		// Create New Integer Point
		Point<Integer, Double> mixed = new Point<Integer, Double>(5, 6.0);

		// Print first point (int)
		System.out.println("Mixed point: (" + mixed.getX() + ", " + mixed.getY() + ")");
	}
}
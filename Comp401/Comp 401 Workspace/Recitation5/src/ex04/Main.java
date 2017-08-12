package ex04;

public class Main {
	// Without generics...
	public static void printArray1(Integer[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(""); // end the line
	}
	
	
	// With generics...
	public static <T> void printArray2(T[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(""); // end the line
	}
	
	
	// Main...
	public static void main(String[] args) {
		Integer[]   a = {1, 1, 2, 3, 5, 8, 13};
		Character[] b = {'z', 'y', 'x', 'w', 'v', 'u', 't'};
		
		// Print a, method 1
		printArray1(a);
		
		// Print a, method 2
		//Main.<Integer>printArray2(a); // Don't need to do this because of type inference!
		printArray2(a);
		
		// Can't print b, method 1...
		//printArray1(b);
		
		// Print b, method 2
		printArray2(b);
	}
}
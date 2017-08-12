package lec7.ex4;

public class Main {

	public static void main(String[] args) {

		A.methodA(1, 2);
		A.methodA(1.5, 2.5);
		A.methodA(1, 2.5);
		A.methodA(1.5, 2);
		
	}

}

class A {
	
	static int methodA(int a, int b) {
		System.out.println("methodA was called with 2 integers: " + a + ", and " + b);
		return a+b;
	}

	static double methodA(double a, double b) {
		System.out.println("methodA was called with 2 doubles: " + a + ", and " + b);
		return a+b;
	}

	static void methodA(int a, double b) {
		System.out.println("methodA was called with integer " + a + ", and double " + b);
	}

	static void methodA(double a, int b) {
		System.out.println("methodA was called with double " + a + ", and integer " + b);
	}

}

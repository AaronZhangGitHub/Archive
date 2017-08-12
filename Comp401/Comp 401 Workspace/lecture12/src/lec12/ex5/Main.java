package lec12.ex5;

public class Main {

	public static void main(String[] args) {
		
		Service s1 = Service.getService();
		
		s1.doService();
		
		Service.goOnline();
		
		s1.doService();
		
		Service s2 = Service.getService();
		
		s2.doService();
	}
}

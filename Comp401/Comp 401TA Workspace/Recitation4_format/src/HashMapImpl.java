import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HashMapImpl {

	public static void main(String [] args){
		Map<Integer,Shape> map = new HashMap<Integer,Shape>();
		/**
		 *create a circle with name circle1, radius 2.0, color green
		 *create a circle with name circle2, radius 5.0, color blue
		 *create a square with name square1, length 6.0, color red
		 *create a square with name square2, length 5.0, color yellow
		 */
		//start code here
		Circle circle1 = new Circle(2.0, "green");
		Circle circle2 = new Circle(5.0, "blue");
		Square square1 = new Square(6.0, "red");
		Square square2 = new Square(5.0, "yellow");
		
		
		/**
		 * add these above objects in to Hashmap defined above
		 * circle1 key -> 3
		 * circle2 key -> 5
		 * square1 key -> 1
		 * square2 key -> 2
		 */
		// start code here
		map.put(3, circle1);
		map.put(5, circle2);
		map.put(1, square1);
		map.put(2, square2);
		/**
		 * print object specifications of all the objects in the hashmap 
		 * by calling their toString() method
		 */
		//start code here
		for (Entry<Integer, Shape> s: map.entrySet()){
			System.out.println(s.getValue().toString());
		}

	}
}

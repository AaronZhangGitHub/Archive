package list;

// This is a simplified version of Java's ArrayList.
//     The real ArrayList does additional error checking, etc.
public class ArrayList<E> implements List<E> {
	// Constants
	private static final int DEFAULT_SIZE = 10; // Defines the initial size of the encapsulated array
	
	
	// Fields
	private Object[] arr;                       // Internal, encapsulated array
	private int size;                           // Stores the current size of the list
	
	
	// Constructor
	// TODO: Initialize array to the default size and set the size integer to zero
	public ArrayList() {
		// Your code goes here...
	}
	

	// TODO: Check the index to make sure it is in bounds, and return the desired element.
	// Don't forget to cast the element from type Object back to type E!
	public E get(int index) throws IndexOutOfBoundsException {
		// Your code goes here...
	}
	
	// TODO: Get the current size of the list (not the current size of the array!)
	public int size() {
		// Your code goes here...
	}
	
	// TODO 1: Make sure there is enough room for another element in the internal array
	//             -> if there isn't enough room, call the expand() method defined at the bottom
	// TODO 2: Add the item to the array
	// TODO 3: Increase the list size counter
	public void add(E item) {
		// Your code goes here...
	}

	// TODO: Search the internal array for the desired item
	//           -> Use .equals() to test equality.
	//           -> If no item is found, return -1
	public int search(E item) {
		// Your code goes here...
	}
	
	// TODO: Return true if the list contains the given item; false otherwise.
	//           -> Hint: Use the search() method!
	public boolean contains(E item) {
		// Your code goes here...
	}
	
	// Private utility function to copy one Object array to another
	//           -> This method is used in toArray() and expand()
	private static void copy(Object[] from, Object[] to) {
		for (int i = 0; i < from.length; i++) {
			to[i] = from[i];
		}
	}

	// TODO: Convert the list to an Object[] array
	//           -> We already have a private Object[] array, but it may be too big
	//           -> To fix this, make a new Object[] array of the correct size, and
	//                  fill it in by making a call to the copy() method defined above.
	public Object[] toArray() {
		// Your code goes here...
	}
	
	// Doubles the size of the internal array
	private void expand() {
		Object[] bigger = new Object[2*arr.length];
		copy(arr, bigger);
		arr = bigger;
	}
}

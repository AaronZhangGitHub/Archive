package list;

public interface List<T> {
	
	T get(int index) throws IndexOutOfBoundsException;
	void add(T item);              // appends to the list and expands if necessary
	int search(T item);            // returns index of first instance of 'item', or -1 if not found
	boolean contains(T item);      // returns true if the list contains the passed item, and false otherwise.
	int size();                    // returns the number of elements in the list
	Object[] toArray();            // converts the list to a basic Object array
}
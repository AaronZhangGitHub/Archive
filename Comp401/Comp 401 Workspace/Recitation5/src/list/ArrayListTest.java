package list;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayListTest {

	@Test
	public void testInAndOut() {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		list.add("World");
		assertEquals("Hello", list.get(0));
		assertEquals("World", list.get(1));
	}
	
	@Test
	public void testSearchContains() {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++)
			list.add("No");
		list.add("Yes");
		
		assertEquals(10, list.search("Yes"));
		assertTrue(list.contains("No"));
		assertFalse(list.contains("Brian"));
	}
	
	@Test
	public void testToArray() {
		List<String> list = new ArrayList<String>();
		
		for (int i = 0; i < 10; i++)
			list.add("Hello");
		
		Object[] a = list.toArray();

		assertTrue(a[1] instanceof String);
		assertTrue(a[9].equals("Hello"));
	}
	
	@Test
	public void testSize() {
		List<String> list = new ArrayList<String>();
		assertEquals(0, list.size());
		
		for (int i = 0; i < 15; i++)
			list.add("Hello");
		assertEquals(15, list.size());
	}
}

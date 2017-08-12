package a5junit;

import static org.junit.Assert.*;

import java.io.*;

import org.junit.Test;

import a5jedi.Main;

public class a5jediMainTest {
	
	@Test
	public void notARealTest() {
		System.err.println("NOTE: Make sure that your main class exits when the goal city is reached "
				+ "otherwise \nyou will get a NoSuchElementException.");
	}

	@Test
	public void easyPath1Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "1\n2\n3\n4\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("easyPath1.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 1, 2, 3, 4");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void easyPath2Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "1\n2\n3\n1\n2\n3\n1\n2\n3\n4\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("easyPath2.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 1, 2, 3, 1, 2, 3, 1, 2, 3, 4\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void easyPathQuitTest() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "1\n2\n3\n0\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println("Your a5jedi.Main.main() method does not quit when 0 is entered");
			fail();
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("easyPathQuit.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 1, 2, 3, 0n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void mediumPath1Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "2\n2\n3\n4\n5\n6\n7\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("mediumPath1.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 2, 2, 3, 4, 5, 6, 7\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void mediumPath2Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "2\n2\n3\n4\n5\n6\n5\n4\n3\n2\n4\n5\n6\n7\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("mediumPath2.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 2, 2, 3, 4, 5, 6, 5, 4, 3, 2, 4, 5, 6, 7\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void mediumPathQuitTest() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "2\n2\n3\n4\n5\n6\n0\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println("Your a5jedi.Main.main() method does not quit when 0 is entered");
			fail();
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("mediumPathQuit.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 2, 2, 3, 4, 5, 6, 0\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void hardPath1Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "3\n2\n3\n4\n5\n6\n7\n8\n9\n10\n11\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("hardPath1.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 3, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void hardPath2Test() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "3\n2\n3\n4\n5\n6\n7\n8\n9\n10\n1\n6\n11";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("hardPath2.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 3, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 6, 11\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
	
	@Test
	public void hardPathQuitTest() throws IOException {
		OutputStream os1 = new ByteArrayOutputStream();
		PrintStream ps1 = new PrintStream(os1);
		System.setOut(ps1);
		String str = "3\n2\n3\n4\n5\n6\n7\n8\n9\n10\n0\n";
		InputStream sbis = new ByteArrayInputStream(str.getBytes());
		System.setIn(sbis);
		
		try {
			Main.main(null);
		} catch (IndexOutOfBoundsException ioobe) {
			System.err.println("Your a5jedi.Main.main() method does not quit when 0 is entered");
			fail();
		} catch (Exception e) {
			System.err.println("Unexpected Exception caught on a5jedi.Main.main()");
			e.printStackTrace();
			fail();
		}
		
		System.setOut(System.out);
		
		OutputStream os2 = new ByteArrayOutputStream();
		PrintStream ps2 = new PrintStream(os2);
		System.setOut(ps2);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("hardPathQuit.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		System.setOut(System.out);
		
		try {
			assertEquals(os1.toString(), os2.toString());	
		} catch (AssertionError ae) {
			System.err.println("Input was: 3, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0\n");
			System.err.println("Expected output:\n");
			System.err.println(os2.toString());
			System.err.println("Actual output:\n");
			System.err.println(os1.toString());
			fail();
		}
	}
}

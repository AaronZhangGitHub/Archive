/**
 * Recitation 3 ó JUNIT Testing of Assignment 2 Rectangle Class
 * 
 * @Author : KJ Moon & Brian Cristante
 * Written expressively for COMP 401 Spring 2015 w/ Dr. Ketan Mayer-Patel
 */

package a2junit;

import a2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class test {
	
	@Test
	// This one is done for you as a model
	public void testConstructor1() {
		// Unit under test
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2,  "uut");
		
		// Expected values
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		// Check the outputs against what you expected
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
	}
	
	@Test
	public void testConstructor2() {
		// Unit under test
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;
		Rectangle uut = new Rectangle(x2, y2, x1, y1, "uut");
		
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
	}
	
	@Test
	public void testConstructor3() {
		// Unit under test
		int x1 =  0;  int y1 = 10;
		int x2 = 10;  int y2 =  0;
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		// Expected values
		int left_expected   = 0;  int right_expected = 10;
		int bottom_expected = 0;  int top_expected   = 10;
		
		// Call your methods to get their actual values
		int left_actual   = uut.getLeft();  
		int right_actual  = uut.getRight();
		int bottom_actual = uut.getBottom();  
		int top_actual    = uut.getTop();
		
		// Check the outputs against what you expected
		assertEquals(left_expected,   left_actual);
		assertEquals(right_expected,  right_actual);
		assertEquals(bottom_expected, bottom_actual);
		assertEquals(top_expected,    top_actual);
	}
	
	@Test
	public void testGetWidth1() {
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_width = 10;
		assertEquals(expected_width, uut.getWidth());		
	}
	
	@Test
	public void testGetWidth2() {
		int x1 = - 5;  int y1 = 0;
		int x2 = -10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_width = 5;
		assertEquals(expected_width, uut.getWidth());			
	}
	
	@Test
	public void testGetHeight() {
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		int expected_height = 10;
		assertEquals(expected_height, uut.getHeight());	
	}
	
	@Test
	public void testEquals() {
		int x1 =  0;  int y1 =  0;
		int x2 = 10;  int y2 = 10;
		int x3 = 11;
		
		Rectangle r1 = new Rectangle(x1, y1, x2, y2, "r1");
		Rectangle r2 = new Rectangle(x2, y1, x1, y2, "r2");
		Rectangle r3 = new Rectangle(x1, y1, x3, y2, "r3");
		
		assertTrue(r1.equals(r2));
		assertTrue(r2.equals(r1));
		assertFalse(r1.equals(r3));
	}
	
	@Test
	public void testIsTall() {
		int x1 = -5;  int y1 = -15;
		int x2 =  5;  int y2 =   0;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertTrue(uut.isTall());
		assertFalse(uut.isWide());
		assertFalse(uut.isSquare());
	}
	
	@Test
	public void testIsWide() {
		int x1 = -5;  int y1 = -5;
		int x2 =  10;  int y2 =   5;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertTrue(uut.isWide());
		assertFalse(uut.isTall());
		assertFalse(uut.isSquare());
	}
	
	@Test
	public void testIsSquare() {
		int x1 = -5;  int y1 = -5;
		int x2 =  5;  int y2 =   5;		
		Rectangle uut = new Rectangle(x1, y1, x2, y2, "uut");
		
		assertFalse(uut.isTall());
		assertFalse(uut.isWide());
		assertTrue(uut.isSquare());
	}

	@Test
	public void testTranslate() {
		Rectangle toBeTranslated = new Rectangle(0, 0, 10, 10, "toBeTranslated");
		
		
		Rectangle translated = toBeTranslated.translate(10, 10);
		
		assertEquals("Left X", 10, translated.getLeft());

		assertEquals("Left Y", 10, translated.getBottom());

		assertEquals("Right X", 20, translated.getRight());

		assertEquals("Right Y", 20, translated.getTop());
	}
}
package exercise;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathUtilTest {
	@Test
	public void linearInterpolateTest(){
		double [] p1 = {-1, -1};
		double [] p2 = {3, 3};
		double x = 1.7;
		
		double expected = 1.7;
		
		assertEquals(expected, MathUtil.linearInterpolate(p1,p2,x), .00001);
	}
	
	@Test
	public void getMidPointTest(){
		double [] p1 = {-1, -1};
		double [] p2 = {3, 3};
		double [] expected = {1,1};
		
		assertArrayEquals(expected, MathUtil.getMidpoint(p1, p2), .00001);
	}
	
	@Test public void meanTest(){
		double [] arr = {5, 3, 7, 10, 0};
		double expected = 5;
		assertEquals(expected, MathUtil.computeMean(arr), .00001);
	}
}

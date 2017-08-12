package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import a7.*;
import supplies.*;

public class removeTest {

	@Test
	public void removeFoodTest() {
		Knapsack knapsack = new KnapsackImpl();
		
		Food bj = new BisonJerky(2);
		Food b = new Burrito(10);
		Supplies r = new Ramen(3);
		
		knapsack.add(bj);
		knapsack.add(b);
		knapsack.add(r);
		
		Food[] expected = {bj, b, (Food) r};
		Food[] actual = knapsack.getEdibleSupplies();
		
		assertArrayEquals(expected, actual);
		
		knapsack.remove(b);
		knapsack.remove(r);
		
		Food[] expected2 = {bj};
		Food[] actual2 = knapsack.getEdibleSupplies();
		
		assertEquals(expected2[0], actual2[0]);
	}
	
	@Test
	public void removePowerUpsTest() {
		Knapsack knapsack = new KnapsackImpl();
		
		PowerUp c2 = new Coffee(2);
		Food rb = new RedBison(10);
		Supplies c3 = new Coffee(3);
		
		knapsack.add(c2);
		knapsack.add(rb);
		knapsack.add(c3);
		
		PowerUp[] expected = {c2,(PowerUp) rb, (PowerUp) c3};
		Food[] edible = knapsack.getEdibleSupplies();
		PowerUp[] actual = new PowerUp[edible.length];
		for (int i = 0; i < edible.length; i++) {
			actual[i] = (PowerUp) edible[i];
		}
		assertArrayEquals(expected, actual);
		
		knapsack.remove(c3);
		knapsack.remove(rb);
		
		PowerUp[] expected2 = {c2};
		Food[] edible2 = knapsack.getEdibleSupplies();
		PowerUp[] actual2 = new PowerUp[edible.length];
		for (int i = 0; i < edible2.length; i++) {
			actual2[i] = (PowerUp) edible2[i];
		}
		
		assertEquals(expected2[0], actual2[0]);
	}
	
	@Test
	public void removeClothingTest() {
		Knapsack knapsack = new KnapsackImpl();
		
		Clothing f = new Fleece(2);
		Clothing t = new TShirt(10);
		Supplies b = new ButtonUp(3);
		
		knapsack.add(f);
		knapsack.add(t);
		knapsack.add(b);
		
		Supplies[] expected = {f, t, (Clothing) b};
		Supplies[] actual = knapsack.getSupplies();
		
		assertArrayEquals(expected, actual);
		
		knapsack.remove(t);
		knapsack.remove(b);
		
		Supplies[] expected2 = {f};
		Supplies[] actual2 = knapsack.getSupplies();
		
		assertEquals(expected2[0], actual2[0]);
		
	}

	@Test
	public void removeSuppliesTest() {
		Knapsack knapsack = new KnapsackImpl();
		
		Food bj = new BisonJerky(2);
		PowerUp c = new Coffee(10);
		Clothing f = new Fleece(5);
		Supplies r = new Ramen(3);
		
		knapsack.add(bj);
		knapsack.add(c);
		knapsack.add(f);
		knapsack.add(r);
		
		
		Supplies[] expected = {bj, r, c, f};
		Supplies[] actual = knapsack.getSupplies();

		assertArrayEquals(expected, actual);
		
		knapsack.remove(c);
		knapsack.remove(f);
		knapsack.remove(r);
		
		Supplies[] expected2 = {bj};
		Supplies[] actual2 = knapsack.getSupplies();
		
		assertEquals(expected2[0], actual2[0]);
	}
	
	@Test
	public void removeNonexistentItemTest() {
		Knapsack knapsack = new KnapsackImpl();
		
		Food bj = new BisonJerky(2);
		PowerUp c = new Coffee(10);
		Clothing f = new Fleece(5);
		Supplies r = new Ramen(3);
		
		knapsack.add(bj);
		knapsack.add(c);
		knapsack.add(f);
		
		Supplies[] expected = {bj, c, f};
		Supplies[] actual = knapsack.getSupplies();

		assertArrayEquals(expected, actual);
		
		knapsack.remove(c);
		knapsack.remove(f);
		knapsack.remove(r);
		
		Supplies[] expected2 = {bj};
		Supplies[] actual2 = knapsack.getSupplies();
		
		assertEquals(expected2[0], actual2[0]);
	}
}

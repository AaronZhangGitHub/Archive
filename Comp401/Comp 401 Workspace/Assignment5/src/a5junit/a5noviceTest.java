package a5junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import a5novice.*;
import supplies.*;
import person.*;

import java.lang.reflect.*;

public class a5noviceTest {

	@Test
	public void SquadImplTest() {
		Knapsack b = new KnapsackImpl();
		Squad a = new SquadImpl(10, b);
		
		try {
			assertEquals(10, a.getNumPlayers());
		} catch (AssertionError ae ) {
			System.out.println("Error location: SquadImpl.getNumPlayers()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(null, a.getPlayer(5));
		} catch (AssertionError ae) {
			System.out.println("Error location: SquadImpl.getPlayer()");
			ae.printStackTrace();
			fail();
		}
		
		boolean iaeThrown1 = false;
		
		try {
			a.getPlayer(-10);
		} catch (IllegalArgumentException iae) {
			iaeThrown1 = true;
		} catch (Exception e) { 
			System.out.println("Caught unexpected error on SquadImpl.getPlayer()");
			e.printStackTrace();
			fail(); 
		}
		
		try { assertTrue(iaeThrown1); } catch (AssertionError ae) {
			System.out.println("SquadImpl.getPlayer() does not throw an "
					+ "IllegalArgumentException for numbers below 0");
			fail();
		}
		
		boolean iaeThrown2 = false;
		
		try {
			a.getPlayer(10);
		} catch (IllegalArgumentException iae) {
			iaeThrown2 = true;
		} catch (Exception e) { 
			System.out.println("Caught unexpected error on SquadImpl.getPlayer()");
			e.printStackTrace();
			fail(); 
		}
		
		try { assertTrue(iaeThrown2); } catch (AssertionError ae) {
			System.out.println("SquadImpl.getPlayer() does not throw an "
					+ "IllegalArgumentException for numbers above getNumPlayers()-1");
			fail();
		}
		
		Person c = new Student("A");
		a.setPlayer(1, c);
		
		try { assertEquals(c, a.getPlayer(1)); } catch (AssertionError ae) {
			System.out.println("Error location: SquadImpl.setPlayer()");
			ae.printStackTrace();
			fail();
		}
		
		boolean iaeThrown3 = false; 
		
		try { 
			a.setPlayer(100, new Student("A")); 
		} catch (IllegalArgumentException iae) {
			iaeThrown3 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on SquadImpl.setPlayer()");
			e.printStackTrace();
			fail();
		}
		
		try { assertTrue(iaeThrown3); } catch (AssertionError ae) {
			System.out.println("SquadImpl.setPlayer() does not throw and "
					+ "IllegalArgumentException for numbers above getNumPlayers()-1");
			fail();
		}
		
		boolean iaeThrown4 = false; 
		
		try { 
			a.setPlayer(-1, new Student("A")); 
		} catch (IllegalArgumentException iae) {
			iaeThrown4 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on SquadImpl.setPlayer()");
			e.printStackTrace();
			fail();
		}
		
		try { assertTrue(iaeThrown4); } catch (AssertionError ae) {
			System.out.println("SquadImpl.setPlayer() does not throw an "
					+ "IllegalArgumentException for numbers below 0");
			fail(); 
		}
			
		try {a.setPlayer(6, null);} catch (Exception e) {
			System.out.println("SquadImpl.setPlayer() should allow you to set a player "
					+ "to null");
			fail();
		}
		
		try { assertEquals(b, a.getKnapsack()); } catch (AssertionError ae) {
			System.out.println("Error location: SquadImpl.getKnapsack()");
			ae.printStackTrace();
		}
	
		boolean iaeThrown5 = false;
		
		try {
			@SuppressWarnings("unused")
			Squad d = new SquadImpl(10, null);
		} catch (IllegalArgumentException iae) {
			iaeThrown5 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on SquadImpl constructor");
			e.printStackTrace();
			fail();
		}
		
		try { assertTrue(iaeThrown5); } catch (AssertionError ae) {
			System.out.println("SquadImpl constructor does not throw an "
					+ "IllegalArgumentException for a null Knapsack");
			fail(); 
		}
		
		boolean iaeThrown6 = false;
		
		try {
			@SuppressWarnings("unused")
			Squad e = new SquadImpl(0, b);
		} catch (IllegalArgumentException iae) {
			iaeThrown6 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on SquadImpl constructor");
			e.printStackTrace();
			fail();
		}
		
		try { assertTrue(iaeThrown6); } catch (AssertionError ae) {
			System.out.println("SquadImpl constructor does not throw an "
					+ "IllegalArgumentException for numbers below 1");
			fail(); 
		}
	}
	
	@Test
	public void FoodPouchTest() {
		Pouch a = new FoodPouch();
		Clothing b = new Fleece(10);
		Food c = new Burrito(10);
		Food d = new Ramen(10);
		Supplies[] f = new Supplies[] {d, c};
		
		boolean iaethrown1 = false;
				
		try {
			a.add(b);
		} catch (IllegalArgumentException iae) {
			iaethrown1 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on FoodPouch.add()");
			e.printStackTrace();
			fail();
		}
		
		try {
			assertTrue(iaethrown1);
		} catch (AssertionError ae) {
			System.out.println("FoodPouch.add() does not thrown an IllegalArgumentException"
					+ "for items that aren't of the Food class");
			fail();
		}
		
		a.add(c);
		a.add(d);
		
		try{
			assertEquals(60, a.getTotalWeight());
		} catch (AssertionError ae) {
			System.out.println("Error location: FoodPouch.getTotalWeight()");
			ae.printStackTrace();
			fail();
		}
		
		List<Supplies> g = Arrays.asList(a.getItems());
		List<Supplies> h = Arrays.asList(f);
		
		try { 
			assertTrue((g.containsAll(h)) && (h.containsAll(g)));
		} catch (AssertionError ae) {
			System.out.println("Error location: FoodPouch.getItems()");
			System.out.println("Items returned with getItems() do not match the items "
					+ "that were passed into the pouch. This error is not caused by "
					+ "ordering differences.");
			fail();
		}
	}
	
	@Test
	public void PowerUpPouchTest() {
		Pouch a = new PowerUpPouch();
		Clothing b = new Fleece(10);
		PowerUp c = new Coffee(10);
		PowerUp d = new RedBison(10);
		Supplies[] f = new Supplies[] {d, c};
		
		boolean iaethrown1 = false;
				
		try {
			a.add(b);
		} catch (IllegalArgumentException iae) {
			iaethrown1 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on PowerUpPouch.add()");
			e.printStackTrace();
			fail();
		}
		
		try {
			assertTrue(iaethrown1);
		} catch (AssertionError ae) {
			System.out.println("PowerUpPouch.add() does not thrown an IllegalArgumentException"
					+ "for items that aren't of the PowerUp class");
			fail();
		}
		
		a.add(c);
		a.add(d);
		
		try{
			assertEquals(30, a.getTotalWeight());
		} catch (AssertionError ae) {
			System.out.println("Error location: PowerUp.getTotalWeight()");
			ae.printStackTrace();
			fail();
		}
		
		List<Supplies> g = Arrays.asList(a.getItems());
		List<Supplies> h = Arrays.asList(f);
		
		try { 
			assertTrue((g.containsAll(h)) && (h.containsAll(g)));
		} catch (AssertionError ae) {
			System.out.println("Error location: PowerUp.getItems()");
			System.out.println("Items returned with getItems() do not match the items "
					+ "that were passed into the pouch. This error is not caused by "
					+ "ordering differences.");
			fail();
		}
	}
	
	@Test
	public void ClothingPouchTest() {
		Pouch a = new ClothingPouch();
		Food b = new Burrito(10);
		Clothing c = new TShirt(10);
		Clothing d = new Fleece(10);
		Supplies[] f = new Supplies[] {d, c};
		
		boolean iaethrown1 = false;
				
		try {
			a.add(b);
		} catch (IllegalArgumentException iae) {
			iaethrown1 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected error on ClothingPouch.add()");
			e.printStackTrace();
			fail();
		}
		
		try {
			assertTrue(iaethrown1);
		} catch (AssertionError ae) {
			System.out.println("ClothingPouch.add() does not thrown an IllegalArgumentException"
					+ "for items that aren't of the ClothingPouch class");
			fail();
		}
		
		a.add(c);
		a.add(d);
		
		try{
			assertEquals(110, a.getTotalWeight());
		} catch (AssertionError ae) {
			System.out.println("Error location: ClothingPouch.getTotalWeight()");
			ae.printStackTrace();
			fail();
		}
		
		List<Supplies> g = Arrays.asList(a.getItems());
		List<Supplies> h = Arrays.asList(f);
		
		try { 
			assertTrue((g.containsAll(h)) && (h.containsAll(g)));
			} catch (AssertionError ae) {
			System.out.println("Error location: ClothingPouch.getItems()");
			System.out.println("Items returned with getItems() do not match the items "
					+ "that were passed into the pouch. This error is not caused by "
					+ "ordering differences.");
			fail();
		}
	}
	
	@Test
	public void KnapsackImplTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Food r = new Ramen(1);
		Food b = new Burrito(1);
		Supplies s = new Sushi(1);
		Food c = new Coffee(1);
		PowerUp rb = new RedBison(1);
		Supplies rb2 = new RedBison(1);
		Supplies t = new TShirt(1);
		Clothing f = new Fleece(1);
		Knapsack k = new KnapsackImpl();
		Supplies[] fd = new Supplies[] {s, b, r};
		Supplies[] pu = new Supplies[] {rb, c, rb2};
		Supplies[] cl = new Supplies[] {f, t};
		Supplies[] edbl = new Supplies[] {rb, rb2, s, b, c, r};
		Supplies[] all = new Supplies[] {rb, rb2, s, f, b, t, c, r};
		
		try {
			k.add(r);
			k.add(b);
			k.add(s);
			k.add(c);
			k.add(rb);
			k.add(t);
			k.add(f);
			k.add(rb2);
		} catch (Exception e) {
			System.out.println("Error Location: Knapsack.add()");
			System.out.println("Make sure that add(Food food) and add(Supplies "
					+ "supplies) both put items in the right pouch");
			e.printStackTrace();
			fail();
		}
		
		Field x = null;
		Field y = null;
		Field z = null;
		
		try {
			x = k.getClass().getDeclaredField("food");
			y = k.getClass().getDeclaredField("powerup");
			z = k.getClass().getDeclaredField("clothing");
			x.setAccessible(true);
			y.setAccessible(true);
			z.setAccessible(true);
		} catch (NoSuchFieldException e) {
			System.out.println("You need to set your private pouch fields for KnapsackImpl "
					+ "to 'food', 'powerup', and 'clothing' for this test to work");
			fail();
		} catch (Exception e) {
			System.out.println("Unhandled exception. Contanct Justin on piazza for help.");
			e.printStackTrace();
			fail();
		}
	
		Pouch food = (Pouch) x.get(k);
		Pouch powerup = (Pouch) y.get(k);
		Pouch clothing = (Pouch) z.get(k);
		
		List<Supplies> foodList = Arrays.asList(food.getItems());
		List<Supplies> powerupList = Arrays.asList(powerup.getItems());
		List<Supplies> clothingList = Arrays.asList(clothing.getItems());
		List<Supplies> fdList = Arrays.asList(fd);
		List<Supplies> puList = Arrays.asList(pu);
		List<Supplies> clList = Arrays.asList(cl);
		
		try { 
			assertTrue((foodList.containsAll(fdList)) && 
						(fdList.containsAll(foodList)));
			} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.add(Food food)");
			System.out.println("Items put into the knapsack that are supposed to go into "
					+ "the food pouch field do not match the items \nthat are in your food "
					+ "pouch field. This error is not caused by ordering differences.");
			System.err.println("Expected: \n");
			for (Supplies item : fdList) {
				System.err.println(item.getName());			
			}
			System.err.println("\nActual: \n");
			for (Supplies item : foodList) {
				System.err.println(item.getName());
			}
			fail();
		}
		
		try { 
			assertTrue((powerupList.containsAll(puList)) && 
						(puList.containsAll(powerupList)));
			} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.add(PowerUp powerup)");
			System.out.println("Items put into the knapsack that are supposed to go into "
					+ "the powerup pouch field do not match the items \nthat are in your "
					+ "powerup pouch field. This error is not caused by ordering "
					+ "differences.");
			System.err.println("Expected: \n");
			for (Supplies item : puList) {
				System.err.println(item.getName());			
			}
			System.err.println("\nActual: \n");
			for (Supplies item : powerupList) {
				System.err.println(item.getName());
			}
			fail();
		}
		
		try { 
			assertTrue((clothingList.containsAll(clList)) && 
						(clList.containsAll(clothingList)));
			} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.add(Clothing clothing)");
			System.out.println("Items put into the knapsack that are supposed to go into "
					+ "the clothing pouch field do not match the items \nthat are in your "
					+ "clothing pouch field. This error is not caused by ordering "
					+ "differences.");
			System.err.println("Expected: \n");
			for (Supplies item : clList) {
				System.err.println(item.getName());			
			}
			System.err.println("\nActual: \n");
			for (Supplies item : clothingList) {
				System.err.println(item.getName());
			}
			fail();
		}
		
		List<Food> edibleList = Arrays.asList(k.getEdibleSupplies());
		List<Supplies> allItemsList = Arrays.asList(k.getSupplies());
		List<Supplies> edblList = Arrays.asList(edbl);
		List<Supplies> allList = Arrays.asList(all);
		
		try { 
			assertTrue((edibleList.containsAll(edblList)) && 
						(edblList.containsAll(edibleList)));
			} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.getEdibleSupplies()");
			System.out.println("Items returned with getEdibleSupplies() do not match the "
					+ "items that were put into the knapsack. This error \nis not caused by "
					+ "ordering differences.");
			System.err.println("Expected: \n");
			for (Supplies item : edblList) {
				System.err.println(item.getName());			
			}
			System.err.println("\nActual: \n");
			for (Supplies item : edibleList) {
				System.err.println(item.getName());
			}
			fail();
		}
		
		try { 
			assertTrue((allItemsList.containsAll(allList)) && 
						(allList.containsAll(allItemsList)));
			} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.getSupplies()");
			System.out.println("Items returned with getSupplies() do not match the "
					+ "items that were put into the knapsack. This error \nis not caused by "
					+ "ordering differences.");
			System.err.println("Expected: \n");
			for (Supplies item : allList) {
				System.err.println(item.getName());			
			}
			System.err.println("\nActual: \n");
			for (Supplies item : allItemsList) {
				System.err.println(item.getName());
			}
			fail();
		}
		
		try {
			assertEquals(25, k.getTotalWeight());
		} catch (AssertionError ae) {
			System.out.println("Error location: Knapsack.getTotalWeight()");
			ae.printStackTrace();
			fail();
		}
	}
}

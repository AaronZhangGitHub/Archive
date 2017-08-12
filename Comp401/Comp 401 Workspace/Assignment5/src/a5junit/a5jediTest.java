package a5junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import a5jedi.*;
import supplies.*;

import java.lang.reflect.*;

public class a5jediTest {
	
	@Test
	public void FoodPouchTest() {
		Pouch<Food> a = new PouchImpl<Food>();
		Food c = new Ramen(10);
		Food d = new Burrito(10);
		Supplies[] f = new Supplies[] {d, c};
		
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
		Pouch<PowerUp> a = new PouchImpl<PowerUp>();
		PowerUp c = new Coffee(10);
		PowerUp d = new RedBison(10);
		Supplies[] f = new Supplies[] {d, c};
		
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
		Pouch<Clothing> a = new PouchImpl<Clothing>();
		Clothing c = new TShirt(10);
		Clothing d = new Fleece(10);
		Supplies[] f = new Supplies[] {d, c};
		
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
	
		@SuppressWarnings("unchecked")
		Pouch<Food> food = (Pouch<Food>) x.get(k);
		@SuppressWarnings("unchecked")
		Pouch<PowerUp> powerup = (Pouch<PowerUp>) y.get(k);
		@SuppressWarnings("unchecked")
		Pouch<Clothing> clothing = (Pouch<Clothing>) z.get(k);
		
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
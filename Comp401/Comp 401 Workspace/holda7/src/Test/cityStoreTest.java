package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import a7.*;
import a7.Adventure.Difficulty;

public class cityStoreTest {

	Knapsack knapsack = new KnapsackImpl();
	Squad squad = new SquadImpl(3, knapsack);
	Adventure adventure = new Adventure(Difficulty.HARD, squad);
	City[] cities = adventure.getCities();
	
	@Test
	public void testChapelHill() {
		
		Store store = StoreImpl.makeStore(cities[0]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2.0, .01);
			assertEquals(store.getPrice("burrito"), 4.0, .01);
			assertEquals(store.getPrice("button-up"), 10.4, .01);
			assertEquals(store.getPrice("coffee"), 2.5, .01);
			assertEquals(store.getPrice("fleece"), 12.48, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.5, .01);
			assertEquals(store.getPrice("Red Bison"), 3.25, .01);
			assertEquals(store.getPrice("sushi"), 3.75, .01);
			assertEquals(store.getPrice("t-shirt"), 5.2, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}

	}
	
	@Test
	public void testCharlotte() {
		
		Store store = StoreImpl.makeStore(cities[1]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2.0, .01);
			assertEquals(store.getPrice("burrito"), 4.0, .01);
			assertEquals(store.getPrice("button-up"), 10.4, .01);
			assertEquals(store.getPrice("coffee"), 2.5, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.5, .01);
			assertEquals(store.getPrice("Red Bison"), 3.25, .01);
			assertEquals(store.getPrice("sushi"), 3.75, .01);
			assertEquals(store.getPrice("t-shirt"), 5.2, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}
		
		try {
			store.getPrice("fleece");
		} catch (ItemNotForSaleException e) {
			assertTrue(true);
		}

	}
	
	@Test
	public void testAtlanta() {
		
		Store store = StoreImpl.makeStore(cities[2]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2.06, .01);
			assertEquals(store.getPrice("burrito"), 4.12, .01);
			assertEquals(store.getPrice("button-up"), 10.6, .01);
			assertEquals(store.getPrice("coffee"), 2.575, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.515, .01);
			assertEquals(store.getPrice("Red Bison"), 3.3475, .01);
			assertEquals(store.getPrice("sushi"), 3.8625, .01);
			assertEquals(store.getPrice("t-shirt"), 5.3, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}
		
		try {
			store.getPrice("fleece");
		} catch (ItemNotForSaleException e) {
			assertTrue(true);
		}

	}
	
	@Test
	public void testWashingtonDC() {
		
		Store store = StoreImpl.makeStore(cities[3]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 3.675, .01);
			assertEquals(store.getPrice("burrito"), 5.775, .01);
			assertEquals(store.getPrice("button-up"), 12.075, .01);
			assertEquals(store.getPrice("coffee"), 4.2, .01);
			assertEquals(store.getPrice("fleece"), 14.175, .01);
			assertEquals(store.getPrice("ramen noodles"), 2.1, .01);
			assertEquals(store.getPrice("Red Bison"), 4.9875, .01);
			assertEquals(store.getPrice("sushi"), 5.5125, .01);
			assertEquals(store.getPrice("t-shirt"), 6.825, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}


	}
	
	@Test
	public void testNewYork() {
		
		Store store = StoreImpl.makeStore(cities[4]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 3.675, .01);
			assertEquals(store.getPrice("burrito"), 5.775, .01);
			assertEquals(store.getPrice("button-up"), 12.65, .01);
			assertEquals(store.getPrice("coffee"), 4.2, .01);
			assertEquals(store.getPrice("fleece"), 14.85, .01);
			assertEquals(store.getPrice("ramen noodles"), 2.1, .01);
			assertEquals(store.getPrice("Red Bison"), 4.9875, .01);
			assertEquals(store.getPrice("sushi"), 5.5125, .01);
			assertEquals(store.getPrice("t-shirt"), 7.15, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}

	}
	
	@Test
	public void testChicago() {
		
		Store store = StoreImpl.makeStore(cities[5]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2.1, .01);
			assertEquals(store.getPrice("burrito"), 4.2, .01);
			assertEquals(store.getPrice("button-up"), 10.5, .01);
			assertEquals(store.getPrice("coffee"), 2.625, .01);
			assertEquals(store.getPrice("fleece"), 12.6, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.525, .01);
			assertEquals(store.getPrice("Red Bison"), 3.4125, .01);
			assertEquals(store.getPrice("sushi"), 3.9375, .01);
			assertEquals(store.getPrice("t-shirt"), 5.25, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}

	}
	
	@Test
	public void testAustin() {
		
		Store store = StoreImpl.makeStore(cities[6]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2, .01);
			assertEquals(store.getPrice("burrito"), 4, .01);
			assertEquals(store.getPrice("button-up"), 10, .01);
			assertEquals(store.getPrice("coffee"), 2.5, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.50, .01);
			assertEquals(store.getPrice("Red Bison"), 3.25, .01);
			assertEquals(store.getPrice("sushi"), 3.75, .01);
			assertEquals(store.getPrice("t-shirt"), 5, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}
		
		try {
			assertEquals(store.getPrice("fleece"), 12.6, .01);
		} catch (ItemNotForSaleException e) {
			assertTrue(true);
		}

	}
	
	@Test
	public void testMinneapolis() {
		
		Store store = StoreImpl.makeStore(cities[7]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2, .01);
			assertEquals(store.getPrice("burrito"), 4, .01);
			assertEquals(store.getPrice("button-up"), 10, .01);
			assertEquals(store.getPrice("coffee"), 2.5, .01);
			assertEquals(store.getPrice("fleece"), 12, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.50, .01);
			assertEquals(store.getPrice("Red Bison"), 3.25, .01);
			assertEquals(store.getPrice("sushi"), 3.75, .01);
			assertEquals(store.getPrice("t-shirt"), 5, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}
	}
	
	@Test
	public void testSeattle() {
		
		Store store = StoreImpl.makeStore(cities[8]);
		
		try {
			assertEquals(store.getPrice("coffee"), 4.16, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}
		
		try {
			assertEquals(store.getPrice("bison jerky"), 2, .01);
			assertEquals(store.getPrice("burrito"), 4, .01);
			assertEquals(store.getPrice("button-up"), 10, .01);
			assertEquals(store.getPrice("fleece"), 12, .01);
			assertEquals(store.getPrice("ramen noodles"), 0.50, .01);
			assertEquals(store.getPrice("Red Bison"), 3.25, .01);
			assertEquals(store.getPrice("sushi"), 3.75, .01);
			assertEquals(store.getPrice("t-shirt"), 5, .01);
		} catch (ItemNotForSaleException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSanFrancisco() {
		
		Store store = StoreImpl.makeStore(cities[9]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 3.78, .01);
			assertEquals(store.getPrice("burrito"), 5.94, .01);
			assertEquals(store.getPrice("button-up"), 12.995, .01);
			assertEquals(store.getPrice("coffee"), 4.32, .01);
			assertEquals(store.getPrice("fleece"), 15.255, .01);
			assertEquals(store.getPrice("ramen noodles"), 2.16, .01);
			assertEquals(store.getPrice("Red Bison"), 5.13, .01);
			assertEquals(store.getPrice("sushi"), 5.67, .01);
			assertEquals(store.getPrice("t-shirt"),7.345, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}

	}

	@Test
	public void testPaloAlto() {
		
		Store store = StoreImpl.makeStore(cities[10]);
		
		try {
			assertEquals(store.getPrice("bison jerky"), 3.5, .01);
			assertEquals(store.getPrice("burrito"), 5.5, .01);
			assertEquals(store.getPrice("button-up"), 12.075, .01);
			assertEquals(store.getPrice("coffee"), 4.0, .01);
			assertEquals(store.getPrice("fleece"), 14.175, .01);
			assertEquals(store.getPrice("ramen noodles"), 2.0, .01);
			assertEquals(store.getPrice("Red Bison"), 4.75, .01);
			assertEquals(store.getPrice("sushi"), 5.25, .01);
			assertEquals(store.getPrice("t-shirt"), 6.825, .01);
		} catch (ItemNotForSaleException e) {
			fail();
		}

	}

}

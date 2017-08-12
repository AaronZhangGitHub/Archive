package a3novice;

import static org.junit.Assert.*;

import org.junit.Test;

public class a4noviceTest {

	@Test
	public void RamenTest() {
		Food a = new Ramen(10);
		Class b = Ramen.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getFill());
			fail();
		}
		
		try {assertEquals(a.getName(), "ramen noodles");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: ramen noodles");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 10);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 1000);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTillExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 1000");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 999);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 999");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		Food c = new Ramen(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Food d = new Ramen(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}
	
	@Test
	public void BurritoTest() {
		Food a = new Burrito(10);
		Class b = Burrito.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 7);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 7");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getFill());
			fail();
		}
		
		try {assertEquals(a.getName(), "burrito");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: burrito");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 50);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 50");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTillExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 4);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 4");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		Food c = new Burrito(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Food d = new Burrito(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}

	@Test
	public void SushiTest() {
		Food a = new Sushi(10);
		Class b = Sushi.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 3);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 3");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 15);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 15");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), 15);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: 15");
			System.out.println("Actual: " + a.getFill());
			fail();
		}
		
		try {assertEquals(a.getName(), "sushi");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: sushi");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 30);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 30");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 2);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTillExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 2");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		Food c = new Sushi(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Food d = new Sushi(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}
	
	@Test
	public void BisonJerkyTest() {
		Food a = new BisonJerky(10);
		Class b = BisonJerky.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), 6);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: 6");
			System.out.println("Actual: " + a.getFill());
			fail();
		}
		
		try {assertEquals(a.getName(), "bison jerky");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: bison jerky");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 50);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 50");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 40);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTillExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 40");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 39);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 39");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		Food c = new BisonJerky(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Food d = new BisonJerky(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}
	
	@Test
	public void CoffeeTest() {
		PowerUp a = new Coffee(10);
		Class b = Coffee.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + a.getFill());
			fail();
		}
		
		try {assertEquals(a.getName(), "coffee");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: coffee");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 10);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 100);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTilExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 100");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		try {assertEquals(a.getDuration(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDuration() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getDuration());
			fail();
		}
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 99);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 99");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		PowerUp c = new Coffee(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		PowerUp d = new Coffee(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}
	
	@Test
	public void RedBisonTest() {
		PowerUp a = new RedBison(10);
		Class b = RedBison.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 2);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 2");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 7);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 7");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getFill(), -10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getFill() does not "
					+ "return expected value");
			System.out.println("Expected: -10");
			System.out.println("Actual: " + a.getFill());
			fail();		
		}
		
		try {assertEquals(a.getName(), "Red Bison");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: Red Bison");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 20);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 20");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 100);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDaysTillExpiration() does not "
					+ "return expected value");
			System.out.println("Expected: 100");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		try {assertEquals(a.getDuration(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getDuration() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getDuration());
			fail();
		}
		
		try {a.consume();} catch (NoFoodException nfe) {}
		
		try {a.age();} catch (FoodExpiredException fee) {}

		try {assertEquals(a.getAmount(), 9);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not "
					+ "decrement amount correctly");
			System.out.println("Expected: 9");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		
		try {assertEquals(a.getDaysTillExpiration(), 99);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not "
					+ "decrement daysTilExpiration correctly");
			System.out.println("Expected: 99");
			System.out.println("Actual: " + a.getDaysTillExpiration());
			fail();
		}
		
		PowerUp c = new RedBison(1);
		boolean expiredException = false;
		boolean nofoodException = false;
		int count = c.getDaysTillExpiration();
		
		try{
			for (int i = 0; i<(count+1); i++){
				c.age();
			}
		} catch (FoodExpiredException fee) {
			expiredException = true;
		}
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		try {c.consume();
		} catch (NoFoodException nfe) {
			nofoodException = true;
		}
		
		try {assertTrue(expiredException);
		} catch (AssertionError ae) {
			System.out.println(b + ".age() does not throw "
					+ "FoodExpiredException correctly");
			fail();
		}
		
		try {assertTrue(nofoodException);
		} catch (AssertionError ae) {
			System.out.println(b + ".consume() does not throw "
					+ "NoFoodException correctly");
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		PowerUp d = new RedBison(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
		
	}
	
	@Test
	public void TShirtTest() {
		Clothing a = new TShirt(10);
		Class b = TShirt.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 20);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 20");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getName(), "t-shirt");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: t-shirt");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 10);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getWarmth(), 1);
		} catch (AssertionError ae) {
			System.out.println(b + ".getWarth() does not "
					+ "return expected value");
			System.out.println("Expected: 1");
			System.out.println("Actual: " + a.getWarmth());
			fail();
		}
		
		Clothing c = new TShirt(1);
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Clothing d = new TShirt(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
	
	}	
	
	@Test
	public void ButtonUpTest() {
		Clothing a = new ButtonUp(10);
		Class b = ButtonUp.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 5);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 5");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 50);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 50");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getName(), "button-up");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: button-up");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 50);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 50");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getWarmth(), 2);
		} catch (AssertionError ae) {
			System.out.println(b + ".getWarth() does not "
					+ "return expected value");
			System.out.println("Expected: 2");
			System.out.println("Actual: " + a.getWarmth());
			fail();
		}
		
		Clothing c = new ButtonUp(1);
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Clothing d = new ButtonUp(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
	
	}	
	
	@Test
	public void FleeceTest() {
		Clothing a = new Fleece(10);
		Class b = Fleece.class;
		
		try {assertEquals(a.getAmount(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getAmmount() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getAmount());
			fail();
		}
		try {assertEquals(a.getPoundsPerItem(), 10);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPoundsPerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 10");
			System.out.println("Actual: " + a.getPoundsPerItem());
			fail();
		}
		
		try {assertEquals(a.getPricePerItem(), 100);
		} catch (AssertionError ae) {
			System.out.println(b + ".getPricePerItem() does not "
					+ "return expected value");
			System.out.println("Expected: 100");
			System.out.println("Actual: " + a.getPricePerItem());
			fail();
		}
		
		try {assertEquals(a.getName(), "fleece");
		} catch (AssertionError ae) {
			System.out.println(b + ".getName() does not "
					+ "return expected value");
			System.out.println("Expected: fleece");
			System.out.println("Actual: " + a.getName());
			fail();
		}
		
		try {assertEquals(a.getTotalWeight(), 100);	
		} catch (AssertionError ae) {
			System.out.println(b + ".getTotalWeight() does not "
					+ "return expected value");
			System.out.println("Expected: 100");
			System.out.println("Actual: " + a.getTotalWeight());
			fail();
		}
		
		try {assertEquals(a.getWarmth(), 3);
		} catch (AssertionError ae) {
			System.out.println(b + ".getWarth() does not "
					+ "return expected value");
			System.out.println("Expected: 3");
			System.out.println("Actual: " + a.getWarmth());
			fail();
		}
		
		Clothing c = new Fleece(1);
		
		c.setAmount(0);
		try {assertEquals(c.getAmount(), 0);
		} catch (AssertionError ae) {
			System.out.println(b + ".setAmmount() does not "
					+ "change amount correctly");
			System.out.println("Expected: 0");
			System.out.println("Actual: " + c.getAmount());
			fail();
		}
		
		boolean illegalArgException = false;
		
		try {c.setAmount(-1);
		} catch (IllegalArgumentException iae) {
			illegalArgException = true;
		}
		
		try{assertTrue(illegalArgException);
		} catch(AssertionError ae) {
			System.out.println(b + ".setAmount() does not throw "
					+ "IllegalArgumentException correctly");
			fail();
		}
		
		boolean constructorError = false;
		
		try{@SuppressWarnings("unused")
		Clothing d = new Fleece(-1);
		} catch (IllegalArgumentException iae) {
			constructorError = true;
		}
		
		try{assertTrue(constructorError);
		} catch(AssertionError ae) {
			System.out.println(b + " constructor does not throw "
					+ "an IllegalArgumentException for negative amounts");
			fail();
		}
	
	}
}

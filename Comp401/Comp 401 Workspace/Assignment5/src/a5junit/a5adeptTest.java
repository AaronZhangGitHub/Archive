package a5junit;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import a5adept.*;

public class a5adeptTest {
	
	@Test
	public void cityImplTest() {
		City city1 = new CityImpl("City 1", new ChallengeStub(), new StoreStub(), true);
		City city2 = new CityImpl("City 2", new ChallengeStub(), new StoreStub(), false);
		City city3 = new CityImpl("City 3", new ChallengeStub(), new StoreStub(), false);
		
		try{
			assertEquals(true, city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: CityImpl.isGoal()");
			ae.printStackTrace();
			fail();
		}

		try{
			assertEquals(false, city1.isCleared());
		} catch (AssertionError ae) {
			System.out.println("Error location: CityImpl.isCleared()");
			ae.printStackTrace();
			fail();
		}
		
		city1.challenge(null);
		
		try{
			assertEquals(true, city1.isCleared());
		} catch (AssertionError ae) {
			System.out.println("Error location: CityImpl.challenge()");
			System.out.println("CityImpl.challenge() should change the boolean field for "
					+ "isCleared to true if Challenge.start() returns true");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals("City 1", city1.getName());
		} catch (AssertionError ae) {
			System.out.println("Error location: CityImpl.getName()");
			ae.printStackTrace();
			fail();
		}
		
		city1.setDistance(city2, 100);
		
		try {
			assertEquals(100, city1.getDistance(city2));
		} catch (AssertionError ae) {
			System.out.println("Error location: CityImpl.getDistance or CityImpl.setDistance");
			ae.printStackTrace();
			fail();
		}
	
		boolean iaethrown1 = false; 
		
		try {
			city1.getDistance(city3);
		} catch (IllegalArgumentException iae) {
			iaethrown1 = true;
		} catch (Exception e) {
			System.out.println("Caught unexpected exception on CityImpl.getDistance()");
			e.printStackTrace();
			fail();
		}
		
		try{
			assertTrue(iaethrown1);
		} catch (AssertionError ae) {
			System.out.println("CityImpl.getDistance() does not throw an "
					+ "IllegalArgumentException for cities that don't have distances");
		}
	}
	
	@Test
	public void AdventureTest() throws Exception {
		Adventure adv1 = new Adventure(Adventure.Difficulty.EASY, null);
		Adventure adv2 = new Adventure(Adventure.Difficulty.MEDIUM, null);
		Adventure adv3 = new Adventure(Adventure.Difficulty.HARD, null);
		
		try {
			assertEquals(adv1.getCities()[0], adv1.getCurrentCity());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getCurrentCity or "
					+ "Adventure.getCities()");
			System.out.println("Either current city is not Chapel Hill or Chapel Hill is "
					+ "not the first item in the array returned by getCities()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(adv2.getCities()[0], adv2.getCurrentCity());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getCurrentCity or "
					+ "Adventure.getCities()");
			System.out.println("Either current city is not Chapel Hill or Chapel Hill is "
					+ "not the first item in the array returned by getCities()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(adv2.getCities()[0], adv2.getCurrentCity());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getCurrentCity or "
					+ "Adventure.getCities()");
			System.out.println("Either current city is not Chapel Hill or Chapel Hill is "
					+ "not the first item in the array returned by getCities()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(Adventure.Difficulty.EASY, adv1.getDifficulty());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getDifficulty()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(Adventure.Difficulty.MEDIUM, adv2.getDifficulty());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getDifficulty()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(Adventure.Difficulty.HARD, adv3.getDifficulty());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getDifficulty()");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(0, adv1.getDay());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.getDay()");
			ae.printStackTrace();
			fail();
		}
		
		adv1.travel(adv1.getCities()[3]);
		
		try {
			assertEquals(14, adv1.getDay());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.travel()");
			System.out.println("Either travel() does not advance 20 miles per day or "
					+ "days is not incremented correctly");
			ae.printStackTrace();
			fail();
		}
		
		try {
			assertEquals(adv1.getCities()[3], adv1.getCurrentCity());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.travel()");
			System.out.println("travel() does not update the current city");
			ae.printStackTrace();;
		}
	}
	
	@Test
	public void EasyDifficultyTest() {
		Adventure adv = new Adventure(Adventure.Difficulty.EASY, null);
		City city1;
		City city2;
		int dist; 
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[0];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[1];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[2];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[3];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();	
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[0];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[1];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[2];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[3];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[0];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[1];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[2];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[3];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[0];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[1];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[2];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[3];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.EASY");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
			fail();
		}
		
		city1 = adv.getCities()[1];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
			fail();
		}
		
		city1 = adv.getCities()[2];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
			fail();
		}
		
		city1 = adv.getCities()[3];
		try {
			assertTrue(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.EASY - The wrong city is the goal");
			System.out.println(city1.getName() + " isn't listed as the goal city when it should be");
			fail();
		}
	}
	
	@Test
	public void MediumDifficultyTest() {
		Adventure adv = new Adventure(Adventure.Difficulty.MEDIUM, null);
		City city1;
		City city2;
		int dist; 
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[0];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[1];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[2];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[3];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[4];
		dist = 500;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[5];
		dist = 784;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[6];
		dist = 1300;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[0];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[1];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[2];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[3];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[4];
		dist = 625;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[5];
		dist = 756;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[6];
		dist = 1164;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[0];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[1];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[2];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[3];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[4];
		dist = 864;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[5];
		dist = 717;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[6];
		dist = 921;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[0];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[1];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[2];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[3];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[4];
		dist = 225;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[5];
		dist = 699;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[6];
		dist = 1524;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[0];
		dist = 500;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[1];
		dist = 625;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[2];
		dist = 864;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[3];
		dist = 225;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[4];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[5];
		dist = 790;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[6];
		dist = 1742;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[0];
		dist = 784;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[1];
		dist = 756;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[2];
		dist = 717;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[3];
		dist = 699;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[4];
		dist = 790;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[5];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[6];
		dist = 1120;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[0];
		dist = 1300;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[1];
		dist = 1164;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[2];
		dist = 921;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[3];
		dist = 1524;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[4];
		dist = 1742;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[5];
		dist = 1120;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[6];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[1];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[2];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[3];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[4];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[5];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[6];
		try {
			assertTrue(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.MEDIUM - The wrong city is the goal");
			System.out.println(city1.getName() + " isn't listed as the goal city when it should be");
		}
	}
	
	@Test
	public void HardDifficultyTest() {
		Adventure adv = new Adventure(Adventure.Difficulty.HARD, null);
		City city1;
		City city2;
		int dist; 
		
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[0];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[1];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[2];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[3];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[4];
		dist = 500;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[5];
		dist = 784;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[6];
		dist = 1300;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[7];
		dist = 1194;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[8];
		dist = 2849;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[9];
		dist = 2813;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		city2 = adv.getCities()[10];
		dist = 2787;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[0];
		dist = 140;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[1];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[2];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[3];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[4];
		dist = 625;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[5];
		dist = 756;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[6];
		dist = 1164;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[7];
		dist = 1166;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[8];
		dist = 2795;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[9];
		dist = 2708;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[1];
		city2 = adv.getCities()[10];
		dist = 2682;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[0];
		dist = 380;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[1];
		dist = 200;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[2];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[3];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[4];
		dist = 864;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[5];
		dist = 717;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[6];
		dist = 921;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[7];
		dist = 1112;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[8];
		dist = 2636;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[9];
		dist = 2472;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[2];
		city2 = adv.getCities()[10];
		dist = 2446;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[0];
		dist = 271;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[1];
		dist = 398;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[2];
		dist = 639;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[3];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[4];
		dist = 225;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[5];
		dist = 699;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[6];
		dist = 1524;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[7];
		dist = 1106;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[8];
		dist = 2761;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {			
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[9];
		dist = 2817;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[3];
		city2 = adv.getCities()[10];
		dist = 2844;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[0];
		dist = 500;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}	
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[1];
		dist = 625;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[2];
		dist = 864;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[3];
		dist = 225;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[4];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[5];
		dist = 790;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[6];
		dist = 1742;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[7];
		dist = 1197;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[8];
		dist = 2852;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[9];
		dist = 2569;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[4];
		city2 = adv.getCities()[10];
		dist = 2562;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[0];
		dist = 784;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {			
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[1];
		dist = 756;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[2];
		dist = 717;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[3];
		dist = 699;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[4];
		dist = 790;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[5];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[6];
		dist = 1120;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[7];
		dist = 404;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[8];
		dist = 2064;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[9];
		dist = 2131;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[5];
		city2 = adv.getCities()[10];
		dist = 2158;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[0];
		dist = 1300;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[1];
		dist = 1164;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[2];
		dist = 921;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[3];
		dist = 1524;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[4];
		dist = 1742;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[5];
		dist = 1120;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[6];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[7];
		dist = 1173;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[8];
		dist = 2127;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[9];
		dist = 1759;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[6];
		city2 = adv.getCities()[10];
		dist = 1733;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[0];
		dist = 1194;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[1];
		dist = 1166;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[2];
		dist = 1112;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[3];
		dist = 1106;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[4];
		dist = 1197;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[5];
		dist = 404;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[6];
		dist = 1173;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[7];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[8];
		dist = 1656;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[9];
		dist = 1977;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[7];
		city2 = adv.getCities()[10];
		dist = 2004;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[0];
		dist = 2849;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[1];
		dist = 2795;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[2];
		dist = 2636;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[3];
		dist = 2761;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[4];
		dist = 2852;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[5];
		dist = 2064;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[6];
		dist = 2127;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[7];
		dist = 1656;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[8];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[9];
		dist = 808;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[8];
		city2 = adv.getCities()[10];
		dist = 835;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[0];
		dist = 2813;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[1];
		dist = 2708;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[2];
		dist = 2472;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[3];
		dist = 2817;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[4];
		dist = 2569;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[5];
		dist = 2131;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[6];
		dist = 1759;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[7];
		dist = 1977;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[8];
		dist = 808;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[9];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[9];
		city2 = adv.getCities()[10];
		dist = 33;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[0];
		dist = 2787;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[1];
		dist = 2682;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[2];
		dist = 2446;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {	
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[3];
		dist = 2844;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[4];
		dist = 2562;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[5];
		dist = 2158;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[6];
		dist = 1733;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[7];
		dist = 2004;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[8];
		dist = 835;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[9];
		dist = 33;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[10];
		city2 = adv.getCities()[10];
		dist = 0;
		try {
			assertEquals(dist, city1.getDistance(city2));
		} catch (IllegalArgumentException iae) {
			System.out.println("Error location: Adventure.Difficulty.HARD");
			System.out.println(city1.getName() + " does not have a distance set for "
					+ city2.getName());
			fail();
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - " + city1.getName() + " distance to " + city2.getName());
			ae.printStackTrace();
			fail();
		}
		
		city1 = adv.getCities()[0];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[1];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[2];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[3];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[4];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[5];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[6];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[7];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[8];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[9];
		try {
			assertFalse(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " is listed as the goal city when it shouldn't be");
		}
		
		city1 = adv.getCities()[10];
		try {
			assertTrue(city1.isGoal());
		} catch (AssertionError ae) {
			System.out.println("Error location: Adventure.Difficulty.HARD - The wrong city is the goal");
			System.out.println(city1.getName() + " isn't listed as the goal city when it should be");
		}
	}
	
	@Test
	public void notATest() throws IOException {
		System.err.println("NOTE 1: If you don't see any console output above this telling you 'Day x: "
				+ "You are y miles away from \n(next city).', then your travel() method is not working "
				+ "correctly");
		System.err.println("NOTE 2: If you fail a bunch of the distance tests and you feel like you "
				+ "have them right, then the problem is \nprobably with your getCities() method. You most "
				+ "likely have a problem with the order of the cities.");
	}
}

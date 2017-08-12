package Test;

import static org.junit.Assert.*;
import a7.*;
import a7.Adventure.Difficulty;
import supplies.*;

import org.junit.Test;

public class travelObserverTest {

	@Test
	public void travelObserverTest() {
		Knapsack knapsack = new KnapsackImpl();
		Squad squad = new SquadImpl(3, knapsack);
		Adventure adventure = new Adventure(Difficulty.EASY, squad);
		
		
		Food bj = new BisonJerky(2);
		PowerUp c = new Coffee(10);
		Food s = new Sushi(5);
		Supplies r = new Ramen(3);
		
		knapsack.add(bj);
		knapsack.add(c);
		knapsack.add(r);
		knapsack.add(s);
		
		
		adventure.travel(adventure.getCities()[1]);			//Travel to Charlotte
		
		Food[] supplies = knapsack.getEdibleSupplies();
		int[] actual = new int[supplies.length];
		for (int i = 0; i < supplies.length; i++) {
			actual[i] = supplies[i].getDaysTillExpiration();
		}
		
		int[] expected = {33, 993, 93};

		assertArrayEquals(expected, actual);
	}

}

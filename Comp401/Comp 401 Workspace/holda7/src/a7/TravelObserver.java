package a7;

import supplies.FoodExpiredException;

public interface TravelObserver {
	void travelUpdate(Adventure adventure, int distance_to_destination, City destination);
}

package a7;

public interface City {
	int getDistance(City other);
	void setDistance(City other, int distance);
	String getName();
	boolean isCleared();
	boolean isGoal();
	
	void challenge(Squad squad); // Delegates to challenge() method of encapsulated Challenge object.
	void store(Squad squad);     // Delegates to enter() method of encapsulated Store object.
}
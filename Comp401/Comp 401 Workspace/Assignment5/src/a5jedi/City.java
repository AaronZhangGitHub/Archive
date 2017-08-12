package a5jedi;

public interface City {
	int getDistance(City other); //gets distance from one city to another
	void setDistance(City other, int distance); //sets distance from one city to another
	String getName();//gets the name of the city
	boolean isCleared();//returns if the challenge is cleared
	boolean isGoal();//returns if the goal is accomplished
	
	void challenge(Squad squad); // Delegates to start() method of encapsulated Challenge object.
	void store(Squad squad);     // Delegates to enter() method of encapsulated Store object.
}
package a4jedi;

public interface Clothing extends Supplies{

	Warmth getWarmth();//returns the warmth level of the clothing
	
	public enum Warmth {
		//warmth levels
		LIGHT,MEDIUM,WARM,
	}
}
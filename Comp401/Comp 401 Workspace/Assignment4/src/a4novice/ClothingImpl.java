package a4novice;

public class ClothingImpl  extends SuppliesImpl implements Clothing{
	private int warmth; //warmth level of the clothing
	protected ClothingImpl(int amount ,int weight, int price, int warmth, String name){
		super(amount, weight, price, name);
		this.warmth = warmth;
	}
	public int getWarmth() {
		if(warmth<1||warmth>3){
			//Checks to see if warmth level is 1, 2, or 3 if not throws an illegal argument exception
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		return warmth;
	}
}

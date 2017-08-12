package a3novice;

public class ClothingImpl  extends SuppliesImpl implements Clothing{
	private int warmth;
	public ClothingImpl(int amount ,int weight, int price, int warmth, String name){
		super(amount, weight, price, name);
		this.warmth = warmth;
	}
	public int getWarmth() {
		if(warmth<1||warmth>3){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		return warmth;
	}
}

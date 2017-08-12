package a3novice;

public class Fleece extends ClothingImpl {
	static final int weight = 10;
	static final int price = 100;
	static final int warmth = 3;
	static final String name = "fleece";
	public Fleece(int amount) {
		super(amount, weight, price, warmth, name);
	}
	
}

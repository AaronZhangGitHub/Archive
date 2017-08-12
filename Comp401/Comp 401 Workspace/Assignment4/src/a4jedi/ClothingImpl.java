package a4jedi;

abstract public class ClothingImpl  extends SuppliesImpl implements Clothing{
	private Warmth status;
	protected ClothingImpl(int amount ,int weight, int price, Warmth status, String name){
		super(amount, weight, price, name);
		this.status = status;
	}
	public Clothing.Warmth getWarmth() {
		return status;
	}
}

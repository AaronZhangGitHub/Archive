package supplies;

public abstract class ClothingImpl extends SuppliesImpl implements Clothing {

	protected Warmth warmth;

	public ClothingImpl(int amount, int weight, int price, Warmth warmth, String name) {
		super(amount, weight, price, name);
		
			this.warmth = warmth;
	}

	public Warmth getWarmth() {
		return warmth;
	}

}

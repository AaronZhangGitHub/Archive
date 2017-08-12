package supplies;

public abstract class ClothingImpl extends SuppliesImpl implements Clothing {
	
	private Clothing.Warmth warmth;
	
	protected ClothingImpl(int amount, int unit_weight, int unit_cost, String name, Clothing.Warmth warmth) {
		super(amount, unit_weight, unit_cost, name);
		this.warmth = warmth;
	}
	
	public Clothing.Warmth getWarmth() {
		return warmth;
	}
}
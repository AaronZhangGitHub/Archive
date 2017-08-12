package supplies;

public abstract class SuppliesImpl implements Supplies {
	
	/* Fields */
	private int amount;
	private int pounds_per_item;
	private int price_per_item;
	private String name;
	
	
	/* Constructors */
	
	// Protected because this is an "abstract class"
	protected SuppliesImpl(int amount, int unit_weight, int unit_cost, String name) {
		// Validate input
		if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative!");
		if (unit_weight < 0) throw new IllegalArgumentException("Unit weight must be non-negative!");
		if (unit_cost < 0) throw new IllegalArgumentException("Unit cost must be non-negative!");
		if (name == null) throw new IllegalArgumentException("Name must be non-null!");
		
		// Initialize object fields
		this.amount = amount;
		this.pounds_per_item = unit_weight;
		this.price_per_item = unit_cost;
		this.name = name;
	}
	
	
	/* Supplies methods */
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		if (amount < 0) throw new IllegalArgumentException("Amount must be non-negative!");
		this.amount = amount;
	}
	
	public int getPoundsPerItem() {
		return pounds_per_item;
	}
	
	public int getTotalWeight() {
		return amount*pounds_per_item;
	}
	
	public int getPricePerItem() {
		return price_per_item;
	}
	
	public String getName() {
		return name;
	}
}
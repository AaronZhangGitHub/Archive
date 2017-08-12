package supplies;

public abstract class SuppliesImpl implements Supplies {

	//protected variables to inherit in subclasses
	protected int amount;
	protected int weight;
	protected int price;
	protected String name;

	public SuppliesImpl(int amount, int weight, int price, String name) {
		setAmount(amount);
		this.weight = weight;
		this.price = price;
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if (amount < 0) {
			throw new IllegalArgumentException();
		} else {
			this.amount = amount;
		}
	}

	public int getPoundsPerItem() {
		return weight;
	}

	public int getTotalWeight() {
		return weight * amount;
	}

	public int getPricePerItem() {
		return price;
	}

	public String getName() {
		return name;
	}

}

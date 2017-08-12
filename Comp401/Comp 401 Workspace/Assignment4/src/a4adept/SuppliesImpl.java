package a4adept;

public class SuppliesImpl implements Supplies {
	protected int amount;
	private int weight;
	private int price;
	private String name;
	protected SuppliesImpl(int amount, int weight, int price, String name){
		if(amount<0){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		this.amount = amount;
		this.weight = weight;
		this.price = price;
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		if(amount<0){
			throw new IllegalArgumentException("Illegal Argument Exception");
		}
		this.amount = amount;
	}

	public int getPoundsPerItem() {
		return weight;
	}

	public int getTotalWeight() {
		return amount*weight;
	}

	public int getPricePerItem() {
		return price;
	}

	public String getName() {
		return name;
	}

}

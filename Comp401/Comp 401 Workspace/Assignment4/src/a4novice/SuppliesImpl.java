package a4novice;

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
		//returns how much of the supply you have left
		return amount;
	}

	public void setAmount(int amount) {
		//sets the amount of the supply to an integer
		//if the integer is less than zero, throws an exception
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

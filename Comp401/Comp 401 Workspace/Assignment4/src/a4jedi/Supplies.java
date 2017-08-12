package a4jedi;

public interface Supplies {
	int getAmount(); //returns amount of the supply
	void setAmount(int amount);//sets amount of supply
	
	int getPoundsPerItem();//returns how much the supply weights
	int getTotalWeight();//returns total weight of the supply
	
	int getPricePerItem();//returns the price for the supply
	
	String getName();//returns the name of the supply
}

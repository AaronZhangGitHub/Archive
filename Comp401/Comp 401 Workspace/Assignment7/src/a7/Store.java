package a7;

public interface Store {
	void enter(Squad squad);
	double getPrice(String item_name) throws ItemNotForSaleException;
	String[] getItemNames();
}
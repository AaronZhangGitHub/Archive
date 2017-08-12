package a7;

public class WDCStore implements Store {
	
	private StoreImpl store;
	
	public WDCStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return ((store.getPrice(item_name) + 1.50) * 1.05);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}

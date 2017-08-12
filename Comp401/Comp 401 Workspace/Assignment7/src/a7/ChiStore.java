package a7;

public class ChiStore implements Store {
	
	private StoreImpl store;
	
	public ChiStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return (store.getPrice(item_name) * 1.05);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}

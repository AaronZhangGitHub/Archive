package a7;

public class MinnStore implements Store {
	
	private StoreImpl store;
	
	public MinnStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		return store.getPrice(item_name);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}

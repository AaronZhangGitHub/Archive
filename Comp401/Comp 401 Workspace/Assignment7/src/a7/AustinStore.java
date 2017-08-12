package a7;

public class AustinStore implements Store {
	
	private StoreImpl store;
	
	public AustinStore(StoreImpl s){
		this.store = s;
		s.getPrices().remove("fleece");
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

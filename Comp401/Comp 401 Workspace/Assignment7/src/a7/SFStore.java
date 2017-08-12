package a7;

public class SFStore implements Store {
	
	private StoreImpl store;
	
	public SFStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("fleece") || item_name.equals("t-shirt")){
			return ((store.getPrice(item_name) + 1.50) * 1.13);
		}
		return ((store.getPrice(item_name) + 1.50) * 1.08);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}

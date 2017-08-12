package a7;

public class CHStore implements Store {
	
	private StoreImpl store;
	
	public CHStore(StoreImpl s){
		this.store = s;
	}

	@Override
	public void enter(Squad squad) {
		store.enter(squad);
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("fleece") || item_name.equals("t-shirt")){
			return (store.getPrice(item_name) * 1.04);
		}
		return store.getPrice(item_name);
	}

	@Override
	public String[] getItemNames() {
		return store.getItemNames();
	}

}

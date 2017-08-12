package a7;

public class PAStore implements Store {
	
	private StoreImpl s;
	
	public PAStore(StoreImpl s){
		this.s = s;
	}

	@Override
	public void enter(Squad squad) {
		s.enter(squad);
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("fleece") || item_name.equals("t-shirt")){
			return ((s.getPrice(item_name) + 1.50) * 1.05);
		}
		return ((s.getPrice(item_name) + 1.50));
	}

	@Override
	public String[] getItemNames() {
		return s.getItemNames();
	}

}

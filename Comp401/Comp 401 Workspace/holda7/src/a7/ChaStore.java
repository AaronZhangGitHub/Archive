package a7;

public class ChaStore implements Store {

	private StoreImpl s;

	public ChaStore(StoreImpl s) {
		this.s = s;
		s.getPrices().remove("fleece");
	}

	@Override
	public void enter(Squad squad) {
		s.enter(squad);

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		if(item_name.equals("button-up") || item_name.equals("fleece") || item_name.equals("t-shirt")){
			return (s.getPrice(item_name) * 1.04);
		}
		return s.getPrice(item_name);
	}

	@Override
	public String[] getItemNames() {
		return s.getItemNames();
	}

}

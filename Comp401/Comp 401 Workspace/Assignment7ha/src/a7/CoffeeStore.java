package a7;

public class CoffeeStore implements Store {
	private double city;
	private double state;
	private double price_adder;

	public CoffeeStore(Store store, double tax_c, int state,
			double orice_adder) {
		this.city = tax_c;
		this.state = state;
		this.price_adder = orice_adder;
	}

	@Override
	public void enter(Squad squad) {
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		String[] items = this.getItemNames();
		String[] names = { "coffee" };
		double[] price = { 2.50 };
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item_name)) {
				
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals(item_name)) {
						if (item_name.equals("button-up")|| (item_name.equals("fleece"))|| (item_name.equals("t-shirt"))) {
							return (((price[j] + price_adder)) * (city+ state - 1));
						} else {
							return ((price[j]) + price_adder) * (city);
						}
					}
				}
				
			}
		}

		throw new ItemNotForSaleException();
	}

	@Override
	public String[] getItemNames() {
		String[] Name = {"coffee"};
		return Name;
	}

}

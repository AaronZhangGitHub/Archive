package a7;

public class NoFleeceStore implements Store {
	private double city_tax;
	private double state_tax;
	private double base_add_price;

	public NoFleeceStore(Store store, double city_tax, double state_tax,
			double base_add_price) {
		this.city_tax = city_tax;
		this.state_tax = state_tax;
		this.base_add_price = base_add_price;
	}

	@Override
	public void enter(Squad squad) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		String[] allItems = this.getItemNames();
		String[] names = { "bison jerky", "burrito", "button-up", "coffee",
				"fleece", "ramen noodles", "Red Bison", "sushi", "t-shirt" };
		double[] prices = { 2.00, 4.00, 10.00, 2.50, 12.00, 0.50, 3.25, 3.75,
				5.00 };
		for (int i = 0; i < allItems.length; i++) {
			if (allItems[i].equals(item_name)) {
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals(item_name)) {
						if (item_name.equals("button-up")
								|| (item_name.equals("fleece"))
								|| (item_name.equals("t-shirt"))) {
							return (((prices[j] + base_add_price)) * (city_tax
									+ state_tax - 1));
						} else {
							return ((prices[j]) + base_add_price) * (city_tax);
						}
					}
				}
			}
		}

		throw new ItemNotForSaleException();
	}

	@Override
	public String[] getItemNames() {
		String[] itemNames = { "bison jerky", "burrito", "button-up", "coffee",
				"ramen noodles", "Red Bison", "sushi", "t-shirt" };
		return itemNames;
	}

}

package a7;

public class NoFleeceStore implements Store {
	private double city;
	private double state;
	private double added_price;

	public NoFleeceStore(Store store, double city, double state,
			double added_price) {
		this.city = city;
		this.state = state;
		this.added_price = added_price;
	}

	@Override
	public void enter(Squad squad) {
	}

	@Override
	public double getPrice(String item_name) throws ItemNotForSaleException {
		String[] items = this.getItemNames();
		String[] names = { "bison jerky", "burrito", "button-up", "coffee",
				"fleece", "ramen noodles", "Red Bison", "sushi", "t-shirt" };
		double[] prices = { 2.00, 4.00, 10.00, 2.50, 12.00, 0.50, 3.25, 3.75,5.00 };
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(item_name)) {
				for (int j = 0; j < names.length; j++) {
					if (names[j].equals(item_name)) {
						if (item_name.equals("button-up")|| (item_name.equals("fleece"))
								|| (item_name.equals("t-shirt"))) {
							return (((prices[j] + added_price)) * (city+ state - 1));
						} else {
							return ((prices[j]) + added_price) * (city);
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

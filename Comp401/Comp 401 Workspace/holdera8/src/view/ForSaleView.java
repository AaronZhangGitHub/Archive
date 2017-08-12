package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import supplies.Supplies;
import model.ItemNotForSaleException;
import model.Store;

public class ForSaleView extends JPanel implements ActionListener {

	private Store our_store;
	private JComboBox items_in_store;
	
	public ForSaleView(Store our_store) throws ItemNotForSaleException {
		this.our_store = our_store;
	
	JLabel items_for_sale_label = new JLabel("Items for Sale at Current City's Store: ");
	
	String[] items = our_store.getItemNames();
	String[] items_and_prices = new String[items.length];
	
	for (int i=0; i<our_store.getItemNames().length; i++) {
		items_and_prices[i] = (items[i] + " ($" + our_store.getPrice(items[i]) + ")");
	}
	
	items_in_store = new JComboBox(items_and_prices);
	items_in_store.addActionListener(this);
	
	add(items_for_sale_label);
	add(items_in_store);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		}
	
}


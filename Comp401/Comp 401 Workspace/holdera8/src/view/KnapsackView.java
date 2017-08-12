package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import supplies.Supplies;
import model.Knapsack;

public class KnapsackView extends JPanel implements Observer {
// Knapsack is an observable class. We want KnapsackView to be an observer 
	
	private Knapsack backpack;
	private String in_knapsack;
	private JLabel items_in_knapsack;
	private JPanel knapsack_panel;

	public KnapsackView(Knapsack backpack) {
		this.backpack = backpack;
		this.backpack.addObserver(this);
		// Now whenever something in the knapsack changes, the update() method can be called so KnapsackView is notified
		
		setLayout(new BorderLayout());
		
		knapsack_panel = new JPanel();
		knapsack_panel.setLayout(new GridLayout(backpack.getSupplies().length,1));
		
		
		JLabel knapsack_contents = new JLabel ("Knapsack Contents:");
		
		
		add (knapsack_contents, BorderLayout.NORTH);
		
		in_knapsack="";
		for (int i=0; i<backpack.getSupplies().length; i++) {
			in_knapsack = (backpack.getSupplies()[i].toString());
			items_in_knapsack = new JLabel(in_knapsack);
			knapsack_panel.add(items_in_knapsack);
		}	
		
		add(knapsack_panel, BorderLayout.CENTER);
	}

	@Override
	public void update(Observable o, Object arg) {
		// When we call notify, it will go to the list of observers and call the update method for each one
		knapsack_panel.removeAll();
		// We need to remove all first so it doesn't keep building on old items
		in_knapsack="";
		for (int i=0; i<backpack.getSupplies().length; i++) {
			in_knapsack = (backpack.getSupplies()[i].toString());
			items_in_knapsack = new JLabel(in_knapsack);
			knapsack_panel.add(items_in_knapsack);
		}	
		
		add(knapsack_panel);
	
	}
	

}

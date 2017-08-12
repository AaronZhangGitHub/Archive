package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.Knapsack;

public class KnapackView extends JPanel implements Observer{
	private Knapsack knapsack;
	private JLabel items;
	private JPanel panel;
	public KnapackView(Knapsack k){
		knapsack = k;
		this.knapsack.addObserver(this);
		
		setLayout(new BorderLayout());
		add(new JLabel("Whats in your Sack: "), BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(knapsack.getSupplies().length,1));
		
		String hold ="";
		
		for (int i=0; i<knapsack.getSupplies().length; i++) {
			hold = (knapsack.getSupplies()[i].toString());
			items = new JLabel(hold);
			panel.add(items);
		}	
		add(panel,BorderLayout.SOUTH);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		panel.removeAll();
		String hold="";
		for (int i=0; i<knapsack.getSupplies().length; i++) {
			hold = (knapsack.getSupplies()[i].toString());
			items = new JLabel(hold);
			panel.add(items);
		}	
		add(panel,BorderLayout.SOUTH);
		
	}
}

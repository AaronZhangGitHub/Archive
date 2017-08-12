package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import person.Person;
import model.Adventure;
import model.InTransitException;
import model.ItemNotForSaleException;
import model.Squad;
import model.TravelObserver;

public class AdventureView extends JPanel {
	// View that encapsulates all other views. PersonView, TravelControlView, CityLocation, StatusView 
		// should all be instantiated in this class
	// When we create a view, we have to instantiate the view in our AdventureVeiew

	private Adventure adventure;
	
	public AdventureView(Adventure adventure) throws InTransitException, ItemNotForSaleException {
		this.adventure = adventure;
		
		Squad my_homies = adventure.getSquad();
		
		setLayout(new GridLayout(7,1));
	
		for (int i=0; i<5; i++) {
			Person homie = my_homies.getPlayer(i);
			PersonView pvhomie = new PersonView(homie);
			add(pvhomie.getButton());
		}

		TravelControlView travel_view = new TravelControlView(adventure);
		add(travel_view);

		
		KnapsackView knapsack_view = new KnapsackView(adventure.getSquad().getKnapsack());
		add(knapsack_view);
		
		ForSaleView for_sale_view = new ForSaleView(adventure.getCurrentCity().getStore());
		add(for_sale_view);
		
		
	}
}

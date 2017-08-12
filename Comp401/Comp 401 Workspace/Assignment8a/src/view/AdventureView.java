package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import person.Person;
import model.Adventure;
import model.InTransitException;
import model.Squad;

public class AdventureView extends JPanel {

	private Adventure adventure;
	
	public AdventureView(Adventure adventure) throws InTransitException {
		this.adventure = adventure;
		
		setLayout(new GridLayout(5,1));
		
		Squad s = adventure.getSquad();
		
		for (int i=0; i<5; i++) {
			Person p = s.getPlayer(i);
			PersonView person_view = new PersonView(p);
			add(person_view.getTheButt());
		}
		
		TravelControlView travel_view = new TravelControlView(adventure);
		add(travel_view);
		
		KnapackView viewTheSack = new KnapackView(adventure.getSquad().getKnapsack());
		add(viewTheSack);
		
	}
}

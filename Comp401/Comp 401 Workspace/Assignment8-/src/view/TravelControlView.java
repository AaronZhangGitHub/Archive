package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;
import model.City;
import model.InTransitException;
import model.TravelObserver;

public class TravelControlView extends JPanel implements ActionListener, TravelObserver {
	private Adventure adventure;
	private JComboBox listCity;
	private JLabel info;
	
	public TravelControlView(Adventure adventure) throws InTransitException {
		setLayout(new BorderLayout());
		this.adventure = adventure;
		this.adventure.addTravelObserver(this);
		
		
		JLabel label = new JLabel("Travel to:");
		JPanel layout = new JPanel();
		
		
		City[] cityarray = adventure.getCities();
		listCity = new JComboBox(cityarray);
		listCity.addActionListener(this);
		
		info = new JLabel("You are currently in " + adventure.getCurrentCity().toString() + ".");
		
		layout.add(label);
		layout.add(listCity);
		
		add(layout, BorderLayout.NORTH);
		add(info, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//get selected city and travel to the city
		adventure.travel((City)listCity.getSelectedItem());
	}
	
	public void travelUpdate(Adventure adventure, 
							int distance_to_destination,
							City destination) {
		if (distance_to_destination == 0) {
			info.setText("You have arrived in " + destination.toString() + "!");
		}else {
		info.setText("You are " + distance_to_destination + " miles away from " + destination.toString());
		}
	}
}

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
	// In our Adventure class, the TravelObservers are updated each day that passes.
	// Since we call travel(), it will update TravelObservers and update all views that
		// implement travel observers. 
	// Second part: We want our UI to tell us how many days we are from Chicago. So we need a view that
		// implements TravelObserver and add that view to the list of TravelObservers. We'll create
		// another View and in the constructor we'll add that view to a list of TravelObservers in the 
		// Adventure and they'll change their views accordingly.
	
	private Adventure our_adventure;
	private JComboBox city_list;
	private JLabel travel_info;
	
	public TravelControlView(Adventure our_adventure) throws InTransitException {
		
		setLayout(new BorderLayout());
		
		this.our_adventure = our_adventure;
		this.our_adventure.addTravelObserver(this);
		//Need to addTravelObserver to our TravelControlView so the travel update method is called
		
		City[] city_array = our_adventure.getCities();
			
		JLabel city_label = new JLabel("Travel to:");
		JPanel layout = new JPanel();
		
		city_list = new JComboBox(city_array);
		// JComboBox takes in an array of cities. So we will get an array of cities from our_adventure
		// We need to make sure city_list is being listened to.
		// We will add this class to the listener for JComboBox
		
		city_list.addActionListener(this);
		// Now that city_list implements an ActionListener, we add this class to a listener that JComboBox has
		// JComboBox comes with the addActionListener method
		
		travel_info = new JLabel("You are currently in " + our_adventure.getCurrentCity().toString() + ".");
		
		layout.add(city_label);
		layout.add(city_list);
		
		// Need to have city_list and city_label to the JPanel so we can see them
		add(layout, BorderLayout.NORTH);
		add(travel_info, BorderLayout.CENTER);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// I am going to travel to the city selected. We want to notify all listeners of the city selected.
		// When an action is performed, we get to select the city and travel to that city.
		our_adventure.travel((City)city_list.getSelectedItem());
		// We want to travel to the item that we selected. To get the item we selected, we use the JavaBeans
			// convention getSelectedItem()
		// Since this will return an object, and the object is not necessarily a city, we must cast it.
	}


	@Override
	public void travelUpdate(Adventure adventure, int distance_to_destination,
			City destination) {
		if (distance_to_destination == 0) {
			travel_info.setText("You have arrived in " + destination.toString() + "!");
		}
		else {
		travel_info.setText("You are " + distance_to_destination + " miles away from " + destination.toString());
		}
	}
	

}

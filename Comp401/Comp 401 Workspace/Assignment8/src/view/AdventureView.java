package view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Adventure;

public class AdventureView extends JPanel {

	private Adventure adventure;
	
	public AdventureView(Adventure adventure) {
		this.adventure = adventure;
		
		setLayout(new BorderLayout());
		
		add(new JLabel("Your UI Here"), BorderLayout.CENTER);
	}
}

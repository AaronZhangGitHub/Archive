package view;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import person.Person;

public class PersonView extends JPanel implements Observer {

	private Person person;
	private JButton butt;
	
	JLabel name;
	JLabel hp;
	JLabel skill;
	JLabel health;
	
	public PersonView(Person p) {
		person = p;	
		
		butt = new JButton();
		butt.setLayout(new GridLayout(4,0));
		butt.add(new JLabel(p.getName()));
		butt.add(new JLabel("HP: " + p.getCurrentHP()));
		butt.add(new JLabel("Skill: " + p.getSkill()));
		butt.add(new JLabel(p.getStatus().toString()));
		butt.add(new JLabel(""));
		
		add(butt);
		person.addObserver(this);
	}
	
	public JButton getTheButt() {
		return butt;
	}

	@Override
	public void update(Observable o, Object arg) {
		hp.setText("HP: " + person.getCurrentHP());
		skill.setText("Skill: " + person.getSkill());
		health.setText(person.getStatus().toString());
	}
	
}

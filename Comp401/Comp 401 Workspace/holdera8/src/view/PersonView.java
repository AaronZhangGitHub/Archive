package view;

import java.awt.Button;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import person.Person;
import person.Person.Status;

public class PersonView extends JPanel implements Observer {

	private Person person;
	private JButton butt;
	
	JLabel name;
	JLabel hp;
	JLabel skill;
	JLabel health;
	
	public PersonView(Person p) {
		person = p;
		
		name = new JLabel(p.getName());
		hp = new JLabel("HP: " + p.getCurrentHP()+"/"+p.getMaxHP());
		skill = new JLabel("Skill: " + p.getSkill());
		health = new JLabel(p.getStatus().toString());
		
		butt = new JButton();
		butt.setLayout(new GridLayout(2,0));
		butt.add(name);
		butt.add(hp);
		butt.add(skill);
		butt.add(health);
		
		add(butt);
		person.addObserver(this);
	}
	
	public JButton getButton() {
		return butt;
	}

	@Override
	public void update(Observable o, Object arg) {
		hp.setText("HP: " + person.getCurrentHP()+"/"+person.getMaxHP());
		skill.setText("Skill: " + person.getSkill());
		health.setText(person.getStatus().toString());
	}
	
}

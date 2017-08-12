package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

import person.Person;
import model.Adventure;
import model.Squad;

public class PersonUpdate extends JPanel {
	private Adventure a;

	public PersonUpdate(Adventure a) {
		this.a = a;
		Squad s = a.getSquad();
		Person hold;
		for (int i = 0; i < 5; i++) {
			hold = s.getPlayer(i);
			add(new JLabel(hold.getName()));
			add(new JLabel("HP: " + hold.getCurrentHP() + "/" + hold.getMaxHP()));
			add(new JLabel("Skill " + hold.getSkill()));
			add(new JLabel(hold.getStatus() + ""));
			add(new JLabel(""));
		}
	}
}

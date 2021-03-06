package croaker;

import java.util.List;
import java.util.ArrayList;

import observer.Follower;
import observer.Publisher;

/** A class representing a user on the Croaker social media platform.
 *  A user can both follow other users 
 *  and send "croaks" to their followers.
 *  
 *  Note that this just encapsulates the user account data:
 *  it is not a user interface!  */
public class UserAccount implements Publisher, Follower {
	
	private String name;
	private List<Croak> croaks;
	// TODO one more instance variable ...
	
	public UserAccount(String name) {
		this.name = name;
		croaks = new ArrayList<Croak>();
	}
	
	public String getName() {
		return name;
	}
	
	public List<Croak> getCroaks() {
		return croaks;
	}

	public void follow(Publisher p) {
		// TODO
		// In real life, we would return information about 
		// success or failure
	}
	
	public void registerFollower(Follower f) {
		// TODO
	}

	/** The eponymous croak method! */
	public void croak(String message) {
		// TODO
	}

	public void instantMessage(Follower f, String message) {
		// TODO
	}
	
	public void update(Croak croak) {
		// TODO	
	}
	
	/** Returns "newsfeed" */
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Croak c : croaks) {
			UserAccount sender = (UserAccount) c.getSender();
			sb.append(sender.getName() + ": ");
			sb.append(c.getText());
			sb.append('\n');
		}
		
		return sb.toString();
	}
}

package a5junit;

import a5adept.Challenge;
import a5adept.Squad;

public class ChallengeStub implements Challenge{

	@Override
	public boolean start(Squad squad) {
		return true;
	}

}

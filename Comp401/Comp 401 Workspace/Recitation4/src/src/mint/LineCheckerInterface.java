package src.mint;

// This interface is implemented by all of our LineChecker subclasses
public interface LineCheckerInterface {
	
  // This method checks one line of code, and returns true
  // if the line passed whichever test is being run
  public boolean checkLine(String line);
  
  // This method records the line number of a failed test
  public void failedAtLine(int numLine);
  
  // Get a string array listing all error messages that have
  // been detected
  public String[] listErrors();
}

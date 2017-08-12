package src.mint;

import java.lang.Character;

public class SpaceLineChecker extends LineChecker implements LineCheckerInterface {
  // Constructor.
  public SpaceLineChecker() {
    // Call the parent class's constructor
    super();
    
    // Set errMsg
    errMsg = "Extra space at the end of a line.";
  }


  // This method records the line number of a failed test
  public void failedAtLine(int line_num) {
    lineNums.add(line_num);
  }


  // Get a string array listing all error messages that have
  // been detected
  public String[] listErrors() {
    String[] errMsgs = new String[lineNums.size()];
    for (int i=0; i<lineNums.size(); i++) {
      errMsgs[i] = "Line " + (lineNums.get(i) + 1) + ": " + errMsg;
    }
    return errMsgs;
  }


  // This function implements the checkLine function for this test
  public boolean checkLine(String line) {
    int len = line.length();
    return !(len > 0 && Character.isWhitespace(line.charAt(len-1)));
  }
}

package src.mint;

import java.util.ArrayList;

public class WidthLineChecker extends LineChecker implements LineCheckerInterface {

  private int maxWidth;
  private int tabSize;


  // Constructor with both maxWidth and tabSize parameters.
  public WidthLineChecker(int maxWidth, int tabSize) {
    // **** TODO ****
    // 1. Call Parent Constructor (via super())
    // 2. Initialize maxWidth
    // 3. Set tabSize
    // 4. Set default error message (errMsg)
  }


  // Overloaded constructor with maxWidth parameter.
  public WidthLineChecker(int maxWidth) {
    // **** TODO ****
	  this(maxWidth,4);
  }


  // Overloaded constructor with no parameters passed.
  public WidthLineChecker() {
    // **** TODO ****
	  this(80);
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
    int tabCount = 0;
    for(int i = 0; i < line.length(); ++i) {
      if (line.charAt(i) == '\t') {
        tabCount++;
      }
    }
    int lineLength = line.length() + tabCount * (tabSize-1);
    return (lineLength <= maxWidth);
  }
}

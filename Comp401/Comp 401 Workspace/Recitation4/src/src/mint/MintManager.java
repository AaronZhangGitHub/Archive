package src.mint;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MintManager {

  // LineCheckers
  private SpaceLineChecker spaceCheck;
  private WidthLineChecker widthCheck;


  // Filepath And Number Of Errors
  private String filepath;
  private int numErrors;


  // Array To Store Lines From File
  private ArrayList<String> lines;


  // Constructor
  public MintManager(String filepath) throws IOException {
    
    // Variable Initialization
    // **** TODO ****
    // 1. Initialize spaceCheck and widthCheck.
    // 2. Initialize numErrors to zero
    // 3. Initialize filepath.
    // 4. Initialize lines.
    
    // Read Lines From File
    // **** TODO ****
    // 5. Read the lines from the file given by filepath into memory
    //    Hint: Use readLines() method, defined below
    
  }


  // Read all the lines from the input file.
  private void readLines() throws IOException {
    // Try to open the given file and create a scanner to read in each line.
    try (Scanner scanner = new Scanner(new File(filepath))) {
      while (scanner.hasNextLine()) {
        lines.add(scanner.nextLine());
      }
    }
  }


  // Returns path to the file to check.
  public String getFilePath() {
    return filepath;
  }


  // Returns the total number of errors.
  public int getNumErrors() {
    return numErrors;
  }


  // Check each line
  public void check() {
    String line;
    for (int i=0; i<lines.size(); i++) {
      line = lines.get(i);
      if (!spaceCheck.checkLine(line)) {
        spaceCheck.failedAtLine(i);
        numErrors++;
      }
      if (!widthCheck.checkLine(line)) {
        widthCheck.failedAtLine(i);
        numErrors++;
      }
    }
  }


  // Return errors as a single String.
  public String getErrors() {
    StringBuilder b = new StringBuilder();
    String[] errors;
    errors = spaceCheck.listErrors();
    for (int i=0; i<errors.length; i++) {
      b.append(errors[i] + System.lineSeparator());
    }
    errors = widthCheck.listErrors();
    for (int i=0; i<errors.length; i++) {
      b.append(errors[i] + System.lineSeparator());
    }
    return b.toString();
  }
}

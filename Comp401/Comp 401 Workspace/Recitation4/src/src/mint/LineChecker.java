package src.mint;

import java.util.ArrayList;

// The parent class for all of our LineChecker subclasses
public class LineChecker {
  
  // To encapsulate the errors that were detected, we will
  // store an error message string and an integer array
  // to store line numbers
  protected String errMsg;
  protected ArrayList<Integer> lineNums;


  // A protected constructor to initialize lineNums
  protected LineChecker() {
    lineNums = new ArrayList<Integer>();
  }


  // **** TODO ****
  // Factor methods common to both LineCheckers here
  // You should end up factoring out EXACTLY TWO methods
  //   to this class

}

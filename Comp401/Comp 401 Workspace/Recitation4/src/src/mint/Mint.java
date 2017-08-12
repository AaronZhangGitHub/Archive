package src.mint;


import java.io.IOException;
import java.util.Scanner;


public class Mint {
  public static void main(String[] args) {
    // Create Scanner
    Scanner s = new Scanner(System.in);
    
    // Print Welcome Message
    System.out.println("Welcome to Mint - a programmer's best friend for finding style mistakes in your Java code.");
    
    // Ask User For Java File Path
    String filepath = "";
    System.out.println("Enter the path to the .java file that you want to check:");
    filepath = s.next();
    
    // Create MintManager Object
    MintManager mint;
    try {
      mint = new MintManager(filepath);
    } catch (IOException e) {
      System.err.println("Error: Cannot read or find file: " + filepath);
      System.err.println("Mint cannot continue.");
      System.err.println("Program terminated.");
      return;
    }
    
    // Run Mint
    System.out.println("Running Mint...");
    mint.check();
    
    // Print Errors
    System.out.println(mint.getErrors());
    
    // Print Number Of Errors
    int numErrors = mint.getNumErrors();
    System.out.println("We found a total of " + numErrors + " style errors.");
  }
}

package Recitation5Sample.src;



public class Account {

	// define var1, var2
	protected int id = 0;
	protected double balance = 0;



	// constructor with specific id and initial balance
	public Account(int newId, double newBalance) {
		id = newId;
		balance = newBalance;
	}


	public int getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}



	public void setId(int newId) {
		id = newId;
	}

	public void setBalance(double newBalance) {
		balance = newBalance;
	}


	// define method withdraw
	void withdraw(double amount) {
		// write your code here
	}

	// define method deposit
	void deposit(double amount) {
		//wite your code here
	}
	
	void printInfo(){
		System.out.println("Account balance:"+balance);
	}
}

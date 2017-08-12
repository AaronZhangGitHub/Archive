package Recitation5Sample.src;

/*
 * SavingsAccount extends Account
 * It cannot go negative balance
 */

public class SavingsAccount extends Account {
	public SavingsAccount(int newId, double newBalance) {
		super(newId, newBalance);
		System.out.println("Account Succesfully created  with id=" + newId);
	}

	// a savings account cannot be overdrawn
	public void withdraw(double amount) {
		//write your code here

	}

	public void printInfo() {
		System.out.println("Its a savings account, with balance :" + balance);
	}
}

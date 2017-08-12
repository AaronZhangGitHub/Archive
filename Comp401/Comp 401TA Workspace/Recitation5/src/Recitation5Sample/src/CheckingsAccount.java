package Recitation5Sample.src;

/*
 * CheckingsAccounts extends Account class
 * with a extra parameter called overdrafLimit
 * You can go to negative balance till the over draft limit is reached
 */
public class CheckingsAccount extends Account {
	
	private double overdrafLimit;

	public CheckingsAccount(int newId, double newBalance, double overdrafLimit) {
		super(newId, newBalance);
		this.overdrafLimit = overdrafLimit;
		System.out.println("Account Succesfully created  with id="+newId);
	}

	public void setOverdraftLimit(double o) {
		overdrafLimit = o;
	}

	public double getOverdraftLimit() {
		return overdrafLimit;
	}

	public void withdraw(double amount) {
		//write your code here
	}
	
	public void printInfo(){
		System.out.println("Its a checkings account, with balance: "+balance+", overdraft limit :"+overdrafLimit);
	}


}

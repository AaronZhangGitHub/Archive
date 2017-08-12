package Recitation5Sample.src;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * Bank App with features like:
 * 								create account
 * 								with draw funds
 * 								add funds
 */
public class BankApp {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Map<Integer,Account> accounts = new HashMap<Integer,Account>();
		int counter=0;
		while(true){
			counter++;
			System.out.println("enter 1 to create an account");
			System.out.println("enter 2 to withdraw funds");
			System.out.println("enter 3 to add funds");
			System.out.println("enter 4 to check account status");
			System.out.println("enter 5 to exit");
			int choice = input.nextInt();
			int id;
			double amount;
			Account account;
			switch(choice){
			case 1:
				System.out.println("Press 0 for savings account or 1 for checkings account");
				int accountType=input.nextInt();
				System.out.println("Enter initial Account balance");
				double balance=input.nextDouble();
				if(accountType==0){
					
					accounts.put(counter,new SavingsAccount(counter,balance));
				}
				else if(accountType==1){
					System.out.println("Enter Over draft limit amount");
					double overdrafLimit = input.nextDouble();
					accounts.put(counter,new CheckingsAccount(counter,balance,overdrafLimit));
				}
				else{
					System.out.println("Option not exits! try again!");
				}
				break;
			case 2:
				System.out.println("Enter account id");
				id = input.nextInt();
				System.out.println("Enter the withdrawal Amount");
				amount = input.nextDouble();
				account = accounts.get(id);
				if (account != null){
					account.withdraw(amount);
				}
				else{
					System.out.println("Account doesn't exit!");
				}
				break;
			case 3:
				System.out.println("Enter account id");
				id = input.nextInt();
				System.out.println("Enter the Amount");
				amount = input.nextDouble();
				account = accounts.get(id);
				if (account != null){
					account.deposit(amount);
				}
				else{
					System.out.println("Account doesn't exit!");
				}
				break;
				
			case 4:
				System.out.println("Enter account id");
				id = input.nextInt();
				account = accounts.get(id);
				if (account != null){
					account.printInfo();
				}
				else{
					System.out.println("Account doesn't exit!");
				}
				
				break;
				
			case 5:
				System.out.println("Program Terminated...");
				System.exit(0);
				break;
				
			default:
				System.out.print("Not a valid option!");
				break;
				
			}
			
				
					
			
		}
	}

}
package application;

import java.util.Locale;
import java.util.Scanner;

import Exceptions.AmountException;
import entities.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner keyBoard = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = keyBoard.nextInt();
			System.out.print("Holder: ");
			keyBoard.nextLine();
			String holder = keyBoard.nextLine();
			System.out.print("Initial balance: ");
			double balance = keyBoard.nextDouble();
			System.out.print("Withdraw limit: ");
			double limit = keyBoard.nextDouble();
			
			Account account = new Account(number, holder, balance, limit);
			
			System.out.println("");
			System.out.println("Enter amount for withdraw: ");
			account.withdraw(keyBoard.nextDouble());
			System.out.printf("New balance: %.2f", account.getBalance());
		}
		catch (AmountException e){
			System.out.println("Withdraw error: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Unexpected error");
		}
		
		keyBoard.close();
	}
}

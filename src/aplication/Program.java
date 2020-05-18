package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int numberAccount = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			Account account = new Account(numberAccount, holder, initBalance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw:: ");
			account.withdraw(sc.nextDouble());

			System.out.printf("New balance: %.2f", account.getBalance());
		} catch (DomainExceptions e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Corrigir." + e.getMessage());
		}

		sc.close();
	}
}

package account;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static Scanner input = new Scanner(System.in);
	static Account acc = new Account("Hoan", "vietcombank", 1234, 0);

	public static void main(String[] args) {
		System.out.println(acc.getCardNumber());
		acc.deposit(10000);

		while (true) {
			System.out.println("Set phone number:");
			String phone = input.next();
			if (acc.isRightNumber(phone)) {
				acc.setPhoneNumber(phone);
				break;
			}
		}

		boolean check = true;
		while (check) {
			System.out
					.println("============== Online Payment System ===============");
			System.out.println("1. CreditCardStrategy");
			System.out.println("2. DirectPayStrategy");
			System.out.println("3. MobileBankingStrategy");
			System.out.println("4. Exit");
			System.out.println("Enter your option please");
			int option = input.nextInt();

			switch (option) {
			case 1:
				input.nextLine();
				CreditCardStrategy pay1 = new CreditCardStrategy("", "", 0000);
				System.out.println("Enter name:");
				String name = input.nextLine();
				pay1.setName(name);
				System.out.println("Enter creditCard number:");
				String cardNumber = input.next();
				pay1.setCardNumber(cardNumber);
				int count1 = 3;
				while (count1 > 0) {
					try {
						System.out.println("PIN:");
						int pin2 = input.nextInt();
						count1--;
						pay1.setSecretPIN(pin2);
						break;
					} catch (InputMismatchException ex) {
						System.out.println("Numercial string is required");
						count1--;
						input.nextLine();
					}
				}

				System.out.println("How much money do u want to withdraw?");
				double withdrawMoney = input.nextDouble();
				acc.withdraw(pay1, withdrawMoney);
				System.out.println("Balance = " + acc.getBalance());
				break;

			case 2:
				DirectPayStrategy pay2 = new DirectPayStrategy("", 0000);
				System.out.println("Enter userID:");
				String userId = input.next();
				pay2.setUserId(userId);

				int count2 = 3;
				while (count2 > 0) {
					try {
						System.out.println("PIN:");
						int pin2 = input.nextInt();
						count2--;
						pay2.setSecretPIN(pin2);
						break;
					} catch (InputMismatchException ex) {
						System.out.println("Numercial string is required");
						count2--;
						input.nextLine();
					}
				}
				System.out.println("How much money do u want to withdraw?");
				double withdrawMoney2 = input.nextDouble();
				acc.withdraw(pay2, withdrawMoney2);
				System.out.println("Balance = " + acc.getBalance());
				break;

			case 3:
				MobileBankingStrategy pay3 = new MobileBankingStrategy("", 0000);
				System.out.println("Phone number:");
				String phoneNumber = input.next();
				pay3.setPhoneNumber(phoneNumber);

				int count3 = 3;
				while (count3 > 0) {
					try {
						System.out.println("PIN:");
						int pin2 = input.nextInt();
						count3--;
						pay3.setSecretPIN(pin2);
						break;
					} catch (InputMismatchException ex) {
						System.out.println("Numercial string is required");
						count3--;
						input.nextLine();
					}
				}
				System.out.println("How much money do u want to withdraw?");
				double withdrawMoney3 = input.nextDouble();
				acc.withdraw(pay3, withdrawMoney3);
				System.out.println("Balance = " + acc.getBalance());
				break;

			case 4:
				check = false;
				System.out.println("Exit program, Thank you");
				break;
			default:
				break;
			}
		}
	}
}

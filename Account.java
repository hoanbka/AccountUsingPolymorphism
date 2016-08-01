package account2;

import java.util.Arrays;
import java.util.List;

public class Account {
	private String name;
	private String userId;
	private String phoneNumber;
	private String cardNumber;
	private double balance;
	private int secretPIN;
	private static final List<String> phonePrefixs = Arrays.asList("091",
			"092", "094", "097", "098", "016");

	public Account() {
	}

	public Account(String name, String userId, int secretPIN) {
		super();
		this.name = name;
		this.userId = userId;
		this.secretPIN = secretPIN;
	}

	public Account(String name, String userId, int secretPIN, double balance) {
		this(name, userId, secretPIN);
		this.secretPIN = secretPIN;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isRightPIN(int PIN) {
		if (PIN == this.secretPIN)
			return true;
		else
			return false;
	}

	public void deposit(double value) {
		balance = balance + value;
	}

	public double withdraw(PaymentStrategy paymentStrategy, double withdrawMoney) {
		if (withdrawMoney <= 0) {
			throw new IllegalArgumentException("Withdraw money should be > 0");
		}
		if (balance < withdrawMoney) {
			throw new RuntimeException("Withdraw Money > balance");

		}
		if (paymentStrategy.isValidInfo(this)) {
			return this.balance -= withdrawMoney;
		}
		return this.balance;

	}

	public boolean isRightNumber(String phoneNumber) {
		String phonePrefix = phoneNumber.substring(0, 3);

		if (!phonePrefixs.contains(phonePrefix) || phoneNumber.length() < 10
				|| phoneNumber.length() > 11) {
			return false;
		}

		for (char c : phoneNumber.toCharArray()) {
			if (!Character.isDigit(c))
				return false;
		}
		return true;
	}

	public String generateRandomCardNumber() {
		CreditCardNumberGenerator cardNumber = new CreditCardNumberGenerator();
		return this.cardNumber = cardNumber.generate("123", 10);
	}
}

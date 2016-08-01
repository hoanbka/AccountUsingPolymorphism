package account;

public class Account {
	private String name;
	private String userId;
	private String phoneNumber;
	private String cardNumber = generateRandomCardNumber();
	private double balance;
	private int secretPIN;

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

	public double withdraw(PaymentStrategy paymentStrategy, double value) {
		if (paymentStrategy.isValidInfo(this)) {
			if (this.balance >= value) {
				return this.balance -= value;
			} else {
				return this.balance;
			}
		} else
			return this.balance;

	}

	public boolean isRightNumber(String phoneNumber) {
		if (((phoneNumber.length() == 10) || (phoneNumber.length() == 11))
				&& (phoneNumber.substring(0, 3).equals("091"))
				|| (phoneNumber.substring(0, 3).equals("090"))
				|| (phoneNumber.substring(0, 3).equals("016"))
				|| (phoneNumber.substring(0, 3).equals("098"))
				|| (phoneNumber.substring(0, 3).equals("094"))) {
			for (char c : phoneNumber.toCharArray()) {
				if (!Character.isDigit(c))
					return false;
			}
			return true;
		} else
			return false;
	}

	public static String generateRandomCardNumber() {
		CreditCardNumberGenerator cardNumber = new CreditCardNumberGenerator();
		return cardNumber.generate("123", 10);
	}
}

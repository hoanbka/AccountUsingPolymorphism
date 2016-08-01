package account;

public class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private String cardNumber;
	private int secretPIN;

	
	public CreditCardStrategy(String name, String cardNumber, int secretPIN) {
		super();
		this.name = name;
		this.cardNumber = cardNumber;
		this.secretPIN = secretPIN;

	}

	@Override
	public boolean isValidInfo(Account acc) {
		if (this.name.equals(acc.getName())
				&& (this.cardNumber.equals(acc.getCardNumber()) && (acc
						.isRightPIN(this.secretPIN)))) {
			return true;
		}
		return false;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public void setSecretPIN(int secretPIN) {
		this.secretPIN = secretPIN;
	}

}
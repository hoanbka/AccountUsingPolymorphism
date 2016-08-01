package account;

public class MobileBankingStrategy implements PaymentStrategy {
	private String phoneNumber;
	private int secretPIN;

	public MobileBankingStrategy(String phoneNumber, int secretPIN) {
		super();
		this.phoneNumber = phoneNumber;
		this.secretPIN = secretPIN;
	}

	@Override
	public boolean isValidInfo(Account acc) {
		if (this.phoneNumber.equals(acc.getPhoneNumber())
				&& (acc.isRightPIN(this.secretPIN))) {
			return true;
		}
		return false;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSecretPIN(int secretPIN) {
		this.secretPIN = secretPIN;
	}

}
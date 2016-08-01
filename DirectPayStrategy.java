package account;

public class DirectPayStrategy implements PaymentStrategy {
	private String userId;
	private int secretPIN;

	public DirectPayStrategy(String userId, int secretPIN) {
		super();
		this.userId = userId;
		this.secretPIN = secretPIN;
	}

	@Override
	public boolean isValidInfo(Account acc) {
		if (this.userId.equals(acc.getUserId())
				&& (acc.isRightPIN(this.secretPIN))) {
			return true;
		}
		return false;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setSecretPIN(int secretPIN) {
		this.secretPIN = secretPIN;
	}

}

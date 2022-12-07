package Payment;

import java.util.Arrays;
import java.util.Objects;

import Payment.Bank.CardBank;

public class Client {	
	private String accountID;	
	private Bank.CardBank[] cardBank;	
	private Provider[] provider;
	
	public Client(String accountID, CardBank[] cardBank) {
		super();
		this.accountID = accountID;
		this.cardBank = cardBank;
	}

	public Client(String accountID, Provider[] provider) {
		super();
		this.accountID = accountID;
		this.provider = provider;
	}

	@Override
	public String toString() {
		if(cardBank!=null) {
			return "Client [accountID=" + accountID + ", cardBank=" + Arrays.toString(cardBank) + "]";
		}
		if(provider!=null) {
			return "Client [accountID=" + accountID + ", provider="	+ Arrays.toString(provider) + "]";
		}
		return"";	
	}

	public String getAccountID() {
		return accountID;
	}

	public Provider[] getProvider() {
		return provider;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(accountID, other.accountID);
	}	
}

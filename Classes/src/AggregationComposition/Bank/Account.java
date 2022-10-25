package Bank;

public class Account implements Comparable<Account>{	
	
	private String account;
	private Double money;
	private boolean block;
	
	public Account(String account, Double money, boolean block) {
		super();
		this.account = account;
		this.money = money;
		this.block = block;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public boolean isBlock() {
		return block;
	}

	public void setBlock(boolean block) {
		this.block = block;
	}

	@Override
	public String toString() {
		return "[account=" + account + ", money=" + money + ", block=" + block + "]";
	}

	@Override
	public int compareTo(Account o) {		
		return this.getAccount().compareTo(o.getAccount());
	}	
}

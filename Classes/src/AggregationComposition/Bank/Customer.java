package Bank;

import java.util.Arrays;
import java.util.stream.Stream;

public class Customer {
	private int id;
	private static int ID=1;	
	
	private String name;	
	private Account[] account;
	
	public Customer(int id, String name, Account[] account) {
		super();
		this.id = ID++;
		this.name = name;
		this.account = account;
	}	

	public Customer() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Account[] getAccount() {
		return account;
	}

	public void setAccount(Account[] account) {
		this.account = account;
	}

	@Override
	public String toString() {		
		return "Customer " + id + " [name=" + name + ", accounts=" + Arrays.toString(account) + "]";
	}			
	
	public void block(String account) {		
		Stream.of(getAccount())
			.filter(t ->t.getAccount().equals(account))
			.forEach(t -> t.setBlock(false));		
	}
	
	public void unblock(String account) {
		Stream.of(getAccount())
			.filter(t ->t.getAccount().equals(account))
			.forEach(t -> t.setBlock(true));
	}
}

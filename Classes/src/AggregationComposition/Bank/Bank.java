package Bank;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bank {	
	Customer[] customers;
	Account [] accounts; //= new Account[100];
	
	public Bank(Customer[] customers) {
		super();
		this.customers = customers;
	}
	
	public Bank() {
		super();
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
	
	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		System.out.println("Bank -> ");
		for (Customer customer : customers) {
			System.out.println(customer);
		}
		return "";
	}
	
	public void init() {
		
		Double[] money = {1_000_000.00, -100.00, 999_999.00, 1_000.00, -999.00, 
				0.0, 55_555.00, -1_000_000.00, 444.00};
		String[] bankAccount = {"BE69 5987 1676 6052", "BE06 8159 1742 2133", "ME36 6723 4210 0408", "BE74 4759 6874 6751", "BE12 4759 5574 4451",
				"MF36 6723 4210 1234", "SE36 6723 4210 0408", "SE36 6723 4210 9999", "BE05 8159 1742 1111"};
		
		accounts = new Account[bankAccount.length];
		
		for (int i = 0; i < accounts.length; i++) {			
			accounts[i]=new Account(bankAccount[i], money[i], true);				
		}	
		
		String[] name = {"Даниил", "Максим", "Владислав", "Никита", "Артем"};				
		
		Customer customer_1 = new Customer(0, name[0], new Account[] {accounts[0], accounts[1]});
		Customer customer_2 = new Customer(0, name[1], new Account[] {accounts[2]});
		Customer customer_3 = new Customer(0, name[2], new Account[] {accounts[3], accounts[4]});
		Customer customer_4 = new Customer(0, name[3], new Account[] {accounts[5], accounts[6], accounts[7]});
		Customer customer_5 = new Customer(0, name[4], new Account[] {accounts[8]});		
		
		setCustomers(new Customer[] {customer_1, customer_2, customer_3, customer_4, customer_5});		
	}
		
	public void block(String account) {
		Stream.of(getCustomers())			
			.forEach(t -> t.block(account));
		System.out.println("Bank account "+account+" is block.");
	}
	
	public void unblock(String account) {
		Stream.of(getCustomers())			
			.forEach(t -> t.unblock(account));
		System.out.println("Bank account "+account+" is unblock.");
	}
	
	public void search(String account) {	
		Stream.of(getAccounts())
			.filter(t -> t.getAccount().equals(account))		
			.forEach(t-> System.out.println("Looking for information on the account "+account+": "+t));
	}
	
	public void sumMoney() {
		Double money = Stream.of(getAccounts())
				.map(t -> t.getMoney())
				.collect(Collectors.summingDouble(Double::doubleValue));		
		System.out.println("Sum of money on all accounts: "+money+"$");	
		
	}
	
	public void sumPositiveMoney() {
		Double money = Stream.of(getAccounts())
				.filter(t -> t.getMoney()>0)
				.map(t -> t.getMoney())				
				.collect(Collectors.summingDouble(Double::doubleValue));		
		System.out.println("Sum of money on all accounts, having a positive balance: "+money+"$");	
		
	}
	
	public void sumNegativeMoney() {
		Double money = Stream.of(getAccounts())
				.filter(t -> t.getMoney()<0)
				.map(t -> t.getMoney())				
				.collect(Collectors.summingDouble(Double::doubleValue));		
		System.out.println("Sum of money on all accounts, having a negative balance: "+money+"$");		
	}
	
	public void sortOfMoney() {
		Comparator<Account> comparatorMoney = ((o1, o2) -> o1.getMoney().compareTo(o2.getMoney()));
		Stream.of(getAccounts())
			.sorted(comparatorMoney)
			.forEach(System.out::println);
	}
}

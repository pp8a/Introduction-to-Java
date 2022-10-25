package Bank;

import java.util.Arrays;
import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.init();		
		Stream.of(bank).forEach(System.out::println);
		
		//block and unblock
		bank.block("BE06 8159 1742 2133");
		bank.block("BE74 4759 6874 6751");
		Stream.of(bank).forEach(System.out::println);
	
		bank.unblock("BE06 8159 1742 2133");
		bank.block("BE69 5987 1676 6052");
		Stream.of(bank).forEach(System.out::println);
		
		//search
		bank.search("BE69 5987 1676 6052");
		bank.search("BE05 8159 1742 1111");
		
		//sort
		System.out.println("Sorted by accounts ->");
		Arrays.sort(bank.getAccounts());
		Stream.of(bank.getAccounts()).forEach(System.out::println);
		
		System.out.println("Sorted by money ->");
		bank.sortOfMoney();
		
		//sum of money
		bank.sumMoney();
		bank.sumPositiveMoney();
		bank.sumNegativeMoney();
		
	}

}

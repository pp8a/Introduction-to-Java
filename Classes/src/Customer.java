import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.Predicate;

public class Customer implements Comparable<Customer>{
	private int id;
	private static int ID=1;
	
	private String surname;
	private String name;
	private String patronymic;
	private String address;
	private String creditCard;
	private String bankAccount;
	
	public Customer(int id, String name, String surname, String patronymic, String address, String creditCard,
			String bankAccount) {
		super();
		this.id = ID++;		
		this.name = name;
		this.surname = surname;
		this.patronymic = patronymic;
		this.address = address;		
		this.creditCard = creditCard;
		this.bankAccount = bankAccount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {		
		this.creditCard = creditCard;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public String toString() {
		return "Customer "+id+" [surname=" + surname + ", name=" + name + ", patronymic=" + patronymic
				+ ", address=" + address + ", creditCard=" + creditCard + ", bankAccount=" + bankAccount + "]";
	}

	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub		
		return this.getSurname().compareTo(o.getSurname());//String sort 
	}
		
	public static String input() {		
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		String str = in.nextLine();
		return str;
	}
	
	public static Boolean rangeCard(String rangeFrom, String rangeTo, String creditCard) {
		BigDecimal from = new BigDecimal(rangeFrom);
	    BigDecimal to = new BigDecimal(rangeTo);
	    BigDecimal card = new BigDecimal(creditCard);
	    	    	
	    Predicate<BigDecimal> is = t -> (from.compareTo(t)<0 && to.compareTo(t)>0);	     		
		return is.test(card);
	}
}

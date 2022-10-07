import java.util.Arrays;


public class CustomerData {
	
	static Customer [] customers;

	public CustomerData(Customer[] customers) {
		super();
		CustomerData.customers = customers;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public static void setCustomers(Customer[] customers) {
		CustomerData.customers = customers;
	}
	
	public static Customer[] createCustomer() {
		
		customers = new Customer[5];
		
		String[] name = {"Даниил", "Максим", "Владислав", "Никита", "Артем"};
		String[] surname = {"Иванов", "Смирнов", "Кузнецов", "Попов", "Васильев"};
		String[] patronymic = {"Николаевич", "Владимирович", "Александрович", "Иванович", "Васильевич"};
		String[] address = {"StreetB 100", "StreetC 25a", "12 StreetD", "13 StreetE WE", "StreetF 81A+B"};
		String[] creditCard = {"1234567812345678", "0234567812345678", "2234567812345678", "4234567812345678", "5234567812345678"};
		String[] bankAccount = {"BE69 5987 1676 6052", "BE06 8159 1742 2133", "E36 6723 4210 0408", "BE74 4759 6874 6751", "BE12 4759 5574 4451"};
		
		for (int i = 0; i < customers.length; i++) {		
			
			Customer customer = new Customer(i, name[i], surname[i], patronymic[i], address[i], creditCard[i], bankAccount[i]);			
			customers[i]=customer;			
		}
		
		setCustomers(customers);
		
		return customers;
	}

	@Override
	public String toString() {
		return "CustomerData [customers=" + Arrays.toString(customers) + "]";
	}
	
}

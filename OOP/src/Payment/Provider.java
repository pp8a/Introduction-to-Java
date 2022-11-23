package Payment;

import java.util.Scanner;
import java.util.stream.Stream;

public class Provider {	

	private String numberPhone;
	private ProviderEnum providerEnum;
	private Double balance;
	
	public Provider(String numberPhone, ProviderEnum providerEnum, Double balance) {
		super();
		this.numberPhone = numberPhone;
		this.providerEnum = providerEnum;
		this.balance = balance;
	}	
	
	public Provider() {
	super();
	}

	public class Payment {
		/**
		 * clients of provider
		 */
		private Client[] clients;
		private Provider[] providers;
		
		public Payment() {
			super();			
		}

		public void initClientProvider() {			
			Provider provider_8753300 = new Provider("+375 29 8753300", ProviderEnum.MTS, 10.0);
			Provider provider_7518131 = new Provider("+375 25 7518131", ProviderEnum.LIFE, 10.0);
			Provider provider_6423333 = new Provider("+375 44 6423333", ProviderEnum.VELCOM, 10.0);
			Provider provider_5236191 = new Provider("+375 29 5236191", ProviderEnum.MTS, 10.0);
			Provider provider_6335858 = new Provider("+375 44 6335858", ProviderEnum.VELCOM, 5.0);
			Provider provider_2223365 = new Provider("+375 29 2223365", ProviderEnum.MTS, 5.0);
			Provider provider_6589635 = new Provider("+375 29 6589635", ProviderEnum.VELCOM, 5.0);
			Provider provider_5123478 = new Provider("+375 25 5123478", ProviderEnum.LIFE, 20.0);
			Provider provider_4421519 = new Provider("+375 44 4421519", ProviderEnum.VELCOM, 20.0);
			Provider provider_5158899 = new Provider("+375 29 5158899", ProviderEnum.MTS, 20.0);
			Provider provider_2563512 = new Provider("+375 17 2563512", ProviderEnum.BEL_TELE_COM, 15.0);
			Provider provider_2123212 = new Provider("+375 17 2123212", ProviderEnum.BEL_TELE_COM, 15.0);
			Provider provider_2545411 = new Provider("+375 17 2545411", ProviderEnum.BEL_TELE_COM, 15.0);
			
			
			Client client_3603936 = new Client("MP3603936", new Provider[] {provider_8753300, provider_7518131});		
			Client client_4721563 = new Client("MP4721563", new Provider[] {provider_6423333, provider_2123212});
			Client client_4521789 = new Client("MP4521789", new Provider[] {provider_5236191, provider_6335858});
			Client client_3681256 = new Client("MP3681256", new Provider[] {provider_2223365});
			Client client_5789124 = new Client("MP5789124", new Provider[] {provider_6589635, provider_2563512});
			Client client_3453636 = new Client("MP3453636", new Provider[] {provider_5123478});
			Client client_9888789 = new Client("MP9888789", new Provider[] {provider_4421519, provider_5158899, provider_2545411});
			
			providers = new Provider[] {provider_2223365, provider_4421519, provider_5123478, provider_5158899, provider_5236191, provider_6335858, 
					provider_6423333, provider_6589635, provider_7518131, provider_8753300, provider_2123212, provider_2563512, provider_2545411};
			
			clients = new Client[] {client_3453636, client_3603936, client_3681256, client_4521789, client_4721563, client_5789124, client_9888789};					
		}		

		public Client[] getClients() {
			return clients;
		}	
		
		public Provider[] getProviders() {
			return providers;
		}		

		@Override
		public String toString() {
			for (Client client : clients) {
				System.out.println(client);			
			}			
			return "";
		}
		
		public void replenishmentBalance(String myPhone, double amount) {
			Stream.of(getProviders())
				.filter(t -> t.getNumberPhone().equals(myPhone))
				.forEach(t -> {
					t.setBalance(t.getBalance()+amount);
					System.out.println("Receipt of provider"
						+ "\nTransfer funds to your phone "+t.getNumberPhone()
						+"\namount "+amount
						+"\nyour balance "+t.getBalance());
				});	
		}
	}		
		
	public ProviderEnum getProviderEnum() {
		return providerEnum;
	}
	
	public String getNumberPhone() {
		return numberPhone;
	}
		
	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}


	@Override
	public String toString() {
		return "Provider [numberPhone=" + numberPhone + ", providerEnum=" + providerEnum + ", balance=" + balance + "]";
	}

	public void providerPhone(int number, Payment payment) {
		
	 	ProviderEnum[] provider =  ProviderEnum.values();
	 	ProviderEnum pEnum = provider[number-1];
	 	System.out.println("You chose provider: "+pEnum);
	 	
	 	Stream.of(payment.getProviders())
	 		.filter(t -> t.getProviderEnum().equals(pEnum))
	 		.forEach(t -> System.out.println(t.getNumberPhone()));
	}
	
	public String yourPhone(Payment payment) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		boolean checkNumber = false;
		String myPhone = "";
		while(!checkNumber) {
			System.out.println("Input your phone number or copy from list above:");
			myPhone = in.nextLine();
			String inNumber = myPhone;
			checkNumber = 
					Stream.of(payment.getProviders())
						.anyMatch(t -> t.getNumberPhone().equals(inNumber.strip()));
			
			if(!checkNumber) {
		    	System.err.println("There's no such phone number "+inNumber);
		    }
		};
		
		return myPhone;		
	}
	
	
	

}

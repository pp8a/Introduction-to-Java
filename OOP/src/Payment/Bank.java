package Payment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Payment.Provider.Payment;

public class Bank {	
	private CardBank[] cardsBank;
	private Client[] clientsBank;
	
	private static ServiceBankEnum serviceBankEnum;
	
	private double virtAmount=-1; //для снятия денег с разных счетов
	
	public Bank() {
		super();
	}

	public class CardBank{
		/**
		 * cards of bank
		 */
		private String accountIDBank;
		private String numberCardBank;
		private Double moneyCardBank;
		
		public CardBank(String accountIDBank, String numberCardBank, Double moneyCardBank) {
			super();
			this.accountIDBank = accountIDBank;
			this.numberCardBank = numberCardBank;
			this.moneyCardBank = moneyCardBank;
		}

		public String getAccountIDBank() {
			return accountIDBank;
		}

		public String getNumberCardBank() {
			return numberCardBank;
		}	

		public Double getMoneyCardBank() {
			return moneyCardBank;
		}

		public void setMoneyCardBank(Double moneyCardBank) {
			this.moneyCardBank = moneyCardBank;
		}

		@Override
		public String toString() {
			return "CardBank [accountIDBank=" + accountIDBank + ", numberCardBank=" + numberCardBank
					+ ", moneyCardBank=" + moneyCardBank + "]";
		}		
	}	

	public void initClientBank() {
		CardBank cardBank_3603936 = new CardBank("MP3603936", "1234 5213 9512 6452", 200.00);
		CardBank cardBank_4721563 = new CardBank("MP4721563", "2234 5213 9512 6512", 100.00);		
		CardBank cardBank_4521789 = new CardBank("MP4521789", "6334 5213 9512 7852", -20.89);
		CardBank cardBank_3681256 = new CardBank("MP3681256", "7234 5213 9512 3492", 200_000.00);
		CardBank cardBank_4721563_2 = new CardBank(cardBank_4721563.getAccountIDBank(), "5412 5213 9512 6662", 500.00);
		CardBank cardBank_5789124 = new CardBank("MP5789124", "2354 5213 9512 3262", -1.32);
		CardBank cardBank_3453636 = new CardBank("MP3453636", "1234 5213 9512 6452", 1_000_000.00);
		CardBank cardBank_3603936_2 = new CardBank(cardBank_3603936.getAccountIDBank(), "5412 5213 9512 6662", 520.00);
		CardBank cardBank_9888789 = new CardBank("MP9888789", "6334 5213 9512 7852", -100.00);
		CardBank cardBank_4521789_2 = new CardBank(cardBank_4521789.getAccountIDBank(), "7234 5213 9512 3492", 56_000.00);		
		
		Client client_3603936 = new Client(cardBank_3603936.getAccountIDBank(), new CardBank[] {cardBank_3603936, cardBank_3603936_2});
		Client client_4721563 = new Client(cardBank_4721563.getAccountIDBank(), new CardBank[] {cardBank_4721563, cardBank_4721563_2});
		Client client_4521789 = new Client(cardBank_4521789.getAccountIDBank(), new CardBank[] {cardBank_4521789, cardBank_4521789_2});
		Client client_3681256 = new Client(cardBank_3681256.getAccountIDBank(), new CardBank[] {cardBank_3681256});
		Client client_5789124 = new Client(cardBank_5789124.getAccountIDBank(), new CardBank[] {cardBank_5789124});
		Client client_3453636 = new Client(cardBank_3453636.getAccountIDBank(), new CardBank[] {cardBank_3453636});
		Client client_9888789 = new Client(cardBank_9888789.getAccountIDBank(), new CardBank[] {cardBank_9888789});
		
		clientsBank = new Client [] {client_3603936, client_4721563, client_4521789, client_3681256, client_5789124, client_3453636, client_9888789};
		cardsBank = new CardBank [] {cardBank_3603936, cardBank_4721563, cardBank_4521789, cardBank_3681256, cardBank_4721563_2, cardBank_5789124,
				cardBank_3453636, cardBank_3603936_2, cardBank_9888789, cardBank_4521789_2};			
	}

	
	public Client[] getClientsBank() {
		return clientsBank;
	}

	public void setClientsBank(Client[] clientsBank) {
		this.clientsBank = clientsBank;
	}
	
	public static ServiceBankEnum getServiceBankEnum() {
		return serviceBankEnum;
	}
	
	public static void setServiceBankEnum(ServiceBankEnum serviceBankEnum) {
		Bank.serviceBankEnum = serviceBankEnum;
	}
	
	public CardBank[] getCardsBank() {
		return cardsBank;
	}
	
	

	public double getN() {
		return virtAmount;
	}


	public void setN(double n) {
		this.virtAmount = n;
	}


	@Override
	public String toString() {		
		for (CardBank cardBank : cardsBank) {
			System.out.println(cardBank);			
		}
		for (Client client : clientsBank) {
			System.out.println(client);			
		}
		return "";
	}
	
	public boolean checkId(String id) {		
		boolean checkId = Stream.of(getClientsBank())			
			.anyMatch(t -> t.getAccountID().equals(id));
		
		return checkId;
	}
	
	public void listServiceBank() {	
		System.out.println("List of services provided by the bank:");
		Arrays.stream(ServiceBankEnum.values()).forEach(t->{			
			System.out.println((t.ordinal()+1)+" "+t.toString());			
		});
	}
	
	public int numberServiceBank() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int countService = ServiceBankEnum.values().length;
		int number;
		
		do {
			System.out.print("Select the service number from 1 to "+countService+": ");
			number = in.nextInt();	
			if(number<=0||number>countService) {
		    	System.err.println("There's no such service");
		    }
		}while(number<=0||number>countService);
		return number;
	}
	
	public String checkServiceBankProvider(int numberService) {
		
		String service = 
				Stream.of(ServiceBankEnum.getList())
					.filter(t -> t.ordinal()==numberService-1)
					.map(String::valueOf)
					.collect(Collectors.joining()).toString();		
		
		System.out.println("You have chosen a payment service: " + service);
		return service;		
	}
	
	public ProviderEnum[] provider(String service) {		
		
		System.out.println("This service is provided by the following companies:");
				
		ProviderEnum[] providerEnums = 
				Arrays.stream(ProviderEnum.values())			
				.filter(t -> 					
						t.getService_1().toString().equals(service)||
						t.getService_2().toString().equals(service)||
						t.getService_3().toString().equals(service))
				.toArray(ProviderEnum[]::new);	
	
		Stream.of(providerEnums).forEach(t -> System.out.println((t.ordinal()+1)+" "+t.toString()));
		
		return providerEnums;
	}
	
	public int numberServiceProvider(ProviderEnum[] providerEnums) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);		
		int number = 0;
		boolean checkId = false;
		while(!checkId) {
			System.out.print("Select number of transaction: ");			
			number = in.nextInt();	
			int check = number;
			checkId = Stream.of(providerEnums)					
					.anyMatch(t -> (t.ordinal()+1)==check);
			if(!checkId) {
		    	System.err.println("There's no such transaction "+number);
		    }
		};
		return number;
	}

	public void inCheckMoney(String id, Payment providerClient, String myPhone) {		
		
		boolean checkId = Stream.of(getCardsBank())	
				.filter(t -> t.getAccountIDBank().equals(id))
				.anyMatch(t -> t.getMoneyCardBank()>0);
		
		
		if(!checkId) {
			System.err.println("Insufficient funds");//Недостаточно средств на счете
		}else {
			Stream.of(getCardsBank())
				.filter(t -> t.getAccountIDBank().equals(id))
				.filter(t -> t.getMoneyCardBank()>0)
				.forEach(t->System.out.println("Checking account: "+t.getNumberCardBank()+" money="+t.getMoneyCardBank()));
			
			Double moneyCards = Stream.of(getCardsBank())
				.filter(t -> t.getAccountIDBank().equals(id))
				.filter(t -> t.getMoneyCardBank()>0)
				.map(t -> t.getMoneyCardBank())
				.collect(Collectors.summingDouble(Double::doubleValue));			
					
			System.out.println("Enter amount and press OK: ");
			
			@SuppressWarnings("resource")
			Scanner in = new Scanner(System.in);
			
			double amount = 0;
			do {
				amount = in.nextDouble();
				if(amount>moneyCards) {
			    	System.err.println("Insufficient funds. Current balance: "+moneyCards);
			    }
			}while(amount>moneyCards);
			System.out.println("-------------------");
			providerClient.replenishmentBalance(myPhone, amount);
			System.out.println("-------------------");
			receipt(id, amount);
			
		}
	}
	
	public void receipt (String id, double amount) {
		double sAmount = amount;
		Stream.of(getCardsBank())
			.filter(t -> t.getAccountIDBank().equals(id))
			.forEach(t -> {
				
				if(t.getMoneyCardBank()-sAmount<=0) {
					setN(sAmount-t.getMoneyCardBank());	
					System.out.println("Receipt of bank"
							+ "\nTransfer of funds from your account "+t.getNumberCardBank()
							+"\namount -"+t.getMoneyCardBank());
					t.setMoneyCardBank(0.0);						
					System.out.println("your balance "+t.getMoneyCardBank());						
				}else {
					if(getN()==-1) {
						t.setMoneyCardBank(t.getMoneyCardBank()-sAmount);
						System.out.println("-------------------");
						System.out.println("Receipt of bank"
								+ "\nTransfer of funds from your account "+t.getNumberCardBank()
								+"\namount -"+sAmount
								+"\nyour balance "+t.getMoneyCardBank());
						setN(0.0);
					}else {
						t.setMoneyCardBank(t.getMoneyCardBank()-getN());
						System.out.println("-------------------");
						System.out.println("Receipt of bank"
								+ "\nTransfer of funds from your account "+t.getNumberCardBank()
								+"\namount -"+getN()
								+"\nyour balance "+t.getMoneyCardBank());
					}
						
					
					
				}
			});		
	}
}

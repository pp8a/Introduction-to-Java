package Payment;

import Payment.Provider.Payment;

public class main {

	public static void main(String[] args) {
		Bank bank = new Bank();//for initialization
		bank.initClientBank();
	
		Provider provider = new Provider();
		Provider.Payment payment = new Provider().new Payment();
		payment.initClientProvider();	

//		Stream.of(bank.getCardsBank()).forEach(t -> System.out.print(t.getAccountIDBank()+" "));
//for demonstration choose ID -> MP3603936 MP4721563 MP4521789 MP3681256 MP4721563 MP5789124 MP3453636 MP3603936 MP9888789 MP4521789 
		
		String accountID = "MP3603936"; // inserted a card into the ATM
		processing(bank, provider, payment, accountID);		
		
		processing(bank, provider, payment, accountID);//for demonstration
	}
	
	public static void processing(Bank bank, Provider provider, Payment payment, String accountID) {
		if(bank.checkId(accountID)) {
			bank.listServiceBank();
			
			int numberServiceBank = bank.numberServiceBank();
			String service = bank.checkServiceBankProvider(numberServiceBank);
			
			ProviderEnum[] providerEnums = bank.provider(service);
			int numberServiceProvider = bank.numberServiceProvider(providerEnums);
			
			provider.providerPhone(numberServiceProvider, payment);
			String myPhone = provider.yourPhone(payment);
			
			bank.inCheckMoney(accountID, payment, myPhone);
		};
	}

}

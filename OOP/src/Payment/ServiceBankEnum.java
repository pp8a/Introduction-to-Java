package Payment;

public enum ServiceBankEnum {
	PHONE, INTERNET, SHOP, TV;
	
	private static ServiceBankEnum[] list = ServiceBankEnum.values();

	public static ServiceBankEnum[] getList() {
		return list;
	}	
}

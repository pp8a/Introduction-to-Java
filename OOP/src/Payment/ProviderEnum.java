package Payment;

public enum ProviderEnum {
	MTS(ServiceProviderEnum.PHONE, ServiceProviderEnum.INTERNET, ServiceProviderEnum.RESERVE), 
	VELCOM(ServiceProviderEnum.PHONE, ServiceProviderEnum.INTERNET, ServiceProviderEnum.RESERVE), 
	LIFE(ServiceProviderEnum.PHONE, ServiceProviderEnum.RESERVE, ServiceProviderEnum.RESERVE), 
	BEL_TELE_COM(ServiceProviderEnum.SHOP, ServiceProviderEnum.TV, ServiceProviderEnum.INTERNET);

	private ServiceProviderEnum service_1;
	private ServiceProviderEnum service_2;
	private ServiceProviderEnum service_3;	

	private ProviderEnum(ServiceProviderEnum service_1, ServiceProviderEnum service_2, ServiceProviderEnum service_3) {
		this.service_1 = service_1;
		this.service_2 = service_2;
		this.service_3 = service_3;
	}

	public ServiceProviderEnum getService_1() {
		return service_1;
	}

	public ServiceProviderEnum getService_2() {
		return service_2;
	}

	public ServiceProviderEnum getService_3() {
		return service_3;
	}
}

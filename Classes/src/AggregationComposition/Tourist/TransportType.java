package Tourist;

public enum TransportType {
	AVIATION("Plane"), BUS("Bus"), RAILWAY("Train"), MOTOR_SHIP("Ship"), COMBINED("Ñombo");	
	
	String type;

	private TransportType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}

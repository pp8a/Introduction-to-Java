package State;

public enum RegionEnum {
	BREST_REGION("Brest", 32_790.68), VITEBSK_REGION("Vitebsk", 40_400.99), GOMEL_REGION("Gomel", 40_361.66), 
	GRODNO_REGION("Grodno", 25_118.07), MINSK_REGION("Minsk", 39_912.35), MOGILEV_REGION("Mogilev", 29_079.01);
	
	String center;
	double square;//km^2
	
	private RegionEnum(String center, double square) {
		this.center = center;
		this.square = square;
	}

	public String getCenter() {
		return center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public double getSquare() {
		return square;
	}

	public void setSquare(double square) {
		this.square = square;
	}	
}

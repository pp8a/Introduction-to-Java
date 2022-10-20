package State;

import java.util.Arrays;

public class City {
	
	CityEnum[]  cityEnum;

	public City(CityEnum[] cityEnum) {
		super();
		this.cityEnum = cityEnum;
	}

	public CityEnum[] getCityEnum() {
		return cityEnum;
	}

	public void setCityEnum(CityEnum[] cityEnum) {
		this.cityEnum = cityEnum;
	}

	@Override
	public String toString() {
		return "City " + Arrays.toString(cityEnum);
	}	
}

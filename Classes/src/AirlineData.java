import java.time.DayOfWeek;
import java.time.LocalTime;

public class AirlineData {
	
	private Airline[] airlines;
	
	public AirlineData() {
		super();
	}

	public AirlineData(Airline[] airlines) {
		super();
		this.airlines = airlines;
	}

	public Airline[] getAirlines() {
		return airlines;
	}

	public void setAirlines(Airline[] airlines) {
		this.airlines = airlines;
	}
	
	public void initData() {		
		
		LocalTime localTime = LocalTime.of(9, 15);		
		Airline airline_1 = new Airline("Aberdeen", "BD674", AircraftType.LIGHT_JETS, localTime, DayOfWeek.MONDAY);		
		
		localTime = localTime.withMinute(30);				
		Airline airline_2 = new Airline("Newcastle", "BA1326", AircraftType.HEAVY_JETS, localTime, DayOfWeek.MONDAY);		
		Airline airline_9 = new Airline("Newcastle", "BA1326", AircraftType.HEAVY_JETS, localTime, DayOfWeek.TUESDAY);
		
		localTime = localTime.withMinute(45);		
		Airline airline_3 = new Airline("Glasgow", "BA1476", AircraftType.HEAVY_JETS, localTime, DayOfWeek.MONDAY);		
		Airline airline_10 = new Airline("Glasgow", "BA1476", AircraftType.HEAVY_JETS, localTime, DayOfWeek.TUESDAY);
		
		localTime = localTime.withMinute(55);
		Airline airline_4 = new Airline("Durham Tees", "GF5232", AircraftType.HEAVY_JETS, localTime, DayOfWeek.MONDAY);		
		Airline airline_5 = new Airline("Cork", "AA8025", AircraftType.LIGHT_JETS, localTime, DayOfWeek.MONDAY);		
		
		localTime = localTime.withHour(10).withMinute(5);
		Airline airline_6 = new Airline("Dublin", "AA8025", AircraftType.LIGHT_JETS, localTime, DayOfWeek.TUESDAY);
		
		localTime = localTime.withMinute(10);
		Airline airline_7 = new Airline("Shannon", "AA8017", AircraftType.LIGHT_JETS, localTime, DayOfWeek.WEDNESDAY);
		Airline airline_8 = new Airline("Newcastle", "BA1327", AircraftType.LIGHT_JETS, localTime, DayOfWeek.WEDNESDAY);
		
		
		
		airlines = new Airline[] {airline_1, airline_2, airline_3, airline_4, airline_5, airline_6, airline_7, airline_8, airline_9, airline_10};
		setAirlines(airlines);
	}

}

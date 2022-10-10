import java.time.DayOfWeek;
import java.time.LocalTime;

public class Airline {
	
	String destination;
	String flightNumber;
	AircraftType typeOfAircraft;
	LocalTime localTime;
	DayOfWeek dayOfWeek;
	
	public Airline(String destination, String flightNumber, AircraftType typeOfAircraft, LocalTime localTime,
			DayOfWeek dayOfWeek) {
		super();
		this.destination = destination;
		this.flightNumber = flightNumber;
		this.typeOfAircraft = typeOfAircraft;
		this.localTime = localTime;
		this.dayOfWeek = dayOfWeek;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public AircraftType getTypeOfAircraft() {
		return typeOfAircraft;
	}

	public void setTypeOfAircraft(AircraftType typeOfAircraft) {
		this.typeOfAircraft = typeOfAircraft;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	public void setLocalTime(LocalTime localTime) {
		this.localTime = localTime;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public String toString() {
		return "Airline [destination=" + destination + ", flightNumber=" + flightNumber + ", typeOfAircraft="
				+ typeOfAircraft + ", localTime=" + localTime + ", dayOfWeek=" + dayOfWeek + "]";
	}	
}

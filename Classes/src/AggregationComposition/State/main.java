package State;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		
		State state = new State(new Region(RegionEnum.values()), new District(DistrictEnum.values()), new City(CityEnum.values()));
		System.out.println("The State of Belarus:");
		Stream.of(state.getRegion()).forEach(System.out::println);
		Stream.of(state.getDistrict()).forEach(System.out::println);
		Stream.of(state.getCity()).forEach(System.out::println);		
		
		state.capital();
		state.countRegion();
		state.squareState();
		state.centersRegion();	
	}

}

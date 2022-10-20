package State;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class State {
	
	Region region;
	District district;
	City city;
	
	public State(Region region, District district, City city) {
		super();
		this.region = region;
		this.district = district;
		this.city = city;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}	
	
	@Override
	public String toString() {
		return "State [region=" + region + ", district=" + district + ", city=" + city + "]";
	}

	public void capital() {
		Stream.of(getRegion())			
		.map(t -> RegionEnum.MINSK_REGION.getCenter())
		.forEach(t -> System.out.println(t+" is the capital of Belarus."));		
	}
	
	public void countRegion() {
		Stream.of(getRegion())
			.map(t -> RegionEnum.values().length)
			.forEach(t -> System.out.println("The count of regions: "+t+"."));	
	}
	
	public void squareState() {
		Double square = Stream.of(getRegion().getRegionEnum())
				.map(t -> t.getSquare())
				.collect(Collectors.summingDouble(Double::doubleValue));		
		System.out.println("The square of Belarus: "+square+" km2");	
	}
	
	public void centersRegion() {
		System.out.print("Regionals centers: ");
		Stream.of(getRegion().getRegionEnum())
			.forEach(t -> System.out.print(t.getCenter()+" "));	
	}
}

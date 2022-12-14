package Tourist;

import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		Tourist tourist = new Tourist();
		tourist.initData();
		Stream.of(tourist).forEach(System.out::println);		
		
		//country
		tourist.selectionCountry("Canada");		
		tourist.selectionCountry("Ukraine");
		
		//transport
		tourist.selectionTransport("Plane");
		tourist.selectionTransport("Train");		
		
		//food
		tourist.selectionFood(FoodType.AL);
		tourist.selectionFood(FoodType.FB_PLUS);
		
		//days
		tourist.selectDays(10, 20);
		
		//voucher
		tourist.sortVaucher();
		
		//city
		tourist.sortCity();
	}

}

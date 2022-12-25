package composition.buyer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Treasures.Treasures;
import composition.Composition;

public class Buyer {
	private static Buyer buyer;
	private static List<Composition> buyerList = new ArrayList<>();
	
	public static synchronized Buyer getBuyers() {
		if(buyer == null) {
			buyer = new Buyer();
		}
		
		return buyer;		
	}
	
	private Buyer() {
		
	}
	
	public void addBuyer(Composition composition) {
		buyerList.add(composition);		
	}
	
	public void showBuyer() {
		Optional<List<Composition>> optionals = Optional.of(buyerList.stream().toList());
		Optional<List<Composition>> optional = optionals.map(Optional::of).orElseGet(Optional::empty);
		
		if(optional.get().isEmpty()) {
			System.out.println("You didn't choose flower compositions.");
		}else {
			System.out.println("You've chosen: "+optional.get());				
		}
	}	
}

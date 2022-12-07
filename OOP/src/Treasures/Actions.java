package Treasures;

import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

public enum Actions {
	VIEWING("Treasure viewing (in order of numbers)") {
		@Override
		public void start() {
			Stream.of(cave).forEach(System.out::println);			
		}
	}, VIEWING_SORT("Treasure viewing (sorted by name, cost)") {
		@Override
		public void start() {
			Comparator<Treasures> comparator = cave.sortTreasures();
			Collections.sort(cave.getTreasures(), comparator);	
			Stream.of(cave).forEach(System.out::println);
		}
	}, VIEWING_SORT_COST("Treasure viewing (sorted by cost)") {
		@Override
		public void start() {
			Collections.sort(cave.getTreasures());	
			Stream.of(cave).forEach(System.out::println);
		}
	}, EXPENSIVE("The most expensive treasure") {
		@Override
		public void start() {
			cave.expensiveTreasures();			
		}
	}, CHOOSE("Take the treasure"){
		@Override
		public void start() {
			cave.numberTreasures(bogatyr);				
		}
	}, EXIT("Run away with the treasures") {
		@Override
		public void start() {
			isExit=true;		
			System.out.println("You ran away with the treasures!");
		}
	};
	
	public abstract void start(); 	
	private String title;
	static boolean isExit = false;
	
	private static Cave cave;
	private static Bogatyr bogatyr;
	
	private Actions(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public static Cave getCave() {
		return cave;
	}

	public static void setCave(Cave cave) {
		Actions.cave = cave;
	}

	public static Bogatyr getBogatyr() {
		return bogatyr;
	}

	public static void setBogatyr(Bogatyr bogatyr) {
		Actions.bogatyr = bogatyr;
	}
	
}

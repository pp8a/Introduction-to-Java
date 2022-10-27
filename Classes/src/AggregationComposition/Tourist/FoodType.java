package Tourist;

public enum FoodType {
	RO("Room only"), BB("Bed & breakfast"), HB("Half board"), FB("Full board"), 
	HB_PLUS("Extended half board"), FB_PLUS("Extended full board"), AL("All inclusive"), UAI("Ultra All inclusive");
	
	String type;

	private FoodType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}		
}

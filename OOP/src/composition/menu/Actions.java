package composition.menu;

import composition.buyer.Buyer;

public enum Actions {
	SELECTION("Composition selection") {
		@Override
		public void start() {
			Menu.selectionComposition();			
		}
	}, VIEWING("Viewing a composition") {
		@Override
		public void start() {
			Buyer.getBuyers().showBuyer();			
		}
	}, EXIT("Exit") {
		@Override
		public void start() {
			isExit=true;		
			System.out.println("You go away with the flower composition!");
			
		}
	};
	
	public abstract void start(); 	
	private String title;
	public static boolean isExit = false;
	
	private Actions(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
	
	
}

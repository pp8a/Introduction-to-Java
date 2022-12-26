package composition;

import composition.menu.Actions;
import composition.menu.Menu;


public class CompositionRunner {

	public static void main(String[] args) {	
		
		while (!Actions.isExit) {
			Menu.menu();			
		}
	}

}

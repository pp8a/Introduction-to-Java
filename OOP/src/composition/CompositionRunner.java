package composition;


import composition.buyer.Buyer;
import composition.flower.DirectorFlowers;
import composition.flower.Flower;
import composition.flower.FlowerColor;
import composition.flower.FlowerName;
import composition.flower.SetFlowers;
import composition.menu.Actions;
import composition.menu.Menu;
import composition.packaging.DirectorPacks;
import composition.packaging.Pack;
import composition.packaging.PackColor;
import composition.packaging.PackType;
import composition.packaging.SetPacks;

public class CompositionRunner {

	public static void main(String[] args) {	
		
		while (!Actions.isExit) {
			Menu.menu();			
		}
	}

}

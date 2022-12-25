package composition;
import composition.flower.*;
import composition.packaging.*;

public class Composition {
	Flower flower;
	Pack pack;
	
	public void setFlower(Flower flower) {
		this.flower = flower;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	
	@Override
	public String toString() {
		return "Composition [" + flower + ", " + pack + "]";
	}
}

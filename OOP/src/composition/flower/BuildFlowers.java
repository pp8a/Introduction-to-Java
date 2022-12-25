package composition.flower;

public abstract class BuildFlowers {
	Flower flower;
	
	public void cresteFlower() {
		flower = new Flower();
	}
	
	public abstract void buildFlowerCount(int count);
	public abstract void buildFlowerColor(FlowerColor color);
	public abstract void buildFlowerName(FlowerName name);	
	
	public Flower getFlower() {
		return flower;
	}
}

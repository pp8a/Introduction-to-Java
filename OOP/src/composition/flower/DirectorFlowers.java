package composition.flower;

public class DirectorFlowers {
	BuildFlowers buildFlowers;

	public void setBuildFlowers(BuildFlowers buildFlowers) {
		this.buildFlowers = buildFlowers;
	}
	
	public Flower buildFlowers(int count, FlowerColor color, FlowerName name) {
		buildFlowers.cresteFlower();
		buildFlowers.buildFlowerCount(count);
		buildFlowers.buildFlowerColor(color);
		buildFlowers.buildFlowerName(name);
		
		Flower flower = buildFlowers.getFlower();
		return flower;
	}
}

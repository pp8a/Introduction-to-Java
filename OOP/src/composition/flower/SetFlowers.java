package composition.flower;

public class SetFlowers extends BuildFlowers{

	@Override
	public void buildFlowerCount(int count) {
		flower.setCount(count);
		
	}

	@Override
	public void buildFlowerColor(FlowerColor color) {
		flower.setColor(color);
		
	}

	@Override
	public void buildFlowerName(FlowerName name) {
		flower.setName(name);
		
	}

}

package composition;

import composition.flower.Flower;
import composition.packaging.Pack;

public class SetCompositions extends BuildCompositions{

	@Override
	public SetCompositions buildFlower(Flower flower) {
		composition.setFlower(flower);
		return this;
	}

	@Override
	public SetCompositions buildPack(Pack pack) {
		composition.setPack(pack);
		return this;
	}

}

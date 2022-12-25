package composition;

import composition.flower.Flower;
import composition.packaging.Pack;

public abstract class BuildCompositions {
	Composition composition;
	
	public BuildCompositions createComposition() {
		composition = new Composition();
		
		return this;
	}
	
	public abstract BuildCompositions buildFlower(Flower flower);
	public abstract BuildCompositions buildPack(Pack pack);

	public Composition getComposition() {
		return composition;
	}
}

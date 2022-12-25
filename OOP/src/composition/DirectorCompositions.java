package composition;

import composition.flower.Flower;
import composition.packaging.Pack;

public class DirectorCompositions {
	BuildCompositions buildCompositions;

	public DirectorCompositions setBuildCompositions(BuildCompositions buildCompositions) {
		this.buildCompositions = buildCompositions;
		
		return this;
	}
	
	public Composition buildCompositions(Flower flower, Pack pack) {
		buildCompositions.createComposition().buildFlower(flower).buildPack(pack);
		
		return buildCompositions.getComposition();
	}
}

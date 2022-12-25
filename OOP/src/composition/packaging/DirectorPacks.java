package composition.packaging;

public class DirectorPacks {
	BuildPacks buildPacks;

	public DirectorPacks setBuildPacks(BuildPacks buildPacks) {
		this.buildPacks = buildPacks;
		
		return this;
	}
	
	public Pack buildPacks(PackColor color, PackType type) {
		buildPacks.createPack();
		buildPacks.buildPackColor(color);
		buildPacks.buildPackType(type);
		
		Pack pack = buildPacks.getPack();		
		
		return pack;
	}
	
	
	
}

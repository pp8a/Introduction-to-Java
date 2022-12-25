package composition.packaging;

public abstract class BuildPacks {
	Pack pack;
	
	public void createPack() {
		pack = new Pack();
	}
	
	public abstract void buildPackColor(PackColor color);
	public abstract void buildPackType(PackType type);

	public Pack getPack() {
		return pack;
	}
}

package composition.packaging;

public class SetPacks extends BuildPacks{

	@Override
	public void buildPackColor(PackColor color) {
		pack.setColor(color);		
	}

	@Override
	public void buildPackType(PackType type) {
		pack.setType(type);
		
	}

	

}

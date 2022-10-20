package State;

import java.util.Arrays;

public class Region {
	
	RegionEnum[] regionEnum;

	public Region(RegionEnum[] regionEnum) {
		super();
		this.regionEnum = regionEnum;
	}

	public RegionEnum[] getRegionEnum() {
		return regionEnum;
	}

	public void setRegionEnum(RegionEnum[] regionEnum) {
		this.regionEnum = regionEnum;
	}

	@Override
	public String toString() {
		return "Region " + Arrays.toString(regionEnum);
	}

	
		
}

package State;

import java.util.Arrays;

public class District {
	
	DistrictEnum[] districtEnum;

	public District(DistrictEnum[] districtEnum) {
		super();
		this.districtEnum = districtEnum;
	}

	public DistrictEnum[] getDistrictEnum() {
		return districtEnum;
	}

	public void setDistrictEnum(DistrictEnum[] districtEnum) {
		this.districtEnum = districtEnum;
	}

	@Override
	public String toString() {
		return "District " + Arrays.toString(districtEnum);
	}		
}

package composition.flower;

import java.util.Objects;

public class Flower {
	private int count;
	private FlowerColor color;
	private FlowerName name;
	
	public void setCount(int count) {
		this.count = count;
	}
	public void setColor(FlowerColor color) {
		this.color = color;
	}
	public void setName(FlowerName name) {
		this.name = name;
	}
	
	@Override
	public String toString() {		
		return "Flowers: "+color+" "+name+" "+count+" pcs.";
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, count, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flower other = (Flower) obj;
		return color == other.color && count == other.count && name == other.name;
	}	
}

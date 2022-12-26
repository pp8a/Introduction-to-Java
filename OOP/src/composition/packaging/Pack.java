package composition.packaging;

import java.util.Objects;

public class Pack {
	private PackColor color;
	private PackType type;
	
	public void setColor(PackColor color) {
		this.color = color;
	}
	public void setType(PackType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Packaging: " + type + ", " + color;
	}
	@Override
	public int hashCode() {
		return Objects.hash(color, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack other = (Pack) obj;
		if(!(color == other.color || other.color!=null && this.color.equals(other.color))) return false;			
		return type == other.type || other.type!=null && this.type.equals(other.type);
	}
}

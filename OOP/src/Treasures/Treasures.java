package Treasures;

import java.util.Objects;

public class Treasures implements Comparable<Treasures>{
	private int id;
	private static int ID=1;
	
	private String name;
	private Double cost;
	
	public Treasures(int id, String name, Double cost) {
		super();
		this.id = ID++;
		this.name = name;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public Double getCost() {
		return cost;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "[#" + id + ", name=" + name + ", cost=" + cost + "$]";
	}

	@Override
	public int compareTo(Treasures o) {		
		return o.getCost().compareTo(this.getCost());
	}

	@Override
	public int hashCode() {
		return Objects.hash(cost, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasures other = (Treasures) obj;
		return Objects.equals(cost, other.cost) && id == other.id && Objects.equals(name, other.name);
	}	
}

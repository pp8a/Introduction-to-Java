package Treasures;

import java.util.ArrayList;
import java.util.List;

public class Bogatyr {
	private String name;
	private Double money;
	private List<Treasures> treasures = new ArrayList<>();
	
	public Bogatyr(String name, Double money) {
		super();
		this.name = name;
		this.money = money;
	}

		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	public List<Treasures> getTreasures() {
		return treasures;
	}

	public void setTreasures(List<Treasures> treasures) {
		this.treasures = treasures;
	}

	@Override
	public String toString() {
		return "Bogatyr [name=" + name + ", money=" + money + "]";
	}	
}

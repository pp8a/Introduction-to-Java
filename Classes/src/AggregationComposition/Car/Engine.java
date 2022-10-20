package Car;

public class Engine {
	private double volume;
	private EngineType engineType;
	
	public Engine(double volume, EngineType engineType) {
		super();
		this.volume = volume;
		this.engineType = engineType;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	public EngineType getEngineType() {
		return engineType;
	}

	public void setEngineType(EngineType engineType) {
		this.engineType = engineType;
	}

	@Override
	public String toString() {
		return "Engine [volume=" + volume + ", engineType=" + engineType + "]";
	}
	
}

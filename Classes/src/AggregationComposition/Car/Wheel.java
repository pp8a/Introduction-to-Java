package Car;

public class Wheel {
	WheelDisk wheelDisk;
	WheelTire wheelTire;
	
	public Wheel(WheelDisk wheelDisk, WheelTire wheelTire) {
		super();
		this.wheelDisk = wheelDisk;
		this.wheelTire = wheelTire;
	}

	public WheelDisk getWheelDisk() {
		return wheelDisk;
	}

	public void setWheelDisk(WheelDisk wheelDisk) {
		this.wheelDisk = wheelDisk;
	}

	public WheelTire getWheelTire() {
		return wheelTire;
	}

	public void setWheelTire(WheelTire wheelTire) {
		this.wheelTire = wheelTire;
	}

	@Override
	public String toString() {
		return "Wheel [wheelDisk=" + wheelDisk + ", wheelTire=" + wheelTire + "]";
	}
}

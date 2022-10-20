package Car;

import java.util.stream.Stream;

public class main {

	public static void main(String[] args) {
		
		Car car = new Car();
		car.initCar();
		Stream.of(car.getCar()).forEach(System.out::println);
		
		String changeWheels = "AUDI A8";
		System.out.println("Change wheels: "+changeWheels);		
		car.changeWheel(new Wheel(WheelDisk.COMBINED, WheelTire.WINTER), changeWheels);		
		
		changeWheels = "AUDI A8S";
		System.out.println("Change wheels: "+changeWheels);		
		car.changeWheel(new Wheel(WheelDisk.COMBINED, WheelTire.WINTER), changeWheels);
		
		Stream.of(car.getCar()).forEach(System.out::println);		
		
		car.refueling("AUDI A6");
		car.refueling("AUDI A4");
		
		System.out.println("Refuel the cars:");
		Stream.of(car.getCar())
			.filter(t -> t.isFuel())
			.forEach(System.out::println);
		
		car.drive();
		car.console();
		
	}
}

package Car;

import java.util.stream.Stream;

public class Car{
	private Engine engine;
	private Wheel wheel;
	private Car[] car;
	private String brand;
	private boolean fuel = false;
	
	public Car(String brand, Engine engine, Wheel wheel, boolean fuel) {
		super();
		this.engine = engine;
		this.wheel = wheel;
		this.brand = brand;
		this.fuel = fuel;
	}
	public Car(Car[] car) {
		super();
		this.car = car;
	}
		
	public Car() {
		super();
	}
	public Car[] getCar() {
		return car;
	}
	public void setCar(Car[] car) {
		this.car = car;
	}
		
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	public Wheel getWheel() {
		return wheel;
	}
	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}
		
	public String getBrand() {
		return brand;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public boolean isFuel() {
		return fuel;
	}
	
	public void setFuel(boolean fuel) {
		this.fuel = fuel;
	}
	@Override
	public String toString() {
		String refuelded = "the car is not refueled";
		if(fuel) {
			refuelded = "the car is refueled";
		}
		return "Car "+brand+" [" + engine + ", " + wheel +" "+ refuelded +"]";
	}
	
	public void drive() {
		Stream.of(car).filter(x->x.isFuel()).forEach(t->System.out.println(t.getBrand()+" went ..."));
	}
	
	public void console() {
		System.out.print("All cars of the fleet: ");
		Stream.of(car).forEach(t-> System.out.print(t.getBrand()+". "));
	}
	
	public void refueling(String brand) {
		
		System.out.println("Refueling..."+brand);
		Stream.of(car)
			.filter(t -> t.getBrand().equals(brand))
			.forEach(t -> t.setFuel(true));
		
		//or example:
		
//		for(Car car : getCar()) {
//			if(car.getBrand().equals(brand)) {
//				System.out.println("Refueling..."+brand);
//				car.setFuel(true);
//			}
//		}
	}
	
	public void changeWheel(Wheel newWheel, String brand) {		

		Stream.of(car)
			.filter(t -> t.getBrand().equals(brand))
			.forEach(t -> t.setWheel(newWheel));
		
		//or example:
		
//		for (Car car : getCar()) {
//			if(car.getBrand().equals(brand)) {
//				car.setWheel(newWheel);
//			}
//		}
 	}
	
	public void initCar() {
		
		Engine engine_1 = new Engine(2.0, EngineType.GASOLINE);
		Wheel wheel_1 = new Wheel(WheelDisk.SOLID_CAST, WheelTire.ALL_SEASON);				
		Car car_1 = new Car("AUDI A6", engine_1, wheel_1, isFuel());
			
		Engine engine_2 = new Engine(3.0, EngineType.DIESEL);
		Wheel wheel_2 = new Wheel(WheelDisk.WELDED, WheelTire.ALL_SEASON);				
		Car car_2 = new Car("AUDI A4", engine_2, wheel_2, isFuel());
		
		Engine engine_3 = new Engine(4.0, EngineType.GASOLINE);
		Car car_3 = new Car("AUDI A8", engine_3, wheel_1, isFuel());
		
		Car car_4 =  new Car("AUDI A8S", engine_3, wheel_2, isFuel());
		
		//Car[] cars = new Car[]{car_1, car_2};			
		setCar(new Car[]{car_1, car_2, car_3, car_4});		
	}	
}

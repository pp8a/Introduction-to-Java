import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import java.util.Optional;
import java.util.stream.Stream;


public class Simple extends TaskSelection{

	@Override
	void taskOne() {
		// TODO Auto-generated method stub
		super.taskOne();
		
		Test1 test1 = new Test1();
		test1.a = 4;
		test1.b = 6;
		test1.print();		
		System.out.println("Sum: "+test1.sum());
		System.out.println("Max: "+test1.max());
	}

	@Override
	void taskTwo() {
		// TODO Auto-generated method stub
		super.taskTwo();
		
		Test2 test2 = new Test2();
		System.out.println("Default value: à = "+test2.getA()+" b = "+test2.getB());
		test2.setA(5);
		test2.setB(6);
		System.out.println("New value: à = "+test2.getA()+" b = "+test2.getB());
	}

	@Override
	void taskThree() {
		// TODO Auto-generated method stub
		super.taskThree();
		
		Student[] students = new Student[10];
	    for (int i = 0; i < students.length; i++) {
	    	Student student = new Student();	    	
	    	students[i]=student.createStudent();
	    }
	    
	    System.out.println("Student database: ");
	    for (Student student : students) {		    	
	    	System.out.println(student.toString());
	    }
		
	    System.out.println("\nStudents with grades equal to 9 or 10:");
	    for (Student student: students) {	
	    	for(int progress: student.getProgress()) {
	    		if(progress>8) {
	    			System.out.println(student.getFullName()+" from group "+ student.getNumberGroup());
	    			break;
	    		}
	    	}	    	
	    }
	}

	@Override
	void taskFour() {
		// TODO Auto-generated method stub
		super.taskFour();
		
		Train[] trains = new Train[5];
		
		for (int i = 0; i < trains.length; i++) {
			Train train = new Train();
			trains[i]=train.createRoute(i);			
		}
		
		System.out.println("Train schedule:");
		for(Train train:trains) {
			System.out.println(train.toString());
		}
		
		Arrays.sort(trains);		
		System.out.println("Train schedule sorted by train numbers:");
		for(Train train:trains) {
			System.out.println(train.toString());
		}
		
		System.out.println("Input the train number:");		
		int numberTrain = Train.input();		
		Optional<Train> optionalTrain = Train.searchTrainForNumber(numberTrain, trains);		
//		if(optionalTrain.isPresent()) {
//			System.out.println(optionalTrain.get().toString());
//		}else {
//			System.out.println("No such number train as "+numberTrain);
//		}		
		optionalTrain.ifPresentOrElse(
				x->System.out.println(optionalTrain.get().toString()),
				()->System.out.println("No such number train as "+numberTrain));
		
		System.out.println("Train schedule sorted by the destination and time: ");
		Comparator<Train> comparatorTrain = Train.sortedDestination(trains);		
		Stream.of(trains).sorted(comparatorTrain).forEach(System.out::println);

	}

	@Override
	void taskFive() {
		// TODO Auto-generated method stub
		super.taskFive();
					
		DecimalCounter decimalCounter = new DecimalCounter(0);
		System.out.println("The default decimal counter is: "+decimalCounter.toString());		
		System.out.println("Current position: "+decimalCounter.print());
		
		decimalCounter  = new DecimalCounter(6, 2);
		System.out.println("\nCurrent position: "+decimalCounter.print());
		decimalCounter.changePosition();
		
		decimalCounter  = new DecimalCounter(5, 8);
		System.out.println("\nCurrent position: "+decimalCounter.print());
		decimalCounter.changePosition();
		
		List<Integer> counterRandom = DecimalCounter.randomInit();
		decimalCounter.setCounter(counterRandom);
		System.out.println("\nThe random decimal counter is: "+decimalCounter.toString());
		
		decimalCounter  = new DecimalCounter(4, 6);
		System.out.println("\nCurrent position: "+decimalCounter.print());
		decimalCounter.changePosition();
			
	}

	@Override
	void taskSix() {
		// TODO Auto-generated method stub
		super.taskSix();
		
		MyTime timeNow = new MyTime();		
		System.out.println(timeNow.toString());
		
		MyTime changeTime = new MyTime();
		
		changeTime.newTime(changeTime, timeNow);//create new time
		
		MyTime timeChange = new MyTime(changeTime.getHour(), changeTime.getMinute(), changeTime.getSecond());
		System.out.println(timeChange.toString());
		
//		LocalTime localTime = LocalTime.of(changeTime.getHour(), changeTime.getMinute(), changeTime.getSecond());
//		timeNow.setChange(localTime);
//		System.out.println(timeNow.toString());
		
	}

	@Override
	void taskSeven() {
		// TODO Auto-generated method stub
		super.taskSeven();
		
		Point [] point = new Point[3];
		for (int i = 0; i < point.length; i++) {			
			point[i] = new Point((Math.random() * 10)-10, (Math.random() * 10));				
		}
		
		for (Point coordinate : point) {
			System.out.println(coordinate.toString());
		}
		
		Triangle triangle = new Triangle(point[0], point[1], point[2]);
		System.out.println(triangle.toString());
		
		Calculation.setTriangle(triangle);
		Arrays.stream(Calculation.values()).forEach(t -> System.out.print(t.calculation()+" "));		
	}

	@Override
	void taskEight() {
		// TODO Auto-generated method stub
		super.taskEight();
	}

	@Override
	void taskNine() {
		// TODO Auto-generated method stub
		super.taskNine();
	}

	@Override
	void taskTen() {
		// TODO Auto-generated method stub
		super.taskTen();
	}
	
	
}

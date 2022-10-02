//import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.Optional;


public class Train implements Comparable<Train>, Supplier<Train>{
	/**
	 * {@link} https://javarush.ru/groups/posts/2262-comparator-v-java
	 * {@link} https://javarush.ru/groups/posts/1941-kak-ne-poterjatjhsja-vo-vremeni--datetime-i-calendar
	 * {@link} https://javarush.ru/groups/posts/2866-funkcionaljhnihe-interfeysih-v-java
	 * {@link} https://struchkov.dev/blog/optional-in-java/
	 */
	
	private String destination;
	private int numberTrain;
	Calendar calendar;
	
	
	public Train(String destination, int numberTrain, Calendar calendar) {
		super();
		this.destination = destination;
		this.numberTrain = numberTrain;
		this.calendar = calendar;
	}

	public Train() {
		super();	
		
	}

	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {		
		this.destination = destination;
	}


	public int getNumberTrain() {
		return numberTrain;
	}


	public void setNumberTrain(int numberTrain) {
		this.numberTrain = numberTrain;
	}


	public Calendar getCalendar() {
		return calendar;
	}


	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	
	@Override
	public String toString() {
		return "Train " + numberTrain + " [destination: " + destination + ", departure time: " + calendar.get(Calendar.HOUR) +":"+ calendar.get(Calendar.MINUTE) + "]";
	}

	public Train createRoute(int n) {
		
		String[] city = new String[] {"Brest-Minsk", "Vitebsk-Minsk", "Brest-Minsk", "Grodno-Minsk", "Brest-Minsk"};
		int[] number = new int[] {102, 101, 104, 103, 105};		
		
		Calendar time = new GregorianCalendar();
		
		switch (number[n]) {
		case 101:
			time.set(Calendar.HOUR, 9);
			time.set(Calendar.MINUTE, 30);				
			break;
		case 102:
			time.set(Calendar.HOUR, 10);
			time.set(Calendar.MINUTE, 45);				
			break;
		case 103:
			time.set(Calendar.HOUR, 11);
			time.set(Calendar.MINUTE, 15);				
			break;
		case 104:
			time.set(Calendar.HOUR, 9);
			time.set(Calendar.MINUTE, 15);				
			break;
		case 105:
			time.set(Calendar.HOUR, 8);
			time.set(Calendar.MINUTE, 00);				
			break;
		default:
			time.set(Calendar.HOUR, 0);
			time.set(Calendar.MINUTE, 0);
			break;
		}				
				
		setCalendar(time);
		setDestination(city[n]); 
		setNumberTrain(number[n]);
		
		return new Train (destination, numberTrain, calendar);		
	}

	@Override
	public int compareTo(Train o) {
		// TODO Auto-generated method stub
		return this.getNumberTrain()-o.getNumberTrain();
	}
	
	public static Optional<Train> searchTrainForNumber(int numberTrain, Train[] trains) {
		
		Supplier<Train> supplierNumber = ()->{
			Train train = null;
			for (int i = 0; i < trains.length; i++) {				
				if(trains[i].numberTrain==numberTrain) { 					
					train=trains[i];
				}				
			}
			return train; 
		};		
				
		Optional<Train> optionalTrain = supplierNumber.get() != null ? Optional.of(supplierNumber.get()) : Optional.empty();		
		
		return optionalTrain;	
	}
	
	public static Comparator<Train> sortedDestination(Train[] trains) {
		Comparator<Train> comparatorTrain = ((o1, o2) -> o1.getDestination().compareTo(o2.getDestination()));
		comparatorTrain = comparatorTrain.thenComparing(t -> t.getCalendar());				
		//Stream.of(trains).sorted(comparatorTrain).forEach(System.out::println);		
		return comparatorTrain;		
	}
	
	
	@Override
	public Train get() {
		// TODO Auto-generated method stub
		return new Train (destination, numberTrain, calendar);
	}
	
	public static int input() {		
		int number;
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);	
		
		do {				
		    while (!in.hasNextInt()) {
		        System.err.println("It's not an integer number! ... Input:");
		        in.next(); 
		    }
		    number = in.nextInt();
		    if(number<=0) {
		    	System.out.println("Input only positive number! ... Input:");
		    }
		} while (number <= 0);
		
		return number;
	}
	
	
	
}

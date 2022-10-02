import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

public class MyTime {

	private LocalTime now;
	private LocalTime change;
	private int hour;
	private int minute;
	private int second;
	
	{
		change = LocalTime.now();//LocalTime.of(0, 0, 0);
		setChange(change);
		now = LocalTime.now();
	}

	public MyTime() {
		super();		
		
	}
	
	public MyTime(int hour, int minute, int second) {
		super();
		this.hour = hour;
		this.minute = minute;
		this.second = second;	
		setChange(LocalTime.of(hour, minute, second));
	}

	public LocalTime getNow() {
		return now;
	}

	public void setNow(LocalTime now) {
		this.now = now;
	}	
	

	public LocalTime getChange() {
		return change;
	}

	public void setChange(LocalTime change) {
		this.change = change;
	}

	
	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}
	
	
	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");		
		return "Time now = [" + now.format(formatter) + "]. Time change = [" + change.format(formatter) + "].";
	}
	
	public MyTime setUpTime(LocalTime change) {
//		Predicate<Integer> isEvenNumber = x -> (x==0);
//		
//		if(isEvenNumber.test(change.getHour())) setHour(change.getHour());
//		if(isEvenNumber.test(change.getMinute())) setMinute(change.getMinute());
//		if(isEvenNumber.test(change.getSecond())) setSecond(change.getSecond());
		setHour(change.getHour());
		setMinute(change.getMinute());
		setSecond(change.getSecond());
		setChange(change);
				
		return new MyTime(hour, minute, second);		
	}
	
	public static void isValidFormat(String nTime, int number) {		
		
		
		LocalTime localDateTime2 = LocalTime.now();
		try {
			LocalTime newT = localDateTime2.withHour(number);
			DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern(nTime);
			System.out.println(newT.format(formatter2));			
		} catch (Exception e) {
			System.out.println("Ошибка ввода");
			isValidFormat(nTime, 0);
		}
		
				
	}
	
	public void newTime(MyTime changeTime, MyTime timeNow) {
		boolean exist = true;
		do {
			String lTime = MyTime.inputLetter();
			if(lTime.equals("e")||lTime.equals("E")) {
				exist=false;
				break;
			}
			
			TimeEnum [] timeEnums = TimeEnum.values();//get array enum
			
			Optional<TimeEnum> optionalTimeEnum = TimeEnum.timeEnum(lTime, timeEnums);//object enum
			
			optionalTimeEnum.ifPresentOrElse(
					x->{
						LocalTime change = optionalTimeEnum.get().action(changeTime.getChange());//action with enum												
						MyTime timeChange = changeTime.setUpTime(change);
						System.out.println(timeChange.toString());
						
					},
					()->{						
						System.out.println("There is no such time starting with the \'"+lTime+"\'.");																	
					});			
			
		}while(exist);
		
	}
	
	public static String inputLetter() {
		
		System.out.println("\tChange the time. If you want to change the time, input the letter:\n"
				+ "\t\th or H (hour); m or M (minute); s or S (second).\n"
				+ "\t\tif PLUS (example: PH or PM or PS)\n"
				+ "\t\tif MINUS (example: PH or PM or PS)\n"
				+ "\te or E - exit from time settings.");
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
				
		String s = null;
		while((s = sc.nextLine()).isEmpty()) {		  
		  System.out.println("You didn't input the letter. ( h or H (hour); m or M (minute); s or S (second); e or E (exit). Input ... ");			
		}		
		
		String result = "";		
		
		if(s.length()==2) {
			result = s.substring(0, 2);
		}else {
			result=String.valueOf(s.charAt(0));
		}
		
		
		return result;
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
		    if(number<0) {
		    	System.out.println("Input only positive number! ... Input:");
		    }
		} while (number<0);
		
		return number;
	}
	
}

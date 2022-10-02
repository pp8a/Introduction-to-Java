
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Supplier;

public enum TimeEnum {
	
	HOUR("H", "h"), MINUTE("M", "m"), SECOND("S", "s"), 
	PLUS_HOUR("PH", "ph"), PLUS_MINUTE("PM", "pm"), PLUS_SECOND("PS", "ps"), 
	MINUS_HOUR("MH", "mh"), MINUS_MINUTE("MM", "mm"), MINUS_SECOND("MS", "ms");
	
	private String upper;
	private String lower;
	
	private TimeEnum(String upper, String lower) {
		this.upper = upper;
		this.lower = lower;
	}

	

	public String getUpper() {
		return upper;
	}



	public void setUpper(String upper) {
		this.upper = upper;
	}



	public String getLower() {
		return lower;
	}



	public void setLower(String lower) {
		this.lower = lower;
	}



	public static Optional<TimeEnum> timeEnum(String str, TimeEnum [] enums) {
		
		Supplier<TimeEnum> supplierTime = ()->{
			TimeEnum time = null;
			for (int i = 0; i < TimeEnum.values().length; i++) {				
				if(enums[i].getLower().equals(str) || enums[i].getUpper().equals(str)) { 					
					time=enums[i];
				}				
			}
			return time; 
		};		
		
		Optional<TimeEnum> optionalTime = supplierTime.get() != null ? Optional.of(supplierTime.get()) : Optional.empty();
		
		return optionalTime;
	}
	
	public LocalTime action(LocalTime localTime) {
		
		System.out.print("You change the "+this+". Input number: ");
		int number = MyTime.input();		
	
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();		
		
		switch (this) {
		case HOUR:
			try {
				localTime = localTime.withHour(number);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(HOUR.upper+HOUR.upper);
				hour = Integer.valueOf(localTime.format(formatter));
				System.out.println("You input the time "+hour+" "+HOUR);
			} catch (Exception e) {
				System.err.println("Hour the hour-of-day to represent, from 0 to 23, so "+HOUR+"="+hour);
				hour=0;									
			}		
			break;
		case MINUTE:
			try {
				localTime = localTime.withMinute(number);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(MINUTE.lower+MINUTE.lower);
				minute = Integer.valueOf(localTime.format(formatter));
				System.out.println("You input the time "+minute+" "+MINUTE);
			} catch (Exception e) {
				System.err.println("minute the minute-of-hour to set in the result, from 0 to 59, so "+MINUTE+"="+minute);
				minute=0;								
			}	
			break;
		case SECOND:
			try {
				localTime = localTime.withSecond(number);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(SECOND.lower+SECOND.lower);
				second = Integer.valueOf(localTime.format(formatter));
				System.out.println("You input the time "+second+" "+SECOND);
			} catch (Exception e) {
				System.err.println("second the second-of-minute to set in the result, from 0 to 59, so "+SECOND+"="+second);
				second=0;								
			}	
			break;		
		case PLUS_HOUR:
			try {								
				localTime = localTime.plus(number, ChronoUnit.HOURS);				
				hour = Integer.valueOf(localTime.getHour());
				System.out.println("You change the time plus "+hour+" "+HOUR);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		case PLUS_MINUTE:
			try {								
				localTime = localTime.plus(number, ChronoUnit.MINUTES);				
				minute = Integer.valueOf(localTime.getMinute());
				System.out.println("You change the time plus "+minute+" "+MINUTE);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		case PLUS_SECOND:
			try {								
				localTime = localTime.plus(number, ChronoUnit.SECONDS);				
				second = Integer.valueOf(localTime.getSecond());
				System.out.println("You change the time plus "+second+" "+SECOND);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		case MINUS_HOUR:
			try {								
				localTime = localTime.minus(number, ChronoUnit.HOURS);				
				hour = Integer.valueOf(localTime.getHour());
				System.out.println("You change the time minus "+hour+" "+HOUR);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		case MINUS_MINUTE:
			try {								
				localTime = localTime.minus(number, ChronoUnit.MINUTES);				
				minute = Integer.valueOf(localTime.getMinute());
				System.out.println("You change the time minus "+minute+" "+MINUTE);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		case MINUS_SECOND:
			try {								
				localTime = localTime.minus(number, ChronoUnit.SECONDS);				
				second = Integer.valueOf(localTime.getSecond());
				System.out.println("You change the time minus "+second+" "+SECOND);
			} catch (Exception e) {
				System.err.println("Error "+this);				
			}	
			break;
		

		default:
			break;
		}
		
		LocalTime nTime = LocalTime.of(hour, minute, second);
		return nTime;
		
	}

}

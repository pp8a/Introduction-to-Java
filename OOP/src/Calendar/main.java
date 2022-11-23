package Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class main {

	public static void main(String[] args) {		
		Calendar calendar = new Calendar();
		calendar.initData();		
		
		Calendar.WeekendHoliday weekendHoliday = calendar.new WeekendHoliday();
		
		LocalDate localDate = LocalDate.MAX;
		for (int i = 1; i <= localDate.getMonthValue(); i++) {
			weekendHoliday.holiday(i);
		}
	}

}

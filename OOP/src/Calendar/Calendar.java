package Calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.stream.Stream;

public class Calendar {
		
	private WeekendHoliday[] weekendHolidays;		
	
	public Calendar() {
		super();
	}

	public class WeekendHoliday{
		/**
		 * weekends and holidays
		 */		
		private int dayOfMonth;	
		private Month month;
		private String holidayName;
		private TypeHoliday typeHoliday;
				
		public WeekendHoliday() {
			super();
		}

		public WeekendHoliday(int dayOfMonth, Month month, String holidayName, TypeHoliday typeHoliday) {
			super();
			this.dayOfMonth = dayOfMonth;
			this.month = month;
			this.holidayName = holidayName;
			this.typeHoliday = typeHoliday;
		}			

		@Override
		public String toString() {
			return "WeekendHoliday [dayOfMonth=" + dayOfMonth + ", month=" + month + ", holidayName=" + holidayName
					+ ", typeHoliday=" + typeHoliday + "]";
		}
		
		public void weekend(LocalDate date) {
			DayOfWeek checkDayOfWeek = date.getDayOfWeek();
			if(checkDayOfWeek.equals(DayOfWeek.of(6))||checkDayOfWeek.equals(DayOfWeek.of(7))) {				
				System.out.println(date+" "+date.getDayOfWeek()+" -> Weekend!");
			}
		}		
		
		public void holiday(int month) {
			LocalDate inMonth = LocalDate.of(2023, month, 1);
			//получаем количество дней в месяце...
			Stream.of(getWeekendHolidays())
				.forEach(t->{
					
				inMonth
					.datesUntil(inMonth.plusMonths(1))
					.filter(date -> date.getMonth()==t.getMonth())
					.filter(date -> date.getDayOfMonth()==t.getDayOfMonth())
					.forEach(date->{
						System.out.println(date+" | "+t.getHolidayName()+" | "+t.getTypeHoliday().getType());
						weekend(date);
					});				
				});	
			
		}

		public int getDayOfMonth() {
			return dayOfMonth;
		}

		public Month getMonth() {
			return month;
		}

		public String getHolidayName() {
			return holidayName;
		}

		public TypeHoliday getTypeHoliday() {
			return typeHoliday;
		}		
	
	}

	public WeekendHoliday[] getWeekendHolidays() {		
		return weekendHolidays;
	}
	
	public void initData() {
		WeekendHoliday jan_01 = new WeekendHoliday(1, Month.JANUARY, "New Year's Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday jan_02 = new WeekendHoliday(2, Month.JANUARY, "New Year's Day (in lieu)", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday jan_16 = new WeekendHoliday(16, Month.JANUARY, "Martin Luther King Jr. Day", TypeHoliday.FEDERAL_HOLIDAY);			
		WeekendHoliday feb_20 = new WeekendHoliday(20, Month.FEBRUARY, "President's Day", TypeHoliday.FEDERAL_HOLIDAY);
		
		WeekendHoliday apr_09 = new WeekendHoliday(9, Month.APRIL, "Easter Sunday", TypeHoliday.NOT_A_PUBLIC_HOLIDAY);
		WeekendHoliday may_14 = new WeekendHoliday(14, Month.MAY, "Mother's Day", TypeHoliday.NOT_A_PUBLIC_HOLIDAY);
		WeekendHoliday may_29 = new WeekendHoliday(29, Month.MAY, "Memorial Day", TypeHoliday.FEDERAL_HOLIDAY);
		
		WeekendHoliday jun_18 = new WeekendHoliday(18, Month.JUNE, "Father's Day", TypeHoliday.NOT_A_PUBLIC_HOLIDAY);
		WeekendHoliday jun_19 = new WeekendHoliday(19, Month.JUNE, "Juneteenth", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday jun_19_2 = new WeekendHoliday(19, Month.JUNE, "Juneteenth (in lieu)", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday jul_04 = new WeekendHoliday(4, Month.JULY, "Independece Day", TypeHoliday.FEDERAL_HOLIDAY);
		
		WeekendHoliday sep_04 = new WeekendHoliday(4, Month.SEPTEMBER, "Labor Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday oct_02 = new WeekendHoliday(2, Month.OCTOBER, "Cabrini Day", TypeHoliday.REGIONAL_HOLIDAY);
		WeekendHoliday oct_09 = new WeekendHoliday(9, Month.OCTOBER, "Columbus Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday oct_09_2 = new WeekendHoliday(9, Month.OCTOBER, "US Indigenous People's Day", TypeHoliday.REGIONAL_HOLIDAY);
		WeekendHoliday nov_10 = new WeekendHoliday(10, Month.NOVEMBER, "Veterans Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday nov_11 = new WeekendHoliday(11, Month.NOVEMBER, "Veterans Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday nov_23 = new WeekendHoliday(23, Month.NOVEMBER, "Thanksgiving", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday nov_24 = new WeekendHoliday(24, Month.NOVEMBER, "day after Thanksgiving", TypeHoliday.REGIONAL_HOLIDAY);
		WeekendHoliday dec_25 = new WeekendHoliday(25, Month.DECEMBER, "Christmas Day", TypeHoliday.FEDERAL_HOLIDAY);
		WeekendHoliday dec_27 = new WeekendHoliday(27, Month.DECEMBER, "Christmas Holiday", TypeHoliday.REGIONAL_HOLIDAY);
		
		weekendHolidays = new WeekendHoliday[] {jan_01, jan_02, jan_16, feb_20, apr_09, may_14, may_29, jun_18, jun_19, jun_19_2,
				jul_04, sep_04, oct_02, oct_09, oct_09_2, nov_10, nov_11, nov_23, nov_24, dec_25, dec_27};
	}
	
	@Override
	public String toString() {
		System.out.println("Calendar: ");
		for (WeekendHoliday weekendHoliday : weekendHolidays) {
			System.out.println(weekendHoliday);
		}
		return "";
	}
}

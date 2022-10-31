package Tourist;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Tourist {
	
	Voucher[] vouchers;

	public Tourist() {
		super();
	}
	
	public Voucher[] getVouchers() {
		return vouchers;
	}

	public void setVouchers(Voucher[] vouchers) {
		this.vouchers = vouchers;
	}

	@Override
	public String toString() {
		System.out.println("Tourist -> ");
		for (Voucher voucher : vouchers) {
			System.out.println(voucher);
		}			
		return "";
	}
	
	public void initData() {		
		
		Voucher voucher_1 = new Voucher(CountryType.CA, "Vancouver", VoucherType.NEW_YEAR, TransportType.AVIATION, FoodType.AL, 
				LocalDate.of(2022, Month.DECEMBER, 23), LocalDate.of(2023, Month.JANUARY, 10),  0);
		
		Voucher voucher_2 = new Voucher(CountryType.US, "New York", VoucherType.NEW_YEAR, TransportType.AVIATION, FoodType.UAI, 
				LocalDate.of(2022, Month.DECEMBER, 20), LocalDate.of(2023, Month.JANUARY, 10),  0);
		
		Voucher voucher_3 = new Voucher(CountryType.EG, "Cairo", VoucherType.EXCURSIONS, TransportType.BUS, FoodType.AL, 
				LocalDate.of(2023, Month.JULY, 1), LocalDate.of(2023, Month.JULY, 30),  0);
		
		Voucher voucher_4 = new Voucher(CountryType.CY, "Nicosia", VoucherType.CRUISES, TransportType.MOTOR_SHIP, FoodType.FB_PLUS, 
				LocalDate.of(2023, Month.MAY, 10), LocalDate.of(2023, Month.JUNE, 28),  0);
		
		Voucher voucher_5 = new Voucher(CountryType.GE, "Racha-Lechkhumi", VoucherType.SKI, TransportType.COMBINED, FoodType.RO, 
				LocalDate.of(2023, Month.JANUARY, 15), LocalDate.of(2023, Month.MARCH, 20),  0);
		
		Voucher voucher_6 = new Voucher(CountryType.UA, "Yevpatoria", VoucherType.TREATMENT, TransportType.RAILWAY, FoodType.FB_PLUS, 
				LocalDate.of(2023, Month.SEPTEMBER, 2), LocalDate.of(2023, Month.SEPTEMBER, 20),  0);
		
		Voucher voucher_7 = new Voucher(CountryType.CA, "Calgary", VoucherType.NEW_YEAR, TransportType.AVIATION, FoodType.FB, 
				LocalDate.of(2022, Month.DECEMBER, 20), LocalDate.of(2023, Month.JANUARY, 8),  0);
		
		Voucher voucher_8 = new Voucher(CountryType.US, "Washington", VoucherType.NEW_YEAR, TransportType.AVIATION, FoodType.HB, 
				LocalDate.of(2022, Month.DECEMBER, 20), LocalDate.of(2023, Month.JANUARY, 10),  0);
		
		Voucher voucher_9 = new Voucher(CountryType.EG, "Hurghada", VoucherType.EXCURSIONS, TransportType.MOTOR_SHIP, FoodType.BB, 
				LocalDate.of(2023, Month.JULY, 10), LocalDate.of(2023, Month.JULY, 20),  0);
		
		Voucher voucher_10 = new Voucher(CountryType.IT, "Napoli", VoucherType.CRUISES, TransportType.COMBINED, FoodType.FB_PLUS, 
				LocalDate.of(2023, Month.MAY, 10), LocalDate.of(2023, Month.JUNE, 28),  0);
		
		Voucher voucher_11 = new Voucher(CountryType.CN, "Shanghai", VoucherType.CRUISES, TransportType.BUS, FoodType.AL, 
				LocalDate.of(2023, Month.AUGUST, 15), LocalDate.of(2023, Month.SEPTEMBER, 3),  0);
		
		Voucher voucher_12 = new Voucher(CountryType.UA, "Odessa", VoucherType.TREATMENT, TransportType.RAILWAY, FoodType.HB_PLUS, 
				LocalDate.of(2023, Month.JUNE, 23), LocalDate.of(2023, Month.JULY, 20),  0);
		Voucher voucher_13 = new Voucher(CountryType.UA, "Odessa", VoucherType.TREATMENT, TransportType.RAILWAY, FoodType.HB_PLUS, 
				LocalDate.of(2023, Month.JUNE, 23), LocalDate.of(2023, Month.JULY, 10),  0);
		Voucher voucher_14 = new Voucher(CountryType.UA, "Odessa", VoucherType.TREATMENT, TransportType.RAILWAY, FoodType.HB_PLUS, 
				LocalDate.of(2023, Month.JUNE, 23), LocalDate.of(2023, Month.JULY, 15),  0);
		
		setVouchers(new Voucher [] {voucher_1, voucher_2, voucher_3, voucher_4, voucher_5, voucher_6,
				voucher_7, voucher_8, voucher_9, voucher_10, voucher_11, voucher_12, voucher_13, voucher_14
				});		
//		vouchers = new Voucher[] {voucher_1, voucher_2, voucher_3, voucher_4, voucher_5, voucher_6,
//				voucher_7, voucher_8, voucher_9, voucher_10, voucher_11, voucher_12};
	}
		
	public void selectionCountry(String country) {
		
		System.out.println("\nÑhoosing travel packages to "+country+":");
		Stream.of(getVouchers())
			.filter(t -> t.getCountryType().getFullTitle().equals(country))
			.forEach(System.out::println);			
	}
	
	public void selectionTransport(String transport) {
		
		System.out.println("\nÑhoosing travel packages to "+transport+":");
		Stream.of(getVouchers())
			.filter(t -> t.getTransportType().getType().equals(transport))
			.forEach(System.out::println);		
	}
	
	public void selectionFood(FoodType foodType) {
		
		System.out.println("\nSelection "+foodType+" ("+foodType.type+"):");
		Stream.of(getVouchers())
			.filter(t -> t.foodType.equals(foodType))
			.forEach(System.out::println);		
	}
	
	public void selectDays(long from, long to) {
		
		System.out.println("\nSelection of days from "+from+" to "+to+":");
		Stream.of(getVouchers())
			.filter(t -> (t.getDays()>=from)&&t.getDays()<=to)
			.forEach(System.out::println);
	}
	
	public void sortVaucher() {
		System.out.println("\nSorted by voucher ->");
		Arrays.sort(getVouchers());
		Stream.of(getVouchers()).forEach(System.out::println);
	}
	
	public void sortCity() {
		System.out.println("\nSorted by city, then days ->");
		Comparator<Voucher> comparator = ((o1, o2) -> o1.getCity().compareTo(o2.getCity()));
		comparator = comparator.thenComparing(t -> t.getDays());
		Stream.of(getVouchers())
			.sorted(comparator)
			.forEach(System.out::println);
	}
}

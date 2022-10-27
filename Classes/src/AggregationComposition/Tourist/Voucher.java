package Tourist;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Voucher implements Comparable<Voucher>{
	
	CountryType countryType;
	String city;
	VoucherType voucherType;
	TransportType transportType;
	FoodType foodType;
	LocalDate fromDate;
	LocalDate toDate;
	long days;
	
	public Voucher(CountryType countryType, String city, VoucherType voucherType, TransportType transportType,
			FoodType foodType, LocalDate fromDate, LocalDate toDate, long days) {
		super();
		this.countryType = countryType;
		this.city = city;
		this.voucherType = voucherType;
		this.transportType = transportType;
		this.foodType = foodType;
		this.fromDate = fromDate;
		this.toDate = toDate;		
		this.days = ChronoUnit.DAYS.between(fromDate, toDate);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public long getDays() {
		return days;
	}

	public CountryType getCountryType() {
		return countryType;
	}

	public VoucherType getVoucherType() {
		return voucherType;
	}

	public TransportType getTransportType() {
		return transportType;
	}

	public FoodType getFoodType() {
		return foodType;
	}

	@Override
	public String toString() {
		return "Voucher [country=" + countryType.fullTitle + ", city=" + city + ", voucher=" + voucherType
				+ ", transport=" + transportType + ", food=" + foodType + ", from=" + fromDate + ", to="
				+ toDate + ", days=" + days + "]";
	}

	@Override
	public int compareTo(Voucher o) {			
		return this.getVoucherType().compareTo(o.getVoucherType());
	}
}

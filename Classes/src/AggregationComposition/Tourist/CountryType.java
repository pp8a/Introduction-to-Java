package Tourist;

public enum CountryType {
	BY("Belarus"), BE("Belgium"), BG("Bulgaria"), DO("Dominican Republic"), EG("Egypt"), IN("India"),
	ES("Spain"), IT("Italy"), CY("Cyprus"), CN("China"), LT("Lithuania"), AE("United Arab Emirates"),
	PL("Poland"), GB("United Kingdom"), US("United States"), TR("Turkey"), UA("Ukraine"), FR("France"),
	CA("Canada"), DE("Germany"), GE("Georgia");
	
	String fullTitle;

	private CountryType(String fullTitle) {
		this.fullTitle = fullTitle;
	}

	public String getFullTitle() {
		return fullTitle;
	}
}

package tp1;

public class CountryHandler {
	private String countryName;
	private Integer countryTemp;
	
	public CountryHandler() {
		this.countryName = "France";
		this.countryTemp = 10;
	}

	public String getCountryName() {
		return countryName;
	}

	public CountryHandler(String countryName, Integer countryTemp) {
		super();
		this.countryName = countryName;
		this.countryTemp = countryTemp;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Integer getCountryTemp() {
		return countryTemp;
	}

	public void setCountryTemp(Integer countryTemp) {
		this.countryTemp = countryTemp;
	}

	@Override
	public String toString() {
		return "CountryHandler [countryName=" + countryName + ", countryTemp=" + countryTemp + "]";
	}
	
}

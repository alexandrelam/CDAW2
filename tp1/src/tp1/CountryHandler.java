package tp1;

public class CountryHandler {
	private String countryName;
	private Integer countryTemp;
	private String countryCapital;

	public CountryHandler() {
		this.countryName = "France";
		this.countryTemp = 10;
		this.countryCapital = "Paris";
	}

	public String getCountryCapital() {
		return countryCapital;
	}

	public void setCountryCapital(String countryCapital) {
		this.countryCapital = countryCapital;
	}

	public String getCountryName() {
		return countryName;
	}

	public CountryHandler(String countryName, Integer countryTemp, String countryCapital) {
		super();
		this.countryName = countryName;
		this.countryTemp = countryTemp;
		this.countryCapital = countryCapital;
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

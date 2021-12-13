package tp1;

import java.util.List;
import java.util.ArrayList;

public class WeatherHandler {
	private List<CountryHandler> countryHandlerList;
	
	public WeatherHandler() {
		CountryHandler france = new CountryHandler();
		CountryHandler espagne = new CountryHandler("Espagne", 20);
		CountryHandler italy = new CountryHandler("Italy",3);
		this.countryHandlerList = new ArrayList<CountryHandler>();
		this.countryHandlerList.add(france);
		this.countryHandlerList.add(espagne);
		this.countryHandlerList.add(italy);
	}

	public List<CountryHandler> getCountryHandlerList() {
		return countryHandlerList;
	}

	public void setCountryHandlerList(List<CountryHandler> countryHandlerList) {
		this.countryHandlerList = countryHandlerList;
	}
	
}

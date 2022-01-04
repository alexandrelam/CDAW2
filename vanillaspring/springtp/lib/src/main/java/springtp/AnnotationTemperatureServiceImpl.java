package springtp;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class AnnotationTemperatureServiceImpl {
	public static Map<String, Integer> countryTemp;

	public AnnotationTemperatureServiceImpl() {
		this.countryTemp = new HashMap<>();
		this.countryTemp.put("FR", 15);
		this.countryTemp.put("DE", 6);
		this.countryTemp.put("EN", 21);
	}

	public BigDecimal getTemperature(String country) {
		this.countryTemp.put(country, this.countryTemp.get(country) + 1);
		return BigDecimal.valueOf(this.countryTemp.get(country));
	}
}

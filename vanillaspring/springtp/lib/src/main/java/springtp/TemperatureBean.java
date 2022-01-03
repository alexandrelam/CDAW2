package springtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public interface TemperatureBean {
	String getName();

	void printTemperature();
}

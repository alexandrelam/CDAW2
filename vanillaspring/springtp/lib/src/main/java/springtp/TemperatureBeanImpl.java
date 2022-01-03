package springtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemperatureBeanImpl implements TemperatureBean {
	private String name;
	
	@Autowired
	private TemperatureServiceImpl service;

	public TemperatureBeanImpl(TemperatureServiceImpl service) {
		super();
		this.name = "frBean";
		this.service = service;
	}

	public void setService(TemperatureServiceImpl service) {
		this.service = service;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void printTemperature() {
		System.out.println("la température en " + this.getName() + " est "
				+ this.service.getTemperature(this.name).toString() + " hashcode : " + this.service.hashCode());
	}

	@Override
	public String getName() {
		return name;
	}
}

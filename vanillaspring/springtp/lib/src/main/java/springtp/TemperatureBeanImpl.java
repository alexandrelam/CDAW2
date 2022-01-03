package springtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TemperatureBeanImpl implements TemperatureBean {
	private String name;

	@Autowired
	private TemperatureServiceImpl service;

	public TemperatureBeanImpl(TemperatureServiceImpl service) {
		super();
		this.name = "FR";
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
		System.out.println(
				"la température en " + this.getName() + " est " + this.service.getTemperature(this.name).toString()
						+ " hashcode service : " + this.service.hashCode() + " hashcode object : " + this.hashCode());

	}

	@Override
	public String getName() {
		return name;
	}
}

package springtp;

public class TemperatureBeanImpl implements TemperatureBean {
	private String name;
	private TemperatureServiceBean service;

	public void setService(TemperatureServiceBean service) {
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

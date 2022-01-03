package springtp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TemperatureMain {
	private ApplicationContext context;

	private TemperatureBean frBean;
	private TemperatureBean enBean;
	private TemperatureBean deBean;

	private void postConstruction() {
		this.frBean = this.context.getBean("frBean", TemperatureBean.class);
		this.enBean = this.context.getBean("enBean", TemperatureBean.class);
		this.deBean = this.context.getBean("deBean", TemperatureBean.class);
	}

	private void printTemperatures() {
		this.frBean.printTemperature();
		this.enBean.printTemperature();
		this.deBean.printTemperature();
	}

	public static void main(final String[] args) throws Exception {
		TemperatureMain temperatureMain = new TemperatureMain();
		temperatureMain.context = new ClassPathXmlApplicationContext("application-context.xml");
		temperatureMain.postConstruction();
		temperatureMain.printTemperatures();

	}
}

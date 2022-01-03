package springtp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class TemperatureMain {

	public static void main(final String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		TemperatureBean frBean = (TemperatureBean)context.getBean("temperatureBeanImpl");
		frBean.printTemperature();
	}
}

package springtp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TemperatureMain {

	public static void main(final String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		TemperatureBeanImpl frBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");
		frBean.printTemperature();

		TemperatureBeanImpl enBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");
		enBean.setName("EN");
		enBean.printTemperature();
		
		TemperatureBeanImpl deBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");
		enBean.setName("DE");
		enBean.printTemperature();
		
		System.out.println("ending...");

	}
}

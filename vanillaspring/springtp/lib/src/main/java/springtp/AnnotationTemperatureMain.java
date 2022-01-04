package springtp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTemperatureMain {

	public static void printTemperatures(TemperatureBeanImpl frBean, TemperatureBeanImpl enBean,
			TemperatureBeanImpl deBean) {
		for (int i = 0; i < 10; i++) {
			System.out.println("---" + i + "----");
			frBean.printTemperature();
			enBean.printTemperature();
			deBean.printTemperature();
		}
	}

	public static void main(final String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		TemperatureBeanImpl frBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");

		TemperatureBeanImpl enBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");
		enBean.setName("EN");

		TemperatureBeanImpl deBean = (TemperatureBeanImpl) context.getBean("temperatureBeanImpl");
		deBean.setName("DE");

		printTemperatures(frBean, enBean, deBean);

		System.out.println("ending...");

	}
}

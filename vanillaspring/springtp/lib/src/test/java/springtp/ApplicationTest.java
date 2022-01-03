package springtp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationTest {
	@Test
	public void should_simple_bean_be_injected() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
		SimpleBeanInjection bean = applicationContext.getBean("SimpleBean", SimpleBeanInjection.class);
		Assertions.assertNotNull(bean.getSimpleBean());
	}
}

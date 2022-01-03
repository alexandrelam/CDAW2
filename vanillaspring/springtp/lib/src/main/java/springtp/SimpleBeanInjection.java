package springtp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleBeanInjection {
	@Autowired
	private SimpleBean simpleBean;

	public SimpleBeanInjection(SimpleBean simpleBean) {
		super();
		this.simpleBean = simpleBean;
	}

	public void setSimpleBean(SimpleBean simpleBean) {
		this.simpleBean = simpleBean;
	}

	public SimpleBean getSimpleBean() {
		return simpleBean;
	}

	
}

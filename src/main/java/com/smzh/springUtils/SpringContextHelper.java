/**
 * @title SpringContextHelper.java
 * @package com.smzh.springUtils
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月28日 下午4:26:31
 */
package com.smzh.springUtils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author zhenjun.yu
 */
@Service
public class SpringContextHelper implements ApplicationContextAware {
	private static ApplicationContext context;

	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
	}

}

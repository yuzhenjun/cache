/**
 * @title CacheEventListenerFactory.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月28日 下午4:18:03
 */
package com.smzh.ehcache;

import java.util.Properties;

import com.smzh.springUtils.SpringContextHelper;

import net.sf.ehcache.event.CacheEventListener;

/**
 * @author zhenjun.yu
 * ehcache监听管理器，
 */
public class CacheEventListenerFactory extends net.sf.ehcache.event.CacheEventListenerFactory {

	@Override
	public CacheEventListener createCacheEventListener(Properties properties) {
		 String beanName = properties.getProperty("bean");
	       if ( beanName == null ) {
	           throw new IllegalArgumentException( "缓存监听器名字未定义" );
	       }
	       return (CacheEventListener) SpringContextHelper.getBean(beanName);
	}

}

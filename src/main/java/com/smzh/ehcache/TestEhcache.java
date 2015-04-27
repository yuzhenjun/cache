/**
 * @title TestEhcache.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月27日 下午5:55:33
 */
package com.smzh.ehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhenjun.yu
 */
public class TestEhcache {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ehcache/application.xml");
			EhCacheCacheManager ehCacheManager= (EhCacheCacheManager) context.getBean("ehCacheManager");
			CacheManager  cacheManager=ehCacheManager.getCacheManager();
			//获取ehcache配置文件中的一个cache
			Cache cache=cacheManager.getCache("simple");
			Element element = new Element("key", "val");
			cache.put(element);
			//cache.remove("key");
			Element result = cache.get("key");
			System.out.println("=============================================");
			if(result!=null){
				System.out.println("========string========="+result.toString());
				System.out.println("========key========="+result.getObjectKey());
				System.out.println("========value========="+result.getObjectValue());
				System.out.println(result.getExpirationTime());
				System.out.println(result.getCreationTime());
				System.out.println(result.getExpirationTime()-result.getCreationTime());
			}
			for (String cacheName : cacheManager.getCacheNames()) {
			    System.out.println(cacheName);
			}
			
	}
}

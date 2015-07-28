/**
 * @title TestEhcache.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月27日 下午5:55:33
 */
package com.smzh.ehcache;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author zhenjun.yu
 */
public class TestSpringEhcache {


	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ehcache/application.xml");
			EhCacheCacheManager ehCacheManager= (EhCacheCacheManager) context.getBean("ehCacheManager");
			CacheManager  cacheManager=ehCacheManager.getCacheManager();
			//获取所有ehcache的名字
			for (String cacheName : cacheManager.getCacheNames()) {
			    System.out.println("name="+cacheName);
			}
			
			Cache cache=cacheManager.getCache("simple");
			for(Object key:cache.getKeys()){
				System.out.println(cache.get(key).getObjectValue());
			}
			Element element1 = new Element("key", "val");
			cache.put(element1);
			Element element2 = new Element("key2", "val2");
			cache.put(element2);
			Map<String, String> map=new HashMap<String, String>();
			map.put("name", "jun");
			Element element3 = new Element("MAP",map);
			cache.put(element3);
			
			System.out.println("======================"+System.currentTimeMillis()+"=======================");
			
			Thread.sleep(10000);
			
			cache.get("key");
			
			Thread.sleep(10000);
			
			System.out.println("======================"+System.currentTimeMillis()+"=======================");
			for( Object key:cache.getKeys()){
				Element element=cache.get(key);
				if(element!=null){
						System.err.println("======最后访问时间======"+element.getLastAccessTime()+"============");
						
					}
			}
			cacheManager.shutdown();
			
			
	}
}

/**
 * @title TestEhcache.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月27日 下午5:55:33
 */
package com.smzh.ehcache;

import java.util.HashMap;
import java.util.List;
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
	 */
	public static void main(String[] args) {
			@SuppressWarnings("resource")
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:ehcache/application.xml");
			EhCacheCacheManager ehCacheManager= (EhCacheCacheManager) context.getBean("ehCacheManager");
			CacheManager  cacheManager=ehCacheManager.getCacheManager();
			//获取所有ehcache的名字
			for (String cacheName : cacheManager.getCacheNames()) {
			    System.out.println("name="+cacheName);
			}
			
			//System.out.println("配置文件:=================\n"+cacheManager.getActiveConfigurationText());
			//System.out.println(cacheManager.getName());
			Cache cache=cacheManager.getCache("simple");
			Element element1 = new Element("key", "val");
			cache.put(element1);
			Element element2 = new Element("key2", "val2");
			cache.put(element2);
			cache.evictExpiredElements();
			Map<String, String> map=new HashMap<String, String>();
			map.put("name", "jun");
			Element element3 = new Element("MAP",map);
			cache.put(element3);
			for(Object key:cache.getKeys()){
				System.out.println(key);
				System.out.println("========="+cache.get(key)+"=========");
				System.out.println(cache.remove(key));
			}
			System.out.println("=============================================");
			
			
			
			
	}
}

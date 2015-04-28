/**
 * @title TestEhcache.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月28日 上午10:11:05
 */
package com.smzh.ehcache;

import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author zhenjun.yu

 */
public class TestEhcache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   CacheManager manager = new CacheManager("E://ehcache.xml");
	       Cache cache = manager.getCache("simple");
	       for (int i = 0; i < 6; i++) {
	            Element e = new Element("key" + i, "value" + i);
	            cache.put(e);
	        }

	        List<String> keys = cache.getKeys();
	        for (String key : keys) {
	            System.out.println(key + "," + cache.get(key));
	            System.out.println(cache.get(key).getExpirationTime()-cache.get(key).getCreationTime());
	        }
	}

}

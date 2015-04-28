/**
 * @title SimpleListener.java
 * @package com.smzh.ehcache
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月28日 下午4:11:43
 */
package com.smzh.ehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.event.CacheEventListener;

/**
 * @author zhenjun.yu

 */
public class SimpleListener implements CacheEventListener {

	@Override
	public void notifyElementRemoved(Ehcache cache, Element element)
			throws CacheException {
		System.out.println("删除数据"+element+",类型为："+element.getObjectValue().getClass());
	}

	@Override
	public void notifyElementPut(Ehcache cache, Element element)
			throws CacheException {
		System.out.println(cache.getName()+"开始添加数据"+element+",类型为："+element.getObjectValue().getClass());
	}

	@Override
	public void notifyElementUpdated(Ehcache cache, Element element)
			throws CacheException {
		System.out.println("更新缓存"+element);
	}

	@Override
	public void notifyElementExpired(Ehcache cache, Element element) {
		System.out.println(element+"过期");
	}

	@Override
	public void notifyElementEvicted(Ehcache cache, Element element) {
	}

	@Override
	public void notifyRemoveAll(Ehcache cache) {
	}

	@Override
	public void dispose() {
	}
	
	@Override  
    public Object clone() throws CloneNotSupportedException {  
        throw new CloneNotSupportedException("Singleton instance");  
    }  
}

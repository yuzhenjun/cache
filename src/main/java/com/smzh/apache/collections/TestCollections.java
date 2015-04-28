/**
 * @title TestCollections.java
 * @package com.smzh.apache.collections
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月28日 下午5:22:35
 */
package com.smzh.apache.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.collections.MapUtils;

/**
 * @author zhenjun.yu

 */
public class TestCollections {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, String> map=new HashMap<String, String>();
		System.out.println(MapUtils.isEmpty(map));
		ResourceBundle bundle=ResourceBundle.getBundle("com.smzh.config.test");
		@SuppressWarnings("unchecked")
		Map<String,String> map1=MapUtils.toMap(bundle);
		System.out.println(map1.get("jdbc.password"));
		
		List<String> list1=new ArrayList<String>();
		List<String> list2=new ArrayList<String>();
		System.out.println(ListUtils.isEqualList(list1, list2));
		
	}

}

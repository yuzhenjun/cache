/**
 * @title TestJetcd.java
 * @package com.smzh.etcd
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月30日 下午2:27:55
 */
package com.smzh.etcd;

import jetcd.EtcdClient;
import jetcd.EtcdClientFactory;
import jetcd.EtcdException;


/**
 * @author zhenjun.yu

 */
public class TestJetcd {

	/**
	 * @param args
	 * @throws EtcdException 
	 */
	public static void main(String[] args) throws EtcdException {
		String server="http://10.222.138.160:4001";
		EtcdClient client=EtcdClientFactory.newInstance(server);
		String key="/a/b/c/d";//key不能为此种形式
		String value="jun";
		client.set("a", value);
		System.out.println(client.get(key));
		
		
	}

}

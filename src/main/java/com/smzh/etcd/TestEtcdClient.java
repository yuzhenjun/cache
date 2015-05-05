/**
 * @title EtcdClient.java
 * @package com.smzh.etcd
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月30日 上午11:15:01
 */
package com.smzh.etcd;

import java.net.URI;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.ListenableFuture;
import com.justinsb.etcd.EtcdClient;
import com.justinsb.etcd.EtcdClientException;
import com.justinsb.etcd.EtcdResult;


/**
 * @author zhenjun.yu

 */
public class TestEtcdClient {

	/**
	 * @param args
	 * @throws EtcdClientException 
	 * @throws TimeoutException 
	 * @throws ExecutionException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws EtcdClientException, InterruptedException, ExecutionException, TimeoutException {
		String url="http://10.222.138.160:4001";
		EtcdClient client = new EtcdClient(URI.create(url));
		// key   /recordRule/${app}/${instance}
	/*	String value="hello";
		System.out.println("开始存储键为"+key);
		EtcdResult result = client.set(key, value);
		System.out.println("键值存储成功："+result);
		System.out.println("===========开始获取键为mykey的键值对==========");
		result = client.get("mykey");
		System.out.println("键为mykey的值为"+result);
		ListenableFuture<EtcdResult> watchFuture =client.watch(key);
		result =client.set(key, "world");
		EtcdResult watchResult = watchFuture.get(1, TimeUnit.SECONDS);
		System.out.println(watchResult.toString());*/
		long start=System.currentTimeMillis();
		for(int i=0;i<10;i++){
			System.out.println(client.set("/a/b/b","jun"));
		}
		System.out.println("======EtcdClient耗时："+(System.currentTimeMillis()-start)+"===========");
	}

}

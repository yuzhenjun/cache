/**
 * @title RedisClient.java
 * @package com.smzh.redis
 * @projectName cache
 * @author zhenjun.yu
 * @date 2015年4月29日 下午2:10:07
 */
package com.smzh.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.commons.collections.MapUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author zhenjun.yu
 */
public class RedisClient {
	private Jedis jedis;// 非切片客户端连接
	private JedisPool jedisPool;// 非切片连接池
	private ShardedJedis shardedJedis;// 切片客户端连接  
	private ShardedJedisPool shardedJedisPool;// 切片连接池
	private final String host="10.222.138.160";
	private final int port=6379;

	public RedisClient() {
		 initialPool(); 
	     initialShardedPool(); 
	     shardedJedis = shardedJedisPool.getResource();
	     jedis = jedisPool.getResource(); 
	}
	
	/**
     * 初始化非切片池
     */
	private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = initPools();
        jedisPool = new JedisPool(config,host,port);
    }
    
    
    /** 
     * 初始化切片池 
     */ 
    private void initialShardedPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = initPools();
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo(host, 6379, "master")); 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 
   
    
    @SuppressWarnings("unchecked")
	private JedisPoolConfig initPools(){
    	JedisPoolConfig config = new JedisPoolConfig(); 
        Map<String, String> conf=MapUtils.toMap(ResourceBundle.getBundle("com.smzh.redis.redis"));
        config.setMaxIdle(Integer.valueOf(conf.get("redis.maxIdle"))); 
        config.setMaxActive(Integer.valueOf(conf.get("redis.maxActive")));
        config.setMaxWait(Long.valueOf(conf.get("redis.maxWait")));
        config.setTestOnBorrow(Boolean.valueOf(conf.get("redis.testOnBorrow"))); 
        return config;
    }
    
    
    public void show() {     
        KeyOperate(); 
        StringOperate(); 
        ListOperate(); 
        SetOperate();
        SortedSetOperate();
        HashOperate(); 
        jedisPool.returnResource(jedis);
        shardedJedisPool.returnResource(shardedJedis);
    } 
    private void KeyOperate() {
    	jedis.flushDB();
    	 System.out.println("======================key=========================="); 
    	 System.out.println("判断是否存在smzh建:"+shardedJedis.exists("smzh")+"建值为:"+shardedJedis.get("smzh"));
    	 for(int i=1;i<=10;i++){
    		 System.out.println("新增建值：key=smzh"+i+",value=xisaaf"+i);
    		 shardedJedis.set("smzh"+i, "xisaaf"+i);
    		 shardedJedis.expire("smzh"+i, 10);
    	 }
    	 System.out.println("==============获取redis所有的主键=================");
    	 Set<String> keys=jedis.keys("*");//获取redis所有的主键
    	 for (String key:keys) {
			System.out.println(key+"="+shardedJedis.get(key));
		}
    	 System.out.println("查看某个key的剩余生存时间,单位【秒】.永久生存返回-1,不存在返回-2");
    	 // 查看某个key的剩余生存时间,单位【秒】.永久生存或者不存在的都返回-1
         System.out.println("查看key001的剩余生存时间："+jedis.ttl("key1"));
         System.out.println("查看smzh1的剩余生存时间："+jedis.ttl("smzh1"));
         
         System.err.println("移除某个key的生存时间");
         // 移除某个key的生存时间
         System.out.println("移除smzh1的生存时间："+jedis.persist("smzh1"));
         System.out.println("查看smzh1的剩余生存时间："+jedis.ttl("smzh1"));
     }

     private void StringOperate() {
    	 System.out.println("======================String_1=========================="); 
         // 清空数据 
        // System.out.println("清空库中所有数据："+jedis.flushDB());
         
         System.out.println("=============增=============");
         jedis.set("key001","value001");
         jedis.set("key002","value002");
         jedis.set("key003","value003");
         System.out.println("已新增的3个键值对如下：");
         System.out.println(jedis.get("key001"));
         System.out.println(jedis.get("key002"));
         System.out.println(jedis.get("key003"));
         
        System.out.println("移除");
         
     }

     private void ListOperate() {
    	 System.out.println("======================list=========================="); 
         // 清空数据 
         System.out.println("清空库中所有数据："+jedis.flushDB()); 
         System.out.println("=============增=============");
       /*  jedisCluster.lpush("list", "a");
         jedisCluster.lpush("list", "b");
         jedisCluster.lpush("list", "c");
         jedisCluster.lpush("list", "c");*/
         jedis.lpush("list","d");
         //System.out.println("所有元素-list："+jedisCluster.lrange("list", 0, -1));
     }

     private void SetOperate() {
      jedis.get(new byte[]{});
     }

     private void SortedSetOperate() {
        
     }
   
     private void HashOperate() {
       
     }

}

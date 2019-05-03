package cn.twang.redis;

import redis.clients.jedis.Jedis;

/**
 * @author Tyanao
 * @date 2017年4月17日 下午5:18:35
 * @version 
 */
public class FirstRedis {

	public static void main(String[] args) {
		// Jedis jedis = new Jedis("192.168.184.100");//默认端口是6379
		Jedis jedis = new Jedis("10.6.2.119");// 默认端口是6379
		 jedis.lpush("mygod", "wanglikun","liuyifei","jingtian","zhangyan");
		 jedis.set("a","hello");
		 System.out.println(jedis.get("a") + jedis.keys("*") +
		 jedis.lrange("mygod", 0, -1));//取出list中全部的值
		// jedis.close();

		//list
		//Long ll = setList(jedis);
		//System.out.println(ll);
		
		//setHset(jedis);
		
		//jedis.select(2);
		//setHset(jedis);
		//jedis.flushDB();
		//jedis.flushAll();
		
		
		jedis.close();
		
		// JedisPoolConfig
	}

	private static Long setList(Jedis jedis) {
		
		//存入值为list的数据  ===> 这里的list即有java中arraylist的按照顺序插入，又有linklist的两头插入、删除的特性
		Long res = jedis.lpush("mygodlist1", "wanglikun", "liuyifei", "jingtian", "zhangyan");
		//lpush的返回值是list中值的个数
		
		//取指定的第几个值
		System.out.println("value:" + jedis.lindex("mygodlist1", 2L));
		return res;
	}
	
	
	private static String setHset(Jedis jedis) {
		
		//hset 存入类似为map的东西，===> 这里hset即值是key-value形式
		jedis.hset("hset1", "name", "zhenzhen");
		jedis.hset("hset1", "address", "shanghai");
		
		
		System.out.println(jedis.hget("hset1", "name"));
		return null;
		
	}
	
	

}

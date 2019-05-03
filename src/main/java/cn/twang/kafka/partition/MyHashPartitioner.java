package cn.twang.kafka.partition;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @Description:
 *    整个kafka有非常多个Broker，那Producer在发送一条消息的时候需要决定这条消息应该发送到哪一个Broker上，那如何决定呢？？
 *    1.在kafka中提供了一个Partitioner接口，需要自定义partition类来实现这个Partitioner接口，重写partition()方法
 *    2.实例化Producer的时候将这个自定义的partition类的类名告诉Producer即可！
 * @author 70973
 * @date 2018年4月20日下午1:06:59
 */
public class MyHashPartitioner implements Partitioner{

	/**
	 * 不写这个方法，会报错
     * Exception in thread "main" java.lang.NoSuchMethodException: ckm.kafka.producer.SimplePartitioner.<init>(kafka.utils.VerifiableProperties)
     * at java.lang.Class.getConstructor0(Class.java:2892)
     * at java.lang.Class.getConstructor(Class.java:1723)
     * at kafka.utils.Utils$.createObject(Utils.scala:436)
     * at kafka.producer.Producer.<init>(Producer.scala:61)
     * at kafka.javaapi.producer.Producer.<init>(Producer.scala:26)
     * at ckm.kafka.producer.KafkaProducerWithPartition.<init>(KafkaProducerWithPartition.java:58)
     * at ckm.kafka.producer.KafkaProducerWithPartition.main(KafkaProducerWithPartition.java:70)
	 * @param verifiableProperties
	 */
	public MyHashPartitioner(VerifiableProperties verifiableProperties) {
		
	}
	
	/**
	 * @param key: 这条消息的key，默认值是null，若设置了就是设置的值
	 * @param numPartition: 指定的topic的partition的总数
	 * @return : 对于指定的消息的key，返回此消息应该发送到哪个partition
	 */
	@Override
	public int partition(Object key, int numPartitions) {
		if((key instanceof Integer)) {
			return Math.abs(Integer.parseInt(key.toString())) % numPartitions;
		}
		return Math.abs(key.hashCode() % numPartitions);
	}
	

}

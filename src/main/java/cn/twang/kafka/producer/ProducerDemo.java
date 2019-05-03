package cn.twang.kafka.producer;

import cn.twang.utils.kafkaUtils.KafkaProducerUtils;
import kafka.javaapi.producer.Producer;

/**
 * @Description:
 *    编写生产者的java代码，
 *    注意，topic主题是在命令行创建好了的，若没有创建就执行此代码则无法写入指定的topic
 * @author Tyanao
 * @date 2018年4月20日下午9:02:12
 */
public class ProducerDemo {

	static private final String TOPIC = "topic1";

	// static private final int PARTITIONS = TopicAdmin.partitionNum(ZOOKEEPER, TOPIC);
	static private final int PARTITIONS = 3;

	
	public static void main(String[] args) throws Exception {
		/**
		 * 获得Producer实例
		 * 	  Producer是一个泛型类：有两个泛型：第一个指定Key的类型，第二个指定value的类型
		 */
		Producer<String, String> producer = KafkaProducerUtils.initProducer();
		KafkaProducerUtils.sendOne(producer, TOPIC);
	}



	

}

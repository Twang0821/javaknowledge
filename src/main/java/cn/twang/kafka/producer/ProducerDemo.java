package cn.twang.kafka.producer;

import java.util.Properties;

import cn.twang.kafka.partition.MyHashPartitioner;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import kafka.serializer.StringEncoder;

/**
 * @Description:
 *    编写生产者的java代码，
 *    注意，topic主题是在命令行创建好了的，若没有创建就执行此代码则无法写入指定的topic
 * @author 70973
 * @date 2018年4月20日下午9:02:12
 */
public class ProducerDemo {

	static private final String TOPIC = "topic1";
	static private final String ZOOKEEPER = "192.168.184.131:2181,192.168.184.132:2181,192.168.184.133:2181";
	static private final String BROKER_LIST = "192.168.184.131:9092,192.168.184.132:9092,192.168.184.133:9092";

	// static private final int PARTITIONS = TopicAdmin.partitionNum(ZOOKEEPER, TOPIC);
	static private final int PARTITIONS = 3;

	
	public static void main(String[] args) throws Exception {
		/**
		 * 获得Producer实例
		 * 	  Producer是一个泛型类：有两个泛型：第一个指定Key的类型，第二个指定value的类型
		 */
		Producer<String, String> producer = initProducer();
		sendOne(producer, TOPIC);
	}

	/**
	 * @Description: 
	 *    初始化生产者信息并创建生产者
	 * @return
	 */
	private static Producer<String, String> initProducer() {
		Properties props = new Properties();
		//props.put("zk.connect", ZOOKEEPER);
		props.put("metadata.broker.list", BROKER_LIST);
		/**
		 * 指定message的序列化方法，用户可以通过实现kafka.serializer.Encoder接口自定义该类
		 * 默认情况下message的key和value都用相同的序列化，但是可以使用"key.serializer.class"指定key的序列化
		 */
		//props.put("serializer.class", "kafka.serializer.StringEncoder");
		props.put("serializer.class", StringEncoder.class.getName());
		
		/**
		 * 指定partition类，自定义的分区类，继承自kafka.producer.Partitioner接口
		 */
		props.put("partitioner.class", MyHashPartitioner.class.getName());//"com.twang.kafka.partition.MyHashPartitioner"
		//props.put("partitioner.class", "kafka.producer.DefaultPartitioner");//默认值

		/**
		 * 压缩
		 */
		//props.put("compression.codec", "0");

		/**
		 * 这个参数用于通知broker接收到message后是否向producer发送确认信号 :
		 * 0 - 表示producer不用等待任何确认信号，会一直发送消息
		 * 1 - 表示leader状态的replica在接收到message后需要向producer发送一个确认信号，否则producer进入等待状态
		 * -1 - 表示leader状态的replica需要等待所有in-sync状态的replica都接收到消息后才会向producer发送确认信号，再次之前producer一直处于等待状态
		 */
		//props.put("request.required.acks", "1");
		/**
		 * 指定同步发送，还是异步发送：sync-同步；async-异步
		 */
		props.put("producer.type", "async");
		
		/**
		 * 下面的参数都是给异步用的
		 */
		props.put("batch.num.messages", "3");
		props.put("queue.buffer.max.ms", "10000000");
		props.put("queue.buffering.max.messages", "1000000");
		props.put("queue.enqueue.timeout.ms", "20000000");

		ProducerConfig config = new ProducerConfig(props);

		Producer<String, String> producer = new Producer<String, String>(config);
		return producer;
	}

	/**
	 * @Description:
	 *    根据topic发送消息
	 * @param producer
	 * @param topic
	 * @throws InterruptedException
	 * @date 2018年4月20日下午11:10:54
	 */
	public static void sendOne(Producer<String, String> producer, String topic)
			throws InterruptedException {
		/**
		 * KeyedMessage类中第一个泛型指定用于分区的key的类型，第二个泛型指message的类型
		 * topic只能为String类型
		 * 构造函数中参数 "31" 是用于分区(partition)的key
		 */
		KeyedMessage<String, String> message1 = new KeyedMessage<String, String>(
				topic, "31", "test 31");
		producer.send(message1);
		Thread.sleep(5000);
		KeyedMessage<String, String> message2 = new KeyedMessage<String, String>(
				topic, "31", "test 32");
		producer.send(message2);
		Thread.sleep(5000);
		KeyedMessage<String, String> message3 = new KeyedMessage<String, String>(
				topic, "31", "test 33");
		producer.send(message3);
		Thread.sleep(5000);
		KeyedMessage<String, String> message4 = new KeyedMessage<String, String>(
				topic, "31", "test 34");
		producer.send(message4);
		Thread.sleep(5000);
		KeyedMessage<String, String> message5 = new KeyedMessage<String, String>(
				topic, "31", "test 35");
		producer.send(message5);
		Thread.sleep(5000);
		producer.close();
	}

}

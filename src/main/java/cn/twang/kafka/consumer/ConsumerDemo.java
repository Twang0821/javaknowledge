package cn.twang.kafka.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * kafka的消费者_java客户端
 * @author 70973
 * @date 2018年4月30日上午0:30:02
 */
public class ConsumerDemo {
	private static final String topic = "mysons";
	/**
	 * 线程数量，一般就是Topic的分区数量；建议一个分区对应一个线程  
	 */
	private static final Integer threads = 3; 

	public static void main(String[] args) {
		
		Properties props = new Properties();
		props.put("zookeeper.connect", "192.168.184.131:2181,192.168.184.132:2181,192.168.184.133:2181");
		//props.put("zookeeper.connect", "192.168.184.131:2181");
		props.put("group.id", "1111");//定义分组,这个group.id的值就记录在zk里
		props.put("auto.offset.reset", "smallest");//设置偏移量
		props.put("zk.connectiontimeout.ms", "15000");
		props.put("derializer.class", "kafka.serializer.DefaultDecoder");
		
		ConsumerConfig config = new ConsumerConfig(props);
		/**
		 * 初始化消费者Consumer实例，在初始化的时候，都需要传一个group.id，这个group.id决定了多个Consumer在消费同一个topic的时候，是分摊，还是广播。
		 * 假设多个Consumer都订阅了同一个topic，这个topic有多个partition.
		 * 负载均衡模式： 多个Consumer属于同一个group，则topic对应的partition的消息会分摊到这些Consumer上。
		 * Pub/Sub模式：多个Consumer属于不同的group，则这个topic的所有消息，会广播到每一个group。
		 */
		//1.创建Kafka连接器
		ConsumerConnector consumerConnector =Consumer.createJavaConsumerConnector(config);//消费者客户端
		//2.设置要消费的主题topic列表，及每个主题开启几个线程
		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		//topicCountMap.put(topic, threads);
		//topicCountMap.put("mygirls", 1);
		topicCountMap.put("first", 3);//主题名，线程数
		
		//3.获取Stream，每调用一次createMessageStreams都会将consumer注册到topic上，这样consumer和brokers之间的负载均衡就会进行调整。
		//API鼓励每次调用创建更多的topic流以减少这种调整。createMessageStreamsByFilter方法注册监听可以感知新的符合filter的topic。
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector.createMessageStreams(topicCountMap);
		//4.获取每次接收到的这个主题的数据 ，即一个topic对应一个stream
		List<KafkaStream<byte[], byte[]>> streams = consumerMap.get("first");
		//5.为每个stream启动一个线程消费消息 
		for(final KafkaStream<byte[], byte[]> kafkaStream : streams){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(MessageAndMetadata<byte[], byte[]> mm : kafkaStream){
						String msg = new String(mm.message());
						System.out.println(msg);
					}
				}
			
			}).start();
		
		}
	}
}
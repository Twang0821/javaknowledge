package cn.twang.kafka.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * @Description:
 *   
 * @author 70973
 * @date 2018年4月20日下午9:02:58
 */
public class DemoConsumer {

	/**
	 * @param args
	 *            传入的数组参数
	 */
	public static void main(String[] args) {
		args = new String[] {
				"192.168.184.131:2181,192.168.184.132:2181,192.168.184.133:2181",
				"topic1", "group1", "consumer1" };
		if (args == null || args.length != 4) {
			System.err
					.print("Usage:\n\tjava -jar kafka_consumer.jar ${zookeeper_list} ${topic_name} ${group_name} ${consumer_id}");
			System.exit(1);
		}
		String zk = args[0];
		String topic = args[1];
		String groupid = args[2];
		String consumerid = args[3];
		Properties props = new Properties();
		props.put("zookeeper.connect", zk);
		props.put("group.id", groupid);
		/*
		 * smallest:去找这个consumer上次消费的地方，从上次的下一条数据开始读，
		 * 否则会从最大的offset开始读，即只读最新的,即largest
		 * largest:自动把offset设为最大的offset,即接收最新消息
		 */
		props.put("auto.offset.reset", "largest");
		props.put("auto.commit.enable", "true");
		props.put("client.id", "test");
		props.put("auto.commit.interval.ms", "1000");

		ConsumerConfig consumerConfig = new ConsumerConfig(props);
		ConsumerConnector consumerConnector = Consumer
				.createJavaConsumerConnector(consumerConfig);

		Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
		topicCountMap.put(topic, 1);
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumerConnector
				.createMessageStreams(topicCountMap);

		KafkaStream<byte[], byte[]> stream1 = consumerMap.get(topic).get(0);
		ConsumerIterator<byte[], byte[]> it1 = stream1.iterator();
		while (it1.hasNext()) {
			MessageAndMetadata<byte[], byte[]> messageAndMetadata = it1.next();
			String message = String
					.format("Consumer ID:%s, Topic:%s, GroupID:%s, PartitionID:%s, Offset:%s, Message Key:%s, Message Payload: %s",
							consumerid, messageAndMetadata.topic(), groupid,
							messageAndMetadata.partition(), messageAndMetadata
									.offset(),
							new String(messageAndMetadata.key()), new String(
									messageAndMetadata.message()));
			System.out.println(message);
		}
	}

}

package cn.twang.utils.kafkaUtils;

import java.util.Properties;

import kafka.consumer.ConsumerConfig;

/**
 * @Description:
 *   kafka消费者工具类
 * @author 70973
 * @date 2018年4月20日下午9:02:58
 * @version 1.0
 */
public class KafkaConsumerUtils {
	
	public static ConsumerConfig getConsumerConfig(String[] args) {
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
		return consumerConfig;
	}

}

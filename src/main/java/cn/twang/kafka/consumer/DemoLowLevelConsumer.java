package cn.twang.kafka.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.javaapi.consumer.ConsumerConnector;
import kafka.javaapi.consumer.SimpleConsumer;
import kafka.message.MessageAndMetadata;

/**
 * @Description:
 *    Low Level Consumer,用户希望比Consumer Group更好的控制数据的消费：
 *    
 * @author 70973
 * @date 2018年4月22日下午5:22:36
 */
public class DemoLowLevelConsumer {

	/**
	 * @param args
	 *            传入的数组参数
	 */
	public static void main(String[] args) {
	
		final String topic = "topic1";
		String clientID = "DemoLowLevelConsumer1";//ClientId类似与consumer group ID的标识，如设置为SparkStreamingKafka
		SimpleConsumer simpleConsumer = new SimpleConsumer("192.168.184.131", 9092, 100000, 64 * 1000000, clientID);
		
		

	
	}

}

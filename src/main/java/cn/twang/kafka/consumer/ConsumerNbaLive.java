package cn.twang.kafka.consumer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
import kafka.message.MessageAndMetadata;

/**
 * @Description:
 *   
 * @author 70973
 * @date 2018年6月19日下午6:47:58
 */
public class ConsumerNbaLive {
	private static final String topic = "bingofzd-kafka-new";
	/**
	 * 线程数量，一般就是Topic的分区数量；建议一个分区对应一个线程  
	 */
	private static final Integer threads = 3; 
	private final static int timeSection = 100;  
	//private boolean autoCommit;  
	
	public static void main(String[] args) {
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "106.75.105.210:9092,106.75.115.198:9092,106.75.99.204:9092");
		props.put("group.id", "fwy_kafka_001");
		props.put("auto.offset.reset", "earliest");//设置偏移量
		
		props.put("enable.auto.commit", "true");  //自动commit
        props.put("auto.commit.interval.ms", "1000"); //定时commit的周期
        props.put("session.timeout.ms", "30000"); //consumer活性超时时间
        
        
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");  
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer"); 
		//props.put("derializer.class", "kafka.serializer.DefaultDecoder");
		
		//ConsumerConfig config = new ConsumerConfig(props);
		KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
		
		consumer.subscribe(Arrays.asList(topic));
	
		while (true) {  
            System.out.println("开始poll---------------");  
            ConsumerRecords<String, String> records = consumer.poll(timeSection);// 拉取一次数据  
            for (ConsumerRecord<String, String> record : records) {  
                System.out.println("topic: " + record.topic() + " key: " + record.key() + " value: " + record.value()  
                        + " partition: " + record.partition());  
            }  
            System.out.println("完成一次poll---------------");  
        }  
    
	
	}
}
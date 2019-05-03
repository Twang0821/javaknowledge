package cn.twang.kafka.producer;

import java.util.Properties;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

/**
 * 使用Producer API发送消息到kafka
 * @author 70973
 * @date 2018年4月21日下午11:17:41
 */
public class ProducerDemo2 {
	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put("zk.connect", "192.168.184.131:2181,192.168.184.132:2181,192.168.184.133:2181");
		props.put("metadata.broker.list","192.168.184.131:9092,192.168.184.132:9092,192.168.184.133:9092");
		props.put("serializer.class", "kafka.serializer.StringEncoder");
		ProducerConfig config = new ProducerConfig(props);
		Producer<String, String> producer = new Producer<String, String>(config);

		// 发送业务消息
		// 读取文件 读取内存数据库 读socket端口
		for (int i = 1; i <= 10; i++) {
			Thread.sleep(500);
			producer.send(new KeyedMessage<String, String>("first",
					"i said i love you baby for" + i + "times,will you have a nice day with me tomorrow"));
		}

	}
}
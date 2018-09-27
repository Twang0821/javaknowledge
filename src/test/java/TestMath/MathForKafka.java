package TestMath;

import org.junit.Test;

import cn.twang.utils.mathUtils.MathUtils;

public class MathForKafka {
	
	@Test
	public void testKafka() {
		MathUtils.getNumPartitionByConsumerGroup("fwy_kafka_001");
	}

}

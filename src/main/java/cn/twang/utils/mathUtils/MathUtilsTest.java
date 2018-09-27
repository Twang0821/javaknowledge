package cn.twang.utils.mathUtils;

import org.junit.Test;

public class MathUtilsTest {

	@Test
	public void testGetNumPartitionByConsumerGroup() {
		MathUtils.getNumPartitionByConsumerGroup("kafka-regex-flume");
	}

}

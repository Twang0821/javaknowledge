package cn.twang.utils.mathUtils;

/**
 * @Description
 * 	   关于Math类中一些方法在实践中的一些使用
 * @author Tyanao
 * @date: 2018年6月9日 下午10:58:47
 * @version 0.1
 */
public class MathUtils {
	
	/**
	 * 对consumergroup进行hash求出在__consumer_offsets topic中所在的分区
	 * 	计算公式：Math.abs(groupID.hashCode()) % numPartitions
	 * @param consumerGroup  Kafka消费端的group id
	 * @return
	 */
	public static int getNumPartitionByConsumerGroup(String consumerGroup) {
		int numPartition = Math.abs(consumerGroup.hashCode())%50;
		System.out.println("the numPartition will return is :" + numPartition);
		return numPartition;
	}
	
	
	
	public static void main(String[] args) {
		String strGroupId = "bingoxsdts_01";
		
		int res = getNumPartitionByConsumerGroup(strGroupId);
		System.out.println(res);
	}

}

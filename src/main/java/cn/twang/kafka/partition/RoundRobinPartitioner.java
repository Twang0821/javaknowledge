package cn.twang.kafka.partition;

import java.util.concurrent.atomic.AtomicLong;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;

/**
 * @Description:
 *    RoundRobinPartitioner
 * @author 70973
 * 2018年4月20日下午1:49:08
 */
public class RoundRobinPartitioner implements Partitioner {
  
  private static AtomicLong next = new AtomicLong();

  /**
   * 
   * @param verifiableProperties
   */
  public RoundRobinPartitioner(VerifiableProperties verifiableProperties) {
	  
  }

  @Override
  public int partition(Object key, int numPartitions) {
    long nextIndex = next.incrementAndGet();
    return (int)nextIndex % numPartitions;
  }
}



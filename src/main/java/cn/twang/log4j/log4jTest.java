package cn.twang.log4j;


import org.apache.log4j.Logger;

/**
 * @Description:
 *   测试使用log4j的实例类
 * @author Tyanao
 * @date: 2016年11月27日 上午11:26:02
 * @version
 */
public class log4jTest {
	private static Logger logger = Logger.getLogger(log4jTest.class);//获取logger实例
	
	public static void main(String[] args) {
		logger.info("普通Info信息222");
		logger.debug("调试debug222信息");
		logger.error("报错error信息");
		logger.warn("警告warn信息");
		logger.fatal("严重错误fatal信息");
		
		//logger.error(message, t);重载打印出异常
		logger.error("报错信息", new IllegalArgumentException("非法参数"));
	}

}

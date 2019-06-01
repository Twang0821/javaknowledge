package TestUtils;

import org.junit.Test;

import cn.twang.utils.dateUtils.DateUtils;

/**@ClassName: DateUtilsTest   
 * @Description: Junit测试类
 * @author: Tyanao
 * @date: 2018年5月25日 下午12:22:46     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目 
 */
public class DateUtilsTest {

	@Test
	public void testGetNextDay() {
		String resStr = DateUtils.getNextDay("2018-05-07", 1);
		System.out.println("the result: " + resStr);
		
		String resStr2 = DateUtils.getNextDay("2018-05-07", -1);
		System.out.println("the result: " + resStr2);
	}
	
	@Test
	public void testUTCStrDateTimeToDefaultString() {
		String utcStrDateTime = "2018-05-23T00:00:45.628Z";
		DateUtils objName = new DateUtils();
		String resStr = objName.UTCStrDateTimeToDefaultString(utcStrDateTime);
		System.out.println("the result: " + resStr);
	}
	
	@Test
	public void testUTCStrDateTimeToDefaultString2() {
		String utcStrDateTime = "2018-05-23T00:00:45.628Z";
		// 连着的写法
		String resStr = new DateUtils().UTCStrDateTimeToDefaultString(utcStrDateTime);
		System.out.println("the result: " + resStr);
	}
	
	// 测试 将毫秒换算成日期
	@Test
	public void testchangeMilliSecondsToDate() {
		String st = "1528754391638"; //1528905591000
		Long minllisecond = 1528754391638L; // 1528905591000
		String resStr = DateUtils.changeMilliSecondsToDate(minllisecond, null);
		System.out.println("the result: " + resStr);
	}
	

}

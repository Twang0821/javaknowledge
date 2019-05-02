package cn.twang.utils.mathUtils;

import java.math.BigDecimal;

/**
 * @ClassName: TestDivide   
 * @Description: 测试BigDecimal类型数据相除保留的位数   
 * @author: Tyanao
 * @date: 2018年5月2日 下午14:26:20     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class TestDivide {
	
	public static void main(String[] args) {
		
		BigDecimal d1 = new BigDecimal("12684.28");
		BigDecimal d2 =  new BigDecimal("1181.18");
		System.out.println("-----");
		BigDecimal dd = d2.divide(d1, 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100));
		System.out.println(":: " + dd);
		
		BigDecimal dd2 = d2.multiply(new BigDecimal(100)).divide(d1, 2);
		System.out.println("df:" + dd2);
		
		
	}

}

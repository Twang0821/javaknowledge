package cn.twang.utils.lombokUtils;


/**
 * @ClassName:  LombokTest   
 * @Description:测试lombok工具的注解的使用 
 * @author: Twangrentao
 * @date:   2018年9月22日 下午3:45:08     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class LombokTest {

	public static void main(String[] args) {
		
		LombokBean bean = new LombokBean();
		bean.setUserId("001");
		bean.setUserName("Jahuing");
		
		System.out.println(bean.hashCode());
		
	}
	
}

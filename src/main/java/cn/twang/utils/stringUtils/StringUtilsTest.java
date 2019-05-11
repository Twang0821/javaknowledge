package cn.twang.utils.stringUtils;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName: StringUtilsTest
 * @Description: org.apache.commons.lang3.StringUtils中关于字符串判断的测试
 * @author: Tyanao
 * @date: 2017年5月11日 下午1:40:08
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved.
 *             注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class StringUtilsTest {
	public static void main(String[] args) {
		 String string = " ";
				
		 test_isBlank(string);
	}
	
	 /**
     * <p>判断一个字符串是不是null, "", " "</p>
     *
     * <pre>
     * test_isBlank(null)      = true
     * test_isBlank("")        = true
     * test_isBlank(" ")       = true
     * </pre>
     *
     * @param str 要判断的字符串
     * @return 返回boolean值
     * @since 1.0
     */
	public static boolean test_isBlank(String str) {
		return StringUtils.isBlank(str);
	}
	
}

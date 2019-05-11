package cn.twang.javaknowledge.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @ClassName: RegexTest
 * @Description: 关于正则表达式的测试使用
 * @author: Tyanao
 * @date: 2019年5月8日 下午5:10:20
 * @Copyright: 2019 www.tydic.com Inc. All rights reserved.
 *             注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class RegexTest {

	public static void main(String[] args) {

		String pre_page = "http://o2o.uzero.com.cn/index.html?lang=zh_CN";
		String curl_page = "http://o2o.uzero.com.cn/index.html";
		String regex = "(?<=//|)((\\w)+\\.)+\\w+";

		String res = compareTwoString(pre_page, curl_page, regex);
		System.out.println(res);
	}

	/**
	 * <p>将2个字符串与正则匹配 </p>
     *
     * <pre>
     * 案例	------	结果值
     * </pre> 
	 * @param pre_url 前一个url链接
	 * @param curl_url 后一个rul链接，即当前url链接
	 * @param regex 正则表达式
	 * @return 
	 */
	public static String compareTwoString(String pre_url, String curl_url, String regex) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher_pre = pattern.matcher(pre_url);
		Matcher matcher_curl = pattern.matcher(curl_url);
		
		String preSourceName = "";
		String curlSourceName = "";
		String strReturn = "";
		if (matcher_pre.find()) {
			preSourceName = matcher_pre.group();
			if (matcher_curl.find()) {
				curlSourceName = matcher_curl.group();
				System.out.println("preSourceName:" + preSourceName + "curlSourceName:" + curlSourceName);
				strReturn ="preSourceName:" + preSourceName + "curlSourceName:" + curlSourceName;
			}
		}
		return strReturn;
	}

}

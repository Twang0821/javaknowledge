package cn.twang.javaknowledge.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: RegexTest
 * @Description: 关于正则表达式的测试使用
 * @author: Tyanao
 * @date: 2016年8月15日 下午3:43:46
 * @Copyright: 2016 www.tydic.com Inc. All rights reserved.
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
	 * <p>
	 * 将2个字符串与正则匹配
	 * </p>
	 *
	 * <pre>
	 * 案例	------	结果值
	 * </pre>
	 * 
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
				strReturn = "preSourceName:" + preSourceName + "curlSourceName:" + curlSourceName;
			}
		}
		return strReturn;
	}

	
	/**
	 * 对数字字符串排序	使用正则表达式的分割功能
	 * 	我有如下一个字符串:"91 27 46 38 50"
	 * 	请写代码实现最终输出结果是："27 38 46 50 91"
	 * 分析：
	 * 	A:定义一个字符串
	 * 	B:把字符串进行分割，得到一个字符串数组
	 * 	C:把字符串数组变换成int数组
	 *	D:对int数组排序
	 * 	E:把排序后的int数组在组装成一个字符串
	 * 	F:输出字符串
	 */
	public void regexTest() {
		// 定义一个字符串
		String s = "91 27 46 38 50";
		// 把字符串进行分割，得到一个字符串数组
		String[] strArray = s.split(" ");
		// 遍历数组
		for (int x = 0; x < strArray.length; x++) {
			System.out.println(strArray[x]);
		}
		// 把字符串数组变换成int数组
		int[] arr = new int[strArray.length];
		for (int x = 0; x < arr.length; x++) {
			arr[x] = Integer.parseInt(strArray[x]);
		}

		// 对int数组排序
		Arrays.sort(arr);

		// 把排序后的int数组在组装成一个字符串
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < arr.length; x++) {
			sb.append(arr[x]).append(" ");
		}
		// 转化为字符串
		String result = sb.toString().trim();// trim()去字符串的前后空格

		// 输出字符串
		System.out.println("result:" + result);
	}

}

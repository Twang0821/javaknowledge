package cn.twang.javaknowledge.regex;

import java.util.Scanner;


/**
 * 校验qq号码
 * 		1.要求必须是5-15位数字
 * 		2.0不能开头
 * 	分析：
 * 		A:键盘录入一个QQ号码
 * 		B:写一个功能实现校验
 * 		C:调用功能，输出结果。
 * ---------------------------------------------
 * 正则表达式：符合一定规则的字符串
 * 			规则：在java.util.regex包下的Pattern类中。
 * 
 * 	String类中的方法
 * 		public boolean matches(String regex) 告知调用此方法的字符串是否匹配给定的正则表达式    
 * 			eg:  qq.matches(regex);
 *		
 * 类Pattern是正则表达式的编译表示形式
 * 
 * @date: 2016年8月15日 下午2:47:32
 */
public class RegexDesign {
	
	public static void main(String[] args) {
		// 加上try...finally解决  Resource leak: 'sc' is never closed 资源没关闭问题
		Scanner sc=new	Scanner(System.in);
		try {
			//创建键盘录入对象
			System.out.println("请输入你的qq号码：");
			String qq = sc.nextLine();
			
			System.out.println("checkQQ:" + checkQQ(qq));
		} finally {
			sc.close();
		}
		
	}
	
	
	/**
	 * <p>	</p>  
	 * 
	 * <pre>
	 * </pre>
	 *
	 * @param qq
	 * @return
	 */
	public static boolean checkQQ(String qq) {
		// String regex ="[1-9][0-9]{4,14}";
		// //public boolean matches(String regex)告知此字符串是否匹配给定的正则表达式
		// boolean flag = qq.matches(regex);
		// return flag;

		//return qq.matches("[1-9][0-9]{4,14}");
		
		return qq.matches("[1-9]\\d{4,14}");
	}
	
}

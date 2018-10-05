package cn.twang.utils.commonUtils;

import cn.twang.bean.UserBean;

public class Test {
	
	public static void main(String[] args) {
		UserBean user = new UserBean();
		UserBean user2 = null;
		String tesStr = "";
		String tesStr2 = null;
		
		System.out.println("判断对象是否为null: " + ObjectUtils.isNullOrEmpty(user2));
		
		System.out.println("判断字符串是否为空: " + ObjectUtils.isNullOrEmpty(tesStr));
		
		System.out.println("判断字符串是否为null: " + ObjectUtils.isNullOrEmpty(tesStr2));
	}
	
}

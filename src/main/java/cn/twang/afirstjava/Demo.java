package cn.twang.afirstjava;	//Demo类在cn.twang.demo包下

import cn.twang.utils.firstUtils.Utils;

/**
 * @ClassName: Demo   
 * @Description:    
 * @author: Tyanao
 * @date: 2016年4月2日 下午10:44:27     
 * @Copyright: 2016 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class Demo {
	
	public static void main(String[] args) {
		System.out.println("helloword.java");
		
		//调用其它包中的类,则在上面要引入此类所在的包名直到所在java文件的类名。如:import cn.twang.utils.Utils
		Utils u = new Utils();
		u.fun();

	/******************************************************************************/	
		
		// 获取随机数，字符串连接符：+
		System.out.println("Random:" + Math.random());//Random:0.8057759524371092
		
		// 获取一个1-100之间的随机数
		System.out.println("Random:" + ((int) (Math.random() * 100) + 1));//Random:52		
		System.out.println("ss" + 22 + 5);	//ss225
	}

}

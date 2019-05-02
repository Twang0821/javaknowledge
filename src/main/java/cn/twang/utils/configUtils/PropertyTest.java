package cn.twang.utils.configUtils;

import java.util.Properties;

/**
 * @ClassName: PropertyTest   
 * @Description: 测试读取指定目录下所有properties配置文件   
 * @author: Tyanao
 * @date: 2017年5月2日 下午10:30:58     
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class PropertyTest {
	
	public static void main(String[] args) {
		
		//String path = System.getProperty("global.config.path", "/data/env");
		//System.out.println("lujing: " + path);
		
		//获取所有的属性
        Properties properties = System.getProperties();
        //遍历所有的属性
        for (String key : properties.stringPropertyNames()) {
            //输出对应的键和值
            System.out.println(key + "=" + properties.getProperty(key));
        }
		
	}

}

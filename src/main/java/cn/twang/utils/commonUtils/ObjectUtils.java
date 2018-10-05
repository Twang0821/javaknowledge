package cn.twang.utils.commonUtils;

import org.springframework.util.StringUtils;

/**
 * @ClassName:  ObjectUtils   
 * @Description: 对对象判断的一些工具方法
 * @author: Tyanao
 * @date:   2017年9月27日 下午4:10:59     
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
public class ObjectUtils {
	
	/**
	 * @Title: isNullOrEmpty   
	 * @Description: 使用第三方的工具类来判断类是否为空 
	 * @param: @param obj
	 * @param: @return      
	 * @return: Boolean      
	 * @throws
	 */
	public static Boolean isNullOrEmpty(Object obj) {
		//org.springframework.util.StringUtils 工具类
		return StringUtils.isEmpty(obj);
	}

}

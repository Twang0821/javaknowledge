package cn.twang.bean;

import lombok.Data;

/**
 * @ClassName:  UserBean   
 * @Description:公用测试bean  
 * @author: Tyanao
 * @date:   2018年9月27日 下午5:07:51     
 * @Copyright: 2018 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****有限公司内部传阅，禁止外泄以及用于其他的商业目
 */
@Data
public class UserBean {

	private String userId;
	private String userName;
	private int age;
	private String address;
}

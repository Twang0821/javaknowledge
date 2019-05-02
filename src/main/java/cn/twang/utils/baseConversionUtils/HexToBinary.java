package cn.twang.utils.baseConversionUtils;


/**
 * @ClassName: HexToBinary   
 * @Description: 进制转换 
 * @author: Tyanao
 * @date: 2017年5月2日 上午10:30:08     
 * @Copyright: 2017 www.tydic.com Inc. All rights reserved. 
 * 注意：本内容仅限于****内部传阅，禁止外泄以及用于其他的商业目
 */
public class HexToBinary {
	
	public static String hexStr = "0123456789ABCDEF";
	
	/**
	 * @Title: BinaryToHexString   
	 * @Description: 二进制转换为十六进制   
	 * @param bytes
	 * @return: String      
	 */
	public static String BinaryToHexString(byte[] bytes) {
		String result = "";
		String hex = "";
		
		for (int i = 0; i < bytes.length; i++) {
			// 字节高4位
			hex = String.valueOf(hexStr.charAt(bytes[i]&0xF0)>>4);
			// 字节低4位
			hex += String.valueOf(hexStr.charAt(bytes[i]&0x0F));
			result += hex;
		}
		return result;
	}

}

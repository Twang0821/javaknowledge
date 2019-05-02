package cn.twang.utils.baseConversionUtils;

public class HexToBinaryTest {
	
	public static void main(String[] args) {
		byte[] bytes = {1,1};
		
		System.out.println("-------将二进制数组转换成十六进制的字符串--------");
		String res = HexToBinary.BinaryToHexString(bytes);
		System.out.println(res);
	}

}

package cn.twang.utils.emojiUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * 	   判断字符串中是否包含emoji表情的正则表达式
 * @author Tyanao
 * @date: 2018年8月31日 上午11:01:25
 * @version 0.1
 */
public class EmojiUtils {
	
	public static void main(String[] args) {
		String str = "心存感激🌊，梦想高飞⛵";
		System.out.println(hasEmoji(str));
	}
	
	/**
	 * 判断字符串中是否包含emoji表情的正则表达式
	 * @param content
	 * @return
	 */
	public static boolean hasEmoji(String content){

	    Pattern pattern = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]");
	    Matcher matcher = pattern.matcher(content);
	    if(matcher .find()){
	        return true;    
	    }
	        return false;
	}
}

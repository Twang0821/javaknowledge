package cn.twang.utils.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * 
 * @author Tyanao
 * @date: 2018年5月29日 上午10:15:23
 * @version
 */
public class DateUtils {

	public static void main(String[] args) {
		String date = "2018-05-23T00:00:45.628Z"; 
		date = date.replace("Z", " UTC");//注意是空格+UTC
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");//注意格式化的表达式
		
		Date d = new Date();
		try {
			d = format.parse(date );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(d);
        System.out.println(str);
	}
	
	/**
	 * 
	 * @param UTCString
	 * @return
	 */
	public String UTCStringtODefaultString(String UTCString) {
		try{
		UTCString = UTCString.replace("Z", " UTC");
		SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
		SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = utcFormat.parse(UTCString);
		return defaultFormat.format(date);
		} catch(ParseException pe)
		{
		pe.printStackTrace();
		return null;
		}
		}

}

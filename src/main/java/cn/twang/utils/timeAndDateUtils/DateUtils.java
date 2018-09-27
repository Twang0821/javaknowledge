package cn.twang.utils.timeAndDateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Description
 * 	   
 * @author Tyanao
 * @date: 2018年5月29日 下午2:50:05
 * @version 0.1
 */
public class DateUtils {

	public static void main(String[] args) {
		/*String date = "2018-05-23T00:00:45.628Z"; 
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
        System.out.println(str);*/
		
		//String ss = changemilliSecondsToDate(1528905591000L);
		//System.out.println(ss);
		
		//System.out.println(changeSecondsToDate(1528905591));
		
		String ss = UTCStringtODefaultString("2018-06-28T19:00:01.820Z");
		System.out.println("sdf: " + ss);
		
	}
	
	
	/**
	 * 
	 * @param UTCString
	 * @return
	 */
	public static String UTCStringtODefaultString(String UTCString) {
		try {
			UTCString = UTCString.replace("Z", " UTC");
			SimpleDateFormat utcFormat = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			SimpleDateFormat defaultFormat = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			Date date = utcFormat.parse(UTCString);
			return defaultFormat.format(date);
		} catch (ParseException pe) {
			pe.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * Unix时间戳(Unix timestamp)有两种，一种以秒为单位，另一种以毫秒为单位。
	 * 	秒为单位是10位数；毫秒为单位是13位数；
	 * http://tool.chinaz.com/Tools/unixtime.aspx
	 * 将毫秒换算成日期
	 * @param milliSecondsValue
	 * @return
	 */
	public static String changemilliSecondsToDate(Long milliSecondsValue) {
		String st = "1528754391638";//1528905591000
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String time = dateFormat.format(new Date(milliSecondsValue));
		return time;
	}
	
	/**
	 * 将秒(时间戳)转换成日期
	 * @param secondsValue
	 * @return
	 */
	public static String changeSecondsToDate(int seconds) {
		
		 //时间总的秒数  
        //int seconds = 30654;  
        //开始时间  
        int startHours = seconds/3600;  
        int startMinutes = (seconds%3600)/60;  
        int startSeconds = (seconds%3600)%60;  
          
        Calendar cal=Calendar.getInstance();//使用日历类  
        SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//时间格式  
          
        //时间：yyyy-MM-dd HH:mm:ss  
        String startDateStr = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH)+1)  
                   + "-" + cal.get(Calendar.DAY_OF_MONTH) + " " + startHours  
                   + ":" + startMinutes + ":" + startSeconds;  
        System.out.println("时间：" + startDateStr);
        
        return startDateStr;
	}
	

}

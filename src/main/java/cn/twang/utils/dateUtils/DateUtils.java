package cn.twang.utils.dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * 	SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
 * 		format.parse(String date )  将字符串日期转换(解析)为Date类型的日期
 * 		format.format(Date date )  将Date类型的日期转换(格式化)为String类型的日期
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
			e.printStackTrace();
		}
		
		String str = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(d);
        System.out.println(str);
	}
	
	
	/** <p>通用标准时间添加8小时转换为北京时间</p>  
	 * 
	 * 中国的时区为"东八区"，因此与中国相差八小时的时区为“中时区”
	 * UTC 通用标准时，以z来标识,转换成北京时间需要加8小时
	 * http://www.028888.net/archives/2016_01_716.html
	 * <pre>
	 * UTCStrDateTimeToDefaultString("2018-05-23T00:00:45.628Z")	= 2018-05-23 08:00:45
	 * </pre>
	 *
	 * @param UTCString
	 * @return      
	 */
	public String UTCStrDateTimeToDefaultString(String UTCStrDateTime) {
		
		SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String resDateTimeStr = null;
		try {
			UTCStrDateTime = UTCStrDateTime.replace("Z", " UTC"); // 注意是空格+UTC
			SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
			Date date = utcFormat.parse(UTCStrDateTime);
			resDateTimeStr = defaultFormat.format(date);
		} catch (ParseException pe) {
			pe.printStackTrace();
			return null;
		}
		return resDateTimeStr;
	}
	
	
	/**
	 * <p>根据给定的日期及时间间隔天数获取想要的日期</p>  
	 * 
	 * <pre>
	 * getNextDay("2019-05-07", 1)			= 2019-05-08
	 * getNextDay("2019-05-07", -1)			= 2019-05-06
	 * </pre>
	 *
	 * @param startDate 基准日期
	 * @param days 间隔天数,正数是获取基准日期之后的第days天的日期;
	 * 					      负数是获取基准日期之前的第days天的日期;
	 * @return
	 */
	public static String getNextDay(String startDate, int days) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Calendar calendar = new GregorianCalendar();
		try {
			date = formatter.parse(startDate);
			calendar.setTime(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//calendar.add(calendar.DATE, -1);// 把日期往后增加一天.整数往后推,负数往前移动
		calendar.add(Calendar.DATE, days);

		date = calendar.getTime(); // 这个时间就是基准日期改动days天后的结果 
		String dateString = formatter.format(date);
		return dateString;
	}
	
	
	/**
	 * <p>将毫秒换算成日期</p>
	 * 
	 * Unix时间戳(Unix timestamp)有两种，一种以秒为单位，另一种以毫秒为单位.
	 * 	秒为单位是10位数；毫秒为单位是13位数;
	 * http://tool.chinaz.com/Tools/unixtime.aspx
	 * 
	 * <pre>
	 * changemilliSecondsToDate(1528754391638, null)		= 2018-06-12 05:59:51
	 * </pre>
	 *
	 * @param millisecond 毫秒
	 * @param strMillisecond 毫秒--字符串类型  与上面的只是入参类型不同
	 * @return 字符串类型的 年月日 时分秒, 如: 2018-06-12 05:59:51
	 */
	public static String changeMilliSecondsToDate(Long millisecond, String strMillisecond) {
//		String st = "1528754391638";//1528905591000
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = "";
		
		if (StringUtils.isNotBlank(strMillisecond)) {
			time = dateFormat.format(new Date(Long.valueOf(strMillisecond)));
		} else {
			time = dateFormat.format(new Date(millisecond));
		}
		
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

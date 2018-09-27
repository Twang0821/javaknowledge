package cn.twang.utils.xmlUtils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;




/**
 * @ClassName: XmlToJson
 * @Description:
 *		org.json包的使用:
 *			用org.json包读取XML配置文件，转成JSON格式的字符串
 *			
 * @author:Twangrentao 
 * @date: 2018年2月7日上午12:00:58
 */
public class XmlToJson {
	
	
	/**
	 * @Description:
	 * 		读取XML文件，将XML文件里的数据转成JSON格式的字符串或对象
	 * @Param: @param fileName  这里fileName用final来修饰，是防止方法参数在调用时被篡改;
	 * @Param: @return
	 * @Param: @throws JSONException
	 * @Param: @throws IOException
	 * @date: 2018年2月7日
	 */
	public static String xml2JsonString(final String fileName) throws JSONException, IOException {
		/**
		 * 静态方法不与特定实例关联，不能引用this，所以要直接用类名
		 */
        //InputStream in = XmlToJson.class.getResourceAsStream("/SidePaymentResponse.xml");
		String endFileName = "/" + fileName; //通过字符串拼接，传进来的文件名参数前不需要加根路径
		InputStream in = XmlToJson.class.getResourceAsStream(endFileName);
        if(in == null) {
        	throw new RuntimeException("配置文件" + fileName + "不存在");
        }
        String xml = IOUtils.toString(in, "UTF-8");
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        
        return xmlJSONObj.toString();
    }
	
	
	/**
	 * 测试上面的读取XML文件转成JSON
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "SidePaymentResponse.xml";
		
		String resString = null;
		try {
			resString = xml2JsonString(fileName);
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(resString);
	}
}

package cn.twang.javaknowledge.xmltojson;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;




/**
 * 	 读取xml文件，转换成json格式数据
 * @author 作者 E-mail:
 * @date 2018年2月3日 下午5:29:44
 * @version
 */
public class XmlToJson {
	
	@SuppressWarnings("deprecation")
	public static String xml2jsonString() throws JSONException, IOException {
        InputStream in = XmlToJson.class.getResourceAsStream("/SidePaymentResponse.xml");
        String xml = IOUtils.toString(in);
        JSONObject xmlJSONObj = XML.toJSONObject(xml);
        
        //System.out.println(xmlJSONObj);
        return xmlJSONObj.toString();
    }
	
	
	/**
	 * 测试上面的读取xml文件转成json
	 * @param args
	 */
	public static void main(String[] args) {
		String string = null;
		System.out.println("hello word");
		
		try {
			string = xml2jsonString();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(string);
	}
}

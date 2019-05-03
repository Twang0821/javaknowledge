package cn.twang.javaknowledge.xmltojson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import net.sf.json.xml.XMLSerializer;

import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;




/**
 * 	 读取xml文件，转换成json格式数据
 * @author 作者 E-mail:
 * @date 2018年2月3日 下午5:29:44
 * @version
 */
public class HttpAndXmlToJson {
	//private static Logger logger = Logger.getLogger(HttpAndXmlToJson.class);
	
	@SuppressWarnings("deprecation")
	public static String xml2jsonString() throws JSONException, IOException {
        InputStream in = HttpAndXmlToJson.class.getResourceAsStream("/testFinancialAgencyacctData.xml");
        String xml = IOUtils.toString(in);
        
        
        //http://blog.csdn.net/lom9357bye/article/details/53291994
        XMLSerializer xmlSerializer = new XMLSerializer(); 
        
       // JSONObject xmlJSONObj = XML.toJSONObject(xml);
       String ss = xmlSerializer.read(xml).toString();
       // System.out.println(ss);
        
        //System.out.println(xmlJSONObj);
      //  return xmlJSONObj.toString();
       return ss;
    }
	
	
	/**
	 * 测试上面的读取xml文件转成json
	 * @param args
	 * @throws IOException 
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException, IOException {
		/*String string = null;
		System.out.println("hello word");
		
		try {
			string = xml2jsonString();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(string);*/
		
		String ss = xml2jsonString();
		System.out.println(ss);
		String endStr = "{\"Service\" "+ ":" + ss + "}"; 
		//String ss = "";
		System.out.println("发送内容：" + endStr);
		com.alibaba.fastjson.JSONObject object = com.alibaba.fastjson.JSONObject.parseObject(ss);
		com.alibaba.fastjson.JSONObject jjJsonObject = invokingFinancialAgencyDynamicAccountMonitorRes(endStr);
		System.out.println(jjJsonObject.toJSONString());
		
	}
	
	
	@SuppressWarnings("deprecation")
	private static  com.alibaba.fastjson.JSONObject invokingFinancialAgencyDynamicAccountMonitorRes(String jsonObj) {

		HttpPost post = null;
		String reString = null;
		String url = "http://10.6.2.105:2141";
		
		try {
	        //HttpClient httpClient = new DefaultHttpClient();
			CloseableHttpClient httpClient = HttpClients.createDefault();

	        // 设置超时时间
	       // httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 2000);
	        //httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 2000);
	            
	        post = new HttpPost(url);
	        // 构造消息头
	       // post.setHeader("Content-type", "application/json; charset=utf-8");
	        //post.setHeader("Connection", "Close");
//	        String sessionId = getSessionId();
//	        post.setHeader("SessionId", sessionId);
//	        post.setHeader("appid", appid);
	      
	        
	        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(2000).setConnectTimeout(2000).build();
	        post.setConfig(requestConfig);
	        
	        
	        // 构建消息实体
	        StringEntity entity = new StringEntity(jsonObj, Charset.forName("UTF-8"));
	        entity.setContentEncoding("UTF-8");
	        // 发送Json格式的数据请求
	        entity.setContentType("application/json");
	        post.setEntity(entity);
	            
	        //HttpResponse response = httpClient.execute(post);
	        CloseableHttpResponse response = httpClient.execute(post);
	            
	        // 检验返回码
	        int statusCode = response.getStatusLine().getStatusCode();
	        if(statusCode != HttpStatus.SC_OK){
	           // LogUtil.info("请求出错: "+statusCode);	
	        	//logger.info("请求出错: "+statusCode);
	            //isSuccess = false;
	        }else{
	            int retCode = 0;
	            String sessendId = "";
	            // 返回码中包含retCode及会话Id
	            for(Header header : response.getAllHeaders()){
	                if(header.getName().equals("retcode")){
	                    retCode = Integer.parseInt(header.getValue());
	                }
	                if(header.getName().equals("SessionId")){
	                    sessendId = header.getValue();
	                }
	            }
	            
	            
	            //获取返回实体
	            HttpEntity entity2 = response.getEntity();
	            reString = EntityUtils.toString(entity2, "utf-8");//一次之后entity里的值就没了
	            System.out.println("返回内容：" + reString);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }finally{
	        if(post != null){
	            try {
	                post.releaseConnection();
	                Thread.sleep(500);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		com.alibaba.fastjson.JSONObject rr = com.alibaba.fastjson.JSONObject.parseObject(reString);
		
		
		return rr;
	}
}

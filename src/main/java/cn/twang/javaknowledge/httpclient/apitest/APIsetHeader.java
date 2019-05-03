package cn.twang.javaknowledge.httpclient.apitest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * 	 1.模拟浏览器发送请求去访问网站
 * 	 2.获取响应头信息
 * @author 作者 E-mail:
 * @date 2017年2月23日 下午3:40:49
 * @version 
 * 	1.模拟浏览器发送请求去访问网站
 *  2.获取响应头信息
 */
public class APIsetHeader {
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault(); // 创建httpClient实例
		//HttpGet httpGet = new HttpGet("http://central.maven.org/maven2/HTTPClient/HTTPClient/0.3-3/HTTPClient-0.3-3.jar");
		HttpGet httpGet = new HttpGet("http://www.tuicool.com/");
		
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:50.0) Gecko/20100101 Firefox/50.0");
		
		CloseableHttpResponse response = null;
		response = httpClient.execute(httpGet);// 执行http get请求
		
		HttpEntity entity = response.getEntity();//获取返回实体
		
		//获取响应头:Content-Type,获取响应状态Status
		System.out.println("Content-Type:" + entity.getContentType().getValue());
		System.out.println("Status:"+response.getStatusLine());//response.getStatusLine().getStatusCode()
		
		//System.out.println("网页内容："+EntityUtils.toString(entity, "utf-8")); // 获取网页内容
		//关闭资源
		response.close();
		httpClient.close();
	}

}

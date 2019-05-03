package cn.twang.javaknowledge.httpclient;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


/**
 * httpclient入门
 * @author Tyanao0821
 * @date: 2017年2月23日 上午11:13:03
 */
public class HelloWord {
	
	public static void main(String[] args) {
		CloseableHttpClient httpClient = HttpClients.createDefault();//创建httpclient实例
		//HttpGet httpGet = new HttpGet("http://www.open1111.com");//创建httpget实例
		HttpGet httpGet = new HttpGet("https://www.baidu.com/home/news/data/newspage?nid=12200638063820682796&n_type=0&p_from=1");//csdn.net
		
		CloseableHttpResponse response = null;		
		try {
			response = httpClient.execute(httpGet);// 执行http get请求
		} catch (ClientProtocolException e) { // http协议异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { // io异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpEntity entity = response.getEntity();//获取返回实体(其中包括：)
		
		String strContent = null;
		try {
			strContent = EntityUtils.toString(entity, "utf-8");//获取网页内容
		} catch (ParseException e) { //解析异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) { //io异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//打印获取的网页内容
		System.out.println("网页内容：" + strContent);
		
		//关闭资源
		try {
			response.close(); //response关闭
		} catch (IOException e) { //io异常
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			httpClient.close(); //httpClient关闭
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

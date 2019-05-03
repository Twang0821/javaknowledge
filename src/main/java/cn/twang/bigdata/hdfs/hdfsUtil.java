package cn.twang.bigdata.hdfs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;

import org.apache.commons.io.IOUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;



/**
 * @author 作者 E-mail:
 * @date 2017年4月6日 上午11:12:52
 * @version 
 */
public class hdfsUtil {
	
	FileSystem fs = null;

	
	@Before
	public void init() throws Exception{
		
		//读取classpath下的xxx-site.xml 配置文件，并解析其内容，封装到conf对象中
		Configuration conf = new Configuration();
		
		//也可以在代码中对conf中的配置信息进行手动设置，会覆盖掉配置文件中的读取的值
		conf.set("fs.defaultFS", "hdfs://weekend110:9000/");
		
		//fs = FileSystem.get(conf);//可以在这里设置jvm运行时候的用户名，示例如下：
		
		//根据配置信息，去获取一个 具体文件系统的客户端操作实例对象
		fs = FileSystem.get(new URI("hdfs://weekend110:9000/"),conf,"hadoop");//以hadoop用户的名义
				
	}
	
	
	
	/**
	 * 上传文件，比较底层的写法
	 * 
	 * @throws Exception
	 */
	@Test
	public void upload() throws Exception {	
					
		Path dst = new Path("hdfs://weekend110:9000/qingshu.txt");
		
		FSDataOutputStream os = fs.create(dst);
		
		FileInputStream is = new FileInputStream("f:/loverletter.txt");
		
		IOUtils.copy(is, os);
		

	}

	
	/**
	 * 上传文件，封装好的写法
	 * @throws Exception
	 * @throws IOException
	 */
	@Test
	public void upload2() throws Exception, IOException{
		
		fs.copyFromLocalFile(new Path("f:/loverletter.txt"), new Path("hdfs://weekend110:9000/aa/qingshu2.txt"));
		
	}
	
	
	/**
	 * 下载文件
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void download() throws Exception{
		
		//fs.copyToLocalFile(new Path("hdfs://weekend110:9000/qingshu2.txt"), new Path("f:/hadoopfile/qingshu2.txt"));//会报错
		/**
		 * copyToLocalFile(path_hdfs,local_path);直接这样用在windows下由于默认没有使用本地文件系统(可能会改成linux下的本地文件系统)导致windows下错误，
		 * 所以需要添加两个参数变成:
		 * 第一个表示是否删除path_hdfs的文件，最后一个是否使用本地文件系统。
		 */
		fs.copyToLocalFile(false,new Path("hdfs://weekend110:9000/qingshu2.txt"), new Path("f:/hadoopfile/qingshu.txt"),true);
		
	}
	
	/**
	 * 查看文件信息
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 * @throws FileNotFoundException 
	 * 
	 */
	@Test
	public void listFiles() throws FileNotFoundException, IllegalArgumentException, IOException {

		// listFiles()方法 列出的是文件信息，而且提供递归遍历
		RemoteIterator<LocatedFileStatus> files = fs.listFiles(new Path("/"), true);
		
		while(files.hasNext()){
			
			LocatedFileStatus file = files.next();
			Path filePath = file.getPath();
			String fileName = filePath.getName();
			System.out.println(fileName);
			
		}
		
		System.out.println("---------------------------------");
		
		//listStatus()方法 可以列出文件和文件夹的信息，但是不提供自带的递归遍历
		FileStatus[] listStatus = fs.listStatus(new Path("/"));
		for(FileStatus status: listStatus){
			
			String name = status.getPath().getName();
			System.out.println(name + (status.isDirectory()?" is dir":" is file"));
			
		}
		
	}
	
	
	/**
	 * 创建文件夹
	 * @throws Exception 
	 * @throws IllegalArgumentException 
	 */
	@Test
	public void mkdir() throws IllegalArgumentException, Exception {

		fs.mkdirs(new Path("/aaa/bbb/ccc"));
				
	}
	
	
	
	
	public static void main(String[] args) throws IOException {
		
		/**
		 * 上传文件，比较底层的写法
		 * 	注意运行时要用 run configuration
		 */
		Configuration conf = new Configuration();
		conf.set("fs.defaultFS", "hdfs://weekend110:9000/");
		
		FileSystem fs = FileSystem.get(conf);
		
		Path dst = new Path("hdfs://weekend110:9000/qingshu3.txt");
		
		FSDataOutputStream os = fs.create(dst);
		
		FileInputStream is = new FileInputStream("f:/loverletter.txt");
		
		IOUtils.copy(is, os);
		
	}

}

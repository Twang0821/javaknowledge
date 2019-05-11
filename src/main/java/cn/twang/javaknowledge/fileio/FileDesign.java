package cn.twang.javaknowledge.fileio;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 我们要想实现IO的操作，就必须知道硬盘上文件的表现形式。
 * 而Java就提供了一个类File供我们使用。
 * 
 * File:文件和目录(文件夹)路径名的抽象表示形式
 * 构造方法：
 * 		File(String pathname)：根据一个路径得到File对象
 * 		File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
 * 		File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象
 * 成员方法：
 * 		public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
 *		public boolean mkdir():创建文件夹 如果存在这样的文件夹，就不创建了，即单级文件夹
 *		public boolean mkdirs():创建文件夹,如果父文件夹不存在，会帮你创建出来,即多级文件夹
 *
 *	注意：你到底要创建文件还是文件夹，你最清楚，方法不要调错了。
 *
 *  获取功能：
 *	 public String getAbsolutePath()：获取绝对路径
 * 	 public String getPath():获取相对路径
 *	 public String getName():获取名称
 *	 public long length():获取长度。字节数
 *	 public long lastModified():获取最后一次的修改时间，毫秒值
 *
 *	 public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
 *	 public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组,File的对象又可以拿路径等其他东西
 *
 * @date: 2016年8月22日 下午10:20:34
 */
public class FileDesign {
	
	public static void main(String[] args) {
		/*File file = new File("e:\\demo");
		System.out.println("mkdir:" + file.mkdir());
		
		File file7 = new File("e:\\aaa\\bbb\\ccc\\ddd");
		System.out.println("mkdirs:" + file7.mkdirs());
		*/
		
		// 创建文件对象
		File file = new File("demo\\test.txt");

		System.out.println("getAbsolutePath:" + file.getAbsolutePath());
		System.out.println("getPath:" + file.getPath());
		System.out.println("getName:" + file.getName());
		System.out.println("length:" + file.length());
		System.out.println("lastModified:" + file.lastModified());

		// 1416471971031---毫秒值
		Date d = new Date(1416471971031L);//构造方法得到毫秒值的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = sdf.format(d);
		System.out.println(s);
		
		System.out.println("----------------------------------------------");
		
		// 指定一个目录
		File file1 = new File("e:\\");

		// public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
		String[] strArray = file1.list();
		for (String ss : strArray) {
			System.out.println(ss);
		}
		System.out.println("------------");
		// public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
		File[] fileArray = file1.listFiles();
		for (File f : fileArray) {
			System.out.println(f.getName());
		}
	}

}

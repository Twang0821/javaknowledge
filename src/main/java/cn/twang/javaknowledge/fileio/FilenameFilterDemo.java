package cn.twang.javaknowledge.fileio;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称 方法A:先获取所有的，然后遍历的时候，依次判断，如果满足条件就输出。
 * 方法B:获取的时候就已经是满足条件的了，然后输出即可。
 * 
 * 要想实现这个效果，就必须学习一个接口：文件名称过滤器 public String[] list(FilenameFilter filter) public
 * File[] listFiles(FilenameFilter filter)
 * 
 * 
 * @date: 2016年8月22日 下午9:25:10
 */
public class FilenameFilterDemo {
	public static void main(String[] args) {
		// 封装e判断目录
		File file = new File("e:\\");

		// 获取该目录下所有文件或者文件夹的String数组 public String[] list(FilenameFilter filter)
		String[] strArray = file.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				// return false;
				// return true;
				// 通过这个测试，我们就知道了，到底把这个文件或者文件夹的名称加不加到数组中，取决于这里的返回值是true还是false
				// 所以，这个的true或者false应该是我们通过某种判断得到的
				// System.out.println(dir + "---" + name);
				// File file = new File(dir, name);//File的第三种构造方法
				// // System.out.println(file);
				// boolean flag = file.isFile();
				// boolean flag2 = name.endsWith(".jpg");
				// return flag && flag2;
				return new File(dir, name).isFile() && name.endsWith(".jpg");
			}
		});

		// 遍历
		for (String s : strArray) {
			System.out.println(s);
		}
	}
}

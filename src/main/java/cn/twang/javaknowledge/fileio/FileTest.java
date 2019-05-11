package cn.twang.javaknowledge.fileio;

import java.io.File;
import java.io.IOException;

/**
 *  注意：
 * 		A:如果你创建文件或者文件夹忘了写盘符路径，那么，默认在项目路径下。
 * 		B:Java中的删除不走回收站。
 * 		C:要删除一个文件夹，请注意该文件夹内不能包含文件或者文件夹
 * @author pc
 *
 *	 重命名功能:public boolean renameTo(File dest)
 * 		1.如果路径名相同，就是改名。
 * 		2.如果路径名不同，就是改名并剪切。
 * 
 * 路径以盘符开始：绝对路径		c:\\a.txt
 * 路径不以盘符开始：相对路径	a.txt
 * 
 * @date: 2016年8月22日 下午2:25:10
 */
public class FileTest {
	
	public static void main(String[] args) throws IOException {
		/* 创建文件
		 * File file = new File("e:\\a.txt");
		 * System.out.println("createNewFile:" + file.createNewFile());
		 * 
		 */
		// 我不小心写成这个样子了
		File file = new File("a.txt");
		System.out.println("createNewFile:" + file.createNewFile());
		
		// 继续玩几个
		File file2 = new File("aaa\\bbb\\ccc");
		System.out.println("mkdirs:" + file2.mkdirs());

		// 删除功能：我要删除a.txt这个文件
		File file3 = new File("a.txt");
		System.out.println("delete:" + file3.delete());

		// 删除功能：我要删除ccc这个文件夹
		File file4 = new File("aaa\\bbb\\ccc");
		System.out.println("delete:" + file4.delete());

		// 删除功能：我要删除aaa文件夹
		// File file5 = new File("aaa");
		// System.out.println("delete:" + file5.delete());

		File file6 = new File("aaa\\bbb");
		File file7 = new File("aaa");
		System.out.println("delete:" + file6.delete());//删除bbb文件夹
		System.out.println("delete:" + file7.delete());
		
		System.out.println("-----------------------------------------------");
		
		//重命名功能
		//创建一个文件对象
		File file11 = new File("林青霞.jpg");
		File newfile = new File("东方不败.jpg");
		System.out.println("renameTo:" +file11.renameTo(newfile));
		
	}
	
}

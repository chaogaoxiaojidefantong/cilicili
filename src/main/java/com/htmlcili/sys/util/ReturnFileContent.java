package com.htmlcili.sys.util;

import java.io.BufferedInputStream;

import java.io.File;
import java.io.FileInputStream;


/**
 * 
 * @author ylw
 *
 */
	public class ReturnFileContent {
/**
 * 用来读取utf-8文件
 * @param filename 传进文件名
 * @return 用string返回文本的类型
 */
	public static String readfileutf8(String filename) {
	File file=new File(filename);
	BufferedInputStream bi=null;
	FileInputStream f1=null;
	try {	
		
		f1=new FileInputStream(file);
		bi=new BufferedInputStream(f1);
		byte b1[]=new byte[1080*10];
		int b=-1;
		StringBuffer s1=new StringBuffer();
		
		while((b=bi.read(b1))!=-1) {				
			String c1=new String(b1,"utf-8");
			s1.append(c1);
			b1=new byte[1080*10];
		}	
		return s1.toString();
	} catch (Exception e) {
//		System.out.println("文件不存在");
		e.printStackTrace();
		
	}
	finally {
		InOutIOClose.closeInOutIO(bi,null);
		InOutIOClose.closeInOutIO(f1, null);
	}
	return null;
}
	/**
	 * 用来读取gbk文件
	 * @param filename 传进文件名
	 * @return 用string返回文本的类型
	 */
	public static String readfilegbk(String filename) {
	File file=new File(filename);
	BufferedInputStream bi=null;
	FileInputStream f1=null;
	try {	
		
		f1=new FileInputStream(file);
		bi=new BufferedInputStream(f1);
		byte b1[]=new byte[1080*10];
		int b=-1;
		StringBuffer s1=new StringBuffer();
		
		while((b=bi.read(b1))!=-1) {				
			String c1=new String(b1,"gbk");
			s1.append(c1);
			b1=new byte[1080*10];
		}	
		return s1.toString();
	} catch (Exception e) {
		System.out.println("文件不存在");
		
	}
	finally {
		InOutIOClose.closeInOutIO(bi,null);
		InOutIOClose.closeInOutIO(f1, null);
	}
	return null;
}
	
}

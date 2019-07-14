package com.htmlcili.sys.util;
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import com.sun.org.apache.bcel.internal.generic.RETURN;



public class FileUtil {
	
	
	/**
	 * 
	 * @param 要操作的文件
	 * @param 要写进的文件的内容
	 */
	public static void  writein(File file,String content) {
		FileOutputStream f1=null;
		PrintWriter p1=null;
		try {
			f1 = new FileOutputStream(file);
			p1=new PrintWriter(new BufferedWriter(new OutputStreamWriter(f1,"utf-8")));
			p1.write(content);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		finally {
			InOutIOClose.closewriterandreader(null,p1);
			InOutIOClose.closeInOutIO(null,f1);
		}
	}
	
	public static void readfile(File file) {
		BufferedReader b1=null;
		try {
			String message=null;
			b1=new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
			while((message=b1.readLine())!=null) {
				System.out.println(message);				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			InOutIOClose.closewriterandreader(b1,null);
		}
		
		
	}
	
}

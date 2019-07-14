package com.htmlcili.sys.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class InOutIOClose {
/**
 * 
 * @param i1  要关闭的输入流
 * @param o1  要关闭的输出流
 */
public static void  closeInOutIO(InputStream i1,OutputStream o1) {
	try {
		if(i1!=null) {
			i1.close();
		}
		if(o1!=null) {
			o1.close();			
		}		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		i1=null;
		o1=null;
	}
}
	/**
	 * 
	 * @param 要关闭的字符输入流
	 * @param 要关闭的字符输出流
	 */
	public static void closewriterandreader(Reader r1,Writer w1) {
		try {
			if(r1!=null) {
				r1.close();
			}
			if(w1!=null) {
				w1.close();			
			}		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			r1=null;
			w1=null;
		}
	}
}

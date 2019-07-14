	package com.htmlcili.sys.util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.Spring;

public class IdJointUtil {
	
	
	public String getjoinStringid(List<String>ids) {
		StringBuilder b1=new StringBuilder("");
		for(int i=0;i<ids.size()-1;i++) {
			b1.append(ids.get(i)+",");
		}
		b1.append(ids.get(ids.size()-1));
		return b1.toString();
	}
	
	/**
	 * 将String型的字符串格式为2,3,4,5,6传到这个方法转为list集合
	 * @param ids
	 * @param 传Integer或者Long的字节码
	 * @return
	 */
	public static List getlistid(String ids,Class<?>cls) {		
		String []v1=ids.split(",");
		List<Integer>id2=new ArrayList<>();
		List<Long>id3=new ArrayList<>();
		System.out.println(cls.getSimpleName());
		if(cls.getSimpleName().equals("Integer")) {			
			for(String vv:v1) {
				int id=Integer.parseInt(vv);
				id2.add(id);
			}	
			return id2;
		}else if(cls.getSimpleName().equals("Long")){
			for(String vv:v1) {
				long id=Long.parseLong(vv);
				id3.add(id);
			}
			return id3;
		}	
	return null;		
	}

	}

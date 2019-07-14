	package com.htmlcili.sys.util;

import java.util.HashMap;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.htmlcili.sys.entity.Fiction;



public class GetOneFictionByFictionIdUtil {
	
	/**
	 * 此方法通过String型的fictionid获得这个id相对的书籍
	 * @param request
	 * @param fictionid
	 * @return
	 */
	public static Fiction getfiction(HttpServletRequest request,String fictionid) {
		long fictionid1=Long.parseLong(fictionid);
		Map map=(HashMap<Long,Fiction>)request.getServletContext().getAttribute("allfiction");
		Fiction fiction=(Fiction) map.get(fictionid1);
		System.out.println(fiction.getFictionname()+"fictionname");
		return fiction;
	}
}
	
	

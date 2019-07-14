package com.htmlcili.sys.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.entity.Fiction;

public interface FictionService {
	public PageObject getcatelog(HttpServletRequest request);
	public List<Fiction> fictionrank();
	List<String>watch(HttpServletRequest request);
	List<Fiction>selectfiction(String searchcontent);	
	public void savehistory(HttpServletRequest request,String fictionid);
}

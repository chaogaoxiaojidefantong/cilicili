package com.htmlcili.sys.listener;

import java.util.HashMap;

import java.util.List;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.htmlcili.sys.dao.FictionDao;
import com.htmlcili.sys.entity.Fiction;
import com.htmlcili.sys.util.GetBeanUtil;


public class SeListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {				
	GetBeanUtil<FictionDao>gg=new GetBeanUtil<FictionDao>();		
	FictionDao dao=gg.getBeanObject("fictionDao",FictionDao.class,"spring-configs.xml");
	List<Fiction>list=dao.selectAllFictionByClick();	
	sce.getServletContext().setAttribute("path",sce.getServletContext().getContextPath());
	HashMap<Long,Fiction>map=new HashMap<>();
	for(Fiction v:list) {
		long fictionid=v.getFictionid();		
		map.put(fictionid,v);
	}			
	sce.getServletContext().setAttribute("allfiction",map);	
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}

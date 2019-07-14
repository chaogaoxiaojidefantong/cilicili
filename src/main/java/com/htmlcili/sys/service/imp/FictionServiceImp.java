	package com.htmlcili.sys.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htmlcili.common.exception.ServiceException;
import com.htmlcili.common.vo.JsonResult;
import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.dao.FictionDao;
import com.htmlcili.sys.entity.Fiction;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.FictionService;
import com.htmlcili.sys.util.UserUtil;
import com.htmlcili.sys.util.GetOneFictionByFictionIdUtil;
import com.htmlcili.sys.util.ReturnFileContent;


@Service
public class FictionServiceImp implements FictionService{
	
	@Autowired
	private FictionDao dao=null;

	@Override
	public PageObject getcatelog(HttpServletRequest request) {		
		String fictionid=request.getParameter("fictionid");			
		String content=ReturnFileContent.readfileutf8(request.getServletContext().getRealPath("/fictiontxt/"+fictionid+".txt"));
		String contents[]=content.split("\\s+");
		System.out.println(contents.length+"contentslength");
		int chapter=(contents.length-1)/10+1;//有多少章
		System.out.println(chapter+"chapter");
		HashMap map=(HashMap<Long, Fiction>)request.getServletContext().getAttribute("allfiction");		
		Fiction fiction=(Fiction) map.get(Long.parseLong(fictionid));
		//操作点击率
		long click=fiction.getClick();
		click++;
		fiction.setClick(click);		
		map.put(Long.parseLong(fictionid),fiction);					
		PageObject pageObject=new PageObject();
		Integer pageSize=pageObject.getPageSize();//每页的记录数
		Integer pageCount=(chapter-1)/pageSize+1;		
		System.out.println(pageCount+"pagecount");//
		pageObject.setPageCount(pageCount);		
		pageObject.setRows(chapter);
		List<Fiction>list=new ArrayList<Fiction>();
		list.add(fiction);
		pageObject.setRecords(list);		
		savehistory(request,fictionid);//保存浏览记录
		return pageObject;
		}
	@Override
	public List<Fiction> fictionrank() {
		List<Fiction>list=dao.selectAllFictionByClick();
		if(list.size()<1) {
			throw new ServiceException("服务器内部出错");
		}
		List<Fiction>lists=new ArrayList<Fiction>();
		
		for(int i=0;i<10;i++) {
			lists.add(list.get(i));
		}
		return lists;	
	}
	
	public List<String>watch(HttpServletRequest request){
		String fictionid=request.getParameter("fictionid");		
		String page=request.getParameter("page");
		System.out.println(page+"pagehaha");
		String content=ReturnFileContent.readfileutf8(request.getServletContext().getRealPath("/fictiontxt")+"/"+fictionid+".txt");
		String contents[]=content.split("\\s+");
		System.out.println(contents.length+"len");
		int pagestart=(Integer.parseInt(page)-1)*10;
		ArrayList<String>list=new ArrayList<>();
		if(contents.length-pagestart<20) {
			int oo=contents.length-pagestart;
			for(int i=0;i<oo;i++) {
				list.add(contents[pagestart+i]);
			}
		}
		else {
			for(int i=0;i<20;i++) {
				list.add(contents[pagestart+i]);
			}	
		}
		return list;	
	}	
	
	/**
	 * 
	 * @param serchcontent 用户输入的查找内容
	 * @return 返回用模糊查询查到的书籍
	 */
	public List<Fiction>selectfiction(String searchcontent){
		searchcontent="%"+searchcontent+"%";
		List<Fiction>list=dao.selectfiction(searchcontent);
		return list;
	}
	
	/**
	 * 保存消息记录
	 * @param request
	 * @param fictionid
	 */
	public void savehistory(HttpServletRequest request,String fictionid) {		
		User user=(User)request.getSession().getAttribute("user");
		if(user==null) {			
		}
		else {
			Fiction fiction=GetOneFictionByFictionIdUtil.getfiction(request,fictionid);
			LinkedList<Fiction>fictionsHistory=user.getFictionsHistory();
			if(fictionsHistory.size()!=3) {//如果保存不到三本书则不删除保存的书籍记录
				for(Fiction f1:fictionsHistory) {
					boolean v=comparefictionid(fiction.getFictionid(),f1.getFictionid());
					System.out.println(v+"v");
					if(v==true) {
						
						return;
					}
				}
				fictionsHistory.push(fiction);
			}
			else {
				
				fictionsHistory.pollLast();
				fictionsHistory.push(fiction);
			}			
			user.setFictionsHistory(fictionsHistory);
		}
	}
	
	public boolean comparefictionid(long f1,long f2) {
		if(f1!=f2) {
			return false;
		}
		return true;
	}
	}

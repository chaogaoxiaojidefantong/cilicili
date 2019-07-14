package com.htmlcili.sys.service.imp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.dao.CommentDao;
import com.htmlcili.sys.dao.UserDao;
import com.htmlcili.sys.entity.Comment;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.CommentService;
import com.htmlcili.sys.util.TimeUtil;

@Service
public class CommentServiceImp implements CommentService{
	@Autowired
	CommentDao dao;
	
	@Autowired
	UserDao userdao;
	
	@Override
	public PageObject<Comment> pageObject(String fictionid,Integer page,Integer currentPage) {
		Integer pageSize=3;
		String fictionidandpage=fictionid+"for"+page;	
		List<Comment>allComment=dao.findPage(fictionidandpage);
		Integer startIndex=(currentPage-1)*pageSize;//从哪条记录开始数
		List<Comment>list=dao.findPageObjects(fictionidandpage,startIndex,pageSize);		
		for(Comment vv:list) {
			String phonenumber=vv.getPhonenumber();
			User user=userdao.getuserbyphone(phonenumber);
			vv.setUser(user);
		}		
		Integer rows=allComment.size();		
		PageObject<Comment>pageObject=new PageObject<Comment>();
		Integer pageCount=(rows-1)/pageSize+1;
		pageObject.setRecords(list);
		pageObject.setCurrentPage(currentPage);	
		pageObject.setRows(rows);				
		pageObject.setPageCount(pageCount);
		return pageObject;
	}
	
	public Integer insertcomment(Comment comment,HttpServletRequest request) {
	  User user=(User)request.getSession().getAttribute("user");
	  String phonenumber=user.getPhonenumber();
	  String nowtime=TimeUtil.getnowtime();
	  	comment.setPhonenumber(phonenumber);
	  	comment.setNowtime(nowtime);
		int co=dao.insertcomment(comment);
		return co;
	}

}

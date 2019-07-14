	package com.htmlcili.sys.service.imp;
	
	import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htmlcili.sys.dao.UserCollectDao;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.entity.UserCollect;
import com.htmlcili.sys.service.UserCollectService;
	import com.htmlcili.sys.util.UserUtil;
	
	@Service
	public class UserCollectServiceImp implements UserCollectService{			
			
		@Autowired
		UserCollectDao dao;		
		/**
		 * 判断用户是否已收藏相应的书籍
		 */	
		@Override
		public Boolean collectstate(HttpServletRequest request) {
			String fictionid=request.getParameter("fictionid");
			User user=(User) request.getSession().getAttribute("user");			
			String phonenumber=user.getPhonenumber();
			UserCollect userCollect=new UserCollect();
			userCollect.setFictionid(Long.parseLong(fictionid));
			userCollect.setPhonenumber(phonenumber);
			UserCollect collect=dao.getusercollect(userCollect);
			//UserCollect collect=dao.getusercollect(Long.parseLong(fictionid), phonenumber);	
			if(collect==null) {
				return false;
			}
			return true;			
		}
		
		/**
		 * 处理取消收藏的请求
		 * @param request
		 * @param fictionid
		 * @return
		 */
		public Integer cancelcollectbyuser(HttpServletRequest request,List<Long>ids) {	
			User user=(User)request.getSession().getAttribute("user");
			String phonenumber=user.getPhonenumber();
			Integer delrows=1;
			for(Long fictionid:ids){
				UserCollect userCollect=new UserCollect();
				userCollect.setFictionid(fictionid);
				userCollect.setPhonenumber(phonenumber);
				delrows=dao.cancelcollectbyuser(userCollect);
			}
			return delrows;
		}
		
		public Integer collectbyuser(HttpServletRequest request,long fictionid) {
			UserCollect userCollect=new UserCollect();
			User user=(User)request.getSession().getAttribute("user");
			String phonenumber=user.getPhonenumber();
			userCollect.setPhonenumber(phonenumber);
			userCollect.setFictionid(fictionid);
			System.out.println(userCollect);
			Integer data=dao.collectbyuser(userCollect);
			return data;
		}
		
	}

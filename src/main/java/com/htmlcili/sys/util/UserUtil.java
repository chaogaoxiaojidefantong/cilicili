	package com.htmlcili.sys.util;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.htmlcili.sys.dao.UserCollectDao;
import com.htmlcili.sys.entity.Fiction;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.entity.UserCollect;


public class UserUtil {
		//存在返回true,不存在返回false
		/**
		 * 判断用户是否已经收藏了这本书，存在则返回true,不存在则返回false
		 * @param fictionid 
		 * @param user
		 * @return
		 */
	@Autowired 
	UserCollectDao dao=null;
	
	/**
	 * 判断用户是否已经登录
	 * @return 返回true则是已登录，false为未登录
	 */
	public  boolean judgeUser(User user) {
		if(user==null) {
			return false;
		}
		return true;
	}
	
	//public  boolean judgecollect(long fictionid,User user) {	
//		String phonenumber=user.getPhonenumber();
//		 UserCollect userCollect=dao.getusercollect(fictionid, phonenumber);  
//	   if(userCollect!=null) {
//		   return true;
//	   }
//	   else {
//		   return false;
//	   }
	//}
	
	/**
	 * 更新用户收藏信息进session里
	 */
	
	public  void updateuser(HttpServletRequest request,String username) {
//		User user=(User) request.getSession().getAttribute(username);
//		String phonenumber=user.getPhonenumber();		
//		List<Fiction>fictions=dao.updateusercollect(phonenumber);		
//		user.setFictions(fictions);
//		request.getSession().setAttribute(username,user);
	}
	
	
	
	}

package com.htmlcili.sys.service.imp;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htmlcili.sys.dao.FictionDao;
import com.htmlcili.sys.dao.UserDao;
import com.htmlcili.sys.entity.Fiction;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.UserService;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserDao userDao;
	
	@Autowired
	FictionDao fictiondao;
	
	@Override
	public User login(User user,HttpServletRequest request,HttpServletResponse response) {
		//String phonnenumber=user.getPhonenumber();
		//String userpwd=user.getUserpwd();
		user=userDao.login(user);
		HttpSession session=request.getSession();
		Cookie cookie=new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60*60*24*30);			
		response.addCookie(cookie);				
		session.setAttribute("user",user);			
		return user;		
	}
	
	public User getAllFictionbyuser(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");
		String phonenumber=user.getPhonenumber();
		List<Fiction>list=fictiondao.getAllFictionbyuser(phonenumber);
		user.setFictions(list);
		return user;	
	}
	
	/**
	 * 处理用户注册
	 * @return
	 */
	public Integer regist(User user,HttpServletRequest request) {
		user.setMember("no");
		Integer data=userDao.regist(user);
		if(data!=0) {
			request.getSession().setAttribute("user",user);
		}
		return data;
	}

}

package com.htmlcili.sys.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.htmlcili.sys.entity.User;

public interface UserService {
		public User login(User user,HttpServletRequest request,HttpServletResponse response);
		public User getAllFictionbyuser(HttpServletRequest request);
		public Integer regist(User user,HttpServletRequest request);
}

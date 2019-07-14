package com.htmlcili.sys.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieSessionHandle {	
	public static void addSessiontoCookies(HttpServletRequest request,HttpServletResponse response) {
		if(request.getSession(false)==null) {
			Cookie cookie=new Cookie("JSESSIONID",request.getSession().getId());
			System.out.println(request.getSession().getId());
			response.addCookie(cookie);
		}
	}
}

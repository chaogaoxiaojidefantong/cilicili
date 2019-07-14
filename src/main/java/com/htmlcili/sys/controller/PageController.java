	package com.htmlcili.sys.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.htmlcili.sys.entity.User;

	@Controller
	public class PageController {
		@RequestMapping("/userhome")
		public String userhome() {
			return "userhome/userhome.html";
		}
		
		@RequestMapping("headcontentfalse")
		public String headcontentfalse() {
			return "common/headcontentfalse.html";
		}
		
		@RequestMapping("headcontenttrue")
		public String headcontenttrue() {
			return "common/headercontenttrue.html";
		}
		
		@RequestMapping("/header")
		public String header() {			
			return "common/head.html";
		}
		
		@RequestMapping("footer")
		public String footer() {
			return "common/foot.html";
		}
		
		@RequestMapping("/")
		public String index() {
			return "cilicili.html";
		}
		
		@RequestMapping("/ci")
		public String indexone() {
			return "cilicili.html";
		}
		
		@RequestMapping("/watchpage")
		public String watchpage() {
			return "watch/watch.html";
		}
		
		@RequestMapping("catelogpage")
		public String catelog(HttpServletRequest request) {
			return "catelog/catelog.html";
		}
				
		@RequestMapping("headercontent")
		public String headcontent(HttpServletRequest request) {		
			User user=(User)request.getSession().getAttribute("user");
			System.out.println(user+"user");
			if(user==null) {
				return "common/headcontentfalse.html";
			}
			return "common/headercontenttrue.html";				
		}
		
		@RequestMapping("regist")
		public String regist() {
			return "regist/regist.html";
		}
		
		@RequestMapping("searchfictionbycontent")
		public String serchfictionbycontent() {
			return "search/search.html";
		}
		
		@RequestMapping("contribute")
		public String contribute() {
			System.out.println("进来了jjjjj");
			return "contribute/contribute.html";
		}
	
	}

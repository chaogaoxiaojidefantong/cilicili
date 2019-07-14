	package com.htmlcili.sys.controller;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htmlcili.common.vo.JsonResult;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	@Autowired
	UserService service;
	
	@RequestMapping("judgelogin")
	@ResponseBody
	public JsonResult judgelogin(HttpServletRequest request) {
		User user=(User)request.getSession().getAttribute("user");		
		JsonResult jsonResult=new JsonResult();		
		jsonResult.setData(user);
		return jsonResult;
	}
	
	@RequestMapping("login")
	@ResponseBody
	public JsonResult login(User user,HttpServletRequest request,HttpServletResponse response)
	{
		user=service.login(user, request, response);
		JsonResult jsonResult=new JsonResult();
		jsonResult.setData(user);
		return jsonResult;
	}
	
	/**
	 * 处理用户退出登录的请求
	 * @return
	 */
	@RequestMapping("quit")
	public String quit(HttpServletRequest request) {
		request.getSession().removeAttribute("user");
		return "common/headcontentfalse.html";
	}
	
	@RequestMapping("userhome")
	@ResponseBody
	public JsonResult userhome(HttpServletRequest request) {
		User user=service.getAllFictionbyuser(request);
		JsonResult jsonResult=new JsonResult();
		jsonResult.setData(user);
		return jsonResult;
	}
	
	@RequestMapping("regist")
	@ResponseBody
	public JsonResult regist(User user,HttpServletRequest request) {
		Integer data=service.regist(user,request);
		JsonResult jsonResult=new JsonResult();
		jsonResult.setData(data);
		return jsonResult;
	}
	}

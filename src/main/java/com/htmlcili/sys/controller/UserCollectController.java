	package com.htmlcili.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htmlcili.common.vo.JsonResult;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.UserCollectService;
import com.htmlcili.sys.util.IdJointUtil;

	@Controller
	@RequestMapping("UserCollect")
	public class UserCollectController {
		@Autowired
		UserCollectService service;
		
		
		@RequestMapping("getusercollectstate")
		@ResponseBody
		public JsonResult jsonResult(HttpServletRequest request) {			
			User user=(User)request.getSession().getAttribute("user");
			if(user==null) {
				JsonResult jsonResult=new JsonResult();
				jsonResult.setData(user);
				return jsonResult;
			}
			Boolean collectstate=service.collectstate(request);
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(collectstate);
			return jsonResult;
		}
		
		@RequestMapping("cancelcollect")
		@ResponseBody
		public JsonResult jsonResult(HttpServletRequest request,String ids) {
			List<Long>list=IdJointUtil.getlistid(ids,Long.class);
			JsonResult jsonResult=new JsonResult();
			Integer delrows=service.cancelcollectbyuser(request,list);
			jsonResult.setData(delrows);
			return jsonResult;
		}
		
		@RequestMapping("collect")
		@ResponseBody
		public JsonResult collect(HttpServletRequest request,String fictionid) {
			JsonResult jsonResult=new JsonResult();
			Integer data=service.collectbyuser(request,Long.parseLong(fictionid));
			jsonResult.setData(data);
			return jsonResult;
		}
	}

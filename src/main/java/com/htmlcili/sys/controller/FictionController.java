	package com.htmlcili.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.htmlcili.common.vo.JsonResult;
import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.entity.Fiction;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.FictionService;


	@Controller
	@RequestMapping("/Fiction/")
	public class FictionController {	
		@Autowired
		FictionService service=null;		
		/**
		 * 因为登录时用户信息存储在session里，所以需要传HttpServletRequest request对象进去获取session,通过线程休眠更好的看出是否执行了局部刷新
		 * @param request
		 * @return
		 */		
		@RequestMapping("getfictionbyclick")
		@ResponseBody
		public JsonResult getfictionbyclick() {			
			List<Fiction> list=service.fictionrank();
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(list);
			return jsonResult;
		}
		
		@RequestMapping("catelog")
		@ResponseBody
		public JsonResult catalog(HttpServletRequest request) {			
			PageObject pageObject=service.getcatelog(request);			
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(pageObject);
			return jsonResult;
		}
		
		@RequestMapping("watch")
		@ResponseBody
		public JsonResult watch(HttpServletRequest request) {
			List<String>watch=service.watch(request);
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(watch);
			return jsonResult;
		}
		
		@RequestMapping("searchcontent")
		@ResponseBody
		public JsonResult searchresult(String searchcontent) {
			List<Fiction>list=service.selectfiction(searchcontent);
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(list);
			return jsonResult;
		}
		
		
		
	}

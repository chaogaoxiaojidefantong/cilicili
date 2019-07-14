	package com.htmlcili.sys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.htmlcili.common.vo.JsonResult;
import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.entity.Comment;
import com.htmlcili.sys.entity.User;
import com.htmlcili.sys.service.CommentService;

	@Controller
	@RequestMapping("/Comment/")
	public class CommentController {
	@Autowired
	CommentService service;
				
		@RequestMapping("watchcomment")
		@ResponseBody
		/**
		 * 
		 * @param fictionid 书的id
		 * @param page 第几章书
		 * @param currentPage 这章的第一页评论
		 * @return
		 */
		public JsonResult jsonResult(String fictionid,Integer page,Integer currentPage) {
			
			PageObject<Comment> pageObject=service.pageObject(fictionid,page,currentPage);
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(pageObject);
			return jsonResult;
		}
		
		@RequestMapping("insertcomment")
		@ResponseBody
		public JsonResult jsonResult(Comment comment,HttpServletRequest request) {
			User user=(User)request.getSession().getAttribute("user");
			if(user==null) {
				return null;
			}
			Integer v1=service.insertcomment(comment,request);
			JsonResult jsonResult=new JsonResult();
			jsonResult.setData(v1);
			return jsonResult;
		}
	}

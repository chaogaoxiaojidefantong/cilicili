package com.htmlcili.sys.service;

import javax.servlet.http.HttpServletRequest;

import com.htmlcili.common.vo.PageObject;
import com.htmlcili.sys.entity.Comment;

public interface CommentService {
	public PageObject<Comment>pageObject(String fictionid,Integer page,Integer currentPage);
	public Integer insertcomment(Comment comment,HttpServletRequest request);
	}

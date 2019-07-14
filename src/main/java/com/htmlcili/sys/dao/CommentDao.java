package com.htmlcili.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htmlcili.sys.entity.Comment;
/**
 * 
 * @author Administrator
 *
 */
public interface CommentDao {
	public List<Comment> findPageObjects(@Param("fictionidandpage")String fictionidandpage,@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	public List<Comment> findPage(String fictionidandpage);//查找当页的所有信息
	public int insertcomment(Comment comment);//用于客户插入评论
}

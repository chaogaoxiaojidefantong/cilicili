	package com.htmlcili.sys.dao;

import com.htmlcili.sys.entity.UserCollect;



public interface UserCollectDao {
	UserCollect getusercollect(UserCollect userCollect);	 
	public Integer cancelcollectbyuser(UserCollect userCollect);
	public int collectbyuser(UserCollect userCollect);//用于插入用户的收藏
	}

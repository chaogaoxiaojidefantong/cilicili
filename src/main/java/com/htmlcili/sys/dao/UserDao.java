package com.htmlcili.sys.dao;

import com.htmlcili.sys.entity.User;

public interface UserDao {
	public User getuser(Integer id);
	public User login(User user);
	public User getuserbyphone(String phonenumber);
	public int regist(User user);
}

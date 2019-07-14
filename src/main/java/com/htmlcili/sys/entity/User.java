package com.htmlcili.sys.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class User implements Serializable{
	private String phonenumber;
	private String username;
	private String userpwd;
	private long userid;
	private List<Fiction>fictions;	
	private String member;
	LinkedList<Fiction> fictionsHistory=new LinkedList<Fiction>();
	

	public LinkedList<Fiction> getFictionsHistory() {
		return fictionsHistory;
	}

	public void setFictionsHistory(LinkedList<Fiction> fictionsHistory) {
		this.fictionsHistory = fictionsHistory;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	@Override
	public String toString() {
		return "User [phonenumber=" + phonenumber + ", username=" + username + ", userpwd=" + userpwd + ", userid="
				+ userid + ", fictions=" + fictions + "]";
	}

	public List<Fiction> getFictions() {
		return fictions;
	}

	public void setFictions(List<Fiction> fictions) {
		this.fictions = fictions;
	}

	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	
	
}

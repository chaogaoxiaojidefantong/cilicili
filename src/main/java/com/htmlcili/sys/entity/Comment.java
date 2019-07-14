	package com.htmlcili.sys.entity;	
	public class Comment {
	private long commentid;
	private String commentcontent;
	private String nowtime;
	private String phonenumber;
	private String fictionidandpage;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getCommentid() {
		return commentid;
	}
	public void setCommentid(long commentid) {
		this.commentid = commentid;
	}
	public String getCommentcontent() {
		return commentcontent;
	}
	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}
	public String getNowtime() {
		return nowtime;
	}
	public void setNowtime(String nowtime) {
		this.nowtime = nowtime;
	}
	
	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", commentcontent=" + commentcontent + ", nowtime=" + nowtime
				+ ", phonenumber=" + phonenumber + ", fictionidandpage=" + fictionidandpage + ", user=" + user + "]";
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFictionidandpage() {
		return fictionidandpage;
	}
	public void setFictionidandpage(String fictionidandpage) {
		this.fictionidandpage = fictionidandpage;
	}
	
	}

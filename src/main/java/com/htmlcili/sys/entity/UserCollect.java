	package com.htmlcili.sys.entity;

import java.io.Serializable;

public class UserCollect implements Serializable{
	private long nouseid;
	private String phonenumber;
	private long fictionid;
	public long getNouseid() {
		return nouseid;
	}
	@Override
	public String toString() {
		return "UserCollect [phonenumber=" + phonenumber + ", fictionid=" + fictionid + "]";
	}
	public void setNouseid(long nouseid) {
		this.nouseid = nouseid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getFictionid() {
		return fictionid;
	}
	public void setFictionid(long fictionid) {
		this.fictionid = fictionid;
	}
}

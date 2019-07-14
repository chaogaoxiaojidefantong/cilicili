package com.htmlcili.sys.entity;

import java.io.Serializable;

public class Fiction implements Serializable{
	private long fictionid;
	private String fictionname;
	private String fictionprice;
	private	String author;
	private long click;
	private	String needmember;
	private String category;
		
		public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
		public String getNeedmember() {
			return needmember;
		}
		public void setNeedmember(String needmember) {
			this.needmember = needmember;
		}
@Override
	public String toString() {
		return "Fiction [fictionid=" + fictionid + ", fictionname=" + fictionname + ", fictionprice=" + fictionprice
				+ ", author=" + author + ", click=" + click + "]";
	}
public long getClick() {
		return click;
	}
	public void setClick(long click) {
		this.click = click;
	}


public long getFictionid() {
	return fictionid;
}
public void setFictionid(long fictionid) {
	this.fictionid = fictionid;
}
public String getFictionname() {
	return fictionname;
}
public void setFictionname(String fictionname) {
	this.fictionname = fictionname;
}
public String getFictionprice() {
	return fictionprice;
}
public void setFictionprice(String fictionprice) {
	this.fictionprice = fictionprice;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}

}

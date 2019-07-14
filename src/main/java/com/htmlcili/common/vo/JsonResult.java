	package com.htmlcili.common.vo;

import java.io.Serializable;

public class JsonResult implements Serializable{
	private static final long serialVersionUID = -2040132524942880841L;
		private String message="ok";
		private Object data;
		private int state=1;//默认数据为1
		public JsonResult() {
			
		}
		
	public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Object getData() {
			return data;
		}

		public void setData(Object data) {
			this.data = data;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

	public JsonResult(String message) {
		this.message=message;
	}
	
	public JsonResult(Throwable e) {
		state=0;
		message=e.getMessage();
	}
	
	public JsonResult(Object data) {
		this.data=data;
	}
	
	
	}

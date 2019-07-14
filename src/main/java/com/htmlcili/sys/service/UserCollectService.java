	package com.htmlcili.sys.service;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

public interface UserCollectService {
		public Boolean collectstate(HttpServletRequest request);
		public Integer cancelcollectbyuser(HttpServletRequest request,List<Long>ids);
		public Integer collectbyuser(HttpServletRequest request,long fictionid);
	}

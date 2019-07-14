	package com.htmlcili.sys.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	public static String getnowtime() {
		Date date=new Date();
		SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sd.format(date);
	}
	}

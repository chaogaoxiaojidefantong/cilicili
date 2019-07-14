	package com.htmlcili.sys.dao;

	import java.util.List;
	import com.htmlcili.sys.entity.Fiction;


public interface FictionDao {		
		public List<Fiction>selectAllFictionByClick();
		public List<Fiction> getAllFictionbyuser(String phonenumber);
		public List<Fiction>selectfiction(String searchcontent);
	}

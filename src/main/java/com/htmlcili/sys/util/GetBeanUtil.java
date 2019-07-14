	package com.htmlcili.sys.util;
	import org.springframework.context.support.ClassPathXmlApplicationContext;

	public class GetBeanUtil<T> {
		public ClassPathXmlApplicationContext ctx=null;
		
		public void init(String xmlname){
			ctx = new ClassPathXmlApplicationContext(xmlname);
			
		}
		

		public T getBeanObject(String beanname,Class<?>cls,String xmlname) {
			init(xmlname);
			T a1=(T) ctx.getBean(beanname,cls);			
			return a1;
		}
	}

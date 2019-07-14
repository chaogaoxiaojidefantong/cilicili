package com.htmlcili.sys.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
/**
 * ����ȫվ����Ĺ�����
 *	1.���������������(GET��POST)
 *  2.������Ӧ��������
 */
public class EncodingFilter implements Filter {
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	/* ���������ص�������ĺ��ķ���
	 * (�൱��Servlet�е�service����) */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("EncodingFilter.doFilter()....");
		HttpServletRequest req = (HttpServletRequest) request;
		/* POST:
		 * �ڹ������д��������������(ֻ��Ҫдһ��, ���б����ص�����Դ���������ⶼ���Խ��)
		 */
		request.setCharacterEncoding("utf-8");//���POST�ύ
		
		/*
		 * �ڹ������д�����Ӧ��������(ֻ��Ҫдһ��, 
		 *   ���б����ص�����Դ���������ⶼ���Խ��)
		 */
		response.setContentType("text/html;charset=utf-8");

		HttpServletRequest myRequest = new MyHttpServletRequest(req);
		//�������һ��Ҫ���й�����, �ſ��Խ��ŷ����������Դ
		chain.doFilter(myRequest, response);
	}
	
	/* ��Filterʵ������֮ǰ����ִ��
	 * �����ƺ�Ĵ���
	 */
	public void destroy() {}
}

class MyHttpServletRequest extends HttpServletRequestWrapper{
	private boolean isEncode = true;
	/* isEncode �Ƿ�����ֶ������ı�ʶ, 
	  Ĭ��ֵ��true, ��ʾ��û���ֶ������ */
	private HttpServletRequest request;
	public MyHttpServletRequest(HttpServletRequest request) {
		super(request);
		this.request = request;
	}
	@Override
	public String getParameter(String name) {
		return this.getParameterValues(name) == null? null : this.getParameterValues(name)[0];
	}
	
	@Override
	public String[] getParameterValues(String name) {
		return this.getParameterMap().get(name);
	}
	@Override
	public Map<String, String[]> getParameterMap() {
		/*
		�÷������Է����������������ɵ�map����, ��ʱmap��
		���������������(get�ύ), ���ǿ��Ա���map�е�ÿһ��
		����ֵ, �ֶ�����봦�������ȷ�������ٴδ��map��,
		��󷵻�һ��û�������map����
		 */
		if("POST".equalsIgnoreCase(request.getMethod())){//��POST�ύ
			return request.getParameterMap();
		}else if("GET".equalsIgnoreCase(request.getMethod())){
			//����map, ����ȡ������, �ֶ�������ٴδ��map������map
			Map<String, String[]> map = request.getParameterMap();
			if(isEncode){
				for (Map.Entry<String, String[]> entry : map.entrySet()) {
					//ȡ��ÿһ����ֵ��, ����ֵ������, ����Ҫ����
					String[] vs = entry.getValue();
					for (int i = 0; i < vs.length; i++) {
						try {
							vs[i] = new String(vs[i].getBytes("iso8859-1"), "utf-8");
						} catch (Exception e) {
							e.printStackTrace();
							throw new RuntimeException(e);
						}
					}
				}
				isEncode = false;
			}
			return map;
		}else{//����5���ύ��ʽ
			return request.getParameterMap();
		}
	}
}
/*
 * ��װ����: request���� --> ��������: A
 * ��װ������������ʵ�ֵĽӿ�: HttpServletRequest
 * 
 * װ����: MyHttpServletRequest  Ҫʵ��HttpServletRequest�ӿ�
 * ��������MyHttpServletRequest�̳�һ��װ����, ���������Ҳ��һ��
 * װ����, ֻ��Ҫ������Ҫ����ĸ����з�������!!
 */
/*
 * 1.дһ��װ����, װ����Ҫ�ͱ�װ������������ʵ����ͬ�Ľӿ�
 * 	���߼̳���ͬ�ĸ���
 * 2.װ����Ҫ�ṩ���췽�����ܱ�װ���߲�����������ڲ�
 * 3.������Ҫ����ķ���ֱ�ӽ��и���, ���ڲ������ķ���, ����
 * 	ԭ�ж����ϵķ���
 */


package com.sinse.hiberasync.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/*
 * A supported interface that allows you to actually take care of your business ahead of the servlet when a request is received
 * Main purpose) Common settings across web applications, logging users, login processing..
 */
public class CharacterEncodingFilter implements Filter{
	String encoding; 
	
	/*
	 * It is completely similar to the life cycle of a servlet. 
	 * The init() below is a filter initialization method that is called as soon as a filter instance is created. 
	 * Developers can proceed with this method to pass the initial value to web.xml.
	 */
	   @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        encoding = filterConfig.getInitParameter("encoding");
	        
	        if (encoding == null) {
	            encoding = "UTF-8"; // 안전장치
	        }
	    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		
		//Process the flow of this request..
		//dIf you don't, the delivery of the request will stop.
		
		
//If you don't, the delivery of the request will stop.
		chain.doFilter(request, response); //다음 필터 또는 다음 서블으로 요청 전
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}

package com.sinse.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 서블릿은 서버측에서 수행되는 자바 클래스로서 매우 필수적인 기술이다.
 * 치명적인 단점은 디자인 표현 시 html 태그를 모두 문자열로 처리해야 한다.. 이 방법을 고수한다면 asp,php와 경쟁이될 수 있다.
 * 따라서 이를 보완할 수 있는 JSP 를 배우자!!
 */

//게시물의 목록 요청을 처리하는 서블
public class ListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
}

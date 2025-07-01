package com.sinse.web0619.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudyServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		int x = 3;
		x=7;
		PrintWriter out = response.getWriter();
		out.print("<h1>it's reusult is " + x + "</h1>");
	}
	
	private void destory() {
		System.out.println("destroy()호출");
	}
}

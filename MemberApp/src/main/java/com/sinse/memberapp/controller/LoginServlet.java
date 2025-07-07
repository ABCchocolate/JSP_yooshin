package com.sinse.memberapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sinse.memberapp.exception.MemberNotFounException;
import com.sinse.memberapp.model.Member;
import com.sinse.memberapp.repository.MemberDAO;


//It receives the login information transmitted to the post and 
//divides the login success and failure depending on whether it matches the member table.
public class LoginServlet extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	MemberDAO memberDAO = new MemberDAO();
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		//get Parameter
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//System.out.println(id);
		//System.out.println(pwd);
//		logger.trace("trace 레벨 출력");
//		logger.debug("debug 레벨 출력");
//		logger.info("info 레벨 출력");
//		logger.warn("warn 레벨 출력");
//		logger.error("error 레벨 출력");

//		for(int i = 1; i< 10; i++) {
//			logger.trace("i는 " +i);
//		}
		
		logger.debug(id);
		logger.debug(pwd);
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		
		
		PrintWriter out = response.getWriter();
		Member obj = null;
		try {
			obj = memberDAO.login(member);
			//If the login is successful, let's put the object in the session.
			//In jsp, session is supported as a built-in object, but the code is currently a servlet, 
			//so the developer must control it as a data type.
			
			
			//You don't need to use new because tomcat gets from the server.
			HttpSession session = request.getSession();
			session.setAttribute("member", obj);
			
			out.println("<script>");
			out.println("alert('" + obj.getName() + " 로그인 성공');");
			out.println("location.href='/member/index.jsp';");
			out.println("</script>");

		}
		catch(MemberNotFounException e){
			e.getStackTrace();
			out.println("<script>");
			out.println("alert('" + e.getMessage() + "');");
			out.println("history.back();");
			out.println("</script>");


			
		}
	}
}

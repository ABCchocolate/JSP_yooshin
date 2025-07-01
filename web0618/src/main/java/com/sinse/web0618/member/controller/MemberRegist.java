package com.sinse.web0618.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.web0618.exception.MemberException;
import com.sinse.web0618.member.model.Member;
import com.sinse.web0618.member.repository.MemberDAO;

//클라이언트에서 들어오는 회원가입 요청을 처리하 컨트롤러
public class MemberRegist extends HttpServlet {

	MemberDAO memberDAO = new MemberDAO();

	// 웹 브라우저인 클라이언트가 포스트로 전송을 하면 서버는 반드시 dopost 메서드로 요청을 처리해야한다.
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 이 때 사용되는 객체는 request 이다.

		String id = request.getParameter("id"); // html의 컴포넌트에 부여한 이름이다.
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");

		// db insert
		Member member = new Member();
		member.setId(id);
		member.setPwd(pwd);
		member.setEmial(name);

		memberDAO.insert(member);
		String reusltMsg = null;

		try {
			
			reusltMsg = "성공";
		} catch (MemberException e) {
			reusltMsg = e.getMessage();
			e.printStackTrace();
		}
		
		System.out.println("전송된 아이디는 " + id); // tomcat 서버의 콘솔에 출력됨.
		System.out.println("전송된 패스워드는 " + pwd);
		System.out.println("전송된 이름은 " + name);

		// 회원 가입 후에는 유저가 보게 될 디자인 코드를 작성하여 결과를 보여주어야한다.
		// 이 메서드의 매개변수 중 두개 중 첫번째 매개변수인 request 객체는 클라이언트의 요청정보를 가지고 있고
		// 두번째 매개변수인 response객체는 클라이언트가 보게 될 응답 정보를 개발자가 구성할 수 있는 객체이다.
		PrintWriter out = response.getWriter(); // 문자 기반의 출력 스트림
		out.print("<!DOCTYPE html>");
		out.print("<html lang='en'>");
		out.print("<head>");
		out.print("    <meta charset='UTF-8'>");
		out.print("    <meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.print("    <title>Document</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("    회원가입을 축하드립니다.");
		out.print("</body>");
		out.print("</html>");

	}
}

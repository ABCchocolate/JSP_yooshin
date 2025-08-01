package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.model.Notice;
import com.sinse.boardapp.repository.NoticeDAO;

//클라이언트가 전송한 글쓰기 폼의 파라미터들을 받아,데이터베이스에서 받아 insert 시키는 서블
public class RegistServlet extends HttpServlet {

	Notice notice;
	NoticeDAO noticeDAO;

	public RegistServlet() {
		// TODO Auto-generated constructor stub
		noticeDAO = new NoticeDAO();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Let's get the value of the variable = parameter sent by the browser, which is
		// the client, and put it in db
		// draw out the parameter, from request object
		request.setCharacterEncoding("utf-8"); // Encoding Point for Parameters
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");

		System.out.println(title);
		System.out.println(writer);
		System.out.println(content);

		notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		try {
			noticeDAO.insert(notice);
			out.print("<script>");
			out.print("alert('등록성공');");
			out.print("location.href='/notice/list.jsp';");
			out.print("</script>");
		} catch (NoticeException e) {

			// 클라이언트가 받게 될 응답 정보에 스크립트 문자열을 채워넣기...
			// Tomcat과 같은 웹 컨테이너가, 이 메서드의 닫는 괄호를 만나면 그 시점부터 나선다.
			// 응답 객체에 들어있는 Response에 들어있는 출력스트림에 누적되어 있는 문자열을 이용하여 ,HTML 컨텐츠를 생성한다.
			out.print("<script>");
			out.print("alert('" + e.getMessage() + "');");
			out.print("</script>");
			e.printStackTrace();
		}

	}
}

package com.sinse.boardapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinse.boardapp.exception.NoticeException;
import com.sinse.boardapp.repository.NoticeDAO;

//삭제 요청을 처리하는 서블릿, 삭제요청은 별도의 디자인을 요구하는 요청이 아니므로 jsp가 아닌 서블릿으로 처리한다.
//삭제 후, 목록으로 링크를 걸어주면 된다.
public class DeleteServlet extends HttpServlet {

	NoticeDAO noticeDAO = new NoticeDAO();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		String notice_id = request.getParameter("notice_id");
		System.out.println("넘겨받은 pk 값: " + notice_id);

		try {
			noticeDAO.delete(Integer.parseInt(notice_id));
			out.print("<script>");
			out.print("alert('삭제 성공');");
			out.print("location.href='/notice/list.jsp';");
			out.print("</script>");
		} catch (NoticeException e) {
			e.printStackTrace();
			out.print("<script>");
			out.print("alert('" + e.getMessage() + "');");
			out.print("history.back();");
			out.print("</script>");
		}
	}
}


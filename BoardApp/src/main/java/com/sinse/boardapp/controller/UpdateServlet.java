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

public class UpdateServlet extends HttpServlet {
	NoticeDAO noticeDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 파라미터를 받기 전에 인코딩부터 처리하자
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Notice notice = new Notice();
		String notice_id = request.getParameter("notice_id");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		notice.setNotice_id(Integer.parseInt(notice_id));

		noticeDAO = new NoticeDAO();

		try {
			noticeDAO.update(notice);
			out.print("<script>");
			out.print("alert('업데이트 성공');");
			out.print("location.href='/notice/content.jsp?notice_id=" + notice_id + "';");
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

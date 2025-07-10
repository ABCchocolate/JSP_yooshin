package com.sinse.mvcapp.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sinse.mvcapp.controller.Controller;
import com.sinse.mvcapp.model.Notice;
import com.sinse.mvcapp.repository.NoticeDAO;

public class RegistController implements Controller {
	NoticeDAO noticeDAO= new NoticeDAO();
	@Override
	public void execute(HttpServletRequest Reqeust, HttpServletResponse response) throws ServletException, IOException {
		String title = Reqeust.getParameter("title");
		String writer = Reqeust.getParameter("writer");
		String content=Reqeust.getParameter("content");
		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		noticeDAO.insert(notice);
		
		HttpSession session = Reqeust.getSession();
		session.setAttribute("noticeList", notice);
	}

	@Override
	public String getViewPage() {
		// TODO Auto-generated method stub
		return "/notice/regist/view";
	}

}

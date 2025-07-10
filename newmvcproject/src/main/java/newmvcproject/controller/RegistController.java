package newmvcproject.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newmvcproject.notice.domain.Notice;
import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

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
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/notice/regist/view";
	}

}

package newmvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newmvcproject.notice.domain.Notice;
import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

public class EditController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String notice_id = request.getParameter("notice_id");
		String writer = request.getParameter("writer");
		String content =request.getParameter("content");
		
		Notice notice = new Notice();
		notice.setNotice_id(Integer.parseInt(notice_id));
		notice.setTitle(title);
		notice.setWriter(writer);
		notice.setContent(content);
		
		noticeDAO.update(notice);
		
		request.setAttribute("notice", notice);
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/notice/update/view";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}

}

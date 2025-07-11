package newmvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

public class DeleteController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String notice_id = request.getParameter("notice_id");
		noticeDAO.delete(Integer.parseInt(notice_id));
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/notice/delete/view";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}
}

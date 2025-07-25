package newmvcproject.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

public class ListController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 일시키기
		List noticeList = noticeDAO.selectAll();
		//4단계: 결과 저장
		request.setAttribute("noticeList", noticeList);
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/notice/list/view";
	}

	@Override
	public boolean isForward() {
		// TODO Auto-generated method stub
		return true;
	}
	
}

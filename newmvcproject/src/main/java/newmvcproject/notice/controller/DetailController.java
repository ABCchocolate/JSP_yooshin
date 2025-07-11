package newmvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newmvcproject.notice.domain.Notice;
import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;


//상세 보기를 요청하는 컨트롤러
public class DetailController implements Controller{
	NoticeDAO noticeDAO = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//가지고오기
		Notice notice = noticeDAO.select(Integer.parseInt(request.getParameter("notice_id")));
		
		request.setAttribute("notice", notice);
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return "/notice/detail/view";
	}

	@Override
	public boolean isForward() {
		
		return true;
	}

}

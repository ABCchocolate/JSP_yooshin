package newmvcproject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

//공지 게시판의 목록 요청을 처리하는 컨트롤러이다.
public class ListController implements Controller{
	NoticeDAO notice = new NoticeDAO();
	@Override
	public void execute(HttpServletRequest Reqeust, HttpServletResponse response) throws ServletException, IOException {
		//알맞는 로직객체에 일 시켜야한다.
		List list = notice.selectAll();
		
		//4단계:결과 페이지에서 보여질 데이터 저장하기
		HttpSession session = Reqeust.getSession();
		session.setAttribute("noticeList", list);
	}

	@Override
	public String getViewName() {
	    return "/notice/view";  // → 이 key가 properties에 있어야 함
	}

}

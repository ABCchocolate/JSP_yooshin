package newmvcproject.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newmvcproject.notice.repository.NoticeDAO;
import newmvcproject.web.servlet.Controller;

public class ListController implements Controller{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//3단계: 일시키기
		NoticeDAO noticeDAO = new NoticeDAO();
		
		//4단계: 결과 저장
	}

	@Override
	public String getViewName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

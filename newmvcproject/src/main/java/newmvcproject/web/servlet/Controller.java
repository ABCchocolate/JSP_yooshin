package newmvcproject.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//모든 종류의 하위 컨트롤러들의 최상우 인터페이스이다.
public interface Controller {
	//dispatcher servlet 대신 요청을 처리한다.따라서 리퀘스트와 리스폰스 객체가 필요하다
	public void execute(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException;
	
	//5단계 업무를 수행할 DispatcherServlet에게 뷰 페이지를 검색할 수 있는 검색어 반환
	public String getViewName();
}

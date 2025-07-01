package com.sinse.web0619.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 자바의 클래스 중 오직 javaEE 기반의 서버에서만 해석 및 실행 될 수 있는 클래스이다.
// 서블릿은 개발자가 인스턴스를 생성하는 방법이 아니라, 개발자는 그냥 클래스 작성 이후 서버에 올려놓으면 된다.

//서블릿이 언제 태어나고, 어떤 일을 수행하며,언제 소멸하는지에 대한 하나의 주기를
//서브릿의 LifeCycle이라고 한다.
//서블릿의 생명주기 관련 메서드
/*
 * 1) init() : 서블릿이 태어난 직, 초기화를 위해 호출되는 메서드(call by tomcat)
 * 2) Service(): 서블릿이 클라이언트의 요청을 처리할 때, 호출되는 메서드이다. (call by thread);
 * 3) Destroy(): 서블릿이 소멸될 때 호출되는 메서드이다 .
 */
public class TestServlet extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println(" init() 호출 :: 저 방금 태어나서, 제가 누군지 알게되었어요.");
	}
	
	// 서블릿은 클라이언트의 요청을 처리하기 위해 태어났으므로, 이 요청 처리를 위해 담당하는메서드가 바로 service이다.
	// 가 바로 service() 이다. 고객의 요청을처리하려면 뭘 원하는지에 대한 요청 정보와
	// 요청에 대한 응답 정보를 가지고 있어야한다.
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출 :: 요청을 처리합니다.");
	}
	
	
	//서블릿이 소멸하는 단계에서 호출되는 메서드이다. 
	@Override
	public void destroy() {
		System.out.println("Destory()호출 :: 반납을 시작합니다.");
	}
}
